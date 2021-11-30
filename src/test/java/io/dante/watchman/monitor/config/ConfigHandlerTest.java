package io.dante.watchman.monitor.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author Dante Wang
 */
public class ConfigHandlerTest {

	@Test
	public void testLoadConfig() {
		var classLoader = ConfigHandlerTest.class.getClassLoader();

		var configHandler = ConfigHandler.instance();

		var inputStream = classLoader.getResourceAsStream("example.yaml");

		configHandler.loadConfig(inputStream);
	}

}