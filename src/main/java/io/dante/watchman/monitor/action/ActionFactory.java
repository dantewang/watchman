package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.config.ActionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Dante Wang
 */
public class ActionFactory {

	public static Action create(ActionConfig actionConfig) {
		var builderFunction = _actionBuilders.get(actionConfig.getType());

		return builderFunction.apply(actionConfig);
	}

	private static final Map<String, Function<ActionConfig, Action>> _actionBuilders =
		new HashMap<>();

	static {
		_actionBuilders.put(EchoAction.NAME, actionConfig -> new EchoAction());
		_actionBuilders.put(SlackAction.NAME, SlackAction::from);
		_actionBuilders.put(TelegramBotAction.NAME, TelegramBotAction::from);
	}
}