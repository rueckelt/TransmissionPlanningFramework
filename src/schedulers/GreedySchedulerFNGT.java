package schedulers;

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
public class GreedySchedulerFNGT extends GreedyScheduler {
	private int[][][] optimalSchedule;

	public GreedySchedulerFNGT(NetworkGenerator ng, FlowGenerator tg, int[][][] schedule) {
		super(ng, tg);
		this.optimalSchedule = schedule;
	}

	@Override
	public String getType() {
		return new String("Greedy_" + schedule_decision_limit + (NEW_RATING_ESTIMATOR ? "_H2" : "")).replace("-", "m")
				+ "_FNGT";
	}

	@Override
	protected Vector<Integer> sortNetworkIDs(final Flow flow) {
		if (optimalSchedule == null) {
			System.out.println("optimal schedule is null!");
			return new Vector<Integer>();
		}

		int flowIndex = getFlowIndex();
		int[] networkScore = new int[optimalSchedule[0][0].length];

		for (int i = 0; i < networkScore.length; i++) {
			networkScore[i] = 0;
		}

		for (int non = 0; non < optimalSchedule[0][0].length; non++) {
			for (int t = 0; t < optimalSchedule[0].length; t++) {
				networkScore[non] += optimalSchedule[flowIndex][t][non];
			}
		}

		Vector<Integer> result = new Vector<Integer>();
		int maxIndex = -1;
		for (int j = 0; j < networkScore.length; j++) {
			for (int i = 0; i < networkScore.length; i++) {
				if ((maxIndex == -1 || networkScore[i] >= networkScore[maxIndex]) && !result.contains(i)) {
					maxIndex = i;
				}
			}
			if (maxIndex == -1) {
				System.err.println("This should never have happened");
				break;
			}
			result.add(maxIndex);
			maxIndex = -1;
		}

		return result;
	}

}
