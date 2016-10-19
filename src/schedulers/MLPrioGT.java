package schedulers;

import java.util.ArrayList;
import java.util.List;

import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class MLPrioGT extends MLPrio {
	protected int[][][] optimalSchedule;

	public MLPrioGT(NetworkGenerator ng, FlowGenerator tg, int[][][] schedule) {
		super(ng, tg, 0.0);
		this.optimalSchedule = schedule;
	}

	@Override
	public String getType() {
		return new String("MLPrio_GT");
	}

	/**
	 * Result is not normalized yet
	 */
	//@Override
	protected double calculateFlowCriticality(int flowID) {
		Flow flow = tg.getFlows().get(flowID);
		double result = 0;

		//Right side of the formula
		int scheduled = 0;
		for (int t = 0; t < optimalSchedule[0].length; t++) {
			for (int n = 0; n < optimalSchedule[0][0].length; n++) {
				if (optimalSchedule[flowID][t][n] != 0) {
					scheduled += optimalSchedule[flowID][t][n];
				}
			}
		}

		result = (scheduled / flow.getTokens()) * (double) flow.getImpUnsched();

		//Left side of the formula
		int window = flow.getWindowMax();
		int numWindows = flow.getDeadline() - flow.getStartTime() - window;
		List<Integer> scheduledPerWindow = new ArrayList<Integer>(numWindows);
		int windowScheduledSum = 0;
		if (window < flow.getDeadline() - flow.getStartTime()) {
			for (int t = flow.getStartTime(); t + window < flow.getDeadline(); t++) {
				int currentWindowScheduled = 0;
				for (int n = 0; n < optimalSchedule[0][0].length; n++) {
					for (int i = t; i < t + window; i++) {
						currentWindowScheduled += optimalSchedule[flowID][i][n];
					}
				}
				scheduledPerWindow.add(currentWindowScheduled);
			}
			for (int x : scheduledPerWindow) {
				windowScheduledSum += x;
			}
		} else { //If the throughputwindow is larger than the flows sending time
			//scheduled was calculated earlier and is now used
			numWindows = 1;
			windowScheduledSum = scheduled;
		}

		result += (double) ((flow.getImpThroughputMin() / (numWindows * flow.getTokensMax())) * windowScheduledSum);

		result = result / (flow.getImpThroughputMin() + flow.getImpUnsched());

		return result;
	}

}
