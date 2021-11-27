package io.dante.watchman.monitor.target;

/**
 * @author Dante Wang
 */
public abstract class BaseTarget implements Target {

	public BaseTarget(int timeout) {
		this.timeout = timeout;
	}

	protected final int timeout;

}