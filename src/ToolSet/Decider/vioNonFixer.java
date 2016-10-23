package ToolSet.Decider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import ToolSet.ScheduleWrapper;
import schedulers.GreedyScheduler;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

/**
 * This Decider works like the GreedyScheduler
 * @author Jakob
 *
 */
public class vioNonFixer extends GreedyScheduler implements Decider {
	protected String name;
	protected double fixThreshold;

	public vioNonFixer(NetworkGenerator ng, FlowGenerator fg, boolean NEW_RATING) {
		super(ng, fg);
		name = "vioNonFixer";
		newRating(NEW_RATING);
		fixThreshold = 0.01;
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (NEW_RATING_ESTIMATOR) {
			initCostSeparation();
		}

		List<List<Integer>> networkRank = rankNetworksByThroughput();
		ScheduleWrapper oldSchedule = sw.clone();
		List<Decision> decisions = new ArrayList<Decision>();
		this.setTempSchedule(sw.clone().getSchedule());
		List<Integer> flows = sortFlowsByVioNon();
		int totalViolation = cf.costViolation(oldSchedule.getSchedule());
		//List<Integer> flows = selectFlows(sw);
		setTempSchedule(getEmptySchedule());
		int[] vioNon = cf.vioNon(cf.cummulated_f_t(getTempSchedule()));
		//		for (int i = 0; i < flows.size(); i++) {
		//			if ((double) vioNon[flows.get(i)] / totalViolation > fixThreshold || true) {
		//				fixNonViolations(flows.get(i), oldSchedule, networkRank);
		//			}
		//		}
		int flow = findHighestNonVioFlow(vioNon);

		scheduleFlow(flow, false);
		decisions.add(new Decision(new ScheduleWrapper(getTempSchedule()).clone().getSchedule(), 1, name));
		return decisions;
	}

	protected int findHighestNonVioFlow(int[] vioNon) {
		int maxIndex = 0;
		int maxVio = Integer.MIN_VALUE;
		for (int i = 0; i < vioNon.length; i++) {
			if (vioNon[i] > maxVio) {
				maxIndex = i;
				maxVio = vioNon[i];
			}

		}
		return maxIndex;
	}

	protected boolean networkIsUsed(int t, int n, int[][][] schedule) {
		for (int f = 0; f < tg.getFlows().size(); f++) {
			if (schedule[f][t][n] > 0) {
				return true;
			}
		}
		return false;
	}

	protected void fixNonViolations(int f, ScheduleWrapper oldSchedule, List<List<Integer>> networkRank) {

		int[] nonVio = cf.vioNon(cf.cummulated_f_t(oldSchedule.getSchedule()));
		int[] allocated = new int[ng.getNetworks().size()];

		for (int t = 0; t < ng.getTimeslots(); t++) {
			if (nonVio[f] > 0) {
				List<Integer> usedNets = getUsedNetworks(t, oldSchedule.getSchedule());
				for (int n = 0; n < usedNets.size(); n++) {
					for (int n_compare = 0; n_compare < networkRank.get(t).size(); n_compare++) {
						if (ng.getNetworks().get(n).getCapacity().get(t) < ng.getNetworks()
								.get(networkRank.get(t).get(n_compare)).getCapacity().get(t)) {
							int allocatedd = allocate(f, t, n, 1);
							//System.err.println(allocatedd);
							allocated[n] += allocatedd;
							n_compare = networkRank.get(t).size();
						}
					}

				}
			}
		}
		return;
	}

	private List<Integer> getUsedNetworks(int t, int[][][] schedule) {
		List<Integer> result = new ArrayList<Integer>();
		for (int n = 0; n < ng.getNetworks().size(); n++) {
			if (networkIsUsed(t, n, schedule)) {
				result.add(n);
			}
		}
		return result;
	}

	protected int tradeOffFlow(int f) {
		int[][] minVio = cf.vioTpMin(cf.cummulated_f_t(getTempSchedule()));
		int tokensLeft = tg.getFlows().get(f).getTokens() - scheduled(f);
		int oldTokensLeft = tokensLeft;
		if (tokensLeft == 0) {
			return 0;
		}

		for (int t = 0; t < ng.getTimeslots(); t++) {
			if (minVio[f][t] > 0) {
				//TODO: find unused networks on the same interface with a higher throughput
				//TODO: find flows that can make do with a little less bandwith this timestep
				for (int n = 0; n < ng.getNetworks().size(); n++) {

				}
			}
		}

		for (int n = 0; n < ng.getNetworks().size(); n++) {
			for (int t = 0; t < ng.getTimeslots(); t++) {
				if (tokensLeft > 0 && getTempSchedule()[f][t][n] != 0 && getRemainingNetCap(n, t) > 0) {
					int allocated = allocate(f, t, n, 12);
					tokensLeft -= allocated;
				}
			}
		}

		return oldTokensLeft - tokensLeft;
	}

	protected int scheduled(int f) {
		int scheduled = 0;
		int[][][] s = getTempSchedule();
		for (int n = 0; n < ng.getNetworks().size(); n++) {
			for (int t = 0; t < ng.getTimeslots(); t++) {
				scheduled += s[f][t][n];
			}
		}
		return scheduled;
	}

	protected List<Integer> sortFlowsByVioNon() {

		List<Integer> flowCriticality = new LinkedList<Integer>();
		//sort keys of map in descending order
		List<Integer> flow_order = new LinkedList<Integer>();
		int[] vioNon = cf.vioNon(cf.cummulated_f_t(getTempSchedule()));

		for (int f = 0; f < tg.getFlows().size(); f++) {
			flow_order.add(f);
			flowCriticality.add(vioNon[f]);
		}

		final List<Integer> flowCrit_tmp = flowCriticality;
		Collections.sort(flow_order, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return flowCrit_tmp.get(i2) - flowCrit_tmp.get(i1);
			}
		}); //highest priority first
		//System.out.println(Arrays.toString(vioNon));
		//System.out.println(flow_order);

		return flow_order;
	}

	protected List<Integer> selectFlows(ScheduleWrapper sw) {
		List<Integer> criticality = sortByFlowCriticality();
		List<Integer> sched = findAlreadyScheduledFlows(sw);
		List<Integer> flows = new ArrayList<Integer>();
		//System.out.println("crit: " + criticality);
		//System.out.println("sched: " + sched);
		for (int i = 0; i < criticality.size(); i++) {
			if (!sched.contains(criticality.get(i))) {
				flows.add(criticality.get(i));
			}
		}
		return flows;
	}

	protected List<Integer> findAlreadyScheduledFlows(ScheduleWrapper sw) {
		List<Integer> result = new ArrayList<Integer>();
		for (int n = 0; n < ng.getNetworks().size(); n++) {
			for (int f = 0; f < tg.getFlows().size(); f++) {
				for (int t = 0; t < ng.getTimeslots(); t++) {
					if (sw.getSchedule()[f][t][n] != 0 && !result.contains(f)) {
						result.add(f);
					}
				}
			}
		}
		return result;
	}

	protected List<List<Integer>> rankNetworksByThroughput() {
		List<List<Integer>> rank = new ArrayList<List<Integer>>();

		for (int t = 0; t < ng.getTimeslots(); t++) {
			List<Integer> networkCapacity = new LinkedList<Integer>();
			//sort keys of map in descending order
			List<Integer> network_order = new LinkedList<Integer>();

			for (int n = 0; n < ng.getNetworks().size(); n++) {
				network_order.add(n);
				networkCapacity.add(ng.getNetworks().get(n).getCapacity().get(t));
			}

			final List<Integer> networkCapacity_tmp = networkCapacity;
			Collections.sort(network_order, new Comparator<Integer>() {
				@Override
				public int compare(Integer i1, Integer i2) {
					return networkCapacity_tmp.get(i2) - networkCapacity_tmp.get(i1);
				}
			}); //highest priority first
			//System.out.println(Arrays.toString(vioNon));
			//System.out.println(flow_order);
			rank.add(network_order);
		}
		return rank;
	}

}
