package io.dante.watchman.monitor.config;

/**
 * @author Dante Wang
 */
public class TargetConfig {

	public String getHost() {
		return _host;
	}

	public int getPort() {
		return _port;
	}

	public int getTimeout() {
		return _timeout;
	}

	public String getType() {
		return _type;
	}

	public void setHost(String host) {
		_host = host;
	}

	public void setPort(int port) {
		_port = port;
	}

	public void setTimeout(int timeout) {
		_timeout = timeout;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _host;
	private int _port;
	private int _timeout;
	private String _type;

}