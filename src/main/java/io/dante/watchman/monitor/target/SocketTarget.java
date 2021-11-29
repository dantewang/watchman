package io.dante.watchman.monitor.target;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

/**
 * @author Dante Wang
 */
public class SocketTarget extends BaseTarget {

	public static final String NAME = "socket";

	public static SocketTarget from(io.dante.watchman.monitor.config.Target targetConfig) {
		return new SocketTarget(targetConfig.getHost(), targetConfig.getPort(), targetConfig.getTimeout());
	}

	public SocketTarget(String host, int port, int timeout) {
		super(timeout);

		_inetSocketAddress = new InetSocketAddress(host, port);
	}

	@Override
	public TargetResult probe() {
		try (var socket = new Socket()) {
			socket.connect(_inetSocketAddress, timeout);

			return TargetResult.live("Successfully connected to [" + _inetSocketAddress + "]");
		}
		catch (IOException ioException) {
			return TargetResult.dead("Failed to connect to [" + _inetSocketAddress + "]: " + ioException.getMessage());
		}
	}

	private final InetSocketAddress _inetSocketAddress;

}