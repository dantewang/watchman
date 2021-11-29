package io.dante.watchman.monitor.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Dante Wang
 */
public class ConfigHandler {

	public static ConfigHandler instance() {
		return _instance;
	}

	public Config getConfig() {
		return _config;
	}

	public void loadConfig(Path configPath) throws IOException {
		loadConfig(Files.newInputStream(configPath));
	}

	public void loadConfig(InputStream inputStream) {
		var yaml = new Yaml(new Constructor(Config.class));

		_config = yaml.load(inputStream);
	}

	private static final ConfigHandler _instance = new ConfigHandler();

	private Config _config;

}