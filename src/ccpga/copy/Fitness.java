package ccpga.copy;

import utils.Combination;
import ccpga.copy.Individual;

public class Fitness {

	// 
    static int[] solution = new int[11];

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static double getFitness(Individual individual) {
    	individual.getComb().updatePart();
    	double combcost = individual.getComb().getCombCost();
    	if (combcost == -1) {
            return individual.getComb().run(); //< 0? Double.MAX_VALUE: individual.getComb().run();
    	} else {
    		return combcost;
    	}
    }
    
    public static void main(String args[]) {
		int[] comb = {1, 1, 2, 2, 3};
		int[] part = {2, 2, 1};
		Combination combi = new Combination(comb);
		Individual ind = new Individual(combi);
		////////System.out.println("fitness: " + Fitness.getFitness(ind));
    }
    
}
