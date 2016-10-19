package ToolSet.Decider;

import java.util.ArrayList;
import java.util.List;

import ToolSet.ScheduleWrapper;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class TimeDisplacementDecider implements Decider {

	public TimeDisplacementDecider(NetworkGenerator ng, FlowGenerator fg) {
	}

	@Override
	public List<Decision> discoverDecisions(ScheduleWrapper sw) {
		List<Decision> decisions = new ArrayList<Decision>();

		return decisions;
	}
}
