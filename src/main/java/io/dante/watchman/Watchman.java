package io.dante.watchman;

import io.dante.watchman.monitor.MonitorBootstrap;
import io.dante.watchman.monitor.config.ConfigHandler;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Dante Wang
 */
public class Watchman {

	public static void main(String[] args) throws Exception {
		Path configPath = Paths.get(args[0]);

		var configHandler = ConfigHandler.instance();

		configHandler.loadConfig(configPath);

		var monitorBootstrap = new MonitorBootstrap();

		monitorBootstrap.start(configHandler);
	}

}