package ToolSet;

import java.util.ArrayList;
import java.util.List;

public class ScheduleWrapper implements Comparable<ScheduleWrapper> {
	private int[][][] schedule;
	private boolean isFinished;
	private List<Decision> history;
	private int totalCost;

	public ScheduleWrapper(int f, int t, int n) {
		this.schedule = new int[f][t][n];
		initSchedule();

		this.history = new ArrayList<Decision>();
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

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void addDecision(Decision d) {
		this.history.add(d);
	}

	public int[][][] getSchedule() {
		return schedule;
	}

	public void setSchedule(int[][][] schedule) {
		this.schedule = schedule;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public ScheduleWrapper clone() {
		ScheduleWrapper result = new ScheduleWrapper(schedule.length, schedule[0].length, schedule[0][0].length);

		for (int f = 0; f < schedule.length; f++) {
			for (int t = 0; t < schedule[0].length; t++) {
				for (int n = 0; n < schedule[0][0].length; n++) {
					result.getSchedule()[f][t][n] = schedule[f][t][n];
				}
			}
		}

		result.setFinished(this.isFinished);
		return result;
	}

	@Override
	public int compareTo(ScheduleWrapper anotherScheduleWrapper) {
		return this.getTotalCost() - anotherScheduleWrapper.getTotalCost();
	}

}
