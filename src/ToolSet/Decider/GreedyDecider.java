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

	public GreedyDecider(NetworkGenerator ng, FlowGenerator fg, boolean NEW_RATING) {
		super(ng, fg);
		name = "GreedyDecider";
		newRating(NEW_RATING);
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (NEW_RATING_ESTIMATOR) {
			initCostSeparation();
		}
		boolean br = false;

		ScheduleWrapper oldSchedule = sw.clone();
		List<Decision> decisions = new ArrayList<Decision>();
		this.setTempSchedule(sw.clone().getSchedule());
		List<Integer> flows = sortByFlowCriticality();
		//List<Integer> flows = selectFlows(sw);

		while (!br && flows.size() > 0) {
			//System.out.println("flowIndex: " + flowIndex);
			scheduleFlow(flows.get(0), false);
			if (oldSchedule.isDifferentSchedule(getTempSchedule())) {
				decisions.add(new Decision(getTempSchedule(), 1, name));
				return decisions;
			} else {
				flows.remove(0);
			}
		}
		return decisions;
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
