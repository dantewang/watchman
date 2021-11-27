package io.dante.watchman.monitor;

/**
 * @author Dante Wang
 */
public record Result(Status status, String message) {

	public enum Status {
		DEAD, LIVE
	}

	public static Result dead(String message) {
		return new Result(Status.DEAD, message);
	}

	public static Result live(String message) {
		return new Result(Status.LIVE, message);
	}

}