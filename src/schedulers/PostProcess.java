package schedulers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ToolSet.CostSeparation;
import ToolSet.ScheduleWrapper;
import ToolSet.Decider.Decider;
import ToolSet.Decider.Decision;
import ToolSet.Decider.FullGreedyDecider;
import ToolSet.Decider.OneStepGreedyDecider;
import ToolSet.Decider.TradeoffDecider;
import schedulingIOModel.CostFunction;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class PostProcess extends GreedyScheduler {
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

	public PostProcess(NetworkGenerator ng, FlowGenerator fg, int config, double ratingThreshold) {
		super(ng, fg);
		this.ratingThreshold = ratingThreshold;
		this.config = config;
		super.newRating(true);
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		initVariables();
		//		for (int i = 0; i < tg.getFlows().size(); i++) {
		//			System.out.println("Flow: " + i);
		//			System.out.println(tg.getFlows().get(i).getTokens());
		//			System.out.println(tg.getFlows().get(i).getImpUser());
		//			System.out.println(tg.getFlows().get(i).getWindowMin());
		//			System.out.println(tg.getFlows().get(i).getTokensMin());
		//			System.out.println(tg.getFlows().get(i).getStartTime());
		//			System.out.println(tg.getFlows().get(i).getDeadline());
		//
		//			System.out.println("$$$$$$$$$");
		//		}
		int sme = 0;

		super.calculateInstance_internal(logfile);
		ScheduleWrapper greedy = new ScheduleWrapper(tg.getFlows().size(), ng.getTimeslots(), ng.getNetworks().size());
		greedy.setSchedule(getTempSchedule());
		currentLeafs.add(greedy.clone());
		finishedLeafs.add(greedy.clone());
		List<Decision> decisions;
		int evaluations = 0;
		Decider greedyDecider = new FullGreedyDecider(ng, tg, true);

		decisions = discoverDecisions(greedy);
		for (int i = 0; i < decisions.size(); i++) {
			ScheduleWrapper newSchedule = new ScheduleWrapper(decisions.get(i).proposedSchedule);
			newSchedule.addDecision(decisions.get(i));
			newSchedule = new ScheduleWrapper(greedyDecider.discoverDecisions(newSchedule).get(0).proposedSchedule)
					.clone();
			finishedLeafs.add(newSchedule.clone());
		}

		//		while (currentLeafs.size() > 0){
		//			//System.out.println("currentLeafs size: " + currentLeafs.size());
		//			ScheduleWrapper sw = currentLeafs.remove(0);
		//			finishedLeafs.add(sw);
		//			decisions = discoverDecisions(sw);
		//			//Only consider decisions that are close to the best rating atm
		//			//System.out.println("decisions made this round: " + decisions.size());
		//
		//			//			int consideredIndex = 1;
		//			//			while (consideredIndex < decisions.size()
		//			//					&& decisions.get(consideredIndex).rating / decisions.get(0).rating > ratingThreshold) {
		//			//				consideredIndex++;
		//			//			}
		//
		//			//			for (int i = 0; i < consideredIndex; i++) {
		//			for (int i = 0; i < decisions.size(); i++) {
		//				ScheduleWrapper newSchedule = sw.clone();
		//				newSchedule.addDecision(decisions.get(i));
		//				boolean similarExists = false;
		//				for (int j = 0; j < finishedLeafs.size(); j++) {
		//					if (finishedLeafs.get(j).isSimilar(newSchedule.getSchedule())) {
		//						similarExists = true;
		//					}
		//				}
		//				for (int j = 0; j < currentLeafs.size(); j++) {
		//					if (currentLeafs.get(j).isSimilar(newSchedule.getSchedule())) {
		//						similarExists = true;
		//					}
		//				}
		//				if (!similarExists) {
		//					finishedLeafs.add(newSchedule);
		//					currentLeafs.add(newSchedule);
		//				} else {
		//					sme++;
		//				}
		//			}
		//
		//			evaluations++;
		//			if (evaluations % 100 == 0) {
		//				System.out.println("evals: " + evaluations + ", currentLeafs size: " + currentLeafs.size()
		//						+ ", finishedLeafs size: " + finishedLeafs.size() + " sme: " + sme);
		//			}
		//		}

		int minIndex = 0;
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < finishedLeafs.size(); i++) {
			finishedLeafs.get(i).setTotalCost(cf.costTotal(finishedLeafs.get(i).getSchedule()));
			if (finishedLeafs.get(i).getTotalCost() < minCost) {
				minIndex = i;
				minCost = finishedLeafs.get(i).getTotalCost();
			}

		}
		System.out.println("minIndex: " + minIndex);
		for (int i = 0; i < finishedLeafs.size(); i++) {
			//			System.out.println(i + ":\t" + finishedLeafs.get(i).getTotalCost());
			//System.out.println(finishedLeafs.get(i).deciderHistory());
			//System.out.println(finishedLeafs.get(i).getTotalCost());
			//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		this.setTempSchedule(finishedLeafs.get(minIndex).getSchedule());
		//System.out.println("totalcost: " + finishedLeafs.get(minIndex).getTotalCost());
		if (!

		verificationOfConstraints(finishedLeafs.get(minIndex).getSchedule())) {
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
			//deciders.add(new GreedyDecider(ng, tg, true));
			//deciders.add(new FillUpDecider(ng, tg, true));
			deciders.add(new TradeoffDecider(ng, tg, true));
			break;
		case 2:
			deciders.add(new OneStepGreedyDecider(ng, tg, true));
			deciders.add(new TradeoffDecider(ng, tg, true));
			break;
		default:
			//deciders.add(new GreedyDecider(ng, tg, true));
			break;
		}

		currentLeafs = new ArrayList<ScheduleWrapper>();

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
		return "PostProcess_" + config;
	}

}
