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
public class FillUpDecider extends GreedyScheduler implements Decider {
	protected String name;

	public FillUpDecider(NetworkGenerator ng, FlowGenerator fg, boolean NEW_RATING) {
		super(ng, fg);
		name = "FillUpDecider";
		newRating(NEW_RATING);
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (NEW_RATING_ESTIMATOR) {
			initCostSeparation();
		}
		if (sw.deciderHistory().contains("FillUpDecider")) {
			System.err.println("skiiiiiip");
			return new ArrayList<Decision>();
		}

		ScheduleWrapper oldSchedule = sw.clone();
		List<Decision> decisions = new ArrayList<Decision>();
		this.setTempSchedule(sw.clone().getSchedule());
		List<Integer> flows = sortByFlowsByCost();
		//List<Integer> flows = selectFlows(sw);

		for (int i = 0; i < flows.size(); i++) {
			fillUpFlow(flows.get(i));
		}

		if (oldSchedule.isDifferentSchedule(getTempSchedule())) {
			decisions.add(new Decision(new ScheduleWrapper(getTempSchedule()).clone().getSchedule(), 1, name));
		}
		return decisions;
	}

	protected int fillUpFlow(int f) {
		int tokensLeft = tg.getFlows().get(f).getTokens() - scheduled(f);
		int oldTokensLeft = tokensLeft;
		if (tokensLeft == 0) {
			return 0;
		}

		for (int n = 0; n < ng.getNetworks().size(); n++) {
			for (int t = 0; t < ng.getTimeslots(); t++) {
				if (tokensLeft > 0 && getTempSchedule()[f][t][n] != 0 && getRemainingNetCap(n, t) > 0) {
					//					System.out.println("f:" + f + ";   t:" + t + ";   n:" + n + ";   getRemainingNetCap: "
					//							+ getRemainingNetCap(n, t) + ";   getTempSchedule()[f][t][n]:" + getTempSchedule()[f][t][n]
					//							+ ";   tokensLeft: " + tokensLeft);
					int allocated = allocate(f, t, n, 12);
					tokensLeft -= allocated;
				}
			}
		}

		//		System.out.println("f: " + f + ";   newly allocated: " + (oldTokensLeft - tokensLeft));
		//		System.out.println("f: " + f + ";   still missing: " + (tokensLeft));
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

	protected List<Integer> sortByFlowsByCost() {

		List<Integer> flowCriticality = new LinkedList<Integer>();
		//sort keys of map in descending order
		List<Integer> flow_order = new LinkedList<Integer>();
		int[] vioNon = cf.vioNon(cf.cummulated_f_t(getTempSchedule()));
		for (int f = 0; f < tg.getFlows().size(); f++) {
			flow_order.add(f);
			flowCriticality.add(calculateFlowCriticality(tg.getFlows().get(f), ng));
			flowCriticality.add(vioNon[f]);
		}

		final List<Integer> flowCrit_tmp = flowCriticality;
		Collections.sort(flow_order, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return flowCrit_tmp.get(i2) - flowCrit_tmp.get(i1);
			}
		}); //highest priority first
		for (int i = 0; i < flow_order.size(); i++) {
			System.out.print(flowCriticality.get(flow_order.get(i)) + ",");
		}
		System.out.println("----------");
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
