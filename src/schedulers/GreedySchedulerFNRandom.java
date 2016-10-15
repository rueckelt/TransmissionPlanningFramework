package schedulers;

import java.util.Collections;
import java.util.Vector;

import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

/**
 * Greedy Scheduler with the Flow-Network matching (sortNetworkIDs) replaced by Ground Truths derived by the IBM CPLEX Scheduler
 * Only works if the result of the CPLEX scheduler has already been calculated and saved in the Optimization_log.m file
 * Otherwise it will not schedule anything
 * @author jakob
 *
 */
public class GreedySchedulerFNRandom extends GreedyScheduler {

	public GreedySchedulerFNRandom(NetworkGenerator ng, FlowGenerator tg) {
		super(ng, tg);
	}

	@Override
	public String getType() {
		return new String("Greedy_" + schedule_decision_limit + (NEW_RATING_ESTIMATOR ? "_H2" : "")).replace("-", "m")
				+ "_FNRandom";
	}

	@Override
	protected Vector<Integer> sortNetworkIDs(final Flow flow) {
		Vector<Integer> result = new Vector<Integer>();

		for (int i = 0; i < ng.getNetworks().size(); i++) {
			result.add(i);
		}
		Collections.shuffle(result);
		return result;
	}

}
