package schedulers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ToolSet.CostSeparation;
import ToolSet.ScheduleWrapper;
import ToolSet.Decider.Decider;
import ToolSet.Decider.Decision;
import ToolSet.Decider.OneStepGreedyDecider;
import ToolSet.Decider.vioMinFixer;
import schedulingIOModel.CostFunction;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class testProcess extends GreedyScheduler {
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

	public testProcess(NetworkGenerator ng, FlowGenerator fg, int config, double ratingThreshold) {
		super(ng, fg);
		this.ratingThreshold = ratingThreshold;
		this.config = config;
		super.newRating(true);
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		initVariables();
		for (int i = 0; i < tg.getFlows().size(); i++) {
			System.out.println("Flow: " + i);
			System.out.println(tg.getFlows().get(i).getTokens());
			System.out.println(tg.getFlows().get(i).getImpUser());
			System.out.println(tg.getFlows().get(i).getWindowMin());
			System.out.println(tg.getFlows().get(i).getTokensMin());
			System.out.println(tg.getFlows().get(i).getStartTime());
			System.out.println(tg.getFlows().get(i).getDeadline());

			System.out.println("$$$$$$$$$");
		}

		super.calculateInstance_internal(logfile);
		ScheduleWrapper greedy = new ScheduleWrapper(tg.getFlows().size(), ng.getTimeslots(), ng.getNetworks().size());
		greedy.setSchedule(getTempSchedule());
		currentLeafs.add(greedy.clone());

		List<Decision> decisions;
		int evaluations = 0;

		ScheduleWrapper test = greedy.clone();
		//System.out.println(showSchedule(test.getSchedule()));
		test.setSchedule(new vioMinFixer(ng, tg, true).discoverDecisions(test).get(0).proposedSchedule);
		//		for (int f = 0; f < getTempSchedule().length; f++) {
		//			for (int t = 0; t < getTempSchedule()[0].length; t++) {
		//				for (int n = 0; n < getTempSchedule()[0][0].length; n++) {
		//					System.out.print(getTempSchedule()[f][t][n] + ",");
		//				}
		//				System.out.println("..............");
		//			}
		//			System.out.println("%%%%%%%%%%%%%%%%%");
		//		}
		//System.out.println(showSchedule(test.getSchedule()));

	}

	private void initVariables() {

		this.cs = new CostSeparation(tg, ng);
		this.cf = new CostFunction(ng, tg);
		deciders = new ArrayList<Decider>();

		//Add deciders here
		config = 2;
		switch (config) {
		case 1:
			//deciders.add(new GreedyDecider(ng, tg, true));
			//deciders.add(new FillUpDecider(ng, tg, true));
			deciders.add(new vioMinFixer(ng, tg, true));
			break;
		case 2:
			deciders.add(new OneStepGreedyDecider(ng, tg, true));
			deciders.add(new vioMinFixer(ng, tg, true));
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
