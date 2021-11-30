package io.dante.watchman.monitor.config;

/**
 * @author Dante Wang
 */
public class TriggerConfig {

	public String getCron() {
		return _cron;
	}

	public void setCron(String cron) {
		_cron = cron;
	}

	private String _cron;

}