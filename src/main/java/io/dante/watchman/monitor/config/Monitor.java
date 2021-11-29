package io.dante.watchman.monitor.config;

import java.util.List;

/**
 * @author Dante Wang
 */
public class Monitor {

	public List<Action> getActions() {
		return _actions;
	}

	public String getName() {
		return _name;
	}

	public Target getTarget() {
		return _target;
	}

	public Trigger getTrigger() {
		return _trigger;
	}

	public void setActions(List<Action> actions) {
		_actions = actions;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setTarget(Target target) {
		_target = target;
	}

	public void setTrigger(Trigger trigger) {
		_trigger = trigger;
	}

	private List<Action> _actions;
	private String _name;
	private Target _target;
	private Trigger _trigger;

}