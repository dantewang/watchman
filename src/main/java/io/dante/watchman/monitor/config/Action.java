package io.dante.watchman.monitor.config;

import java.util.Map;

/**
 * @author Dante Wang
 */
public class Action {

	public String getStatus() {
		return _status;
	}

	public Map<String, String> getParams() {
		return _params;
	}

	public String getType() {
		return _type;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public void setParams(Map<String, String> params) {
		_params = params;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _status;
	private Map<String, String> _params;
	private String _type;

}