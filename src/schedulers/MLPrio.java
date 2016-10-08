package schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ToolSet.CostSeparation;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class MLPrio extends Scheduler {
	protected NetworkGenerator ng;
	protected FlowGenerator fg;

	public MLPrio(NetworkGenerator ng, FlowGenerator fg) {
		super(ng, fg);
		this.ng = ng.clone();
		this.fg = fg;
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @return a list that contains the priorization score for each flow
	 * Get the priorization of flow with number f: result.get(f);
	 */
	protected List<Double> globalFlowPriorization() {
		List<Double> result = new ArrayList<Double>(fg.getFlows().size());

		for (int i = 0; i < tg.getFlows().size(); i++) {
			result.set(i, calculateFlowPrio(i));
		}
		return result;
	}

	protected double calculateFlowPrio(int flowID) {
		return 0;
	}

	/**
	 * Maps each flow to a set of networks
	 * @return
	 */
	protected Map<Integer, List<Integer>> networkSelection() {
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		CostSeparation cs = new CostSeparation(fg, ng);
		int[] networkMatch;

		for (int f = 0; f < fg.getFlows().size(); f++) {
			networkMatch = cs.getNetworkMatch(f);
			Set<Integer> visited;
			int minCost = Integer.MAX_VALUE;
			int minIndex = -1;
			do {
				visited = new HashSet<Integer>();
				for (int i = 0; i < networkMatch.length; i++) {
					if ((minIndex == -1 && !visited.contains(i))
							|| (networkMatch[i] < minCost && !visited.contains(i))) {
						minCost = networkMatch[i];
						minIndex = i;
					}
				}
				if (minIndex == -1) {
					break;
				}

			} while (false);

			result.put(f, new ArrayList<Integer>());
		}

		return result;
	}

	@Override
	public String getType() {
		return "ML-Prio_Scheduler";
	}

}
