package ToolSet.Decider;

/**
	 * A protected class to hold scheduling decisions.
	 * It saves a rating of the decision as well, and is comparable by it to other decisions
	 * @author jakob
	 *
	 */
public class Decision implements Comparable<Decision> {
	public int[][][] proposedSchedule;
	public int rating;
	public String algorithm;

	public Decision(int[][][] proposedSchedule, int rating, String algorithm) {
		this.proposedSchedule = proposedSchedule;
		this.rating = rating;
		this.algorithm = algorithm;
	}

	@Override
	public int compareTo(Decision anotherDecision) {
		return this.rating - anotherDecision.rating;
	}
}