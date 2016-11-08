package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;
import tabusearch.Solution;

import ToolSet.CostSeparation;

public class Combination implements Solution{
	
	private static int netNum = 5, flowNum = 10;
	private static int[] mQ = {65, 20, 50, 30, 80, 50, 0};
	private static int[] max = {100, 100, 100, 40, 120, 100, 0};
	private static int[] prior = {3, 3, 2 ,2, 1, 3, 0};
	private static int priorSum = sum(getPrior());
	private static int[] delReq = {4, 4, 10, 10, Integer.MAX_VALUE, 20, 0};
	private static int[] capPred = {40, 70, 100, 30, 0};
	private static int[] capReal = {100, 85, 10, 50, 0};
	private static int[] delReal = {1, 8, 15, 10, 0};
	private static double[] costDropLight = {2, 2, 2, 1, 0, 1, 0};
	private static double[] costDropHeavy = {2.5, 2.5, 3, 2.2, 3.5, 2.2, 0};
	private static int[]initGenes = {1, 2, 3, 2, 1, 0, 0, 0, 0, 0};
	private static int round = 100;
	private static int[] activeNetworkBool = {1, 1, 1, 1, 0, 0, 0};
	private static int[] networkType = {1, 2, 2, 1, 1, 2, 2};
	private static NetworkGenerator ng;
	private static FlowGenerator fg;

	private static int[] activeFlowBool = {1, 1, 1, 1, 1, 0, 0, 0}; // 8
	private static int time;
	private static CostSeparation cs;
	 
	private int[] comb;
	private int[] part;
	private int[] result;
	private int[] resultGlobal = new int[Combination.getFlowNum()];
	private int[] combGlobal = new int[Combination.getFlowNum()];
	
	private double combCost = -1;
	
	public Combination(int[] combVar) {
		int[] activeFlow = new int[Combination.getActiveFlowNum()];
		int[] activeComb = new int[Combination.getActiveFlowNum()];
		// set those inactive networks to 0
		for (int i = 0, aF = 0; i < combVar.length && aF < Combination.getActiveFlowNum(); i++) {
			if (getActiveFlowBool()[i] > 0) {
				activeFlow[aF] = i;
				////Printer.printInt("comb", combVar);
				//////////System.out.println("i: " + i + " - " + combVar[i]);
				if (combVar[i] < 1 || combVar[i] > getActiveNetworkBool().length || getActiveNetworkBool()[combVar[i] - 1] < 1) {
					activeComb[aF] = 0;
				} else {
					activeComb[aF] = combVar[i];
				}
				aF++;
			}
		}
		//////////System.out.println("new activecomb: ");
		////Printer.printInt(activeComb);
		setComb(activeComb);
		updatePart();
		setResult(new int[comb.length]);
	}
	

	
	public Combination() {
		// TODO Auto-generated constructor stub
		//////System.out.println("flowNum: " + Combination.getFlowNum());
		comb = new int[Combination.getActiveFlowNum()];
		setResult(new int[comb.length]);
//		updatePart();
	}

	public static int sum(int[] req) {
		int sum = 0;
		for (int i = 0; i < req.length; i++) {
			sum += req[i];
		}
		return sum;
	}

	public double run() {
		int t = Combination.getTime();
		setCombCost(0);
		int step = 1;
	
		////Printer.printInt("before", getComb());
		/*
		for (int i = 0; i < getNetNum(); i++) {
			if (activeNetworkBool[i] < 1) {
				for (int j = 0; j < getComb().length; j++) {
					if (getComb()[j] == i + 1) {
						getComb()[j] = 0;
						
					}
				} 

			}
		}
		//////////System.out.println("comb after zero processing: ");
		////Printer.printInt(getComb());
		updatePart();
		*/
		////Printer.printInt(getPart());
		Combination.extend(getCombGlobal(), getComb(), getActiveFlow());
		////Printer.printInt("comb", getCombGlobal());
		////Printer.printInt("globalcomb", getCombGlobal());
		for (int i = 0; i < getNetNum() + 1; i++) { // contains network "0", in order to add the cost for dropped packets (assigned to 0)
			
			int pN = getPart()[i];
			int cap = 0;
			if (i != 0) {
				cap = getCapReal()[i-1];
			}
			////Printer.printInt("pN", getPart());
			int[] minReq = new int[pN];
			int[] maxReq = new int[pN];
			int[] p2 = new int[pN];
			int[] flowId = new int[pN];
			double[] dLC = new double[pN];
			double[] dHC = new double[pN];
			double[] delC = new double[pN];
			updatePart();
			Balancer.pick(getmQ(), minReq, getComb(), getActiveFlow(), i);
			//if (i==1) //Printer.printInt("mQ", minReq);

			Balancer.pick(getPrior(), p2, getComb(),getActiveFlow(), i);

			Balancer.pick(getMax(), maxReq, getComb(),getActiveFlow(), i);

			Balancer.pickFlowId(flowId, getComb(), getActiveFlow(), i);

			Balancer b = new Balancer(cap, pN, step, getPriorSum());
			b.setMinReq(minReq);
			b.setPriority(p2);
			b.calPriorCost();
			b.setMax(maxReq);
			b.setFlowId(flowId);
			//if (i == 1) //Printer.printInt("b-max", b.getMax());
			if (i > 0) {
				b.allocate(i-1, t);
				////Printer.printInt("result", b.getResult());
				setCombCost(getCombCost() + b.evaluator(Combination.time, i-1));

			} else {
			//	b.allocate(i, t);
			}
			//Printer.print(b2.costPrior);
			////Printer.printInt(b.getResult());
			//////////System.out.println("evaluate: " + b.evaluator());	
			//////////System.out.println("***********************************");
			int rIndex = 0;
			
			for (int j = 0; j < comb.length; j++) {
				if (comb[j] != 0 && comb[j] == i) {
					getResult()[j] = b.getResult()[rIndex];
					rIndex++;
					if (rIndex >= pN) {
						break;
					}
				}
			}
		}
	
		Combination.extend(getResultGlobal(), getResult(), getActiveFlow());
		Combination.extend(getCombGlobal(), getComb(), getActiveFlow());
	//	//Printer.printInt("global result", getResultGlobal());
	//	updateState();
		return getCombCost();
	}
	

	public void updateState() {
		// bug
		for (int f : getActiveFlow()) {
			Combination.getCs().updateStatefulReward(f, Combination.time, getResultGlobal()[f]);
		}

	}

	public static void assignResult(int[] result, int[] subResult) {
		// for (int i = 0; i < )
	}
	
	public void updatePart() {
		int[] partNew = new int[netNum + 1]; // add network 0 (this represents unavailable network)
		for (int i = 0; i < comb.length; i++) {
			if (comb[i] < 1) partNew[0] += 1;//continue;
			else partNew[comb[i]] += 1;
		}
		setPart(partNew);
	}


	public int[] getComb() {
		return comb;
	}

	public void setComb(int[] comb) {
		this.comb = comb;
		updatePart();
	}

	public int[] getPart() {
		return part;
	}

	public void setPart(int[] part) {
		this.part = part;
	}

	public static int getFlowNum() {
		return mQ.length; //flowNum;
	}

	public static void setFlowNum(int flowNum) {
		Combination.flowNum = flowNum;
	}

	public static int getNetNum() {
		return netNum;
	}

	public static void setNetNum(int netNum) {
		Combination.netNum = netNum;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] result) {
		this.result = result;
	}

	public static int[] getInitGenes() {
		return initGenes;
	}

	public static void setInitGenes(int[] initGenes) {
		Combination.initGenes = initGenes;
	}

	public static int getRound() {
		return round;
	}

	public static void setRound(int round) {
		Combination.round = round;
	}
	
	public static void extend(int[] orig, int[] sub, int[] index) {
		////Printer.printInt(orig);
		////Printer.printInt(sub);
		////Printer.printInt(index);
		for (int i = 0; i < sub.length; i++) {
			orig[index[i]] = sub[i];
		}
	}
	
	public int[] getActiveFlow() {
		int[] activeFlow = new int[getActiveFlowNum()];
		for (int i = 0, aF = 0; i < getFlowNum(); i++) {
			if (getActiveFlowBool()[i] == 1) {
				activeFlow[aF] = i;
				aF++;
			}
		}
		//////////System.out.println("active Flow: ");
		////Printer.printInt(activeFlow);
		return activeFlow;
	}
	
	public static int getActiveFlowNum() {
		int result = 0;
		for (int af: getActiveFlowBool()) {
			if (af > 0) {
				result++;
			}
		}
		return result;
	}
	
	public static int getActiveNetNum() {
		int result = 0;
		for (int af: getActiveNetworkBool()) {
			if (af > 0) {
				result++;
			}
		}
		return result;
	}
	
	public static Set<Integer> getAvailableNetworks() {
		Set<Integer> netPool = new HashSet<Integer>();
		//netPool.add(0);
		for (int i = 0; i < getActiveNetworkBool().length; i++) {
			if(getActiveNetworkBool()[i] > 0) {
				netPool.add(i+1);
			}
		}
		return netPool;
	}
	
	public static HashMap<Integer, Set<Integer>> getNetTypeMap() {
		HashMap<Integer, Set<Integer>> result = new HashMap();
		int[] activeNet = getActiveNetworkBool();
		int[] netType = getNetworkType();
		for (int i = 0; i < getActiveNetworkBool().length && i < netType.length; i++) {
			if (activeNet[i] > 0) {
				if (result.containsKey(netType[i])) {
					result.get(netType[i]).add(i + 1);
				} else {
					Set<Integer> arr = new HashSet<Integer>();
					arr.add(i + 1);
					result.put(netType[i], arr);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		for (Integer netType : getNetTypeMap().keySet()) {
			//////System.out.println("nt" + netType + "- " + getNetTypeMap().get(netType).toString());
			
			
		}
	}
	
	public void printResult() {
		////////System.out.println(" result: ");

		//Printer.printInt(result);
		////////System.out.println("global result: ");
		//Printer.printInt(getResultGlobal());
		////////System.out.println(" comb: ");

		//Printer.printInt(getComb());
		////////System.out.println("global comb: ");

		//Printer.printInt(getCombGlobal());
		
		////////System.out.println("activeNetwork: ");
		////////System.out.println(Combination.getAvailableNetworks().toString());
	}



	public static int[] getmQ() {
		return mQ;
	}



	public static void setmQ(int[] mQ) {
		Combination.mQ = mQ;
	}



	public static int[] getDelReq() {
		return delReq;
	}



	public static void setDelReq(int[] delReq) {
		Combination.delReq = delReq;
	}



	public static int[] getDelReal() {
		return delReal;
	}



	public static void setDelReal(int[] delReal) {
		Combination.delReal = delReal;
	}



	public static int[] getPrior() {
		return prior;
	}



	public static void setPrior(int[] prior) {
		Combination.prior = prior;
	}



	public static double[] getCostDropLight() {
		return costDropLight;
	}



	public static void setCostDropLight(double[] costDropLight) {
		Combination.costDropLight = costDropLight;
	}



	public static double[] getCostDropHeavy() {
		return costDropHeavy;
	}



	public static void setCostDropHeavy(double[] costDropHeavy) {
		Combination.costDropHeavy = costDropHeavy;
	}



	public static int[] getActiveNetworkBool() {
		return activeNetworkBool;
	}



	public static void setActiveNetworkBool(int[] activeNetworkBool) {
		Combination.activeNetworkBool = activeNetworkBool;
	}



	public static int[] getActiveFlowBool() {
		return activeFlowBool;
	}



	public static void setActiveFlowBool(int[] activeFlowBool) {
		Combination.activeFlowBool = activeFlowBool;
	}



	public static int getPriorSum() {
		return priorSum;
	}



	public static void setPriorSum(int priorSum) {
		Combination.priorSum = priorSum;
	}



	public static int[] getCapReal() {
		return capReal;
	}



	public static void setCapReal(int[] capReal) {
		Combination.capReal = capReal;
	}



	public int[] getResultGlobal() {
		return resultGlobal;
	}



	public void setResultGlobal(int[] resultGlobal) {
		this.resultGlobal = resultGlobal;
	}



	public int[] getCombGlobal() {
		return combGlobal;
	}



	public void setCombGlobal(int[] combGlobal) {
		this.combGlobal = combGlobal;
	}



	public static int[] getMax() {
		return max;
	}



	public static void setMax(int[] max) {
		Combination.max = max;
	}



	public double getCombCost() {
		return combCost;
	}



	public void setCombCost(double combCost) {
		this.combCost = combCost;
	}



	public static CostSeparation getCs() {
		return cs;
	}



	public static void setCs(CostSeparation cs) {
		Combination.cs = cs;
	}



	public static int getTime() {
		return time;
	}



	public static void setTime(int time) {
		Combination.time = time;
	}



	public static int[] getNetworkType() {
		return networkType;
	}



	public static void setNetworkType(int[] networkType) {
		Combination.networkType = networkType;
	}
	
	@Override
	public Double getValue() {	
		//if (run() < 0) return Double.MAX_VALUE;
		return run();
	}

	@Override
	public List<Solution> getNeighbors() {
		// TODO Auto-generated method stub
		List<Solution> neigh = new ArrayList<Solution>();
		Random random = new Random();
		Integer neighborsCount = random.nextInt(7) + 3; 
		Set<Integer> genePool = Combination.getAvailableNetworks();
		for (int j = 0; j < neighborsCount; j++) { 
		    int[] comb = this.getComb().clone();
		    if (j < comb.length) {
		    	int net = getRandomGene();
		    	comb[j] = net;
		    	obeyConstraint(net, comb);
		    	neigh.add(new Combination(comb));
		    }
		} 
		return neigh;
	}
	
	public int getRandomGene() {
		Set<Integer> genePool = Combination.getAvailableNetworks();

		int item = genePool.size() == 0? 0 : new Random().nextInt(genePool.size()); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(Integer gene : genePool) {
		    if (i == item)
		        return gene;
		    i = i + 1;
		}
		return 1;
	}
	
    public void obeyConstraint(int net, int[] com) {
    	//HashMap<Integer, Set<Integer>> netTypeSet = getGeneType();
    	int[] genetype = Combination.getNetworkType().clone();
    	int nt = 0;
    	if (net - 1 < genetype.length && net - 1 >= 0) {
    		nt =  genetype[net - 1];
    	} else {
    		return;
    	}
    	
    	for (int i = 0; i < com.length; i++) {
    		if (com[i] - 1 < 0) continue;
    		if (com[i] == net) continue;
    		if (genetype[com[i] - 1] == nt) {
    			////Printer.printInt("type: ", genetype);
    			////////System.out.println("obeyConstraint: " + "f_" + i + "orig_" + com[i] + "replace_" + net);
    			com[i] = net;
    		}
    	}   	
    }



	public static NetworkGenerator getNg() {
		return ng;
	}



	public static void setNg(NetworkGenerator ng) {
		Combination.ng = ng;
	}



	public static FlowGenerator getFg() {
		return fg;
	}



	public static void setFg(FlowGenerator fg) {
		Combination.fg = fg;
	}
	
	

}