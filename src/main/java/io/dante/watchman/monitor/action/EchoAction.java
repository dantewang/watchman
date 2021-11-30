package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public class EchoAction extends BaseAction {

	public static final String NAME = "echo";

	public EchoAction() {
		super("ALL");
	}

	@Override
	protected String doAction(TargetResult targetResult) {
		return "Echo";
	}

}