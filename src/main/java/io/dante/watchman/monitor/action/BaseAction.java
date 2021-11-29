package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.target.TargetResult;

import java.util.Locale;

/**
 * @author Dante Wang
 */
public abstract class BaseAction implements Action {

	public BaseAction(String on) {
		_on = on.toUpperCase();
	}

	@Override
	public final String on(TargetResult targetResult) throws Exception {
		var status = targetResult.status();

		if (_on.equals(status.toString()) || _on.equals("ALL")) {
			return doAction(targetResult);
		}

		return "Skipped";
	}

	protected abstract String doAction(TargetResult targetResult) throws Exception;

	private final String _on;

}