package io.dante.watchman.monitor.target;

import io.dante.watchman.monitor.config.TargetConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Dante Wang
 */
public class TargetFactory {

	public static Target create(TargetConfig targetConfig) {
		var builderFunction = _actionBuilders.get(targetConfig.getType());

		return builderFunction.apply(targetConfig);
	}

	private static final Map<String, Function<TargetConfig, Target>> _actionBuilders =
		new HashMap<>();

	static {
		_actionBuilders.put(SocketTarget.NAME, SocketTarget::from);
	}
}