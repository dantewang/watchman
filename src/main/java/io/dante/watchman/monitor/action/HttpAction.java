package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public class HttpAction extends BaseAction {

	public HttpAction(String on, String url) {
		super(on);
	}

	@Override
	protected String doAction(TargetResult targetResult) throws Exception {
		return null;
	}

}