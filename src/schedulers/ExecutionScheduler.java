package schedulers;

import ToolSet.JsonLogger;
import ToolSet.LogMatlabFormat;
import executor.Executor;
import schedulingIOModel.FlowGenerator;
import schedulingIOModel.NetworkGenerator;

public class ExecutionScheduler extends Scheduler {
	Executor exe;
	public ExecutionScheduler(NetworkGenerator ng, FlowGenerator tg) {
		super(ng, tg);
		// TODO Auto-generated constructor stub
	}
	public ExecutionScheduler(NetworkGenerator ng, FlowGenerator tg, String logFilePath) {
		super(ng, tg);
		int[][][] sp = JsonLogger.json2Array(logFilePath);
		exe = new Executor(sp, ng, tg);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void calculateInstance_internal(String logfile) {
		// TODO Auto-generated method stub
		exe.run(false);
		setSchedule(exe.getExecutedPlan());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Executor";
	}
	

}
