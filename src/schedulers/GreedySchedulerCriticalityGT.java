package schedulers;

import java.util.ArrayList;
import java.util.List;

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
public class GreedySchedulerCriticalityGT extends GreedyScheduler {
	private int[][][] optimalSchedule;

	public GreedySchedulerCriticalityGT(NetworkGenerator ng, FlowGenerator tg, int[][][] schedule) {
		super(ng, tg);
		this.optimalSchedule = schedule;
	}

	@Override
	public String getType() {
		return new String("Greedy_" + schedule_decision_limit + (NEW_RATING_ESTIMATOR ? "_H2" : "")).replace("-", "m")
				+ "_CriticalityGT";
	}

	@Override
	protected int calculateFlowCriticality(Flow f, NetworkGenerator ng) {
		double result = 0;
		int flowID = getFlowIndex();
		//Right side of the formula
		int scheduled = 0;
		for (int t = 0; t < optimalSchedule[0].length; t++) {
			for (int n = 0; n < optimalSchedule[0][0].length; n++) {
				if (optimalSchedule[flowID][t][n] != 0) {
					scheduled += optimalSchedule[flowID][t][n];
				}
			}
		}

		result = (scheduled / f.getTokens()) * (double) f.getImpUnsched();

		//Left side of the formula
		int window = f.getWindowMax();
		int numWindows = f.getDeadline() - f.getStartTime() - window;
		List<Integer> scheduledPerWindow = new ArrayList<Integer>(numWindows);
		int windowScheduledSum;
		if (window < f.getDeadline() - f.getStartTime()) {
			for (int t = f.getStartTime(); t + window < f.getDeadline(); t++) {
				int currentWindowScheduled = 0;
				for (int n = 0; n < optimalSchedule[0][0].length; n++) {
					for (int i = t; i < t + window; i++) {
						currentWindowScheduled += optimalSchedule[flowID][i][n];
					}
				}
				scheduledPerWindow.add(currentWindowScheduled);
			}
			windowScheduledSum = scheduledPerWindow.stream().reduce((a, b) -> a + b).get();
		} else { //If the throughputwindow is larger than the flows sending time
			//scheduled was calculated earlier and is now used
			numWindows = 1;
			windowScheduledSum = scheduled;
		}

		result += (double) ((f.getImpThroughputMin() / (numWindows * f.getTokensMax())) * windowScheduledSum);

		result = result / (f.getImpThroughputMin() + f.getImpUnsched());

		return (int) Math.round(result);
	}

}
