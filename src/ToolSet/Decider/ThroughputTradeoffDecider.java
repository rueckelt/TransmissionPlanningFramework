package ToolSet.Decider;

import java.util.ArrayList;
import java.util.List;

import ToolSet.ScheduleWrapper;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class ThroughputTradeoffDecider implements Decider {
	protected String name;

	public ThroughputTradeoffDecider(NetworkGenerator ng, FlowGenerator fg) {
		name = "ThroughputTradeoff";
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		List<Decision> decisions = new ArrayList<Decision>();

		return decisions;
	}

}
