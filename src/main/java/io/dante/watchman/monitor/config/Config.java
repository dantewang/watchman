package io.dante.watchman.monitor.config;

import java.util.List;

/**
 * @author Dante Wang
 */
public class Config {

	public List<Monitor> getMonitors() {
		return _monitors;
	}

	public void setMonitors(List<Monitor> monitors) {
		_monitors = monitors;
	}

	private List<Monitor> _monitors;

}