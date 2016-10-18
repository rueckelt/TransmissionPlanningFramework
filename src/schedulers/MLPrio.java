package schedulers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ToolSet.CostSeparation;
import ToolSet.Decision;
import ToolSet.ScheduleWrapper;
import schedulingIOModel.CostFunction;
import schedulingIOModel.Flow;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class MLPrio extends Scheduler {
	protected NetworkGenerator ng;
	protected FlowGenerator fg;
	protected CostSeparation cs;
	protected CostFunction cf;
	protected List<ScheduleWrapper> currentLeafs;
	protected List<ScheduleWrapper> finishedLeafs;

	/*
	 * if this is 0, all scheduling decisions will be evaluated
	 * Higher threshholds mean less computation time, but possibly less ideal solutions
	 */
	protected double ratingThreshold;

	public MLPrio(NetworkGenerator ng, FlowGenerator fg, double ratingThreshold) {
		super(ng, fg);
		this.ng = ng.clone();
		this.fg = fg;
		this.cs = new CostSeparation(fg, ng);
		this.cf = new CostFunction(ng, fg);
		this.ratingThreshold = ratingThreshold;
		currentLeafs = new ArrayList<ScheduleWrapper>();
		currentLeafs.add(new ScheduleWrapper(fg.getFlows().size(), ng.getTimeslots(), ng.getNetworks().size()));
		finishedLeafs = new ArrayList<ScheduleWrapper>();
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		List<Decision> decisions;

		while (currentLeafs.size() > 0) {
			ScheduleWrapper sw = currentLeafs.remove(0);
			decisions = discoverDecisions(sw);
			//Only consider decisions that are close to the best rating atm
			int consideredIndex = 0;
			while (consideredIndex + 1 < decisions.size()
					&& decisions.get(consideredIndex + 1).rating / decisions.get(0).rating > ratingThreshold) {
				consideredIndex++;
			}

			for (int i = 0; i < consideredIndex; i++) {
				ScheduleWrapper newSchedule = sw.clone();
				executeDecision(decisions.get(i), newSchedule);
				if (newSchedule.isFinished()) {
					finishedLeafs.add(newSchedule);
				} else {
					currentLeafs.add(newSchedule);
				}
			}
		}
	}

	/**
	 * Calls all decisionProviders and returns a sorted list with their proposed scheduling decisions
	 * @return
	 */
	private List<Decision> discoverDecisions(ScheduleWrapper sw) {
		List<Decision> decisions = new ArrayList<Decision>();

		decisions.addAll(greedyDecision(sw));
		decisions.addAll(timeDisplacedDecision());
		decisions.addAll(throughputTradeoffDecision());

		Collections.sort(decisions);
		Collections.reverse(decisions);
		return decisions;
	}

	public void executeDecision(Decision d, ScheduleWrapper schedule) {
		int allocated = 0;
		for (int i = 0; i < d.flow.length; i++) {
			for (int t = d.starttime[i]; t < d.deadline[i]; t++) {
				allocated += allocate(d.flow[i], t, d.network[i], d.throughput[i]);
			}
		}
		if (allocated == 0) {
			//this schedule is finished
			schedule.setFinished(true);
			schedule.setTotalCost(cf.costTotal(schedule.getSchedule()));
		}
	}

	private Collection<? extends Decision> greedyDecision(ScheduleWrapper sw) {
		List<Decision> decisions = new ArrayList<Decision>();

		List<Integer> unsched = findUnscheduledFlows(sw);
		List<Integer> criticality = sortByFlowCriticality();
		for (int i = 0; i < criticality.size(); i++) {
			if (unsched.contains(criticality.get(i))) {
				//Find Greedy decision here
			}
		}

		return decisions;
	}

	private List<Integer> findUnscheduledFlows(ScheduleWrapper sw) {
		List<Integer> result = new ArrayList<Integer>();
		for (int n = 0; n < ng.getNetworks().size(); n++) {
			for (int f = 0; f < fg.getFlows().size(); f++) {
				for (int t = 0; t < ng.getTimeslots(); t++) {
					if (sw.getSchedule()[f][t][n] != 0 && !result.contains(f)) {
						result.add(f);
					}
				}
			}
		}
		return result;
	}

	private Collection<? extends Decision> timeDisplacedDecision() {
		List<Decision> decisions = new ArrayList<Decision>();

		return decisions;
	}

	private Collection<? extends Decision> throughputTradeoffDecision() {
		List<Decision> decisions = new ArrayList<Decision>();

		return decisions;
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

	protected List<Integer> sortByFlowCriticality() {
		//		################# 1. sort flows according to decreasing criticality #################
		List<Integer> flowCriticality = new LinkedList<Integer>();
		//sort keys of map in descending order
		List<Integer> flow_order = new LinkedList<Integer>();
		for (int f = 0; f < tg.getFlows().size(); f++) {
			flow_order.add(f);
			flowCriticality.add(calculateFlowCriticality(tg.getFlows().get(f), ng));
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

}
