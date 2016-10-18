package ToolSet;

/**
	 * A protected class to hold scheduling decisions.
	 * It saves a rating of the decision as well, and is comparable by it to other decisions
	 * @author jakob
	 *
	 */
public class Decision implements Comparable<Decision> {
	public int[] flow;
	public int[] network;
	public int[] starttime;
	public int[] deadline;
	public int rating;
	public String algorithm;

	public Decision(int[] flow, int[] network, int[] starttime, int[] deadline, int rating, String algorithm) {
		this.flow = flow;
		this.network = network;
		this.starttime = starttime;
		this.deadline = deadline;
		this.rating = rating;
		this.algorithm = algorithm;
	}

	@Override
	public int compareTo(Decision anotherDecision) {
		return this.rating - anotherDecision.rating;
	}
}