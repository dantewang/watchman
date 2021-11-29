package io.dante.watchman.monitor.target;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Dante Wang
 */
public class TargetFactory {

	public static Target create(io.dante.watchman.monitor.config.Target targetConfig) {
		var builderFunction = _actionBuilders.get(targetConfig.getType());

		return builderFunction.apply(targetConfig);
	}

	private static final Map<String, Function<io.dante.watchman.monitor.config.Target, Target>> _actionBuilders =
		new HashMap<>();

	static {
		_actionBuilders.put(SocketTarget.NAME, SocketTarget::from);
	}
}