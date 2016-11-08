package ccpga.copy;

//import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.ArrayList;

import ToolSet.CostSeparation;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;
import utils.Combination;
import utils.Printer;

//import netModel.Environment;

public class CCP_Ga {
	//private Environment e;
	private static ArrayList<ArrayList<Double>> convergeList = new ArrayList<ArrayList<Double>>();
	private static ArrayList<ArrayList<Population>> popList = new ArrayList<>();
//	private static ArrayList<Integer> converge = new ArrayList<Integer>();
	public static Individual run(double popAmp) {
		//setConverge(new ArrayList<Integer>());
		ArrayList<Double> converge = new ArrayList<Double>();

        // Set a candidate solution
        // Create an initial population - with initial solution
        Population myPop = new Population(popAmp, true);
        int popSize = myPop.getPopulationSize();
        if (popSize <= 2) {
        	Algorithm.setTournamentSize(popSize);
        } else {
        	Algorithm.setTournamentSize(Math.max(2, popSize/2));
        }
        Individual bestInd = new Individual();
        ArrayList<Population> pop = new ArrayList<>();
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (generationCount < myPop.size() * 50) {
        	////////System.out.println("******************" + generationCount + "******************");
            generationCount++;
            //////////System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
            if (bestInd.getFitness() > myPop.getFittest().getFitness()) {
            	bestInd = myPop.getFittest();
            }
            pop.add(myPop);
            converge.add(bestInd.getFitness());
            ////Printer.printInt(myPop.getFittest().getComb().getComb());
            myPop = Algorithm.evolvePopulation(myPop);
            /*
            for (Individual ind : myPop.getIndividuals()) {
            	////////System.out.println(ind.toString());
            }
            */
        }
        if (myPop.size() == 0) return bestInd;
        convergeList.add(converge);
        getPopList().add(pop);
        
        //////System.out.println("Solution found!");
        //////System.out.println("Generation: " + generationCount);
        //////System.out.println("Genes:");
        //////System.out.println("best: " + bestInd.getFitness());
        
 //       //Printer.printInt(myPop.getFittest().getComb().getComb());
 //       //Printer.printInt(myPop.getFittest().getComb().getResult());
        ////////System.out.println(myPop.getFittest().getFitness());
        bestInd.getComb().updateState();
//		int[][] stateful = Combination.getCs().statefulReward;
//		//////System.out.println(".................................");
//		for (int[] x : stateful) {
//		//Printer.printInt(x);
//		//////System.out.println("");
//		}
//		//////System.out.println(".................................");
//        myPop.getFittest().getComb().printResult();
        
        myPop.getFittest().getComb().printResult();
        return myPop.getFittest();
		
	}
    public static void main(String[] args) {
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

//		//Printer.printInt("mq: ", Combination.getmQ());

        // Set a candidate solution
        // Create an initial population - with initial solution
        Population myPop = new Population(5, true);
        Individual bestInd = new Individual();
        
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (generationCount < Combination.getRound()) {
        	//////////System.out.println("******************" + generationCount + "******************");
            generationCount++;
            if (bestInd.getFitness() > myPop.getFittest().getFitness()) {
            	bestInd = myPop.getFittest();
            }
            ////Printer.printInt(myPop.getFittest().getComb().getComb());
            myPop = Algorithm.evolvePopulation(myPop);
            
            for (Individual ind : myPop.getIndividuals()) {
            	////////System.out.println(ind.toString());
            }
        }
        ////////System.out.println("Solution found!");
        ////////System.out.println("Generation: " + generationCount);
        ////////System.out.println("Genes:");
        ////////System.out.println("best: " + bestInd.getFitness());
        //Printer.printInt(myPop.getFittest().getComb().getComb());
        //Printer.printInt(myPop.getFittest().getComb().getResult());
        ////////System.out.println(myPop.getFittest().getFitness());


    }
	public static ArrayList<ArrayList<Double>> getConvergeList() {
		return convergeList;
	}
	public static void setConvergeList(ArrayList<ArrayList<Double>> convergeList) {
		CCP_Ga.convergeList = convergeList;
	}
	public static ArrayList<ArrayList<Population>> getPopList() {
		return popList;
	}
	public static void setPopList(ArrayList<ArrayList<Population>> popList) {
		CCP_Ga.popList = popList;
	}
}
