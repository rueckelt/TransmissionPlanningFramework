package ToolSet.Decider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import ToolSet.ScheduleWrapper;
import schedulers.GreedyScheduler;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

/**
 * This Decider works like the GreedyScheduler
 * @author Jakob
 *
 */
public class TradeoffDecider extends GreedyScheduler implements Decider {
	protected String name;

	public TradeoffDecider(NetworkGenerator ng, FlowGenerator fg, boolean NEW_RATING) {
		super(ng, fg);
		name = "TradeoffDecider";
		newRating(NEW_RATING);
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (NEW_RATING_ESTIMATOR) {
			initCostSeparation();
		}

		if (sw.deciderHistory().contains("TradeoffDecider")) {
			return new ArrayList<Decision>();
		}

		ScheduleWrapper oldSchedule = sw.clone();
		List<Decision> decisions = new ArrayList<Decision>();
		this.setTempSchedule(sw.clone().getSchedule());
		List<Integer> flows = sortFlowsByCost();
		//List<Integer> flows = selectFlows(sw);
		setTempSchedule(getEmptySchedule());
		for (int i = 0; i < flows.size(); i++) {
			fixMinViolations(flows.get(i), oldSchedule);
		}

		if (oldSchedule.isDifferentSchedule(getTempSchedule())) {
			decisions.add(new Decision(new ScheduleWrapper(getTempSchedule()).clone().getSchedule(), 1, name));
		}
		return decisions;
	}

	protected void fixMinViolations(int f, ScheduleWrapper oldSchedule) {

		int[][] minVio = cf.vioTpMin(cf.cummulated_f_t(oldSchedule.getSchedule()));
		Vector<Integer> netIDs = sortNetworkIDs(tg.getFlows().get(f));
		int[] allocated = new int[ng.getNetworks().size()];

		for (int t = 0; t < ng.getTimeslots(); t++) {
			if (minVio[f][t] > 0) {
				//schedule minimum throughput requirement
				for (int n = 0; n < netIDs.size(); n++) {
					if (networkIsUsed(t, n, oldSchedule.getSchedule())) {
						int allocatedd = allocate(f, t, n, minVio[f][t]);
						//System.err.println(allocatedd);
						allocated[n] += allocatedd;
					}
				}
			}
		}
		return;
	}

	protected boolean networkIsUsed(int t, int n, int[][][] schedule) {
		for (int f = 0; f < tg.getFlows().size(); f++) {
			if (schedule[f][t][n] > 0) {
				return true;
			}
		}
		return false;
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

	protected List<Integer> sortFlowsByCost() {

		List<Integer> flowCriticality = new LinkedList<Integer>();
		//sort keys of map in descending order
		List<Integer> flow_order = new LinkedList<Integer>();
		int[] vioNon = cf.vioTp(cf.cummulated_f_t(getTempSchedule()));

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

}
