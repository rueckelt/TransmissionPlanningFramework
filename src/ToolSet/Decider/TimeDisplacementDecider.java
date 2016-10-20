package ToolSet.Decider;

import java.util.ArrayList;
import java.util.List;

import ToolSet.CostSeparation;
import ToolSet.ScheduleWrapper;
import schedulers.PriorityScheduler;
import schedulingIOModel.CostFunction;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class TimeDisplacementDecider implements Decider {
	protected String name;
	CostSeparation cs;
	FlowGenerator fg;
	NetworkGenerator ng;

	public TimeDisplacementDecider(NetworkGenerator ng, FlowGenerator fg) {
		name = "TimeDisplacement";
		this.cs = new CostSeparation(fg, ng);
		this.fg = fg;
		this.ng = ng;
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (fg.getFlows().size() == 1) {
			return new ArrayList<Decision>();
		}
		List<Decision> decisions = new ArrayList<Decision>();
		int[][] networkMatch = cs.getNetworkMatch();
		List<Integer> flowCriticality = calculateFlowCriticalities();
		int[][] flowTimeOverlap = calculateFlowTimeOverlap();
		int biggestOverlapA = 0;
		int biggestOverlapB = 0;
		int biggestOverlapValue = 0;
		for (int i = 0; i < fg.getFlows().size(); i++) {
			for (int j = 0; j < fg.getFlows().size(); j++) {
				if (flowTimeOverlap[i][j] >= biggestOverlapValue) {
					biggestOverlapA = i;
					biggestOverlapB = j;
					biggestOverlapValue = flowTimeOverlap[i][j];
				}
			}
		}

		return decisions;
	}

	private int[][] calculateFlowTimeOverlap() {
		int[][] result = new int[fg.getFlows().size()][fg.getFlows().size()];

		for (int i = 0; i < fg.getFlows().size(); i++) {
			for (int j = 0; j < fg.getFlows().size(); j++) {
				if (j == i) {
					result[j][i] = -1;
				} else {
					int startWindow = Math.max(fg.getFlows().get(i).getStartTime(),
							fg.getFlows().get(j).getStartTime());
					int endWindow = Math.min(fg.getFlows().get(i).getDeadline(), fg.getFlows().get(j).getDeadline());
					result[i][j] = Math.max(0, endWindow - startWindow);
				}
			}
		}

		return result;
	}

	protected List<Integer> calculateFlowCriticalities() {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < fg.getFlows().size(); i++) {
			result.add(calculateFlowCriticality(fg.getFlows().get(i), ng));
		}

		return result;
	}

	/**
	 * criticality is worst case schedule cost (flow NOT scheduled) 
	 * @param f flow
	 * @param ng available networks
	 * @return criticality
	 */
	protected int calculateFlowCriticality(Flow f, NetworkGenerator ng) {
		//calculate violation if flow is NOT scheduled (worst case)
		//TODO: and subtract violation is flow is scheduled alone (best case)
		FlowGenerator tg_temp = new FlowGenerator();
		tg_temp.addFlow(f);
		CostFunction cf = new CostFunction(ng, tg_temp);
		//get cost with empty schedule (worst case, flow is unscheduled)
		int cost_wc = cf.costViolation(getEmptySchedule(tg_temp, ng));
		//cost_wc*=f.getImpUser();
		//System.out.println("criticality:cost of flow "+getId()+" worst: "+cost_wc);
		int cost_bc = 0;
		return cost_wc;//-cost_bc;
	}

	protected int[][][] getEmptySchedule(FlowGenerator tg, NetworkGenerator ng) {
		return new PriorityScheduler(ng, tg).getEmptySchedule(); //this could be a dummy scheduler.. only need empty schedule from it
	}
}
