package schedulers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ToolSet.CostSeparation;
import ToolSet.ScheduleWrapper;
import ToolSet.Decider.Decider;
import ToolSet.Decider.Decision;
import ToolSet.Decider.GreedyDecider;
import ToolSet.Decider.GreedyDecider2;
import schedulingIOModel.CostFunction;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class MLPrio extends Scheduler {
	protected CostSeparation cs;
	protected CostFunction cf;
	protected List<Decider> deciders;
	protected List<ScheduleWrapper> currentLeafs;
	protected List<ScheduleWrapper> finishedLeafs;
	private static int totalEvaluations = 0;
	protected int config;
	/*
	 * if this is 0, all scheduling decisions will be evaluated
	 * Higher thresholds mean less computation time, but possibly less ideal solutions
	 */
	protected double ratingThreshold;

	public MLPrio(NetworkGenerator ng, FlowGenerator fg, int config, double ratingThreshold) {
		super(ng, fg);
		this.ratingThreshold = ratingThreshold;
		this.config = config;
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		initVariables();

		List<Decision> decisions;
		int evaluations = 0;

		while (currentLeafs.size() > 0) {
			//System.out.println("currentLeafs size: " + currentLeafs.size());
			ScheduleWrapper sw = currentLeafs.remove(0);
			decisions = discoverDecisions(sw);
			//Only consider decisions that are close to the best rating atm
			//System.out.println("decisions made this round: " + decisions.size());
			if (decisions.size() == 0) {
				//No Decider wanted to add to the current schedule, so it is regarded as finished
				sw.setFinished(true);
				finishedLeafs.add(sw);
			} else {
				int consideredIndex = 1;
				while (consideredIndex < decisions.size()
						&& decisions.get(consideredIndex).rating / decisions.get(0).rating > ratingThreshold) {
					consideredIndex++;
				}

				for (int i = 0; i < consideredIndex; i++) {
					ScheduleWrapper newSchedule = sw.clone();
					newSchedule.addDecision(decisions.get(i));
					boolean similarExists = false;
					for (int j = 0; j < currentLeafs.size(); j++) {
						if (currentLeafs.get(j).isSimilar(sw.getSchedule())) {
							similarExists = true;
						}
					}
					for (int j = 0; j < finishedLeafs.size(); j++) {
						if (finishedLeafs.get(j).isSimilar(sw.getSchedule())) {
							similarExists = true;
						}
					}
					if (!similarExists) {
						currentLeafs.add(newSchedule);
					}
				}
			}
			evaluations++;
			if (evaluations % 100 == 0) {
				//System.out.println("evals: " + evaluations + ", currentLeafs size: " + currentLeafs.size());
			}
		}

		int minIndex = 0;
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < finishedLeafs.size(); i++) {
			finishedLeafs.get(i).setTotalCost(cf.costTotal(finishedLeafs.get(i).getSchedule()));
			if (finishedLeafs.get(i).getTotalCost() < minCost) {
				minIndex = i;
				minCost = finishedLeafs.get(i).getTotalCost();
			}

		}
		this.setTempSchedule(finishedLeafs.get(minIndex).getSchedule());
		//System.out.println("totalcost: " + finishedLeafs.get(minIndex).getTotalCost());
		if (!verificationOfConstraints(finishedLeafs.get(minIndex).getSchedule())) {
			System.err.println("stuff is weird!");
		}

		//System.out.println("Total number of evaluations for this schedule: " + evaluations);
		totalEvaluations += evaluations;
		System.out.println("Total number of evaluations: " + totalEvaluations);
	}

	private void initVariables() {

		this.cs = new CostSeparation(tg, ng);
		this.cf = new CostFunction(ng, tg);
		deciders = new ArrayList<Decider>();

		//Add deciders here
		switch (config) {
		case 1:
			deciders.add(new GreedyDecider(ng, tg, true));
			deciders.add(new GreedyDecider(ng, tg, false));
			break;
		case 2:
			deciders.add(new GreedyDecider(ng, tg, true));
			deciders.add(new GreedyDecider2(ng, tg, true));
			//deciders.add(new TimeDisplacementDecider(ng, tg));
			break;
		default:
			deciders.add(new GreedyDecider(ng, tg, true));
			break;
		}

		currentLeafs = new ArrayList<ScheduleWrapper>();
		currentLeafs.add(new ScheduleWrapper(tg.getFlows().size(), ng.getTimeslots(), ng.getNetworks().size()));
		finishedLeafs = new ArrayList<ScheduleWrapper>();

	}

	/**
	 * Calls all decisionProviders and returns a sorted list with their proposed scheduling decisions
	 * @return
	 */
	private List<Decision> discoverDecisions(ScheduleWrapper sw) {
		List<Decision> decisions = new ArrayList<Decision>();

		for (Decider dec : deciders) {
			decisions.addAll(dec.discoverDecisions(sw));
		}

		Collections.sort(decisions);
		Collections.reverse(decisions);
		return decisions;
	}

	//	public void executeDecision(Decision d, ScheduleWrapper schedule) {
	//		int allocated = 0;
	//		for (int i = 0; i < d.flow.length; i++) {
	//			for (int t = 0; t < ng.getTimeslots(); t++) {
	//				allocated += allocate(d.flow[i][t], t, d.network[i][t], d.throughput[i][t]);
	//			}
	//		}
	//		if (allocated == 0) {
	//			//this schedule is finished
	//			schedule.setFinished(true);
	//			schedule.setTotalCost(cf.costTotal(schedule.getSchedule()));
	//		}
	//	}

	@Override
	public String getType() {
		return "ML_Prio_Scheduler_type_" + config;
	}

}
