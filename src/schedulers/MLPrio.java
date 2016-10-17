package schedulers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ToolSet.CostSeparation;
import ToolSet.ScheduleWrapper;
import ToolSet.Tree;
import schedulingIOModel.CostFunction;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class MLPrio extends Scheduler {
	protected NetworkGenerator ng;
	protected FlowGenerator fg;
	protected CostSeparation cs;

	/*
	 * if this is 0, all scheduling decisions will be evaluated
	 * Higher threshholds mean less computation time, but possibly less ideal solutions
	 */
	protected double ratingThreshold = 0.9;

	/**
	 * A protected class to hold scheduling decisions.
	 * It saves a rating of the decision as well, and is comparable by it to other decisions
	 * @author jakob
	 *
	 */
	protected class Decision implements Comparable<Decision> {
		public int flow;
		public int network;
		public int starttime;
		public int deadline;
		public int rating;

		public Decision(int flow, int network, int starttime, int deadline, int rating) {
			this.flow = flow;
			this.network = network;
			this.starttime = starttime;
			this.deadline = deadline;
			this.rating = rating;
		}

		@Override
		public int compareTo(Decision anotherDecision) {
			return this.rating - anotherDecision.rating;
		}
	}

	public MLPrio(NetworkGenerator ng, FlowGenerator fg) {
		super(ng, fg);
		this.ng = ng.clone();
		this.fg = fg;
		this.cs = new CostSeparation(fg, ng);
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		//calculate global criticality for all flows
		double[] globalFlowCriticality = calculateGlobalFlowCriticality();
		int[][] timeMatch = cs.getTimeMatch();
		int[][] networkMatch = cs.getNetworkMatch();
		Tree<Integer[][][]> branches;

		do {
			//discover and sort possible Decisions
			List<Decision> decisions = discoverDecisions();

			//Only consider decisions that are close to the best rating atm
			int consideredIndex = 0;
			while (consideredIndex + 1 < decisions.size()
					&& decisions.get(consideredIndex + 1).rating / decisions.get(0).rating > ratingThreshold) {
				consideredIndex++;
			}

		} while (true); //When to stop scheduling?

	}

	public void allocate(Decision d, ScheduleWrapper schedule) {
		//Aus Scheduler.java benutzen
	}

	/**
	 * Calls all decisionProviders and returns a sorted list with their proposed scheduling decisions
	 * @return
	 */
	private List<Decision> discoverDecisions() {
		List<Decision> decisions = new ArrayList<Decision>();

		decisions.addAll(greedyDecision());
		decisions.addAll(timeDisplacedDecision());
		decisions.addAll(throughputTradeoffDecision());

		Collections.sort(decisions);
		Collections.reverse(decisions);
		return decisions;
	}

	private Collection<? extends Decision> greedyDecision() {
		List<Decision> decisions = new ArrayList<Decision>();
		decisions.add(new Decision(0, 0, 0, 1, 15));

		return decisions;
	}

	private Collection<? extends Decision> timeDisplacedDecision() {
		List<Decision> decisions = new ArrayList<Decision>();
		decisions.add(new Decision(0, 0, 0, 1, 15));

		return decisions;
	}

	private Collection<? extends Decision> throughputTradeoffDecision() {
		List<Decision> decisions = new ArrayList<Decision>();
		decisions.add(new Decision(0, 0, 0, 1, 15));

		return decisions;
	}

	/**
	 * 
	 * @return a list that contains the priorization score for each flow
	 * Get the priorization of flow with number f: result.get(f);
	 */
	protected double[] calculateGlobalFlowCriticality() {
		double[] result = new double[fg.getFlows().size()];

		for (int i = 0; i < tg.getFlows().size(); i++) {
			result[i] = calculateFlowCriticality(i);
		}
		return result;
	}

	/**
	 * Slightly adapted from the Greedy Scheduler
	 * @param tg
	 * @param ng
	 * @return
	 */
	protected double calculateFlowCriticality(int flowID) {
		FlowGenerator tg_temp = new FlowGenerator();
		tg_temp.addFlow(fg.getFlows().get(flowID));
		CostFunction cf = new CostFunction(ng, tg_temp);
		//get cost with empty schedule (worst case, flow is unscheduled)
		return cf.costViolation(getEmptySchedule(tg_temp, ng));
	}

	/**
	 * Taken from the Greedy Scheduler
	 * @param tg
	 * @param ng
	 * @return
	 */
	private int[][][] getEmptySchedule(FlowGenerator tg, NetworkGenerator ng) {
		return new PriorityScheduler(ng, tg).getEmptySchedule(); //this could be a dummy scheduler.. only need empty schedule from it
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
