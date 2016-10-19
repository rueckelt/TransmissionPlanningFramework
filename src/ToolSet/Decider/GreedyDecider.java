package ToolSet.Decider;

import java.util.ArrayList;
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
public class GreedyDecider extends GreedyScheduler implements Decider {
	protected String name;

	public GreedyDecider(NetworkGenerator ng, FlowGenerator fg) {
		super(ng, fg);
		name = "GreedyDecider";
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (NEW_RATING_ESTIMATOR) {
			initCostSeparation();
		}
		ScheduleWrapper oldSchedule = sw.clone();
		List<Decision> decisions = new ArrayList<Decision>();
		this.setTempSchedule(sw.clone().getSchedule());
		int flowIndex = selectFlow(sw);
		//System.out.println("flowIndex: " + flowIndex);
		if (flowIndex != -1) {

			scheduleFlow(flowIndex, false);
			if (oldSchedule.isDifferentSchedule(getTempSchedule())) {
				decisions.add(new Decision(getTempSchedule(), 1, name));
			}
		}
		return decisions;
	}

	protected int selectFlow(ScheduleWrapper sw) {
		List<Integer> criticality = sortByFlowCriticality();
		List<Integer> sched = findAlreadyScheduledFlows(sw);
		//System.out.println("crit: " + criticality);
		//System.out.println("sched: " + sched);
		for (int i = 0; i < criticality.size(); i++) {
			if (!sched.contains(criticality.get(i))) {
				return criticality.get(i);
			}
		}
		return -1;
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
