package tabusearch;

import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Comparator; 
import java.util.LinkedList; 
import java.util.List; 
import java.util.Random; 
 
import org.junit.Before; 
import org.junit.Test; 

import ToolSet.CostSeparation;

import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;
import utils.Combination;
import utils.Printer;
 
public class CombinationTest { 
  
 private List<Solution> solutions; 
  
 @Test 
 public void runAlgorithm() { 
	 int[] init = {0, 0, 0, 0, 0, 0};
	 Solution initialSolution = new Combination(init);
	 Combination tmp = (Combination) initialSolution;
	 ////////System.out.println("initcost: " + tmp.getValue());
   
	 for (int s = 5; s <= 10; s++) { //the size of the tabu list 
		 //for (double i = 0.5; i <= 2; i += 0.5) { //the amount of iterations (50%, 100%, 150% and 200%) 
			 Integer maxIterations = s * 100; 
     
			 ////////System.out.println(String.format("Running TS with tabu list size [%s] and [%s] iterations. Instance size [%s]", s, maxIterations, 0)); 
     
			 TabuSearch ts = setupTS(s, maxIterations); 
			 Solution returnValue = ts.run(initialSolution); 
    
			 Combination result = (Combination) returnValue;
			 //Printer.printInt("resultComb", result.getCombGlobal());
			 ////////System.out.println("resultcost: " + result.getValue());
			 //Printer.printInt("result", result.getResultGlobal());

			 //Integer returnedValueIndex = solutions.indexOf(returnValue); 
			 //////////System.out.println(String.format("The algorithm returned a result with [%s] units of distance of the best solution", returnedValueIndex));
			 
		 //} 
	 } 
 } 
  
 public TabuSearch setupTS(Integer tabuListSize, Integer iterations) { 
	 return new TabuSearch(new StaticTabuList(tabuListSize), new IterationsStopCondition(iterations), new BasicNeighborSolutionLocator()); 
 } 
 
 @Before 
 public void buildInstance() { 
		
		NetworkGenerator ngReal = new NetworkGenerator();
		ngReal.addNetwork(Network.getCellular(20, 40, false));
		ngReal.addNetwork(Network.getWiFi(10, 0, 5, false));
		ngReal.addNetwork(Network.getWiFi(10, 0, 10, false));
//		ngReal.addNetwork(Network.getWiFi(10, 0, 5, false));
		ngReal.addNetwork(Network.getCellular(20, 40, false));
		ngReal.addNetwork(Network.getCellular(20, 40, false));

		for (int i = 0; i < 4; i++) {
		//	ngReal.addNetwork(Network.getCellular(20, 80, false));

		}

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
		tg.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0
		tg.addFlow(Flow.BufferableStream(4, 17, 13*70, false)); // 1
		tg.addFlow(Flow.BufferableStream(5, 19, 10*50, false)); // 2
		tg.addFlow(Flow.Interactive(10, 15)); // 3
		tg.addFlow(Flow.Background(300, 2, 19, false)); // 4
		tg.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0

//		tg.addFlow(Flow.LiveStram(10, 9, 6*125, false)); // 0
		for (int i = 0; i < 5; i++) {
		//	tg.addFlow(Flow.LiveStram(8, 10 + i, 6*125, false)); // 0

		}
		
		for (Flow f : tg.getFlows()) {
			////////System.out.println("**** " + f.getId());
			f.setIndex(f.getId());
		}
		
		CostSeparation cs = new CostSeparation(tg, ngReal);
		Combination.setCs(cs);

		//Printer.printInt("mq: ", Combination.getmQ());

 
 }
  

 
}