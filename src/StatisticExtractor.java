import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticExtractor {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		boolean large = true;
		int f, t, n;
		int rep;
		String logpath;
		if (large) {
			f = 4;
			t = 2;
			n = 4;
			rep = 1000;
			logpath = "my_logs" + File.separator + "jakob_large";
		} else {
			f = 2;
			t = 2;
			n = 2;
			rep = 1000;
			logpath = "my_logs" + File.separator + "jakob";
		}
		//rep = 460;

		List<Long> greedyList = new ArrayList<Long>();
		List<Long> postProcess0List = new ArrayList<Long>();
		List<Long> postProcess1List = new ArrayList<Long>();
		List<Long> postProcess2List = new ArrayList<Long>();
		List<Long> cplexList = new ArrayList<Long>();
		List<Long> randomList = new ArrayList<Long>();
		List<Long> fullBranchList = new ArrayList<Long>();
		List<Long> critList = new ArrayList<Long>();
		List<Long> fnMatchList = new ArrayList<Long>();

		List<Long> greedyListTime = new ArrayList<Long>();
		List<Long> postProcess0ListTime = new ArrayList<Long>();
		List<Long> postProcess1ListTime = new ArrayList<Long>();
		List<Long> postProcess2ListTime = new ArrayList<Long>();
		List<Long> cplexListTime = new ArrayList<Long>();
		List<Long> randomListTime = new ArrayList<Long>();
		List<Long> fullBranchListTime = new ArrayList<Long>();
		List<Long> critListTime = new ArrayList<Long>();
		List<Long> fnMatchListTime = new ArrayList<Long>();

		String setup = f + "_" + t + "_" + n;
		for (int i = 0; i < rep; i++) {
			greedyList.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_log.m"));
			postProcess0List.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "PostProcess_0_log.m"));
			postProcess1List.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "PostProcess_1_log.m"));
			postProcess2List.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "PostProcess_2_log.m"));
			cplexList.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Optimization_log.m"));
			randomList.add(getCost(
					logpath + File.separator + setup + File.separator + "rep_" + i + File.separator + "Random_log.m"));
			fullBranchList.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "FullBranch_2_log.m"));
			critList.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_CriticalityGT_log.m"));
			fnMatchList.add(getCost(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_FNGT_log.m"));
			//time
			//
			//
			greedyListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_log.m"));
			postProcess0ListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i
					+ File.separator + "PostProcess_0_log.m"));
			postProcess1ListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i
					+ File.separator + "PostProcess_1_log.m"));
			postProcess2ListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i
					+ File.separator + "PostProcess_2_log.m"));
			cplexListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Optimization_log.m"));
			randomListTime.add(getTime(
					logpath + File.separator + setup + File.separator + "rep_" + i + File.separator + "Random_log.m"));
			fullBranchListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i
					+ File.separator + "FullBranch_2_log.m"));
			critListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_CriticalityGT_log.m"));
			fnMatchListTime.add(getTime(logpath + File.separator + setup + File.separator + "rep_" + i + File.separator
					+ "Greedy_0_H2_FNGT_log.m"));
			if (i % 100 == 0) {
				System.out.println(i);
			}
		}

		//		long greedy = 0;
		//		long postProcess0 = 0;
		//		long postProcess1 = 0;
		//		long postProcess2 = 0;
		//		long cplex = 0;
		//		long random = 0;
		//		long fullBranch = 0;
		//		long fnMatch = 0;
		//		long crit = 0;
		long greedyTime = 0;
		long postProcess0Time = 0;
		long postProcess1Time = 0;
		long postProcess2Time = 0;
		long cplexTime = 0;
		long randomTime = 0;
		long fullBranchTime = 0;
		long fnMatchTime = 0;
		long critTime = 0;

		for (int i = 0; i < rep; i++) {
			//					greedy += greedyList.get(i);
			//					postProcess0 += postProcess0List.get(i);
			//					postProcess1 += postProcess1List.get(i);
			//					postProcess2 += postProcess2List.get(i);
			//					cplex += cplexList.get(i);
			//					random += randomList.get(i);
			//					fullBranch += fullBranchList.get(i);
			//----------------------------------------------------
			greedyTime += greedyListTime.get(i);
			postProcess0Time += postProcess0ListTime.get(i);
			postProcess1Time += postProcess1ListTime.get(i);
			postProcess2Time += postProcess2ListTime.get(i);
			cplexTime += cplexListTime.get(i);
			randomTime += randomListTime.get(i);
			fullBranchTime += fullBranchListTime.get(i);
			fnMatchTime += fnMatchList.get(i);
			critTime += critListTime.get(i);
		}

		List<Double> greedyListPercent = new ArrayList<Double>();
		List<Double> postProcess0ListPercent = new ArrayList<Double>();
		List<Double> postProcess1ListPercent = new ArrayList<Double>();
		List<Double> postProcess2ListPercent = new ArrayList<Double>();
		List<Double> cplexListPercent = new ArrayList<Double>();
		List<Double> randomListPercent = new ArrayList<Double>();
		List<Double> fullBranchListPercent = new ArrayList<Double>();
		List<Double> critListPercent = new ArrayList<Double>();
		List<Double> fnMatchListPercent = new ArrayList<Double>();
		for (int i = 0; i < rep; i++) {
			greedyListPercent.add((double) greedyList.get(i) / cplexList.get(i) * 100);
			postProcess0ListPercent.add((double) postProcess0List.get(i) / cplexList.get(i) * 100);
			postProcess1ListPercent.add((double) postProcess1List.get(i) / cplexList.get(i) * 100);
			postProcess2ListPercent.add((double) postProcess2List.get(i) / cplexList.get(i) * 100);
			randomListPercent.add((double) randomList.get(i) / cplexList.get(i) * 100);
			fullBranchListPercent.add((double) fullBranchList.get(i) / cplexList.get(i) * 100);
			critListPercent.add((double) critList.get(i) / cplexList.get(i) * 100);
			fnMatchListPercent.add((double) fnMatchList.get(i) / cplexList.get(i) * 100);
		}

		//		int[] errors = { 90, 463, 541, 556, 618, 701 };
		//		for (int i = 0; i < errors.length; i++) {
		//			System.err.println(postProcess1List.get(errors[i]));
		//			System.err.println(cplexList.get(errors[i]));
		//			System.err.println((double) postProcess1List.get(errors[i]) / cplexList.get(errors[i]));
		//			System.err.println();
		//		}
		for (int i = 0; i < rep; i++) {
			if (postProcess0List.get(i) < cplexList.get(i)) {
				System.err.println(i);
			}
		}

		System.out.println("execution times:");
		double factor = 100000.0;
		System.out.println("Greedy:\t\t" + ((long) ((long) greedyTime / rep) / factor));
		System.out.println("postProcess0:\t" + ((long) ((long) postProcess0Time / rep) / factor));
		System.out.println("postProcess1:\t" + ((long) ((long) postProcess1Time / rep) / factor));
		System.out.println("postProcess2:\t" + ((long) ((long) postProcess2Time / rep) / factor));
		System.out.println("cplex:\t\t" + ((long) ((long) cplexTime / rep) / factor));
		System.out.println("random:\t\t" + ((long) ((long) randomTime / rep) / factor));
		System.out.println("fullBranch:\t" + ((long) ((long) fullBranchTime / rep) / factor));
		System.out.println("crit:\t\t" + ((long) ((long) critTime / rep) / factor));
		System.out.println("fnMatch:\t" + ((long) ((long) fnMatchTime / rep) / factor));

		Collections.sort(greedyListPercent);
		Collections.sort(postProcess0ListPercent);
		Collections.sort(postProcess1ListPercent);
		Collections.sort(postProcess2ListPercent);
		Collections.sort(cplexListPercent);
		Collections.sort(randomListPercent);
		Collections.sort(fullBranchListPercent);
		Collections.sort(critListPercent);
		Collections.sort(fnMatchListPercent);
		System.out.println("Lower and upper percentiles:");
		System.out.println("Greedy:");
		System.out.println(greedyListPercent.get(50));
		System.out.println(greedyListPercent.get(950));

		System.out.println("postProcess0ListPercent:");
		System.out.println(postProcess0ListPercent.get(50));
		System.out.println(postProcess0ListPercent.get(950));

		System.out.println("postProcess1ListPercent:");
		System.out.println(postProcess1ListPercent.get(50));
		System.out.println(postProcess1ListPercent.get(950));

		System.out.println("postProcess2ListPercent:");
		System.out.println(postProcess2ListPercent.get(50));
		System.out.println(postProcess2ListPercent.get(950));

		//		System.out.println("cplexListPercent:");
		//		System.out.println(cplexListPercent.get(50));
		//		System.out.println(cplexListPercent.get(950));

		System.out.println("randomListPercent:");
		System.out.println(randomListPercent.get(50));
		System.out.println(randomListPercent.get(950));

		System.out.println("fullBranchListPercent:");
		System.out.println(fullBranchListPercent.get(50));
		System.out.println(fullBranchListPercent.get(950));

		System.out.println("critListPercent:");
		System.out.println(critListPercent.get(50));
		System.out.println(critListPercent.get(950));

		System.out.println("fnMatchListPercent:");
		System.out.println(fnMatchListPercent.get(50));
		System.out.println(fnMatchListPercent.get(950));

		//		System.out.println();
		//		System.out.println("total cost over " + rep + " schedules:");
		//		System.out.println("Random:\t\t" + random);
		//		System.out.println("Greedy:\t\t" + greedy);
		//		System.out.println("postProcess0:\t" + postProcess0);
		//		System.out.println("postProcess1:\t" + postProcess1);
		//		System.out.println("postProcess2:\t" + postProcess2);
		//		System.out.println("fullBranch2:\t" + fullBranch);
		//		System.out.println("CPlex:\t\t" + cplex);
		//		System.out.println();
		//				System.out.println("percentages:");
		//				System.out.printf("Cplex:\t\t%.2f\n", (float) cplex / cplex * 100);
		//				System.out.printf("Random:\t\t%.2f\n", (float) random / cplex * 100);
		//				System.out.printf("postProcess0:\t%.2f\n", (float) postProcess0 / cplex * 100);
		//				System.out.printf("postProcess1:\t%.2f\n", (float) postProcess1 / cplex * 100);
		//				System.out.printf("postProcess2:\t%.2f\n", (float) postProcess2 / cplex * 100);
		//				System.out.printf("fullBranch2:\t%.2f\n", (float) fullBranch / cplex * 100);
		//				System.out.printf("Greedy:\t\t%.2f\n", (float) greedy / cplex * 100);

		long greedyAveragePercent = 0;
		long postProcess0AveragePercent = 0;
		long postProcess1AveragePercent = 0;
		long postProcess2AveragePercent = 0;
		long cplexAveragePercent = 0;
		long randomAveragePercent = 0;
		long fullBranchAveragePercent = 0;
		long fnMatchAveragePercent = 0;
		long critAveragePercent = 0;

		for (int i = 0; i < rep; i++) {
			greedyAveragePercent += greedyListPercent.get(i);
			postProcess0AveragePercent += postProcess0ListPercent.get(i);
			postProcess1AveragePercent += postProcess1ListPercent.get(i);
			postProcess2AveragePercent += postProcess2ListPercent.get(i);
			//cplexAveragePercent += greedyListPercent.get(i);
			randomAveragePercent += randomListPercent.get(i);
			fullBranchAveragePercent += fullBranchListPercent.get(i);
			fnMatchAveragePercent += fnMatchListPercent.get(i);
			critAveragePercent += critListPercent.get(i);
		}
		double greedyAveragePercentD = (double) greedyAveragePercent / rep;
		double postProcess0AveragePercentD = (double) postProcess0AveragePercent / rep;
		double postProcess1AveragePercentD = (double) postProcess1AveragePercent / rep;
		double postProcess2AveragePercentD = (double) postProcess2AveragePercent / rep;
		double cplexAveragePercentD = (double) cplexAveragePercent / rep;
		double randomAveragePercentD = (double) randomAveragePercent / rep;
		double fullBranchAveragePercentD = (double) fullBranchAveragePercent / rep;
		double fnMatchAveragePercentD = (double) fnMatchAveragePercent / rep;
		double critAveragePercentD = (double) critAveragePercent / rep;

		System.out.println("greedyAveragePercent:" + greedyAveragePercentD);
		System.out.println("postProcess0AveragePercent:" + postProcess0AveragePercentD);
		System.out.println("postProcess1AveragePercent:" + postProcess1AveragePercentD);
		System.out.println("postProcess2AveragePercent:" + postProcess2AveragePercentD);
		System.out.println("cplexAveragePercent:" + cplexAveragePercentD);
		System.out.println("randomAveragePercent:" + randomAveragePercentD);
		System.out.println("fullBranchAveragePercent:" + fullBranchAveragePercentD);
		System.out.println("fnMatchAveragePercent:" + fnMatchAveragePercentD);
		System.out.println("critAveragePercent:" + critAveragePercentD);

	}

	public static long getCost(String path) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("costTotal")) {
					line = line.substring(12);
					line = line.substring(0, line.length() - 2);
					return Long.parseLong(line);
				}
			}
		}
		throw new IOException("costTotal not found in: " + path);
	}

	public static long getTime(String path) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("scheduling_duration_us")) {
					line = line.substring(25);
					line = line.substring(0, line.length() - 2);
					return Long.parseLong(line);
				}
			}
		}
		throw new IOException("costTotal not found in: " + path);
	}
}
