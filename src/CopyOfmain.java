import java.io.File;
import java.util.Vector;

import schedulers.GreedyScheduler;
import schedulers.Scheduler;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;
import visualization.Plot;
import visualization.VisualizationPack;
import ToolSet.EvaluationScenarioCreator;
import ToolSet.RndInt;




public class CopyOfmain {
	
	public static void main(String[] args) {
//		boolean decomp = false;
//		//logfile is logpath/f_t_n/rep..
////		int f=2;
////		int t=1;
////		int n=2;
////		int rep=3;
//		int f=4;
//		int t=4;
//		int n=3;//5;
//		int rep=1;
////		String logpath= "my_logs"+File.separator+"short_test";
////		String logpath= "my_logs"+File.separator+"test";
//
//		//String logpath= "my_logs"+File.separator+"tester";
////		String logpath= "my_logs"+File.separator+"eval_4_4_3_c15";
//		String logpath= "my_logs"+File.separator+"eval_";
//
//		
////		for(int rep1 = 0; rep1<=rep; rep1++){
//		
//		
//		//if overwrite, then delete everything in folder, create scenario new and calculate
//		//if recalc, then keep generated scenario, keep all files and recalculate only specified schedules; overwrite their files
//		//if nothing of the two, create new scenario if none available; calculate schedules if no logs available for scheduler.
//		
//			EvaluationScenarioCreator eval = new EvaluationScenarioCreator(t,n,f,rep,logpath);
//			eval.recalc();
//			eval.visualize();
////			eval.overwrite();
//			eval.evaluateAll();
////			eval.evaluateTimeVariation();
////			eval.evaluateNetworkVariation();
////			eval.evaluateTop();
////			eval.calculateInstance_t_n_i(t, n, f, rep, logpath+File.separator, false ,true, decomp);	//recalc
////			eval.calculateInstance_t_n_i(t, n, f, rep, logpath+File.separator, true ,false, decomp);	//overwrite
////			eval.parallel(4);
//			eval.start();
////		}
		
		//testing uncertainty models
		String folder = "my_log/eval_uncertainty/3_2_3/Copy of 0/";
		NetworkGenerator ng = EvaluationScenarioCreator.getNetworkGenerator(folder, false, 8, 100, (float)0.5, (float)0.5);
		for (Network n : ng.getNetworks()) {
			System.out.println(n.toString());
		}
		FlowGenerator tg = EvaluationScenarioCreator.getFlowGenerator(folder, false, 8, 100, (float)0.5);
		for (Flow f : tg.getFlows()) {
			System.out.println(f.toString());
		}
//		int timeslots=100;
//		FlowGenerator fg= new FlowGenerator(timeslots, 8);
//		for (Flow f : fg.getFlows()) {
//			System.out.println(f.toString());
//		}
//		fg.addUncertainty((float) 0.5, timeslots);
//		System.out.println("***************************");
//		for (Flow f : fg.getFlows()) {
//			System.out.println(f.toString());
//		}
//		fg.addUncertainty((float)0.2, (float)0.3, timeslots);	//probAddCancel, probContinue, timesteps
//
//		
//		
//		ng.addNetworkUncertainty((float) 0.4);
//		ng.addPositionUncertainty((float) 0.2);
		
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
	}
}