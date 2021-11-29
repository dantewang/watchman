package io.dante.watchman.monitor.target;

/**
 * @author Dante Wang
 */
public record TargetResult(Status status, String message) {

	public enum Status {
		DEAD, LIVE
	}

	public static TargetResult dead(String message) {
		return new TargetResult(Status.DEAD, message);
	}

	public static TargetResult live(String message) {
		return new TargetResult(Status.LIVE, message);
	}

}