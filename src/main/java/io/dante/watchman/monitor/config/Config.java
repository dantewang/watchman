package io.dante.watchman.monitor.config;

import java.util.List;

/**
 * @author Dante Wang
 */
public class Config {

	public List<MonitorConfig> getMonitors() {
		return _monitors;
	}

	public void setMonitors(List<MonitorConfig> monitors) {
		_monitors = monitors;
	}

	private List<MonitorConfig> _monitors;

}