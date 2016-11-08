package ccpga.copy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ToolSet.CostSeparation;
import ToolSet.JsonLogger;
import ToolSet.LogMatlabFormat;

//import org.apache.commons.math3.distribution.NormalDistribution;

import schedulingIOModel.CostFunction;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;
import utils.Combination;
import utils.Hasher;
import utils.Printer;
import visualization.Plot;
import visualization.VisualizationPack;

import ccpga.copy.Fitness;
import executor.Simulation;

public class Individual extends Thread implements Comparable {

    static int defaultGeneLength = Combination.getFlowNum(); // mutation index + 5 flows
    private int genes[] = new int[defaultGeneLength];
    private static int[] initGenes = Combination.getInitGenes(); // TODO shall be put in population
    private int mutateIndex = -1;
    private static Set<Integer> genePool;
    private int id = -1;
    static {
    	setGenePool(Combination.getAvailableNetworks());
    }

    private Combination comb;
    private static Combination combInit;
    
    private double fitness = Double.MAX_VALUE;
    
    public Individual() {
    	Arrays.fill(genes, 1);
//    	Arrays.fill(initGenes, 1);
    	comb = new Combination(initGenes.clone());
    //	////////System.out.println("indi: ");
    //	//Printer.printInt(comb.getComb());
 //   	comb.setComb(initGenes);
    	comb.updatePart();
    }
    
    public Individual(Combination combVar) {
 //   	Arrays.fill(initGenes, 1);
    	setComb(combVar);
    	genes = combVar.getComb();
    }
    
    
    // Create a random individual
    public void generateIndividual(int netIndex) {
    	mutate(false, netIndex);
    	
    }
    
    
    public static void generateInit() {
    	Combination comb = new Combination(initGenes);
    	setCombInit(comb);
//    	//Printer.printInt(combInit.getComb());
//    	//Printer.printInt(combInit.getPart());

    }
    
    public static void generateInit(int[] initLongTerm) {
    	initGenes  = initLongTerm;
    }
    
    public void mutate(boolean random, int netIndex) {
    	////////System.out.println("in mutate: + " + netIndex);
		int[] combList = comb.getComb().clone();
		// for (int i = 0; i < 5 && combList.equals(comb.getComb()); i++) {
			HashMap<Integer, List<Integer>> map = Hasher.listToMap(combList);
			////////System.out.println(map.toString());
			List<Integer> net = map.get(netIndex);
			if (net == null) {
				if (map.get(0) != null) {
					net = map.get(0);
				} else {
					return;
				}
			}
			int randomFlow = -1;
		    ////////System.out.println("++++++++++++++++++++++++++");
		int randomNet = 0;
		for (int i = 0; i < 100 && Arrays.equals(combList, comb.getComb()); i++) {

			Random rand = new Random();
		    int randomFlowIndex = rand.nextInt(net.size());
		    randomFlow = net.get(randomFlowIndex); 
		    randomNet = getRandomGene();
		    if (getGenePool().size() > 1) {
			    ////////System.out.println(getGenePool().toString());
			    ////////System.out.println("combList: " + randomFlow + ":" + combList[randomFlow]);

			    combList[randomFlow] = randomNet;
			    ////////System.out.println("combList: " + randomFlow + ":" + randomNet);
			    ////////System.out.println("*********************");
		    }
		    combList[randomFlow] = randomNet;



		}
	    if (!random) {
	    	mutateIndex = randomFlow;
	    }
	    ////Printer.printInt(combList);	

	    comb.setComb(combList);
	    comb.updatePart();
	    obeyConstraint(randomNet);
	    //////////System.out.println("mutateIndex: " + getMutateIndex());
    }
    
    public void mutate() {
    	// ////////System.out.println("this mutate");
		int[] combList = comb.getComb().clone();
		int randomFlow = -1;
		int randomFlowIndex = -1;
		int randomNet = -1;
		for (int i = 0; i < 100 && Arrays.equals(combList, comb.getComb()); i++) {

			Random rand = new Random();
			randomFlow = rand.nextInt(comb.getComb().length);
		    randomNet = getRandomGene();
		    
		 //   ////////System.out.println("randomNet: " + randomNet);
		    combList[randomFlow] = randomNet;
		 //   System.out.print("i: " + i + " ");
		 //   //Printer.printInt(combList);	
		}
	    ////Printer.printInt(combList);	

	    comb.setComb(combList);
	    comb.updatePart();
	    //////////System.out.println("mutateIndex: " + getMutateIndex());
    }
    public void mutate(boolean constOn) {
    	// ////////System.out.println("this mutate");
		int[] combList = comb.getComb().clone();
		int randomFlow = -1;
		int randomFlowIndex = -1;
		int randomNet = -1;
		for (int i = 0; i < 100 && Arrays.equals(combList, comb.getComb()); i++) {

			Random rand = new Random();
			randomFlow = rand.nextInt(comb.getComb().length);
		    randomNet = getRandomGene();
		    
		 //   ////////System.out.println("randomNet: " + randomNet);
		    combList[randomFlow] = randomNet;
		 //   System.out.print("i: " + i + " ");
		 //   //Printer.printInt("combList: ", combList);	
		 //   //////System.out.println("randomNet: " + randomNet);

		}
	    ////Printer.printInt(combList);	

	    comb.setComb(combList);
	    comb.updatePart();
	    obeyConstraint(randomNet);
	    ////Printer.printInt("nettype", getGeneTypeArray());
	    ////Printer.printInt("after obey: ", comb.getComb());
	    //////////System.out.println("mutateIndex: " + getMutateIndex());
    }
    
    public HashMap<Integer, Set<Integer>> getGeneType() {
    	return Combination.getNetTypeMap();
    }
    
    public int[] getGeneTypeArray() {
    	return Combination.getNetworkType();
    }
    
    public void obeyConstraint(int net) {
    	int[] com = comb.getComb().clone();
    	//HashMap<Integer, Set<Integer>> netTypeSet = getGeneType();
    	int[] genetype = getGeneTypeArray().clone();
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
    	comb.setComb(com);
    	comb.updatePart();
    	
    }
    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public static void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }
    
    public double getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int i) {
        genes[index] = i;
    }

    /* Public methods */
    public int size() {
        return comb.getComb().length;
    }

    public double getFitness() {
        fitness = Fitness.getFitness(this);
       
        return fitness;
    }
    
    public int[] getGenes() {
    	return genes;
    }
    
    public static int[] getInitGenes() {
    	return initGenes;
    }
    
    public static int getRandom(int start, int end) {
        Random rand = new Random();
        return rand.nextInt((end - start) + 1) + start;
    }	
	
	public double calcViolation() {
		return 0.0;
	}
	
	public void print() {
		//Printer.printInt(this.getComb().getComb());
	}
    
    public static void main(String[] args) {
		int[] comb1 = {1, 1, 2, 2, 3, 1};
		//private static int[] activeNetworkBool = {1, 0, 1, 1};
		//private static int[] activeFlowBool = {0, 1, 1, 1, 0, 1};
		Combination combi1 = new Combination(comb1);
		Individual ind1 = new Individual(combi1);
		ind1.mutate(true);
		
		
    	////////System.out.println("random gene: " + Individual.getRandomGene());
    	////////System.out.println("genePool: " + getGenePool());
		NetworkGenerator ng = new NetworkGenerator();

		ng.addNetwork(Network.getCellular(20, 100, true));
		ng.addNetwork(Network.getWiFi(10, 85, 10, true));
		ng.addNetwork(Network.getWiFi(10, 65, 12, true));
		
		NetworkGenerator ngReal = new NetworkGenerator(); //(3,30);
		ngReal.addNetwork(Network.getCellular(30, 95, false));
		ngReal.addNetwork(Network.getWiFi(10, 85, 7, false));
		ngReal.addNetwork(Network.getWiFi(10, 65, 10, false));
		for (Network net : ngReal.getNetworks()) {
			////////System.out.println(net.getCapacity().toString());
		}

		////////System.out.println("*************************");
		//ngReal.addPositionUncertainty((float) 0.3,(float)0.1, false);
		//ngReal.addNetworkUncertainty((float)0.3, 5);		//param1: change characteristics (tp, lcy, jit) --> [0..1]; param 2: change range
		for (Network net : ngReal.getNetworks()) {
			//net.addRangeUncertainty(5);
			//net.addCharacteristicsUncertainty((float) 0.3);
			//net.addRangeUncertainty(5);
			////////System.out.println(net.getCapacity().toString());
		}
		
		FlowGenerator tgPred = new FlowGenerator();
		tgPred.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0
		tgPred.addFlow(Flow.BufferableStream(4, 26, 13*70, false)); // 1
		tgPred.addFlow(Flow.BufferableStream(5, 19, 10*50, false)); // 2
		tgPred.addFlow(Flow.Interactive(10, 15)); // 3
		tgPred.addFlow(Flow.Background(300, 2, 25, false)); // 4*/

		FlowGenerator tg = new FlowGenerator();
		tg.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0
		tg.addFlow(Flow.BufferableStream(4, 26, 13*70, false)); // 1
		tg.addFlow(Flow.BufferableStream(5, 19, 10*50, false)); // 2
		tg.addFlow(Flow.Interactive(10, 15)); // 3
		tg.addFlow(Flow.Background(300, 2, 25, false)); // 4*/
		tg.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0
//		tg.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0


		//tg.addUncertainty((float)0.5, (float)0.5, 3);

		for (int i = 1; i < 4; i++) {
	//		tg.addFlow(Flow.LiveStram(3+i, 15+i, (i+1)*125, false)); // 0
	//		tg.addFlow(Flow.LiveStram(3, 15, 6*125, false)); // 0
			
		}
		for (Flow f : tg.getFlows()) {
			////////System.out.println("flowId-in main: " + f.getIndex());
		}
		CostSeparation cs = new CostSeparation(tg, ngReal);
		Combination.setCs(cs);
		
		int[] comb = {1, 1, 2, 2, 3, 1};
		//private static int[] activeNetworkBool = {1, 0, 1, 1};
		//private static int[] activeFlowBool = {0, 1, 1, 1, 0, 1};
		Combination combi = new Combination(comb);
		Individual ind = new Individual(combi);
		//Printer.printInt(ind.getComb().getComb());
		//ind.fitness = ind.getComb().run();
		//////////System.out.println("Individual's Fitness: " + ind.fitness);
		ind.mutate(false, 1);
		ind.fitness = ind.getComb().run();
		////////System.out.println("Individual's Fitness: " + ind.fitness);
		ind.getComb().printResult();
		//Individual.generateInit();
		
		
		////////System.out.println("++++++++++++2++++++++++++++++");
		int[] init = comb.clone();
		Individual.generateInit(init);
		Individual ind2 = new Individual();
		//Printer.printInt(ind2.getComb().getComb());
		int x = getRandomGene();
		////////System.out.println("select networkNum: " + x);
		ind2.generateIndividual(x);
		////////System.out.println("ind2: ");
		//Printer.printInt(ind2.getComb().getComb());
		////////System.out.println("fitness: " + ind2.getComb().run());
		////////System.out.println("mutateIndex: ");
		////////System.out.println(ind2.mutateIndex);
		ind2.getComb().printResult();
		
		
		////////System.out.println("++++++++++++3++++++++++++++++");
		Individual ind3 = new Individual();
		//Printer.printInt(ind3.getComb().getComb());
		ind3.mutate();
		//Printer.printInt(ind3.getComb().getComb());
		////////System.out.println("fitness 3: " + Fitness.getFitness(ind3));		
    }

	public Combination getComb() {
		return comb;
	}

	public void setComb(Combination comb) {
		this.comb = comb;
	}

	public int getMutateIndex() {
		return mutateIndex;
	}

	public void setMutateIndex(int mutateIndex) {
		this.mutateIndex = mutateIndex;
	}

	public static Combination getCombInit() {
		return combInit;
	}

	public static void setCombInit(Combination combInit) {
		Individual.combInit = combInit;
	}
	
	public static int getRandomGene() {
		int item = getGenePool().size() == 0? 0 : new Random().nextInt(getGenePool().size()); // In real life, the Random object should be rather more shared than this
		int i = 0;
		for(Integer gene : getGenePool()) {
		    if (i == item)
		        return gene;
		    i = i + 1;
		}
		return 0;
	}
	
	public static int getCertainGene(int item) {
		int i = 0;
		for(Integer gene : getGenePool()) {
		    if (i == item)
		        return gene;
		    i = i + 1;
		}
		return 1;
	}

	public static Set<Integer> getGenePool() {
		//Combination.getAvailableNetworks().add(0);
		setGenePool(Combination.getAvailableNetworks());
		return genePool;
	}

	public static void setGenePool(Set<Integer> genePool) {
		Individual.genePool = genePool;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int[] d = getComb().getComb();
		for (int i = 0; i < d.length; i++) {
			if (i != d.length - 1) {
				sb.append(d[i]);
				sb.append(',');
			} else {
				sb.append(d[i]);
			}
		}
		sb.append(']');
		return sb.toString();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Individual d2 = (Individual) o;
		if (this.getFitness() - d2.getFitness() < 0) {
			return -1;
		} else if (this.getFitness() - d2.getFitness() > 0) {
			return 1;
		}
		return 0;
	}
	
	 public void run() {
		 getFitness();
		// ////////System.out.println(id + ": " + );
	}

	public int getIndivId() {
		return id;
	}

	public void setIndivId(int id) {
		this.id = id;
	} 



}
