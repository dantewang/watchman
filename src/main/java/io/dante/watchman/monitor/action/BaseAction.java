package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public abstract class BaseAction implements Action {

	public BaseAction(String status) {
		_status = status.toUpperCase();
	}

	@Override
	public final String onResult(TargetResult targetResult) throws Exception {
		var status = targetResult.status();

		if (_status.equals(status.toString()) || _status.equals("ALL")) {
			return doAction(targetResult);
		}

		return "Skipped";
	}

	protected abstract String doAction(TargetResult targetResult) throws Exception;

	private final String _status;

}