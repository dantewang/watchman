package io.dante.watchman.monitor.target;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Dante Wang
 */
public class SocketTarget extends BaseTarget {

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