package ToolSet.Decider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import ToolSet.ScheduleWrapper;
import schedulers.GreedyScheduler;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

/**
 * This Decider works like the GreedyScheduler
 * @author Jakob
 *
 */
public class FullTimeGreedyDecider extends GreedyScheduler implements Decider {
	protected String name;

	public FullTimeGreedyDecider(NetworkGenerator ng, FlowGenerator fg, boolean NEW_RATING) {
		super(ng, fg);
		name = "FullGreedyDecider";
		newRating(NEW_RATING);
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (NEW_RATING_ESTIMATOR) {
			initCostSeparation();
		}
		List<Decision> decisions = new ArrayList<Decision>();
		this.setTempSchedule(sw.clone().getSchedule());
		List<Integer> flows = sortFlowByWindowSize();
		//List<Integer> flows = selectFlows(sw);

		while (flows.size() > 0) {
			//System.out.println("flowIndex: " + flowIndex);
			scheduleFlow(flows.get(0), false);
			flows.remove(0);

		}
		decisions.add(new Decision(new ScheduleWrapper(getTempSchedule()).clone().getSchedule(), 1, name));
		return decisions;
	}

	/**
	 * @return
	 */
	protected List<Integer> sortFlowByWindowSize() {
		//		################# 1. sort flows according to decreasing criticality #################
		List<Integer> flowCriticality = new LinkedList<Integer>();
		//sort keys of map in descending order
		List<Integer> flow_order = new LinkedList<Integer>();
		for (int f = 0; f < tg.getFlows().size(); f++) {
			flow_order.add(f);
			flowCriticality.add(calculateFlowWindow(tg.getFlows().get(f), ng));
		}
		final List<Integer> flowCrit_tmp = flowCriticality;
		Collections.sort(flow_order, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return flowCrit_tmp.get(i2) - flowCrit_tmp.get(i1);
			}
		}); //highest priority first
		return flow_order;
	}

	protected int calculateFlowWindow(Flow f, NetworkGenerator ng) {
		return f.getDeadline() - f.getStartTime();
	}

	protected List<Integer> selectFlows(ScheduleWrapper sw) {
		List<Integer> criticality = sortFlowByWindowSize();
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
