package ToolSet.Decider;

import java.util.List;

import ToolSet.ScheduleWrapper;

public interface Decider {

	public abstract List<Decision> discoverDecisions(ScheduleWrapper sw);

}
