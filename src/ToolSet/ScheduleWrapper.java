package ToolSet;

public class ScheduleWrapper {
	private int[][][] schedule;
	private boolean isFinished;

	public ScheduleWrapper(int f, int t, int n) {
		this.schedule = new int[f][t][n];
		initSchedule();

		this.isFinished = false;
	}

	private void initSchedule() {
		for (int f = 0; f < schedule.length; f++) {
			for (int t = 0; t < schedule[0].length; t++) {
				for (int n = 0; n < schedule[0][0].length; n++) {
					schedule[f][t][n] = 0;
				}
			}
		}
	}

	public void allocate(int f, int t, int n, int alloc) {
		schedule[f][t][n] = alloc;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public ScheduleWrapper clone() {
		ScheduleWrapper result = new ScheduleWrapper(schedule.length, schedule[0].length, schedule[0][0].length);

		for (int f = 0; f < schedule.length; f++) {
			for (int t = 0; t < schedule[0].length; t++) {
				for (int n = 0; n < schedule[0][0].length; n++) {
					result.allocate(f, t, n, schedule[f][t][n]);
				}
			}
		}

		result.setFinished(this.isFinished);
		return result;
	}

}
