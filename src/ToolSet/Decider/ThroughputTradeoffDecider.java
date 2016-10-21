package ToolSet.Decider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import ToolSet.CostSeparation;
import ToolSet.ScheduleWrapper;
import schedulers.GreedyScheduler;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class ThroughputTradeoffDecider extends GreedyScheduler implements Decider {
	protected String name;
	protected CostSeparation cs;

	public ThroughputTradeoffDecider(NetworkGenerator ng, FlowGenerator fg) {
		super(ng, fg);
		name = "ThroughputTradeoff";
		this.cs = new CostSeparation(fg, ng);
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		if (tg.getFlows().size() == 1) {
			return new ArrayList<Decision>();
		}
		List<Decision> decisions = new ArrayList<Decision>();
		int[][] networkMatch = cs.getNetworkMatch();
		setTempSchedule(sw.getSchedule().clone());
		ScheduleWrapper oldSchedule = sw.clone();
		for (int i = 0; i < tg.getFlows().size(); i++) {
			for (int j = i + 1; j < tg.getFlows().size(); j++) {
				if (calculateFlowTimeOverlap(i, j) > 4) {
					Vector<Integer> flowI = sortNetworkIDs(tg.getFlows().get(i));
					Vector<Integer> flowJ = sortNetworkIDs(tg.getFlows().get(j));
					int startWindow = Math.max(tg.getFlows().get(i).getStartTime(),
							tg.getFlows().get(j).getStartTime());
					int endWindow = Math.min(tg.getFlows().get(i).getDeadline(), tg.getFlows().get(j).getDeadline());
					if (flowI.get(0) != flowJ.get(0) && ng.getNetworks().get(flowI.get(0)).getType() == ng.getNetworks()
							.get(flowJ.get(0)).getType()) {
						int networkType = ng.getNetworks().get(flowJ.get(0)).getType();
						Vector<Integer> throughput = sortNetworkIDsByThroughput(2 + startWindow);
						for (int n = 0; n < throughput.size(); n++) {
							if (ng.getNetworks().get(throughput.get(n)).getType() == networkType) {
								for (int t = startWindow; t < endWindow; t++) {
									allocate(i, t, throughput.get(n), 1);
									allocate(j, t, throughput.get(n), 1);
								}
							}
						}
					}
				}
			}
		}
		if (oldSchedule.isDifferentSchedule(getTempSchedule())) {
			decisions.add(new Decision(getTempSchedule(), 0, name));
		}

		return decisions;
	}

	protected Vector<Integer> sortNetworkIDsByThroughput(final int t) {
		//create sorted list
		Vector<Integer> netIDs = new Vector<>();
		for (int n = 0; n < ng.getNetworks().size(); n++) {
			netIDs.add(n);
		}

		Collections.sort(netIDs, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return ng.getNetworks().get(arg1).getCapacity().get(t)
						- ng.getNetworks().get(arg0).getCapacity().get(t);
			}
		});

		return netIDs;
	}

	protected int calculateFlowTimeOverlap(int i, int j) {
		if (i == j) {
			return -1;
		}
		return Math.min(tg.getFlows().get(i).getDeadline(), tg.getFlows().get(j).getDeadline())
				- Math.max(tg.getFlows().get(i).getStartTime(), tg.getFlows().get(j).getStartTime());
	}

	protected int[][] calculateFlowTimeOverlap() {
		int[][] result = new int[tg.getFlows().size()][tg.getFlows().size()];

		for (int i = 0; i < tg.getFlows().size(); i++) {
			for (int j = i + 1; j < tg.getFlows().size(); j++) {
				if (j == i) {
					result[j][i] = -1;
				} else {
					int startWindow = Math.max(tg.getFlows().get(i).getStartTime(),
							tg.getFlows().get(j).getStartTime());
					int endWindow = Math.min(tg.getFlows().get(i).getDeadline(), tg.getFlows().get(j).getDeadline());
					result[i][j] = Math.max(0, endWindow - startWindow);
				}
			}
		}

		return result;
	}

	@Override
	protected void calculateInstance_internal(String logfile) {
		throw new UnsupportedOperationException("This is not a full scheduler");
	}

	@Override
	public String getType() {
		throw new UnsupportedOperationException("This is not a full scheduler");
	}

}
