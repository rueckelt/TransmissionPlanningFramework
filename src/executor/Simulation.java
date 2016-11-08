package executor;
import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import ToolSet.CostSeparation;
import ToolSet.JsonLogger;
import ToolSet.LogMatlabFormat;
import ccpga.copy.CCP_Ga;
import ccpga.copy.Individual;
import ccpga.copy.Population;
import schedulers.GreedyScheduler;
import schedulers.Scheduler;
import schedulingIOModel.CostFunction;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;
import tabusearch.BasicNeighborSolutionLocator;
import tabusearch.IterationsStopCondition;
import tabusearch.Solution;
import tabusearch.StaticTabuList;
import tabusearch.TabuSearch;
import utils.Balancer;
import utils.Combination;
import utils.Printer;
import visualization.Plot;
import visualization.VisualizationPack;


public class Simulation {
	
	public  int simTime = 100;
	private NetworkGenerator ngPred;
	private FlowGenerator fgPred;
	private FlowGenerator fg;
	private NetworkGenerator ngReal;
	private int maxFlow = 10;
	private int maxNet = 8;
	private int count = 0;
	private long duration = 0;
	private static Combination previous; //= new Combination();
	
	private int[] mQ;
	private int[] netType;
	private List<List<Integer>> netCap = new ArrayList<List<Integer>>(); 
	private List<Integer> throughput; // size: flowSize
	private List<Integer> dataSize;   // size: flowSize
	private List<Integer> tpLongTerm;
	private static Combination comb; // set qos statics 
	private int[][][] longTermSP;
	private ArrayList<ArrayList<ArrayList<Integer>>> adaptedSPAL;
	private int[][][] adapted;
	private int[][][] adaptedBF;
	private CCP_Ga adaptor;
	private Object getNumFlowPred;
	private static ArrayList<Integer> costAdaptedFalse = new ArrayList<Integer>();
	private static ArrayList<Integer> costAdaptedTrue = new ArrayList<Integer>();
	private static ArrayList<Integer> costExecuted = new ArrayList<Integer>();
	private static ArrayList<Integer> numFlowReal = new ArrayList<Integer>();
	private static ArrayList<Integer> numFlowPred = new ArrayList<Integer>();
	private static ArrayList<Integer> numNetReal = new ArrayList<Integer>();
	private static ArrayList<Integer> costAdaptedOpt = new ArrayList<Integer>();
	private static ArrayList<Integer> costAdaptedExe = new ArrayList<Integer>();
	private static ArrayList<Integer> costExeOpt = new ArrayList<Integer>();


	public Simulation(String path) {
		longTermSP = JsonLogger.json2Array(path);
	}
	
	public Simulation(String path, FlowGenerator fgPred, NetworkGenerator ngPredVar, FlowGenerator fgVar, NetworkGenerator ngRealVar) {
		longTermSP = JsonLogger.json2Array(path);
		//adaptedSP = new int[longTermSP.length][longTermSP[0].length][longTermSP[0][0].length];
		//adaptedSP = new int[longTermSP.length + 1][longTermSP[0].length][longTermSP[0][0].length];
		setFgPred(fgPred);
		setNgPred(ngPredVar);
		setFg(fgVar);
		setNgReal(ngRealVar);
		initEnvConfig();
	}
	
	/*
	 * init networkPred capacity
	 * flow QoS
	 */
	public void initEnvConfig() {
		// f - minReq
		Combination.setmQ(new int[fg.getFlows().size()]);
		Combination.setMax(new int[fg.getFlows().size()]);
		Combination.setActiveFlowBool(new int[fg.getFlows().size()]);
		Combination.setPrior(new int[fg.getFlows().size()]);
		Combination.setActiveNetworkBool(new int[ngReal.getNetworks().size()]);
		Combination.setNetworkType(new int[ngReal.getNetworks().size()]);
		Combination.setCapReal(new int[ngReal.getNetworks().size()]);
		Combination.setNetNum(ngReal.getNetworks().size());
		Combination.setFlowNum(fg.getFlows().size());
		Simulation.setPrevious(new Combination());
		Combination.setNg(this.ngReal);
		Combination.setFg(this.fg);
		
		// n - precess id
		int initReal = ngReal.getNetworks().get(0).getId();
		int initPred = ngPred.getNetworks().get(0).getId();
		if (initReal != 0) {
			Simulation.processId(ngReal, initReal);
		}
		
		if (initPred != 0) {
			Simulation.processId(ngPred, initPred);
		}
		int initRealFlow = fg.getFlows().get(0).getId();
		////////System.out.println("initRealFlow: " + initRealFlow);
		int initPredFlow = fgPred.getFlows().get(0).getId();
		if (initRealFlow != 0) {
			Simulation.processId(fg, initRealFlow);
		}
		
		if (initPredFlow != 0) {
			Simulation.processId(fgPred, initPredFlow);
		}

		for (Flow f : fg.getFlows()) {
			////////System.out.println("id: " + f.getIndex() + " - " + f.getTokensMin() + " - " + f.getWindowMin());
			// TODO 
			Combination.getmQ()[f.getIndex()] = (int) f.getTokensMin() / f.getWindowMin();
			mQ = Combination.getmQ().clone();
		}
		
		// f - priority
		for (Flow f : fg.getFlows()) {
			////////System.out.println("id: " + f.getIndex() + " - " + f.getImpUser());
			// TODO 
			Combination.getPrior()[f.getIndex()] = f.getImpUser();
		}
		
		setDataSize(new ArrayList<Integer>());
		setThroughput(new ArrayList<Integer>());

		for (Flow f : fg.getFlows()) {
			getDataSize().add(f.getChunks());
			getThroughput().add(0);
			comb.getMax()[f.getIndex()] = Math.min(f.getTokensMax() / f.getWindowMax(), f.getChunks());
		}
		
		for (int i = 0; i < ngReal.getNetworks().size(); i++) {
			Combination.getNetworkType()[i] = ngReal.getNetworks().get(i).getType();
//			//Printer.printInt("net type after initialization: ", Combination.getNetworkType());
		}		
		initDeactivate();
		updateNetworkConfig(true);
		adaptedSPAL = new ArrayList<ArrayList<ArrayList<Integer>>>();
	}
	
	
	public void initDeactivate() {
		for (int i = 0; i < Combination.getActiveFlowBool().length; i++) {
			Combination.getActiveFlowBool()[i] = 0;
		}
		
		for (int i = 0; i < Combination.getActiveNetworkBool().length; i++) {
			Combination.getActiveNetworkBool()[i] = 0;
		}
		
		for (int i = 0; i < Combination.getInitGenes().length; i++) {
			Combination.getInitGenes()[i] = 0;
		}
		
		for (int i = 0; i < Combination.getCapReal().length; i++) {
			Combination.getCapReal()[i] = 0;
		}
	}
	
	public void updateFlowConfig(boolean onOff) {
		for (Flow f : fg.getFlows()) {
			activateFlow(f.getIndex(), onOff);
		}
	}
	
	public void updateNetworkConfig(boolean onOff) {
		for (Network n : ngReal.getNetworks()) {
			activateNetwork(n.getId(), onOff);
		}
	}
	
	public void activateFlow(int index, boolean active) {
		Combination.getActiveFlowBool()[index] = active? 1 : 0;
	}
	
	public void activateNetwork(int index, boolean active) {
		Combination.getActiveNetworkBool()[index] = active? 1 : 0;
	}
	
	public void updateInitSP(int ts) {
		if (ts >= longTermSP[0].length) return;
		for (int f = 0; f < longTermSP.length && f < Combination.getInitGenes().length; f++) {
			for (int n = 0; n < longTermSP[0][0].length; n++) {
				if (longTermSP[f][ts][n] != 0) {
				//	////////System.out.println(Combination.getInitGenes().length);
				//	//Printer.printInt(Combination.getInitGenes());
					Combination.getInitGenes()[f] = n + 1;
				}
			}
		}
		
	}
	
	//TODO combine with network availability
	public void updateNetCap(int ts) {
		for (Network n : ngReal.getNetworks()) {
			//////////System.out.println("newtork start time: " + n.getId() + " - " + n.getSlots() + " / " + n.);
			int cap = n.getCapacity().get(ts);	
			comb.getCapReal()[n.getId()] = cap;
			if (cap == 0) {
				activateNetwork(n.getId(), false);
			}
		}
	}
	
	public void updateFlowAvl(int ts) {
		for (Flow f : fg.getFlows()) {
	//		////////System.out.println("f-id: " + f.getId() + " - " + f.getStartTime());
			if (f.getStartTime() <= ts) {
				activateFlow(f.getIndex(), true);
			}
			int tp = getThroughput().get(f.getIndex());
			int ds = getDataSize().get(f.getIndex());
			if (ts > f.getDeadline() && !f.isBufferable()) {
			//	activateFlow(f.getIndex(), false);	
			}
			if (tp > 0 && tp >= ds) {
				activateFlow(f.getIndex(), false);
			}
		}
//		//Printer.printInt("activeFlow: ", comb.getActiveFlowBool());		
	}
	
	public void updateFlowAvl(int ts, boolean useOnlyScheduledFlow) {

		for (Flow f : fg.getFlows()) {
	//		////////System.out.println("f-id: " + f.getId() + " - " + f.getStartTime());
			if (f.getStartTime() <= ts) {
				activateFlow(f.getIndex(), true);
			}
			int tp = getThroughput().get(f.getIndex());
			int ds = getDataSize().get(f.getIndex());
			if (ts > f.getDeadline() && !f.isBufferable()) {
	//			activateFlow(f.getIndex(), false);	
			}
			if (tp > 0 && tp >= ds) { 
				activateFlow(f.getIndex(), false);
			}
		}
		if (useOnlyScheduledFlow) {
			for (int i = 0; i < comb.getInitGenes().length && i < fg.getFlows().size(); i++) {
				if (comb.getInitGenes()[i] == 0) {
					activateFlow(i, false);
				}
			}
			
			Set<Integer> newflows = getNewflowsId();
			////////System.out.println("newflows: " + newflows.toString());
			for (Integer nf : newflows) {
				activateFlow(nf, true);
				Flow f = fg.getFlows().get(nf);
				if (f.getStartTime() > ts) {
					activateFlow(f.getIndex(), false);
				}
				int tp = getThroughput().get(f.getIndex());
				int ds = getDataSize().get(f.getIndex());
				if (tp > 0 && tp >= ds) {
					activateFlow(f.getIndex(), false);
				}

			}
		}
//		//Printer.printInt("activeFlow: ", comb.getActiveFlowBool());
		
	}
	
	public void updateMax() {
		int fId = 0;
		int maxPrev = 0;
		for (Flow f : fg.getFlows()) {
			fId = f.getIndex();
			maxPrev = comb.getMax()[fId];
			comb.getMax()[fId] = Math.min(getDataSize().get(fId) - getThroughput().get(fId), maxPrev);
		}
	}
	
	public void updateMQ(int t) {
		int fId = 0;
		int mqPrev = 0;
		for (Flow f : fg.getFlows()) {
			fId = f.getIndex();
			mqPrev = comb.getmQ()[fId];
			comb.getmQ()[fId] = Math.min(getDataSize().get(fId) - getThroughput().get(fId), mqPrev);
			if (f.getDeadline() < t && f.isBufferable() == false) {
				comb.getmQ()[fId] = 0;
			}
			//////System.out.println("f_t: " + f.getId()+"_"+t + "rest: " + (getDataSize().get(fId) - getThroughput().get(fId)) + "-mq: " + comb.getmQ()[fId]);

		}
	}
	
	
	public static void processId(NetworkGenerator ng, int origId) {
		for (Network n : ng.getNetworks()) {
			n.setId(n.getId() - origId);
		}
	}
	
	public static void processId(FlowGenerator fg, int origId) {
		for (Flow f : fg.getFlows()) {
			f.setId(f.getId() - origId);
			////////System.out.println("***f.getId: " + f.getId());
		}
	}
	
	public void run_tb(boolean dep) {
		CostSeparation cs = new CostSeparation(fg, ngReal);
		Combination.setCs(cs);
		initEnvConfig();
		
		adapted = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
		adaptedBF = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
		long startTime = System.nanoTime();

		for (int i = 0; i < simTime; i++) {
			Combination.setTime(i);

			//////System.out.println("******************" + i + "*************");
			// each time slot - update initGene
			updateInitSP(i);
			////Printer.printInt("init: ", Combination.getInitGenes());
			// each time slot - update network capacity
			updateNetworkConfig(true);
			updateNetCap(i);
			updateFlowAvl(i, dep);
			updateMax();
//			//Printer.printInt("max: ", Combination.getMax());
			
			 Solution initialSolution = new Combination(Combination.getInitGenes());
			 Combination tmp = (Combination) initialSolution;
			 ////////System.out.println("initcost: " + tmp.getValue());
		   /************************************/
			// for (int s = 5; s <= 10; s++) { //the size of the tabu list 
				 //for (double i = 0.5; i <= 2; i += 0.5) { //the amount of iterations (50%, 100%, 150% and 200%) 
					int s = 10;
			 		Integer maxIterations = s * 50; 		     
					 TabuSearch ts = setupTS(s, maxIterations); 
					 Solution returnValue = ts.run(initialSolution); 
		    
					 Combination result = (Combination) returnValue;
//					 //Printer.printInt("resultComb", result.getCombGlobal());
					 ////////System.out.println("resultcost: " + result.getValue());
//					 //Printer.printInt("result", result.getResultGlobal());
			// } 
			   /************************************/

			if (Combination.getInitGenes().equals(result.getCombGlobal())) {
				count++;
			}
			for (int f = 0; f < fg.getFlows().size(); f++) {
				int netIndex = result.getCombGlobal()[f];
				if (netIndex > 0) {
					int resource = result.getResultGlobal()[f];
					if (resource > Combination.getCapReal()[netIndex - 1]) {
						//continue;
					} else {
						adapted[f][i][netIndex - 1] = resource;
						getThroughput().set(f, getThroughput().get(f) + resource);
					}

				}
			}	
			////////System.out.println("tp in : " + getThroughput().toString());
			updateMQ(i);
			////Printer.printInt("mq: ", Combination.getmQ());

			initDeactivate();
			
		}
		long endTime = System.nanoTime();
		setDuration((endTime - startTime) / 1000);
		////////System.out.println("\n duration: " + String.valueOf(endTime - startTime));
		////////System.out.println("duration: " + TimeUnit.SECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS) + "s");

	}
	
	public void run(boolean dependence, double d) {
		CostSeparation cs = new CostSeparation(fg, ngReal);
		Combination.setCs(cs);
		initEnvConfig();
		
		adapted = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
		adaptedBF = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
		long startTime = System.nanoTime();

		for (int i = 0; i < simTime; i++) {
			Combination.setTime(i);

			//////System.out.println("******************" + i + "*************");
			// each time slot - update initGene
			updateInitSP(i);
			////Printer.printInt("init: ", Combination.getInitGenes());
			// each time slot - update network capacity
			updateNetworkConfig(true);
			updateNetCap(i);
			updateFlowAvl(i, dependence);
			updateMax();
//			//Printer.printInt("max: ", Combination.getMax());
			//activateNetwork(2, false);
			// GA 
			////////System.out.println("initGene: " + Individual.getGenePool().toString());
			//long startTimeSmall = System.nanoTime();
			Individual result = CCP_Ga.run(d);
			//long endTimeSmall = System.nanoTime();
			//////////System.out.println("\nsmall duration: " + String.valueOf(endTimeSmall - startTimeSmall));
			setPrevious(result.getComb());
			if (Combination.getInitGenes().equals(result.getComb().getCombGlobal())) {
				count++;
			}
			for (int f = 0; f < fg.getFlows().size(); f++) {
				int netIndex = result.getComb().getCombGlobal()[f];
				if (netIndex > 0) {
					int resource = result.getComb().getResultGlobal()[f];
					if (resource > Combination.getCapReal()[netIndex - 1]) {
						//continue;
					} else {
						adapted[f][i][netIndex - 1] = resource;
						getThroughput().set(f, getThroughput().get(f) + resource);
					}

				}
			}	
			////////System.out.println("tp in : " + getThroughput().toString());
			updateMQ(i);
			////Printer.printInt("mq: ", Combination.getmQ());

			initDeactivate();
			
		}
		long endTime = System.nanoTime();
		setDuration((endTime - startTime) / 1000);
		////////System.out.println("\n duration: " + String.valueOf(endTime - startTime));
		////////System.out.println("duration: " + TimeUnit.SECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS) + "s");

	}
	


	public static void initArrayList() {
		Test.setCostOpt(new ArrayList<Integer>());
		Test.setCostGreedy4(new ArrayList<Integer>());
		Test.setCostRandom(new ArrayList<Integer>());

		Simulation.setCostAdaptedTrue(new ArrayList<Integer>());
		Simulation.setCostAdaptedFalse(new ArrayList<Integer>());

		Simulation.setCostExecuted(new ArrayList<Integer>());
		Simulation.setNumFlowReal(new ArrayList<Integer>());
		Simulation.setNumFlowPred(new ArrayList<Integer>());
		Simulation.setNumNetReal(new ArrayList<Integer>());
		Simulation.setCostAdaptedExe(new ArrayList<Integer>());
		Simulation.setCostAdaptedOpt(new ArrayList<Integer>());
		Simulation.setCostExeOpt(new ArrayList<Integer>());
		
		CCP_Ga.setConvergeList(new ArrayList<ArrayList<Double>>());
		CCP_Ga.setPopList(new ArrayList<ArrayList<Population>>());
		TabuSearch.setConvergeList(new ArrayList<ArrayList<Double>>());
		TabuSearch.setNeighList(new ArrayList<ArrayList<List<Solution>>>());

	
	}
	public static void main(String[] args) {
		/*****************Init Simulation Parameters***************/
		ArrayList<String> verf_true = new ArrayList<String>();
		ArrayList<String> verf_false = new ArrayList<String>();

		boolean dependence = false;
		boolean plotBool = false;
		boolean others = true;
		boolean logConv = false;
		float strength = (float) 0.4; //5.0 yes, 10.0 - no
		float offset = (float) 0;
		int timesteps = 5;
		int flowNum = 8;
		int netNum = 8;
		String uncertainty = "RealNetworkUncertainty";
		int simTime = 100;
		double pctg = 1.0;
		String folder_out_root = "08_11_Accuracy" + flowNum + "_n" + netNum + "_t" + simTime + File.separator + uncertainty + File.separator + strength + "_" + offset   + File.separator;// stren_add + "_" + stren_cont + "_" + timesteps + File.separator;
		String log_name = "";
		int group = 30; // the number of repetitions
		/**********************************************************/

		boolean fix  = true; // false -> the value of network/flow parameters is fixed
		Simulation.initArrayList();
		for (int r = 0; r < group; r++) { // ten simulations as a group
		/**********************loop begins************************************/
			CCP_Ga.setConvergeList(new ArrayList<ArrayList<Double>>());
			CCP_Ga.setPopList(new ArrayList<ArrayList<Population>>());
			TabuSearch.setConvergeList(new ArrayList<ArrayList<Double>>());
			TabuSearch.setNeighList(new ArrayList<ArrayList<List<Solution>>>());
			String folder_out = folder_out_root + "rep_" + r + File.separator;
			new File(folder_out).mkdir();
			log_name = "";

		/******************Network Flow Initial*****************************************/
			NetworkGenerator ngReal = new NetworkGenerator();//(3, 30); //(3,30);
			ngReal.addNetwork(Network.getCellular(100, 80, fix));
			ngReal.addNetwork(Network.getCellular(100, 80, fix));
			ngReal.addNetwork(Network.getWiFi(20, 55, 20, fix)); // 85
			ngReal.addNetwork(Network.getWiFi(30, 65, 30, fix));
			ngReal.addNetwork(Network.getWiFi(30, 55, 40, fix)); // 85
			ngReal.addNetwork(Network.getWiFi(20, 65, 50, fix));
			ngReal.addNetwork(Network.getWiFi(30, 55, 50, fix)); // 85
			ngReal.addNetwork(Network.getWiFi(30, 65, 70, fix));
		
		//////////System.out.println("*************************");
			FlowGenerator tg = new FlowGenerator(100, 8);

			NetworkGenerator ngRealClone = ngReal.clone();
			FlowGenerator tgClone = new FlowGenerator();
			for (Flow flow : tg.getFlows()) {
				tgClone.addFlow(flow.clone());
			}
			// Generate Original Longterm scheduler
			Test.testLongTerm(tgClone, ngRealClone, plotBool, "long_term_without_uncertainty", "");
			if (Test.getCostOpt().size() != 0) {
				Test.getCostOpt().remove(Test.getCostOpt().size() - 1);
			}
			/***********************Uncertainty************************/
			ngReal.addNetworkUncertainty(strength);	

			// init logger
			LogMatlabFormat log = new LogMatlabFormat();
			CostFunction cf = new CostFunction(ngReal, tg, log);
			String pathLTS = "long_term_without_uncertainty1"; // 1 -> greedy
			
			// simulation and log results
			/*********adaptation + false**********************************/
			Simulation sim = new Simulation(pathLTS, tgClone, ngRealClone, tg, ngReal);
			sim.simTime = simTime;
			Balancer.setSc(true);
			dependence = false;
			log_name = String.valueOf(dependence) + "_";
			sim.run(dependence, pctg);
			String log_name_adapted = log_name + "adapted";
			log.log("schedule_f_t_n", sim.adapted);
			cf.costTotal(sim.adapted); 
			log.log("scheduling_duration_us", (int)sim.getDuration());
			log.writeLog(folder_out + log_name_adapted + ".m");
			JsonLogger.array2Json(sim.adapted, "adapted");	
			if (plotBool) {
				Plot plot2 = new Plot(new VisualizationPack(ngReal, tg, sim.adapted));
			}
	
			Simulation.getCostAdaptedFalse().add(cf.costTotal(sim.adapted));
	
			/**********************************************/
	
			
			/*********adaptation + true**********************************/
			LogMatlabFormat log_atrue = new LogMatlabFormat();
			CostFunction cf_atrue = new CostFunction(ngReal, tg, log_atrue);
			Simulation simTrue = new Simulation(pathLTS, tgClone, ngReal, tg, ngReal);
			simTrue.simTime = simTime;
			dependence = true;
			Balancer.setSc(true);
			String log_name_true = String.valueOf(dependence) + "_";
			simTrue.run(dependence, pctg);
			String log_name_adapted_true = log_name_true + "adapted";
			////////System.out.println("hellooooooooooooooooooooooooooooooooooo");
			log_atrue.log("schedule_f_t_n", simTrue.adapted);
			cf_atrue.costTotal(simTrue.adapted); 
			log_atrue.log("scheduling_duration_us", (int)sim.getDuration());
			log_atrue.writeLog(folder_out + log_name_adapted_true + ".m");
			JsonLogger.array2Json(simTrue.adapted, "adapted");	
			if (plotBool) {
				Plot plot2 = new Plot(new VisualizationPack(ngReal, tg, simTrue.adapted));
			}
			simTrue.getCostAdaptedTrue().add(cf.costTotal(simTrue.adapted));
			////////System.out.println("after simulation.");
			/**********************************************/
			
			// others: Long-Term schedule plan + Executor after Uncertainty
			if (others) {
				LogMatlabFormat log_exe = new LogMatlabFormat();
				CostFunction cf_exe = new CostFunction(ngReal, tg, log_exe);
				Executor exe = new Executor(sim.longTermSP, ngReal, tg);
				exe.run(plotBool);
				log_exe.log("schedule_f_t_n", exe.getExecutedPlan());
				cf_exe.costTotal(exe.getExecutedPlan());
				log_name = "";
				String log_name_executed = folder_out + log_name + "executed";
				log_exe.writeLog(log_name_executed + ".m");
				sim.costExecuted.add(cf.costTotal(exe.getExecutedPlan()));
				
				 //optimal, greedy, random...
				Test.testLongTerm(tg, ngReal, plotBool, "ScheduleReal + ", folder_out);
				plotBool = false;
			}
		} // end 30 times simulation
	}
	
	private static Integer getFlowNum(FlowGenerator fg) {
		int num = 0;
		for (Flow f : fg.getFlows()) {
			if (f.getChunks() > 0) {
				num++;
			}
		}
		return num;
	}

	public static ArrayList<Integer> calcTP(int[][][] sp) {
		ArrayList<Integer> tp = new ArrayList<Integer>(sp.length);
		for (int f = 0; f < sp.length; f++) {
			tp.add(0);
			for (int t = 0; t < sp[0].length; t++) {
				for (int n = 0; n < sp[0][0].length; n++) {
					tp.set(f, tp.get(f) + sp[f][t][n]);
				}
			}
		}
		return tp;
		
	}
	
	public Set<Integer> getNewflowsId() {
		Set<Integer> nf = new HashSet<Integer>();
		FlowGenerator ng1 = new FlowGenerator();
		FlowGenerator ng2 = new FlowGenerator();
		if (fgPred.getFlows().size() > fg.getFlows().size()) {
			ng1 = fgPred;
			ng2 = fg;
			return nf;
		} else {
			ng1 = fg;
			ng2 = fgPred;
		}
		
		int sizeLong = ng1.getFlows().size();
		int sizeShort = ng2.getFlows().size();
		
		for (int i = sizeShort; i < sizeLong; i++) {
			//TODO this is for exector adding new flows
			////////System.out.println("fid: " + ng1.getFlows().get(i).getIndex());
			
			nf.add(ng1.getFlows().get(i).getIndex());
		}
		return nf;
	}
	public NetworkGenerator getNgPred() {
		return ngPred;
	}
	public void setNgPred(NetworkGenerator ngPred) {
		this.ngPred = ngPred;
	}
	public FlowGenerator getFg() {
		return fg;
	}
	public void setFg(FlowGenerator fg) {
		this.fg = fg;
	}
	public NetworkGenerator getNgReal() {
		return ngReal;
	}
	public void setNgReal(NetworkGenerator ngReal) {
		this.ngReal = ngReal;
	}

	public List<Integer> getThroughput() {
		return throughput;
	}

	public void setThroughput(List<Integer> throughput) {
		this.throughput = throughput;
	}

	public List<Integer> getDataSize() {
		return dataSize;
	}

	public void setDataSize(List<Integer> dataSize) {
		this.dataSize = dataSize;
	}

	public FlowGenerator getFgPred() {
		return fgPred;
	}

	public void setFgPred(FlowGenerator fgPred) {
		this.fgPred = fgPred;
	}

	public static ArrayList<Integer> getCostExecuted() {
		return costExecuted;
	}

	public static void setCostExecuted(ArrayList<Integer> costExecuted) {
		Simulation.costExecuted = costExecuted;
	}

	public static ArrayList<Integer> getNumFlowReal() {
		return numFlowReal;
	}

	public static void setNumFlowReal(ArrayList<Integer> numFlowReal) {
		Simulation.numFlowReal = numFlowReal;
	}

	public static ArrayList<Integer> getNumFlowPred() {
		return numFlowPred;
	}

	public static void setNumFlowPred(ArrayList<Integer> numFlowPred) {
		Simulation.numFlowPred = numFlowPred;
	}

	public static ArrayList<Integer> getNumNetReal() {
		return numNetReal;
	}

	public static void setNumNetReal(ArrayList<Integer> numNetReal) {
		Simulation.numNetReal = numNetReal;
	}

	public static ArrayList<Integer> getCostAdaptedOpt() {
		return costAdaptedOpt;
	}

	public static void setCostAdaptedOpt(ArrayList<Integer> costAdaptedOpt) {
		Simulation.costAdaptedOpt = costAdaptedOpt;
	}

	public static ArrayList<Integer> getCostAdaptedExe() {
		return costAdaptedExe;
	}

	public static void setCostAdaptedExe(ArrayList<Integer> costAdaptedExe) {
		Simulation.costAdaptedExe = costAdaptedExe;
	}

	public static ArrayList<Integer> getCostExeOpt() {
		return costExeOpt;
	}

	public static void setCostExeOpt(ArrayList<Integer> costExeOpt) {
		Simulation.costExeOpt = costExeOpt;
	}
	
	public static ArrayList<Integer> subTwoArray(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (list1.size() != list2.size()) return result;
		for (int i = 0; i < list1.size(); i++) {
			result.add(list1.get(i) - list2.get(i));
		}
		return result;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	private static void writeScenarioLog(String path, int mt, int mf, int mn, int rep, int elm){
		
		//write scenario parameters log
		LogMatlabFormat logger = new LogMatlabFormat();
		logger.comment(path);
		logger.log("max_time", mt);
		logger.log("max_flows", mf);
		logger.log("max_nets", mn);
		logger.log("max_rep", rep);
		logger.log("evaluate_max_only", elm);			//is 1 if simulation did not ran from 0 to max, but only max
		//logger.logSchedulers(initSchedulers(null, null));	//save which schedulers are available for evaluation
		
		logger.writeLog(path+"parameters_log.m");
	}
	

	public static ArrayList<Integer> getCostAdaptedFalse() {
		return costAdaptedFalse;
	}

	public static void setCostAdaptedFalse(ArrayList<Integer> costAdaptedFalse) {
		Simulation.costAdaptedFalse = costAdaptedFalse;
	}

	public static ArrayList<Integer> getCostAdaptedTrue() {
		return costAdaptedTrue;
	}

	public static void setCostAdaptedTrue(ArrayList<Integer> costAdaptedTrue) {
		Simulation.costAdaptedTrue = costAdaptedTrue;
	}

	public int[] getNetType() {
		return netType;
	}

	public void setNetType(int[] netType) {
		this.netType = netType;
	}
	
	 public TabuSearch setupTS(Integer tabuListSize, Integer iterations) { 
		 return new TabuSearch(new StaticTabuList(tabuListSize), new IterationsStopCondition(iterations), new BasicNeighborSolutionLocator()); 
	 }

	public static Combination getPrevious() {
		return previous;
	}

	public static void setPrevious(Combination prev) {
		previous = prev;
	} 
	
	public static void logSchedulerMatlab(NetworkGenerator ngReal, FlowGenerator tg, int schedIndex, String folder_out, String schedName) {
		LogMatlabFormat log = new LogMatlabFormat();
		CostFunction cf = new CostFunction(ngReal, tg, log);
		int[][][] sp = Test.getScheds().get(schedIndex).getSchedule();
		log.log("schedule_f_t_n", sp);
		cf.costTotal(sp);
		String log_name = folder_out + schedName;
		log.writeLog(log_name + ".m");
	}


	

}
