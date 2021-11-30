package io.dante.watchman.monitor.config;

import java.util.List;

/**
 * @author Dante Wang
 */
public class MonitorConfig {

	public List<ActionConfig> getActions() {
		return _actions;
	}

	public String getName() {
		return _name;
	}

	public TargetConfig getTarget() {
		return _target;
	}

	public TriggerConfig getTrigger() {
		return _trigger;
	}

	public void setActions(List<ActionConfig> actions) {
		_actions = actions;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setTarget(TargetConfig target) {
		_target = target;
	}

	public void setTrigger(TriggerConfig trigger) {
		_trigger = trigger;
	}

	private List<ActionConfig> _actions;
	private String _name;
	private TargetConfig _target;
	private TriggerConfig _trigger;

}