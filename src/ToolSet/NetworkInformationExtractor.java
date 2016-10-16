package ToolSet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.Network;
import schedulingIOModel.NetworkGenerator;

public class NetworkInformationExtractor {
	static String rootPath = "/home/jakob/222/2_2_2/";
	static int numberOfFlows = 16;
	static int numberOfTimeslots = 100;
	static int numberOfNetworks = 16;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		timestepAsInstancesWithCS();
	}

	public static void timestepAsInstancesWithCS() throws FileNotFoundException, IOException {
		NetworkGenerator ng;
		FlowGenerator fg;
		CostSeparation cs;
		Vector<Network> networks;
		Vector<Flow> flows;
		List<String> features = new ArrayList<String>();
		List<String> outputs = new ArrayList<String>();
		StringBuilder sb;

		for (int i = 0; i < 30000; i++) {
			int[][][] schedule = getOptimalSchedule(i);
			ng = NetworkGenerator.loadNetworkGenerator(rootPath + "rep_" + i + "/");
			fg = FlowGenerator.loadTrafficGenerator(rootPath + "rep_" + i + "/");
			networks = ng.getNetworks();
			flows = fg.getFlows();
			cs = new CostSeparation(fg, ng);

			for (int t = 1; t < ng.getNetworks().get(0).getSlots(); t++) {
				sb = new StringBuilder();
				// Append Network cost
				for (Network n : networks) {
					sb.append(n.getCapacity().get(t));
					sb.append(',');
				}

				// Append Flows current send status
				//for (Flow f : flows) {
				for (int nof = 0; nof < numberOfFlows; nof++) {
					Flow f = flows.get(nof);
					sb.append(cs.getTimeMatch(nof, t));
					sb.append(",");
					sb.append(f.getWindowMin());
					sb.append(",");
					sb.append(f.getWindowMax());
					sb.append(",");
					sb.append(f.getTokensMin());
					sb.append(",");
					sb.append(f.getTokensMax());
					sb.append(",");
					sb.append(f.getImpThroughputMax());
					sb.append(",");
					sb.append(f.getImpThroughputMin());
					sb.append(",");
					sb.append(f.getImpUnsched());
					sb.append(",");
				}

				for (int non = 0; non < numberOfFlows; non++) {
					Network n = networks.get(non);
					for (int nof = 0; nof < numberOfFlows; nof++) {
						Flow f = flows.get(nof);
						sb.append(cs.getNetworkMatch(nof, non));
						sb.append(",");
					}
				}
				sb.deleteCharAt(sb.toString().length() - 1);
				features.add(sb.toString());
				// Generate output here:
				sb = new StringBuilder();
				for (int f = 0; f < numberOfFlows; f++) {
					for (int n = 0; n < numberOfNetworks; n++) {
						if (schedule[f][t][n] == 0) {
							sb.append(0);
						} else {
							sb.append(1);
						}
						if (f != numberOfFlows - 1 || n != numberOfNetworks - 1) {
							sb.append(",");
						}
					}
				}
				outputs.add(sb.toString());
			}

			if (i % 100 == 0) {
				System.out.println("Folders processed: " + i);
			}
		}
		Files.write(Paths.get("/home/jakob/featuresCS"), features);
		Files.write(Paths.get("/home/jakob/outputsCS"), outputs);
	}

	public static void scheduleAsInstances() throws FileNotFoundException, IOException {
		NetworkGenerator ng;
		FlowGenerator fg;
		Vector<Network> networks;
		Vector<Flow> flows;
		List<String> features = new ArrayList<String>();
		List<String> outputs = new ArrayList<String>();
		StringBuilder feature;
		StringBuilder output;

		for (int i = 0; i < 10000; i++) {
			ng = NetworkGenerator.loadNetworkGenerator(rootPath + "rep_" + i + "/");
			fg = FlowGenerator.loadTrafficGenerator(rootPath + "rep_" + i + "/");
			CostSeparation cs = new CostSeparation(fg, ng);
			networks = ng.getNetworks();
			flows = fg.getFlows();
			feature = new StringBuilder();
			//Generate features here:
			for (Flow f : flows) {
				feature.append(f.getDeadline());
				feature.append(",");
				feature.append(f.getStartTime());
				feature.append(",");
				feature.append(f.getImpDeadline());
				feature.append(",");
				feature.append(f.getImpJitter());
				feature.append(",");
				feature.append(f.getImpLatency());
				feature.append(",");
				feature.append(f.getImpStartTime());
				feature.append(",");
				feature.append(f.getImpThroughputMax());
				feature.append(",");
				feature.append(f.getImpThroughputMin());
				feature.append(",");
				feature.append(f.getImpUser());
				feature.append(",");
				feature.append(f.getReqJitter());
				feature.append(",");
				feature.append(f.getReqLatency());
				feature.append(",");
				feature.append(f.getWindowMax());
				feature.append(",");
				feature.append(f.getWindowMin());
				feature.append(",");
				feature.append(f.getTokensMin());
				feature.append(",");
				feature.append(f.getTokensMax());
				feature.append(",");
			}

			for (Network n : networks) {
				feature.append(n.getJitter());
				feature.append(",");
				feature.append(n.getLatency());
				feature.append(",");
				feature.append(n.getCost());
				feature.append(",");
				for (int t = 0; t < n.getSlots(); t++) {
					feature.append(n.getCapacity().get(t));
					feature.append(";");
				}
			}
			feature.deleteCharAt(feature.length() - 1);
			features.add(feature.toString());
			// Generate output here:
			int[][][] schedule = getOptimalSchedule(i);
			output = new StringBuilder();
			for (int f = 0; f < numberOfFlows; f++) {
				for (int n = 0; n < numberOfNetworks; n++) {
					for (int t = 0; t < numberOfTimeslots; t++) {
						output.append(schedule[f][t][n]);
						if (f != numberOfFlows - 1 || n != numberOfNetworks - 1 || t != numberOfTimeslots - 1) {
							output.append(",");
						}
					}
				}
			}
			outputs.add(output.toString());
			if (i % 100 == 0) {
				System.out.println("Folders processed: " + i);
			}
		}
		Files.write(Paths.get("/home/jakob/features"), features);
		Files.write(Paths.get("/home/jakob/outputs"), outputs);
	}

	public static void timestepAsInstances() throws FileNotFoundException, IOException {
		NetworkGenerator ng;
		FlowGenerator fg;
		Vector<Network> networks;
		Vector<Flow> flows;
		List<String> features = new ArrayList<String>();
		List<String> outputs = new ArrayList<String>();
		StringBuilder sb;

		for (int i = 0; i < 10000; i++) {
			int[][][] schedule = getOptimalSchedule(i);
			ng = NetworkGenerator.loadNetworkGenerator(rootPath + "rep_" + i + "/");
			fg = FlowGenerator.loadTrafficGenerator(rootPath + "rep_" + i + "/");
			networks = ng.getNetworks();
			flows = fg.getFlows();

			for (int t = 1; t < ng.getNetworks().get(0).getSlots(); t++) {
				sb = new StringBuilder();
				// Append Network cost
				for (Network n : networks) {
					sb.append(n.getCost());
					sb.append(',');
					sb.append(n.getCapacity().get(t));
					sb.append(',');
				}
				// Append Flows current send status
				for (Flow f : flows) {
					if (f.getStartTime() > t && f.getDeadline() < t) {
						sb.append("1,");
					} else {
						sb.append("0,");
					}
					sb.append(f.getWindowMin());
					sb.append(",");
					sb.append(f.getWindowMax());
					sb.append(",");
					sb.append(f.getTokensMin());
					sb.append(",");
					sb.append(f.getTokensMax());
					sb.append(",");
					sb.append(f.getImpDeadline());
					sb.append(",");
					sb.append(f.getImpJitter());
					sb.append(",");
					sb.append(f.getImpLatency());
					sb.append(",");
					sb.append(f.getImpStartTime());
					sb.append(",");
					sb.append(f.getImpThroughputMax());
					sb.append(",");
					sb.append(f.getImpThroughputMin());
					sb.append(",");
					sb.append(f.getImpUnsched());
					sb.append(",");
					sb.append(f.getImpUser());
					sb.append(",");
				}

				for (Network n : networks) {
					for (Flow f : flows) {
						if (n.getJitter() < f.getReqJitter()) {
							sb.append(0);
						} else {
							sb.append(Math.pow(n.getJitter() - f.getReqJitter(), 2));
						}
						sb.append(",");
						if (n.getLatency() < f.getReqLatency()) {
							sb.append(0);
						} else {
							sb.append(-Math.pow(n.getLatency() - f.getReqLatency(), 2));
						}
						sb.append(",");
					}
				}
				sb.deleteCharAt(sb.toString().length() - 1);
				features.add(sb.toString());
				// Generate output here:
				sb = new StringBuilder();
				for (int f = 0; f < numberOfFlows; f++) {
					for (int n = 0; n < numberOfNetworks; n++) {
						if (schedule[f][t][n] == 0) {
							sb.append(0);
						} else {
							sb.append(1);
						}
						if (f != numberOfFlows - 1 || n != numberOfNetworks - 1) {
							sb.append(",");
						}
					}
				}
				outputs.add(sb.toString());
			}

			if (i % 100 == 0) {
				System.out.println("Folders processed: " + i);
			}
		}
		Files.write(Paths.get("/home/jakob/features"), features);
		Files.write(Paths.get("/home/jakob/outputs"), outputs);
	}

	public static int[][][] getOptimalSchedule(int i) throws FileNotFoundException, IOException {
		return getOptimalSchedule(rootPath + "rep_" + i + "/Optimization_log.m");
	}

	public static int[][][] getOptimalSchedule(String path) throws FileNotFoundException, IOException {
		// results:
		// Lines represent a network
		// The numbers between the ; tell how much each flow has
		// allocated in each timestep
		int[][][] schedule = new int[numberOfFlows][numberOfTimeslots][numberOfNetworks];
		int networkNumber = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("schedule_f_t_n")) {
					if (networkNumber >= 9) {
						line = line.substring(26);
					} else {
						line = line.substring(25);
					}
					line = line.substring(0, line.length() - 2);
					line = line.replaceAll(" ", "");
					String[] lines = line.split(";");
					for (int x = 0; x < numberOfTimeslots; x++) {
						String[] allocated = lines[x].split(",");
						for (int y = 0; y < numberOfFlows; y++) {
							schedule[y][x][networkNumber] = Integer.parseInt(allocated[y]);
						}
					}
					networkNumber++;
				}
			}
		}
		return schedule;
	}

}
