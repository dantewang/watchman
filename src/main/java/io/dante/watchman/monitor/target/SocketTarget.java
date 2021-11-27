package io.dante.watchman.monitor.target;

import io.dante.watchman.monitor.Result;

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
	public Result check() {
		Socket socket = new Socket();

		try {
			socket.connect(_inetSocketAddress, timeout);

			socket.close();

			return Result.live("Successfully connected to [" + _inetSocketAddress + "]");
		}
		catch (IOException ioException) {
			return Result.dead("Failed to connect to [" + _inetSocketAddress + "]: " + ioException.getMessage());
		}
	}

	private final InetSocketAddress _inetSocketAddress;

}