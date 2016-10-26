import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ToolSet.EvaluationScenarioCreator;

public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		boolean decomp = false;
		//logfile is logpath/f_t_n/rep..
		//		int f=2;
		//		int t=1;
		//		int n=2;
		//		int rep=3;
		boolean large = Boolean.parseBoolean(args[1]);

		int f = 2;
		int t = 2;
		int n = 2;
		int rep = Integer.parseInt(args[0]);
		//		String logpath= "my_logs"+File.separator+"short_test";
		//		String logpath= "my_logs"+File.separator+"test";

		String logpath = "my_logs" + File.separator + "jakob";
		if (large) {
			f = 4;
			t = 2;
			n = 4;//5;
			//		String logpath= "my_logs"+File.separator+"short_test";
			//		String logpath= "my_logs"+File.separator+"test";

			logpath = "my_logs" + File.separator + "jakob_large";
		}
		//		for(int rep1 = 0; rep1<=rep; rep1++){

		//if overwrite, then delete everything in folder, create scenario new and calculate
		//if recalc, then keep generated scenario, keep all files and recalculate only specified schedules; overwrite their files
		//if nothing of the two, create new scenario if none available; calculate schedules if no logs available for scheduler.

		EvaluationScenarioCreator eval = new EvaluationScenarioCreator(t, n, f, rep, logpath);
		eval.recalc();
		//			eval.visualize();
		//			eval.overwrite();
		//			eval.evaluateAll();
		//eval.evaluateTimeVariation();
		//			eval.evaluateNetworkVariation();
		eval.evaluateTop();
		//			eval.calculateInstance_t_n_i(t, n, f, rep, logpath+File.separator, false ,true, decomp);	//recalc
		//			eval.calculateInstance_t_n_i(t, n, f, rep, logpath+File.separator, true ,false, decomp);	//overwrite
		int cores = Runtime.getRuntime().availableProcessors();
		eval.parallel(cores);

		long start = System.currentTimeMillis();

		eval.start();
		long finish = System.currentTimeMillis();

		System.out.println("done in: " + (finish - start) + " ms");
		//		}

		//testing uncertainty models
		//		int timeslots=80;
		//	
		//		FlowGenerator fg= new FlowGenerator(timeslots, 8);
		//		fg.addUncertainty((float)0.2, (float)0.3, timeslots);	//probAddCancel, probContinue, timesteps
		//	
		//		NetworkGenerator ng = new NetworkGenerator(4,80);
		//		ng.addPositionUncertainty((float) 0.3,(float)0.1, false);
		//		ng.addNetworkUncertainty((float)0.3, 5);		//param1: change characteristics (tp, lcy, jit) --> [0..1]; param 2: change range

		//		for(Network net: ng.getNetworks()){
		//			System.out.println(net.toString());
		//
		//			System.out.println("\nnet lcy / jit="+net.getLatency()+" / "+net.getJitter());
		//		}
		//		
		//		
		//		for(Network net: ng.getNetworks()){
		//			System.out.println(net.toString());
		//			System.out.println("\nnet lcy / jit="+net.getLatency()+" / "+net.getJitter());
		//		}

		System.out.println("done");

		long greedy = 0;
		long postProcess0 = 0;
		long postProcess1 = 0;
		long postProcess2 = 0;
		long cplex = 0;
		String setup = f + "_" + t + "_" + n;
		for (int i = 0; i < rep; i++) {
			greedy += getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_log.m");
			postProcess0 += getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "PostProcess_0_log.m");
			postProcess1 += getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "PostProcess_1_log.m");
			postProcess2 += getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "PostProcess_2_log.m");
			cplex += getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Optimization_log.m");
			if (i % 100 == 0) {
				System.out.println(i);
			}
		}
		System.out.println("total cost over " + rep + " schedules:");
		System.out.println("Greedy:\t\t" + greedy);
		System.out.println("postProcess0:\t" + postProcess0);
		System.out.println("postProcess1:\t" + postProcess1);
		System.out.println("postProcess2:\t" + postProcess2);
		System.out.println("CPlex:\t\t" + cplex);
		System.out.println();
		System.out.println("percentages:");
		System.out.printf("Cplex:\t\t%.2f\n", (float) cplex / cplex * 100);
		System.out.printf("postProcess0:\t%.2f\n", (float) postProcess0 / cplex * 100);
		System.out.printf("postProcess1:\t%.2f\n", (float) postProcess1 / cplex * 100);
		System.out.printf("postProcess2:\t%.2f\n", (float) postProcess2 / cplex * 100);
		System.out.printf("Greedy:\t\t%.2f\n", (float) greedy / cplex * 100);

	}

	public static long getCost(String path) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("costTotal")) {
					line = line.substring(12);
					line = line.substring(0, line.length() - 2);
					return Integer.parseInt(line);
				}
			}
		}
		throw new IOException("costTotal not found in: " + path);
	}

}
