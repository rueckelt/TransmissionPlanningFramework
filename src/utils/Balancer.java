package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import executor.Simulation;

import ToolSet.CostSeparation;

import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;


public class Balancer {
	private int partNum;
	private int capacity;
	private int[] minReq;
	private int[] result;
	private int[] priority;
	private int[] flowId;
	private int sumPrior;
	private double[] costPrior;
	private double[] costDelay; // TODO 
	private double[] costDropLight;
	private double[] costDropHeavy;
	private int max[];
	private double cost;
	private double degree;
	private int step;
	private static boolean sc = false;
	private static boolean print = true;
	private static int time = -1;
	private static boolean plot = false;
	
	public Balancer(int capacity, int pN, int step, int sumP) {
		setPartNum(pN);
		setCapacity(capacity);
		minReq = new int[pN];
		costDelay = new double[pN];
		costDropLight = new double[pN];
		costDropHeavy = new double[pN];
		costPrior = new double[pN];
		setMax(new int[pN]);
		setPriority(new int[pN]);
		setResult(new int[pN]);
		cost = 0;
		degree = 0.5;
		sumPrior = sumP;
		setStep(step);
	}
	
	public void initBalancer(int[] mQ, int[] max, double[] cD, double[] cDL, double[] cDH, int[] p) {
		setMinReq(mQ);
		setMax(max);
		setCostDelay (cD);
 		setCostDropLight(cDL);
		setCostDropHeavy(cDH);
		setPriority(p);
		calPriorCost();
	}
	
	public void allocate() {
//		////////System.out.println("here");
		int rest = capacity - sum(minReq);
		// ////////System.out.println("rest: " + rest);
		result = minReq.clone();
		if (rest == 0) {
			return;
		}
		
		// round robin
		if (rest > 0) {
			////////System.out.println("In optimal situation.");
			int waste = 0;
			for (int i = 0; i < result.length; i++) {
				// TODO maximum
				
				// weighted round robin
				int resultPrev = result[i];

				result[i] =  Math.min(getMax()[i], result[i] + rest * priority[i] / sum(priority) + waste);
				waste = resultPrev + rest * priority[i] / sum(priority) + waste - getMax()[i];
				waste = Math.max(waste, 0);
				//////////System.out.println("max: " + getMax()[i] + " rest: " + rest * priority[i] / sum(priority));
			}
			return;
		}
		
		if (rest < 0) {
			//////////System.out.println("in bad situation.");
			rest = -rest;
			double[] curCost = new double[partNum];
			for (int i = 0; i < curCost.length; i++) {
				curCost[i] = calcCost(i);
			}
			//Printer.print(curCost);
			for (int i = rest; i > 0; i -= getStep()) {
				int minIndex = getMinCostIndex(curCost);
				if ((result[minIndex] - getStep()) < 0) {
					curCost[minIndex] = Double.MAX_VALUE;
					i += getStep();
					continue;
				} else {
					result[minIndex] -= getStep();
				}
				curCost[minIndex] = calcCost(minIndex);
			//	System.out.print("cost: ");
			//	Printer.print(curCost);
			//	System.out.print("alloc: ");
			//	//Printer.printInt(result);
			}
		}
		
	}
	
	public void allocate(int n, int t) {
//		////////System.out.println("here");
		int rest = capacity - sum(minReq);
		// ////////System.out.println("rest: " + rest);
		result = minReq.clone();
	//	//Printer.printInt("result.before", result);
		if (rest == 0) {
			return;
		}
		int count = 0;
		
		// round robin
		if (rest > 0) {
			int waste = 0;
//			int tmp0 = 0, tmp4 = 0;
//			for (int i = 0; i < result.length; i++) {
//				if (getFlowId()[i] == 0) {
//					tmp0 = priority[i];
//					priority[i] = 0;
//				}
//				if (getFlowId()[i] == 4) {
//					tmp4 = priority[i];
//					priority[i] = 0;
//				}
//			}
			//if (t > 0) return;
			for (int i = 0; i < result.length; i++) {
				// TODO maximum
				//////////System.out.println("in optimal situation: ");
				// weighted round robin
				//if (n == 0) return;
				int resultPrev = result[i];
				int totalPriority = sum(priority);
				if (totalPriority == 0) return;
				int flowId = getFlowId()[i];
				Flow flow = Combination.getFg().getFlows().get(flowId);
				double costUnsched = (double) flow.getImpUnsched()* flow.getImpUser();
				double costSched =  calcCost(flowId, t, n);
				double monetary = Combination.getNg().getNetworks().get(n).getCost() * Combination.getNg().getCostImportance();

//				//System.out.println("optimal - " + result[i]  + "-"+ "f_t_n:" + flowId + "_" + t + "_" + n + "un/" + costUnsched + "/" + costUnsched*result[i] + " *cost/" + costSched + "*mone/" + monetary) ;
				//}
				if (costSched > costUnsched*result[i]) {
					if (monetary > costUnsched) {
						result[i] = 0;
					} 
					continue;
				} else {
					
				}
				result[i] =  Math.min(getMax()[i], result[i] + rest * priority[i] / totalPriority + waste);
				waste = resultPrev + rest * priority[i] / totalPriority + waste - getMax()[i];
				waste = waste > 0? waste : 0;//Math.max(waste, 0);
				//////////System.out.println("max:h " + getMax()[i] + " rest: " + rest * priority[i] / sum(priority));
				
			}
			return;
		}
		
		if (rest < 0) {
			rest = -rest;
			double[] curCost = new double[partNum];
			for (int i = 0; i < curCost.length; i++) {
				curCost[i] = calcCost(getFlowId()[i], t, n);
			}
//			System.out.print("\n" + "n_" + n + "t_" + t + "_count:  " + count + "-curCost: ");
//			count++;
//			Printer.print(curCost);

			if (t != time) {
//			Printer.print(curCost);
			time = t;
			plot = true;
			} else {
				plot = false;
			}
			if (curCost.length == 0) return;
			for (int i = rest; i > 0; i -= getStep()) {
				int maxIndex = getMaxCostIndex(curCost);
				if (result.length == 0 || (result[maxIndex] - getStep()) < 0) {
					if (curCost[maxIndex] == -Double.MAX_VALUE) { // .... a little silly...
				//		////////System.out.println("in minvalue : " + maxIndex);
				//		Printer.print( curCost);
						return;
					}
					i += getStep();
//					////////System.out.println("maxIndex: " + minIndex + " . " + result[minIndex]);
					curCost[maxIndex] = -Double.MAX_VALUE;
//					////////System.out.println("I am in loop.");
					continue;
				} else {
					result[maxIndex] -= getStep();
					curCost[maxIndex] -= Combination.getCs().getUnitstatefulReward(getFlowId()[maxIndex]);
					rest--;
					//if (rest == 0)
					//	//Printer.printInt(String.valueOf(rest), result);
				}
				//curCost[maxIndex] = calcCost(maxIndex);
//				////////System.out.println("rest: " + i);
			//	System.out.print("cost: ");
			//	Printer.print(curCost);
			//	System.out.print("alloc: ");
			//	//Printer.printInt(result);

			}
			if (rest != 0) {
			//	////////System.out.println("rest: " + rest);

			}
		}
		
	}
	
//	public void getUpdateCost(int[] curCost, int outlierIndex) {
//		for (int i = 0; i < curCost.length; i++) {
//			if (i != outlierIndex) {
//				curCost[i] += Combination.getCs().getUnitstatefulReward(getFlowId()[i]);
//			}
//		}
//	}
	
	// TODO -> change to heap
	public int getMinCostIndex(double[] curCost) {
		double minCost = Double.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < partNum; i++) {	
			if (minCost > curCost[i]) {
				index = i;
				minCost = curCost[i];
			} else if (minCost == curCost[i]) {
				// TODO list - for mult flows with same costs and the same priority
				if (index == -1) continue;
				if (priority[index] == priority[i]) {
					index = ( new Random().nextInt(10) %2 == 0)? index: i;
				} else {
					index = (priority[index] > priority[i])? i: index;
				}
				
			}
		}
		return index;
	}
	
	public int getMaxCostIndex(double[] curCost) {
		double maxCost = -Double.MAX_VALUE;
//		////////System.out.println("partNum: " + partNum);
		int index = 0;
		for (int i = 0; i < partNum; i++) {	
			if (maxCost < curCost[i]) {
				index = i;
				maxCost = curCost[i];
			} else if (maxCost == curCost[i]) {
				// TODO list - for mult flows with same costs and the same priority
				if (index == -1) continue;
				if (priority[index] == priority[i]) {
					index = ( new Random().nextInt(10) %2 == 0)? index: i;
				} else {
					index = (priority[index] < priority[i])? i: index;
				}
				
			}
		}
		return index;
	}
	
	public double calcCost(int index) {
		double costTmp = 0;
		double costDrop = 0;
		costDrop = (result[index] < degree * minReq[index])? costDropHeavy[index] : costDropLight[index];
		//////////System.out.println("***" + (double) priority[index] / sum(priority));
		costTmp = costDrop - costDelay[index] + costPrior[index];
		return costTmp;
		
	}
	
	public double calcCost(int f, int t, int n) {
		int[] prevGlobal = Simulation.getPrevious().getCombGlobal();
		////Printer.printInt("global: ", prevGlobal);
		int switchCost = 0;
		int monetaryCost = 0;
		sc = false;
		if (prevGlobal[f] != 0) {
			if (prevGlobal[f] != (n + 1) && sc) {
				switchCost = 2*500;
			}
		}
		Flow flow = Combination.getFg().getFlows().get(f);
		double costUnsched = (double) flow.getImpUnsched()* flow.getImpUser();
		int stateful = Combination.getCs().getStatefulReward(f, t);
		Network net = Combination.getNg().getNetworks().get(n);
		monetaryCost = net.getCost() * Combination.getNg().getCostImportance();
		double rating = Combination.getCs().calcVio(f, n)+	//stateless reward + network match
				Combination.getCs().getStatefulReward(f, t) * Math.max(1, flow.getTokensMin() / flow.getWindowMin()) +
				Combination.getCs().getTimeMatch(f, t) /getAvMinTp(Combination.getCs().getTg().getFlows().get(f)) + switchCost;
		//ng.getCostImportance()*net.getCost()
		// cost 
		if (rating > 0 && stateful < 0) {
			//rating = rating / Math.abs(stateful);
		}
		if (plot) {
		//	//////System.out.println("f: " + f + " t: " + t + " n: " + n + "rating: " + rating);
		//	//////System.out.println("vio: " + Combination.getCs().calcVio(f, n) + "_stateful:" + 
		//			Combination.getCs().getStatefulReward(f, t) + "_timematch: " + Combination.getCs().getTimeMatch(f, t)/getAvMinTp(Combination.getCs().getTg().getFlows().get(f))
		//			+ "_switchCost: " + switchCost 
		//			+ "_money: " + monetaryCost + "_unsched:" + costUnsched);
//			plot = false;
//			new File("./25_10_uncertainty/").mkdir(); // + uncertainty + "/").mkdir();
//			File log = new File("./25_10_uncertainty/" + "balancer" + ".txt");
//		    try{
//			    if(log.exists() == false){
//			            ////////System.out.println("We had to make a new file.");
//			            log.createNewFile();
//			    }
//				PrintWriter out = new PrintWriter(new FileWriter(log, true));
//				//out.append("addCharacteristicsUncertainty: \n");
//				out.append("vio: " + Combination.getCs().calcVio(f, n) + "_stateful:" + 
//						Combination.getCs().getStatefulReward(f, t) + "_timematch: " + Combination.getCs().getTimeMatch(f, t)/getAvMinTp(Combination.getCs().getTg().getFlows().get(f))
//						+ "_switchCost: " + switchCost 
//						+ "_money: " + monetaryCost);
//				//out.append("f_t_n:" + flowId + "_" + t + "_" + n + "/" + costUnsched + " /" + costSched);
//				out.append("******************************\n");
//				out.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

		return rating;
	}
	
	public double calcCostFinal(int i, int t, int n) {
		int[] prevGlobal = Simulation.getPrevious().getCombGlobal();
		////Printer.printInt("global: ", prevGlobal);
		int switchCost = 0;
		int monetaryCost = 0;
		int f = getFlowId()[i];
		if (prevGlobal[f] != 0) {
			if (prevGlobal[f] != (n + 1) && sc) {
				switchCost = 2*500;
			}
		}
		Flow flow = Combination.getFg().getFlows().get(f);
		double costUnsched = (double) flow.getImpUnsched()* flow.getImpUser();
		int stateful = Combination.getCs().getStatefulReward(f, t);
		Network net = Combination.getNg().getNetworks().get(n);
		monetaryCost = net.getCost() * Combination.getNg().getCostImportance();
		double rating = Combination.getCs().calcVio(f, n)+	//stateless reward + network match
				Combination.getCs().getStatefulReward(f, t) * result[i] +
				Combination.getCs().getTimeMatch(f, t) /getAvMinTp(Combination.getCs().getTg().getFlows().get(f)) + switchCost;
		//ng.getCostImportance()*net.getCost()
		// cost 
		if (rating > 0 && stateful < 0) {
			//rating = rating / Math.abs(stateful);
		}
		if (plot) {
		//	//////System.out.println("f: " + f + " t: " + t + " n: " + n + "rating: " + rating);
		//	//////System.out.println("vio: " + Combination.getCs().calcVio(f, n) + "_stateful:" + 
		//			Combination.getCs().getStatefulReward(f, t) + "_timematch: " + Combination.getCs().getTimeMatch(f, t)/getAvMinTp(Combination.getCs().getTg().getFlows().get(f))
		//			+ "_switchCost: " + switchCost 
		//			+ "_money: " + monetaryCost + "_unsched:" + costUnsched);
//			plot = false;
//			new File("./25_10_uncertainty/").mkdir(); // + uncertainty + "/").mkdir();
//			File log = new File("./25_10_uncertainty/" + "balancer" + ".txt");
//		    try{
//			    if(log.exists() == false){
//			            ////////System.out.println("We had to make a new file.");
//			            log.createNewFile();
//			    }
//				PrintWriter out = new PrintWriter(new FileWriter(log, true));
//				//out.append("addCharacteristicsUncertainty: \n");
//				out.append("vio: " + Combination.getCs().calcVio(f, n) + "_stateful:" + 
//						Combination.getCs().getStatefulReward(f, t) + "_timematch: " + Combination.getCs().getTimeMatch(f, t)/getAvMinTp(Combination.getCs().getTg().getFlows().get(f))
//						+ "_switchCost: " + switchCost 
//						+ "_money: " + monetaryCost);
//				//out.append("f_t_n:" + flowId + "_" + t + "_" + n + "/" + costUnsched + " /" + costSched);
//				out.append("******************************\n");
//				out.close();
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}

		return rating;
	}
	
	
	protected int getAvMinTp(Flow flow){
		//get minimum throughput requirement of flow
		return (int) Math.ceil(flow.getTokensMin()/flow.getWindowMin())+1;
	}
	
	
	public void calPriorCost() {
		for (int i = 0; i < partNum; i++) {
			costPrior[i] = (double) priority[i] / sumPrior;
		}
	}
	
	
	public static int sum(int[] req) {
		int sum = 0;
		for (int i = 0; i < req.length; i++) {
			sum += req[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		
		/*
		// test 1 - works
		Balancer b = new Balancer(50, 3, 1, 8);
		int[] mQ = {20, 30, 30};
		b.setMinReq(mQ);
		double[] cD = {0.5, 0, 0};
 		b.setCostDelay (cD);
 		double[] cDL = {1.3, 1, 1};
 		b.setCostDropLight(cDL);
 		double[] cDH = {3, 3, 3};
		b.setCostDropHeavy(cDH);
		int[] p = {3, 2, 2};
		b.setPriority(p);
		b.calPriorCost();
		b.allocate();
		////////System.out.println("evaluate: " + b.evaluator());
		*/
		// test 2 - multi balancer - 3 Network, 5 Flows
		NetworkGenerator ngReal = new NetworkGenerator();
		ngReal.addNetwork(Network.getCellular(20, 100));
		ngReal.addNetwork(Network.getWiFi(10, 85, 5));
		ngReal.addNetwork(Network.getWiFi(10, 65, 10));
		ngReal.addNetwork(Network.getCellular(10, 60));

		// network capacity changes
		/*
		ngReal.addNetwork(Network.getCellular(20, 80)); //90));	
		ngReal.addNetwork(Network.getWiFi(10, 60, 5));
		ngReal.addNetwork(Network.getWiFi(10, 65, 10));
		*/
		
		//ngReal.addNetwork(Network.getCellular(15, 50));
		//ngReal.addNetwork(Network.getWiFi(20, 65, 35));
		for (Network n : ngReal.getNetworks()) {
			System.out.print(n.getId());
		}
		////////System.out.println("---------");
		
		
		FlowGenerator tg = new FlowGenerator();
		tg.addFlow(Flow.LiveStram(3, 15, 6*125)); // 0
		tg.addFlow(Flow.BufferableStream(4, 17, 13*70)); // 1
		tg.addFlow(Flow.BufferableStream(5, 19, 10*50)); // 2
		tg.addFlow(Flow.Interactive(10, 15)); // 3
		tg.addFlow(Flow.Background(300, 2, 19)); // 4
		for (Flow f : tg.getFlows()) {
			////////System.out.println("**** " + f.getId());
			f.setIndex(f.getId());
		}
		
		CostSeparation cs = new CostSeparation(tg, ngReal);
		Combination.setCs(cs);
		
		int netNum = 3, flowNum = 5;
		
		int[] mQ2 = {20, 20, 30, 30, 80};
		int[] max = {40, 40, 100, 40, 120};

		int[] prior = {3, 3, 2 ,2, 1};
		int priorSum = sum(prior);
		/*
		int[] delReq = {4, 4, 10, 10, Integer.MAX_VALUE};
		int[] capPred = {40, 70, 100};
		
		int[] delReal = {1, 8, 15};
		double[] costDropLight = {2, 2, 2, 1, 0};
		double[] costDropHeavy = {2.5, 2.5, 2.2, 2.2, 3.5};
		*/
		int[] capReal = {10, 60, 120};
		int[][] combN = {{1, 1, 2, 2, 3}, {1, 2, 2, 2, 3}, {1, 2, 2, 3, 3}, {1, 1, 2, 3, 3}, {1, 1, 2, 2, 2}};

		int[][] partN = {{2, 2, 1}, {1, 3, 2}, {1, 2, 2}, {2, 1, 2}, {2, 3, 0}};
		
		double[] combCost = new double[combN.length];
		// ////////System.out.println("-----------------------------------------------------");

		for (int k = 0; k < 1; k++) {
			int[] comb = combN[k].clone();
			int[] part = partN[k].clone();
			int step = 1;
			// ////////System.out.println("***********************************");
			for (int i = 0; i < netNum; i++) {
				int pN = part[i];
				int cap = capReal[i];
				int[] minReq = new int[pN];
				int[] maxReq = new int[pN];
				int[] p2 = new int[pN];
				int[] flowId = new int[pN];
				double[] dLC = new double[pN];
				double[] dHC = new double[pN];
				double[] delC = new double[pN];
				pick(mQ2, minReq, comb, i + 1);
				//pick(costDropLight, dLC, comb, i + 1);
				//pick(costDropHeavy, dHC, comb, i + 1);
				pickFlowId(flowId, comb, i + 1);
				pick(prior, p2, comb, i + 1);
				//pick(max, maxReq, comb, i + 1);
				/*
				int delCI = 0;
				for (int j = 0; j < comb.length; j++) {
					if (comb[j] == (i + 1)) {
						delC[delCI] = calcDelCost(delReq[j], delReal[i]);
						delCI++;
					}
				}*/
				Balancer b2 = new Balancer(cap, pN, step, priorSum);
				b2.setMinReq(minReq);
		 		b2.setCostDelay(delC);
		 		b2.setCostDropLight(dLC);
				b2.setCostDropHeavy(dHC);
				b2.setPriority(p2);
				b2.calPriorCost();
				b2.setFlowId(flowId);
				b2.setMax(maxReq);
				b2.allocate(i, 10);
				//Printer.print(b2.costPrior);
				combCost[k] += b2.evaluator(10, i);
//				//Printer.printInt(b2.result);
				//////////System.out.println("evaluate: " + b2.evaluator());	
				//////////System.out.println("***********************************");
			}
			//////////System.out.println("-----------------------------------------------------");
			
		}
//		Printer.print(combCost);
		
		
	}
	public static void pick(int[] orig, int[] dest, int[] comb, int[] activeFlow, int nIndex) {
		// int[] result = new int[part[nIndex]];
		int rI = 0;
		//////////System.out.println(nIndex);
		////Printer.printInt("orig", orig);
		////Printer.printInt("dest", dest);
		////Printer.printInt("comb", comb);
		if (dest.length == 0) return;

		for (int i = 0; i < comb.length; i++) {
			//////////System.out.println("i: " + i);
			//////////System.out.println("rI: " + rI);
			if (comb[i] == nIndex) {
				dest[rI] = orig[activeFlow[i]];
				////Printer.printInt("after dest", dest);

				rI++;
			}
		}
		////Printer.printInt("after dest", dest);
		// return result;
	}
	
	public static void pickFlowId(int[] dest, int[] comb, int[] activeFlow, int nIndex) {
		// int[] result = new int[part[nIndex]];
		int rI = 0;
		//////////System.out.println(nIndex);
		////Printer.printInt("orig", orig);
		////Printer.printInt("dest", dest);
		////Printer.printInt("comb", comb);
		if (dest.length == 0) return;

		for (int i = 0; i < comb.length; i++) {
			//////////System.out.println("i: " + i);
			//////////System.out.println("rI: " + rI);
			if (comb[i] == nIndex) {
				dest[rI] = activeFlow[i];
				////Printer.printInt("after dest", dest);

				rI++;
			}
		}
		////Printer.printInt("after dest", dest);
		// return result;
	}
	
	public static void pickFlowId(int[] dest, int[] comb,  int nIndex) {
		// int[] result = new int[part[nIndex]];
		int rI = 0;
		//////////System.out.println(nIndex);
		////Printer.printInt("orig", orig);
		////Printer.printInt("dest", dest);
		////Printer.printInt("comb", comb);
		if (dest.length == 0) return;

		for (int i = 0; i < comb.length; i++) {
			//////////System.out.println("i: " + i);
			//////////System.out.println("rI: " + rI);
			if (comb[i] == nIndex) {
				dest[rI] = i;
				////Printer.printInt("after dest", dest);

				rI++;
			}
		}
		////Printer.printInt("after dest", dest);
		// return result;
	}
	
	public static void pick(int[] orig, int[] dest, int[] comb, int nIndex) {
		// int[] result = new int[part[nIndex]];
		int rI = 0;
		// ////////System.out.println(nIndex);
		////Printer.printInt("orig", orig);
		////Printer.printInt("dest", dest);
		////Printer.printInt("comb", comb);
		if (dest.length == 0) return;

		for (int i = 0; i < comb.length; i++) {
		//	////////System.out.println("i: " + i);
		//	////////System.out.println("rI: " + rI);
			if (comb[i] == nIndex) {
				dest[rI] = orig[i];
				////Printer.printInt("after dest", dest);

				rI++;
			}
		}
		// //Printer.printInt("after dest", dest);
		// return result;
	}
	
	public static void pick(double[] orig, double[] dest, int[] comb, int nIndex) {
		int rI = 0;
		if (dest.length == 0) return;

		for (int i = 0; i < comb.length; i++) {
			if (comb[i] == nIndex) {
				dest[rI] = orig[i];
				rI++;
			}
		}
	}
	
	public static void pick(double[] orig, double[] dest, int[] comb, int[] activeFlow, int nIndex) {
		int rI = 0;
		if (dest.length == 0) return;
		for (int i = 0; i < comb.length; i++) {
			if (comb[i] == nIndex) {
				////////System.out.println("rI: " + rI + "i: " + i + " activeFlow" +  activeFlow[i]);
//				//Printer.printInt("activeFlow: ", activeFlow);
//				Printer.print(orig);
				dest[rI] = orig[activeFlow[i]];
				rI++;
			}
		}
	}
	
	
	public static double calcDelCost(int delReq, int delReal) {
		if (delReq > delReal) return 0.0;
		return (delReal - delReq) / delReq;
	}
	
	public double evaluatorSmall(int fIndex) {
		int dropLight = 0, dropHeavy = 0;
		double dLC = 0, dHC = 0, delC = 0; // dropLightCost, dropHeavyCost, delayCost
		int alloc = result[fIndex];
		int req = minReq[fIndex];
		// delC = calDelCost()
		delC = alloc * costDelay[fIndex]; 

		// optimal
		if (req <= alloc) {
		//	////////System.out.println("delc: " + delC + "alloc: " + (alloc - req) + "priorCost: " + (alloc - req) * costPrior[fIndex]);
			return delC - (alloc - req) * costPrior[fIndex]; // delayCost - more allocated
		}
		
		dropLight = req - (int) Math.max(req * degree, alloc);
		dropHeavy = (int) ((req * degree - alloc) > 0? req * degree - alloc: 0);
		dLC = dropLight * costDropLight[fIndex];
		dHC = dropHeavy * costDropHeavy[fIndex];
		return delC + dLC + dHC;
	}
	public double evaluator() {
		double sum = 0;
		for (int i = 0; i < partNum; i++) {
			sum += evaluatorSmall(i);
			//////////System.out.println(evaluatorSmall(i));
		}
		return sum;
	}
	
	public double evaluator(int t, int n) {
		double sum = 0;
		Network net = Combination.getNg().getNetworks().get(n);
		int monetaryCost = net.getCost() * Combination.getNg().getCostImportance();
		for (int i = 0; i < partNum; i++) {
			int fId = getFlowId()[i];
			Flow flow = Combination.getFg().getFlows().get(fId);
			double costUnsched = (double) flow.getImpUnsched()* flow.getImpUser();
			sum += (calcCostFinal(i , t, n) * result[i]); //+ monetaryCost*result[i] - (result[i] - (flow.getChunks() / (flow.getDeadline() - flow.getStartTime())))*costUnsched;
			//////////System.out.println("f: " + flowId[i] + "t: " + t + "n: " + n + "cost: " + calcCost(flowId[i] , t, n) * result[i]);
		}
		return sum;
	}
	
	public int getPartNum() {
		return partNum;
	}
	public void setPartNum(int partNum) {
		this.partNum = partNum;
	}
	public int[] getMinReq() {
		return minReq;
	}
	public void setMinReq(int[] minReq) {
		this.minReq = minReq;
	}
	public double[] getCostDelay() {
		return costDelay;
	}
	public void setCostDelay(double[] costDelay) {
		this.costDelay = costDelay;
	}
	public double[] getCostDropLight() {
		return costDropLight;
	}
	public void setCostDropLight(double[] costDropLight) {
		this.costDropLight = costDropLight;
	}
	public double[] getCostDropHeavy() {
		return costDropHeavy;
	}
	public void setCostDropHeavy(double[] costDropHeavy) {
		this.costDropHeavy = costDropHeavy;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getDegree() {
		return degree;
	}
	public void setDegree(double degree) {
		this.degree = degree;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}

	public int[] getPriority() {
		return priority;
	}

	public void setPriority(int[] priority) {
		this.priority = priority;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public double[] getCostPrior() {
		return costPrior;
	}

	public void setCostPrior(double[] costPrior) {
		this.costPrior = costPrior;
	}

	public int[] getMax() {
		return max;
	}

	public void setMax(int max[]) {
		this.max = max;
	}

	public int[] getFlowId() {
		return flowId;
	}

	public void setFlowId(int[] flowId) {
		this.flowId = flowId;
	}

	public static boolean isSc() {
		return sc;
	}

	public static void setSc(boolean sc) {
		Balancer.sc = sc;
	}
	
}
