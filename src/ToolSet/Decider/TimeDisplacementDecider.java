package ToolSet.Decider;

import java.util.ArrayList;
import java.util.List;

import ToolSet.ScheduleWrapper;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class TimeDisplacementDecider implements Decider {
	protected String name;

	public TimeDisplacementDecider(NetworkGenerator ng, FlowGenerator fg) {
		name = "TimeDisplacement";
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		List<Decision> decisions = new ArrayList<Decision>();

		return decisions;
	}
}
