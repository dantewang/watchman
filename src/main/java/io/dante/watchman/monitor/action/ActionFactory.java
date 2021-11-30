package io.dante.watchman.monitor.action;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Dante Wang
 */
public class ActionFactory {

	public static Action create(io.dante.watchman.monitor.config.Action actionConfig) {
		var builderFunction = _actionBuilders.get(actionConfig.getType());

		return builderFunction.apply(actionConfig);
	}

	private static final Map<String, Function<io.dante.watchman.monitor.config.Action, Action>> _actionBuilders =
		new HashMap<>();

	static {
		_actionBuilders.put(EchoAction.NAME, actionConfig -> new EchoAction());
		_actionBuilders.put(HttpAction.NAME, HttpAction::from);
		_actionBuilders.put(SlackAction.NAME, SlackAction::from);
	}
}