package executor;
import java.awt.Container;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import ToolSet.CostSeparation;
import ToolSet.EvaluationScenarioCreator;
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
import utils.Config;
import utils.Printer;
import visualization.Plot;
import visualization.VisualizationPack;
/*****
 * This is the main entry of GA. Main function does all work, including some necessary initialization.
 * There are two methods - GA and TS. Now TS is not used and main contains bugs.
 * GA functions well. 
 * @author dan.li
 * !deprecated!
 *
 */

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
	/***********************/
	private int[][][] adapted;
	/***********************/
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
	private static double intialRate = 0;


	public Simulation(String path) {
		longTermSP = JsonLogger.json2Array(path);
	}
	public Simulation(String path,  FlowGenerator fgVar, NetworkGenerator ngRealVar) {
		longTermSP = JsonLogger.json2Array(path);
		//adaptedSP = new int[longTermSP.length][longTermSP[0].length][longTermSP[0][0].length];
		//adaptedSP = new int[longTermSP.length + 1][longTermSP[0].length][longTermSP[0][0].length];
		setFg(fgVar);
		setNgReal(ngRealVar);
		initEnvConfig();
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
		Config.setmQ(new int[fg.getFlows().size()]);
		System.out.println("fg.size: " + fg.getFlows().size());
		System.out.println("mq.length: " + Config.getmQ().length);
		Config.setMax(new int[fg.getFlows().size()]);
		Config.setActiveFlowBool(new int[fg.getFlows().size()]);
		Config.setPrior(new int[fg.getFlows().size()]);
		Config.setActiveNetworkBool(new int[ngReal.getNetworks().size()]);
		Config.setNetworkType(new int[ngReal.getNetworks().size()]);
		Config.setNetworkFlag(new int[ngReal.getNetworks().size()]);
		Config.setCapReal(new int[ngReal.getNetworks().size()]);
		Config.setNetNum(ngReal.getNetworks().size());
		Config.setFlowNum(fg.getFlows().size());
		Simulation.setPrevious(new Combination());
		Config.setUnsedFNMap(new HashMap<Integer, Set<Integer>>());
		Config.setNg(this.ngReal);
		Config.setFg(this.fg);
		
		// n - precess id
		/*
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
		*/

		for (Flow f : fg.getFlows()) {
			////////System.out.println("id: " + f.getIndex() + " - " + f.getTokensMin() + " - " + f.getWindowMin());
			// TODO 
			System.out.println("id: " + f.getIndex() + " - " + f.getImpUser());
			System.out.println(Config.getmQ().length);

			Config.getmQ()[f.getIndex()] = (int) f.getTokensMin() / f.getWindowMin();
			mQ = Config.getmQ().clone();
		}
		
		// f - priority
		for (Flow f : fg.getFlows()) {
			System.out.println("id: " + f.getIndex() + " - " + f.getImpUser());
			// TODO 
			System.out.println(Config.getPrior().toString());
			Config.getPrior()[f.getIndex()] = 1; //f.getImpUser();
		}
		
		setDataSize(new ArrayList<Integer>());
		setThroughput(new ArrayList<Integer>());

		for (Flow f : fg.getFlows()) {
			getDataSize().add(f.getTokens());
			getThroughput().add(0);
			Config.getMax()[f.getIndex()] = Math.min(f.getTokensMax() / f.getWindowMax(), f.getTokens());
		}
		
		for (int i = 0; i < ngReal.getNetworks().size(); i++) {
			Config.getNetworkType()[i] = ngReal.getNetworks().get(i).getType();
//			//Printer.printInt("net type after initialization: ", Config.getNetworkType());
		}	
		initDeactivate();
		updateNetworkConfig(true);
		adaptedSPAL = new ArrayList<ArrayList<ArrayList<Integer>>>();
	}
	
	
	public void initDeactivate() {
		for (int i = 0; i < Config.getActiveFlowBool().length; i++) {
			Config.getActiveFlowBool()[i] = 0;
		}
		
		for (int i = 0; i < Config.getActiveNetworkBool().length; i++) {
			Config.getActiveNetworkBool()[i] = 0;
		}
		
		for (int i = 0; i < Config.getInitGenes().length; i++) {
			Config.getInitGenes()[i] = 0;
		}
		
		for (int i = 0; i < Config.getCapReal().length; i++) {
			Config.getCapReal()[i] = 0;
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
		Config.getActiveFlowBool()[index] = active? 1 : 0;
	}
	
	public void activateNetwork(int index, boolean active) {
		Config.getActiveNetworkBool()[index] = active? 1 : 0;
	}
	
	public void updateInitSP(int ts) {
		if (ts >= longTermSP[0].length) return;
		for (int f = 0; f < longTermSP.length && f < Config.getInitGenes().length; f++) {
			for (int n = 0; n < longTermSP[0][0].length; n++) {
				if (longTermSP[f][ts][n] != 0) {
				//	////////System.out.println(Config.getInitGenes().length);
				//	//Printer.printInt(Config.getInitGenes());
					Config.getInitGenes()[f] = n + 1;
				}
			}
		}
		
	}
	
	//TODO combine with network availability
	public void updateNetCap(int ts) {
		for (Network n : ngReal.getNetworks()) {
			//////////System.out.println("newtork start time: " + n.getId() + " - " + n.getSlots() + " / " + n.);
			int cap = n.getCapacity().get(ts);	
			Config.getCapReal()[n.getId()] = cap;
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
			if (ts > f.getDeadline() && f.getIndex() % 4 != 1) {
				activateFlow(f.getIndex(), false);	
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
			if (ts > f.getDeadline()) {// && !f.isBufferable()) {
				activateFlow(f.getIndex(), false);	
			}
			if (tp > 0 && tp >= ds) { 
				activateFlow(f.getIndex(), false);
			}
		}
		if (useOnlyScheduledFlow) {
			for (int i = 0; i < Config.getInitGenes().length && i < fg.getFlows().size(); i++) {
				if (Config.getInitGenes()[i] == 0) {
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
			maxPrev = Config.getMax()[fId];
			Config.getMax()[fId] = Math.min(getDataSize().get(fId) - getThroughput().get(fId), maxPrev);
		}
	}
	
	public void updateMQ(int t) {
		int fId = 0;
		int mqPrev = 0;
		for (Flow f : fg.getFlows()) {
			fId = f.getIndex();
			mqPrev = Config.getmQ()[fId];
			Config.getmQ()[fId] = Math.min(getDataSize().get(fId) - getThroughput().get(fId), mqPrev);
			if (f.getDeadline() < t) { // && f.isBufferable() == false) {
				Config.getmQ()[fId] = 0;
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
	// please fold run_tb, not used.
	public void run_tb(boolean dep) {
//		CostSeparation cs = new CostSeparation(fg, ngReal);
//		Config.setCs(cs);
//		initEnvConfig();
//		
//		adapted = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
//		adaptedBF = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
//		long startTime = System.nanoTime();
//
//		for (int i = 0; i < simTime; i++) {
//			Config.setTime(i);
//
//			//////System.out.println("******************" + i + "*************");
//			// each time slot - update initGene
//			updateInitSP(i);
//			////Printer.printInt("init: ", Config.getInitGenes());
//			// each time slot - update network capacity
//			updateNetworkConfig(true);
//			updateNetCap(i);
//			updateFlowAvl(i, dep);
//			updateMax();
////			//Printer.printInt("max: ", Config.getMax());
//			
//			 Solution initialSolution = new Combination(Config.getInitGenes());
//			 Combination tmp = (Combination) initialSolution;
//			 ////////System.out.println("initcost: " + tmp.getValue());
//		   /************************************/
//			// for (int s = 5; s <= 10; s++) { //the size of the tabu list 
//				 //for (double i = 0.5; i <= 2; i += 0.5) { //the amount of iterations (50%, 100%, 150% and 200%) 
//					int s = 10;
//			 		Integer maxIterations = s * 50; 		     
//					 TabuSearch ts = setupTS(s, maxIterations); 
//					 Solution returnValue = ts.run(initialSolution); 
//		    
//					 Combination result = (Combination) returnValue;
////					 //Printer.printInt("resultComb", result.getCombGlobal());
//					 ////////System.out.println("resultcost: " + result.getValue());
////					 //Printer.printInt("result", result.getResultGlobal());
//			// } 
//			   /************************************/
//
//			if (Config.getInitGenes().equals(result.getCombGlobal())) {
//				count++;
//			}
//			for (int f = 0; f < fg.getFlows().size(); f++) {
//				int netIndex = result.getCombGlobal()[f];
//				if (netIndex > 0) {
//					int resource = result.getResultGlobal()[f];
//					if (resource > Config.getCapReal()[netIndex - 1]) {
//						//continue;
//					} else {
//						adapted[f][i][netIndex - 1] = resource;
//						getThroughput().set(f, getThroughput().get(f) + resource);
//					}
//
//				}
//			}	
//			////////System.out.println("tp in : " + getThroughput().toString());
//			updateMQ(i);
//			////Printer.printInt("mq: ", Config.getmQ());
//
//			initDeactivate();
//			
//		}
//		long endTime = System.nanoTime();
//		setDuration((endTime - startTime) / 1000);
		////////System.out.println("\n duration: " + String.valueOf(endTime - startTime));
		////////System.out.println("duration: " + TimeUnit.SECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS) + "s");

	}
	
	public void updateFlowNetFlag(int t, boolean lookahead) {
		Config.setFlowNetFlag(new int[fg.getFlows().size()][ngReal.getNetworks().size()]);
		int range = 15;
		if (lookahead) {
			if (t + range >= simTime) {
				for (int i = 0; i < Config.getFlowNetFlag().length; i++) {
					Arrays.fill(Config.getFlowNetFlag()[i], 1);
				}
				return;
			}
			for (int i = 0; i < t + range; i++) {
				for (int f = 0; f < longTermSP.length && f < fg.getFlows().size(); f++) {
					for (int n = 0; n < longTermSP[0][0].length; n++) {
						if (longTermSP[f][i][n] != 0 || fg.getFlows().get(f).getTokensMin() < 10) {
							Config.getFlowNetFlag()[f][n] += 1;
						}
					}
				}
			}
			if (fg.getFlows().size() > longTermSP.length) {
				for (int f = longTermSP.length; f < fg.getFlows().size(); f++) {
					for (int n = 0; n < longTermSP[0][0].length; n++) {
						Config.getFlowNetFlag()[f][n] += 1;				
					}
				}	
			}
		} else {
			for (int i = 0; i < Config.getFlowNetFlag().length; i++) {
				Arrays.fill(Config.getFlowNetFlag()[i], 1);
			}
			return;			
		}
	}
	/**************************************/
	public void run(boolean dependence, double d, boolean lookahead) {
		CostSeparation cs = new CostSeparation(fg, ngReal);
		Config.setCs(cs);
		initEnvConfig();
		
		adapted = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
		//adaptedBF = new int[fg.getFlows().size()][ngReal.getTimeslots()][ngReal.getNetworks().size()];
		long startTime = System.nanoTime();

		for (int i = 0; i < simTime; i++) {
			Config.setTime(i);

			//////System.out.println("******************" + i + "*************");
			//System.out.println("before updateflownet");
			updateFlowNetFlag(i, lookahead);
			//System.out.println("after updateflownet");

			// each time slot - update initGene
			updateInitSP(i);
			////Printer.printInt("init: ", Config.getInitGenes());
			// each time slot - update network capacity
			updateNetworkConfig(true);
			updateNetCap(i);
			updateFlowAvl(i, dependence);
			updateMax();

			/**********************************/
			Individual result = CCP_Ga.run(d);
			/**********************************/

			setPrevious(result.getComb());

			for (int f = 0; f < fg.getFlows().size(); f++) {
				int netIndex = result.getComb().getCombGlobal()[f];
				if (netIndex > 0) {
					int resource = result.getComb().getResultGlobal()[f];
					if (resource > Config.getCapReal()[netIndex - 1]) {
						//continue;
					} else {
						adapted[f][i][netIndex - 1] = resource;
						getThroughput().set(f, getThroughput().get(f) + resource);
					}

				}
			}	
			////////System.out.println("tp in : " + getThroughput().toString());
			updateMQ(i);
			////Printer.printInt("mq: ", Config.getmQ());

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
//		CCP_Ga.setPopList(new ArrayList<ArrayList<Population>>());
//		TabuSearch.setConvergeList(new ArrayList<ArrayList<Double>>());init
//		TabuSearch.setNeighList(new ArrayList<ArrayList<List<Solution>>>());

	
	}
	public static void main(String[] args) {
		/*****************Init Simulation Parameters***************/
		ArrayList<String> verf_true = new ArrayList<String>();
		ArrayList<String> verf_false = new ArrayList<String>();

		boolean dependence = false; 
		boolean plotBool = true;
		boolean others = true;
		boolean lookahead = false;
		boolean logConv = false;
		float strength = (float) 0; //5.0 yes, 10.0 - no
		float flowStrength = 0.0f;
		float moveStrength = 0.0f;
		float netStrength = 0.3f;
		boolean overwrite = false;
		float offset = (float) 0;
		int timesteps = 5;
		int flowNum = 8;
		int netNum = 8;
		boolean root = false;
		int simTime = 100;
		double pctg = 1.0; // the factor for population size
		//String folder_out_root = "NewConfig" + flowNum + "_n" + netNum + "_t" + simTime + File.separator + "test" + File.separator + strength + "_" + offset   + File.separator;// stren_add + "_" + stren_cont + "_" + timesteps + File.separator;
		String folder_out_root = "my_logs/" + File.separator + "eval_uncertainty" + File.separator + "3_2_3" + File.separator;
		String log_name = "";
		int group = 1; // the number of repetitions
		/**********************************************************/
		Simulation.initArrayList();
		for (int r = 0; r < group; r++) {  // reptition
			CCP_Ga.setConvergeList(new ArrayList<ArrayList<Double>>());

			String folder_out = folder_out_root + r + File.separator;
			new File(folder_out).mkdir();
			log_name = "";

			/******************Network Flow Initial********************/
			NetworkGenerator ngClone = EvaluationScenarioCreator.getNetworkGeneratorRoot(folder_out);
			FlowGenerator tgClone = EvaluationScenarioCreator.getFlowGeneratorRoot(folder_out);
			for (Network n : ngClone.getNetworks()) {
				System.out.println(n.toString());
			}
			for (Flow flow : tgClone.getFlows()) {
				System.out.println(flow.toString());
			}
			// Generate Original Longterm scheduler
			Test.testLongTerm(true, tgClone, ngClone, plotBool, "long_term_without_uncertainty", "");
			/***********************Uncertainty************************/
			NetworkGenerator ngReal;
			FlowGenerator tg;
			String folder_out_uncert;
			if (root) {
				ngReal = EvaluationScenarioCreator.getNetworkGeneratorRoot(folder_out);//EvaluationScenarioCreator.getNetworkGenerator(folder_out, overwrite, netNum, simTime, netStrength, moveStrength);
				tg = EvaluationScenarioCreator.getFlowGeneratorRoot(folder_out);//EvaluationScenarioCreator.getFlowGenerator(folder_out, overwrite, flowNum, simTime, flowStrength);
				folder_out_uncert = folder_out;
			} else {
				ngReal = EvaluationScenarioCreator.getNetworkGenerator(folder_out, overwrite, netNum, simTime, netStrength, moveStrength);
				tg = EvaluationScenarioCreator.getFlowGenerator(folder_out, overwrite, flowNum, simTime, flowStrength);
				folder_out_uncert = EvaluationScenarioCreator.getFilePath(folder_out, netStrength, moveStrength, flowStrength);
			}
			for (Network n : ngReal.getNetworks()) {
				System.out.println(n.toString());
			}
			for (Flow flow : tg.getFlows()) {
				System.out.println(flow.toString());
			}
			// init logger
			LogMatlabFormat log = new LogMatlabFormat();
			CostFunction cf = new CostFunction(ngReal, tg, log);
			String pathLTS = "long_term_without_uncertainty0"; // this is simply a path to store the long term scheduler in json
			
			// simulation and log results
			/*********adaptation + false**********************************
			String folder_out_uncert = folder_out; // EvaluationScenarioCreator.getFilePath(folder_out, netStrength, moveStrength, flowStrength);
			Simulation sim = new Simulation(pathLTS, tgClone, ngClone, tg, ngReal);
			sim.simTime = simTime;
			Balancer.setSc(true);
			lookahead = false;
			dependence = false;
			log_name = String.valueOf(dependence) + "_";
			sim.run(dependence, pctg, lookahead);
			String log_name_adapted = log_name + "adapted";
			log.log("schedule_f_t_n", sim.adapted);
			cf.costTotal(sim.adapted); 
			log.log("scheduling_duration_us", (int)sim.getDuration());
			log.writeLog(folder_out_uncert + log_name_adapted + ".m");
			JsonLogger.array2Json(sim.adapted, "adapted");	
			if (plotBool) {
				Plot plot2 = new Plot(new VisualizationPack(ngReal, tg, sim.adapted));
			}
			Simulation.getCostAdaptedFalse().add(cf.costTotal(sim.adapted));
			/**********************************************/
			System.out.println("******************true********************");
			
			/*********adaptation + true = what we used ***********************/
			LogMatlabFormat log_atrue = new LogMatlabFormat();
			CostFunction cf_atrue = new CostFunction(ngReal, tg, log_atrue);
			Simulation simTrue = new Simulation(pathLTS, tg, ngReal);
			simTrue.simTime = simTime;
			dependence = false;
			lookahead = true;
			//Balancer.setSc(true);
			// run ga_true (lookahead)
			//dep <= false, pctg(percentage) length of the pop size <= 1.0, lookahead <= true  
			// one round ga for e.g. 100 time slots
			simTrue.run(dependence, pctg, lookahead);
			
			// log m file
			String log_name_true = String.valueOf(lookahead) + "_";
			String log_name_adapted_true = log_name_true + "adapted";
			log_atrue.log("schedule_f_t_n", simTrue.adapted);
			log_atrue.log("scheduling_duration_us", (int)simTrue.getDuration());
			cf_atrue.costTotal(simTrue.adapted); 
			log_atrue.writeLog(folder_out_uncert + log_name_adapted_true + ".m");
			JsonLogger.array2Json(simTrue.adapted, "adapted");	
			if (plotBool) {
				Plot plot2 = new Plot(new VisualizationPack(ngReal, tg, simTrue.adapted));
			}
			/**********************************************/
			// log convergence
			String pathConv = "converge" + flowStrength + File.separator;
			System.out.println(pathConv);
			new File(pathConv).mkdir(); // + uncertainty + "/").mkdir();
			pathConv += r + File.separator;
			new File(pathConv).mkdir(); // + uncertainty + "/").mkdir();
			File logConverge = new File(pathConv + "GA_conv.txt");
		    try{
			    if(logConverge.exists() == false){
			            System.out.println("We had to make a new file.");
			            logConverge.createNewFile();
			    }
				PrintWriter out = new PrintWriter(new FileWriter(logConverge, true));
				//out.append("addCharacteristicsUncertainty: \n");
				int timecon = 0;
				System.out.println("ga_timeslot: " + CCP_Ga.getConvergeList().size());
				System.out.println("ga_rounds: " + CCP_Ga.getConvergeList().get(10).size());
				
				for (ArrayList<Double> converge : CCP_Ga.getConvergeList()) {
					if (converge.size() == 0) {
						out.append(0 + "\n"); //("0: " + 0 + "\n");
					}
					for (int i = 0; i < converge.size(); i++) {
						if (i != converge.size() - 1) {
							out.append(converge.get(i) + ",");
						} else {
							out.append(converge.get(i) + "\n");
						}
					}
				}
				//out.append("******************************\n");
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// others: Long-Term schedule plan + Executor after Uncertainty
		    // mainly executor now
			if (true) {//others) {
//				LogMatlabFormat log_exe = new LogMatlabFormat();
//				CostFunction cf_exe = new CostFunction(ngReal, tg, log_exe);
//				Executor exe = new Executor(simTrue.longTermSP, ngReal, tg);
//				exe.run(plotBool);
//				log_exe.log("schedule_f_t_n", exe.getExecutedPlan());
//				cf_exe.costTotal(exe.getExecutedPlan());
//				log_name = "./";
//				String log_name_executed = log_name + "executed";
//				log_exe.writeLog(log_name_executed + ".m");				
//				 //optimal, greedy, random...
//				//Test.testLongTerm(false, tg, ngReal, plotBool, "ScheduleReal + ", folder_out);
//				plotBool = false;
			}
		} // end rep times simulation
	}
	
	private static Integer getFlowNum(FlowGenerator fg) {
		int num = 0;
		for (Flow f : fg.getFlows()) {
			if (f.getTokens() > 0) {
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

	
	public static void logSchedulerMatlab(NetworkGenerator ngReal, FlowGenerator tg, int schedIndex, String folder_out, String schedName) {
		LogMatlabFormat log = new LogMatlabFormat();
		CostFunction cf = new CostFunction(ngReal, tg, log);
		int[][][] sp = Test.getScheds().get(schedIndex).getSchedule();
		log.log("schedule_f_t_n", sp);
		cf.costTotal(sp);
		String log_name = folder_out + schedName;
		log.writeLog(log_name + ".m");
	}
	public static Combination getPrevious() {
		return previous;
	}
	public static void setPrevious(Combination previous) {
		Simulation.previous = previous;
	}


	

}
