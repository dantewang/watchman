package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.config.ActionConfig;
import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public class HttpAction extends BaseAction {

	public static final String NAME = "http";

	public static SlackAction from(ActionConfig actionConfig) {
		var params = actionConfig.getParams();

		return new SlackAction(actionConfig.getStatus(), params.get("url"));
	}

	public HttpAction(String status, String url) {
		super(status);
	}

	@Override
	protected String doAction(TargetResult targetResult) throws Exception {
		return null;
	}

}