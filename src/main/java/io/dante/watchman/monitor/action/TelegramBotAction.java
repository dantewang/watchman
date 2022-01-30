package io.dante.watchman.monitor.action;

import io.dante.watchman.monitor.config.ActionConfig;
import io.dante.watchman.monitor.target.TargetResult;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.time.Duration;

/**
 * @author Dante Wang
 */
public class TelegramBotAction extends BaseAction {

	public static final String NAME = "telegrambot";

	public static TelegramBotAction from(ActionConfig actionConfig) {
		var params = actionConfig.getParams();

		return new TelegramBotAction(actionConfig.getStatus(), params.get("token"), params.get("chatId"));
	}

	public TelegramBotAction(String status, String token, String chatId) {
		super(status);

		_token = token;
		_chatId = chatId;

		_httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	}

	@Override
	protected String doAction(TargetResult targetResult) throws Exception {

		var url = new URL(
			"https://api.telegram.org/bot" + _token + "/sendMessage?chat_id=" + _chatId + "&text=" +
				URLEncoder.encode(targetResult.message(), Charset.defaultCharset()));

		var request = HttpRequest.newBuilder().GET().uri(
			url.toURI()
		).timeout(
			Duration.ofSeconds(5)
		).build();

		var response = _httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() != 200) {
			throw new IOException(response.statusCode() + response.body());
		}

		return response.body();
	}

	private final String _chatId;
	private final HttpClient _httpClient;
	private final String _token;

}