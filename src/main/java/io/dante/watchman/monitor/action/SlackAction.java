package io.dante.watchman.monitor.action;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookPayloads;
import com.slack.api.webhook.WebhookResponse;

import io.dante.watchman.monitor.Result;

/**
 * @author Dante Wang
 */
public class SlackAction implements Action {

	public SlackAction(String webhook) {
		_webhook = webhook;
	}

	@Override
	public String execute(Result result) throws Exception {
		var slack = Slack.getInstance();

		var webhookResponse = slack.send(
			_webhook, WebhookPayloads.payload(payload -> payload.text(result.message())));

		return webhookResponse.toString();
	}

	private final String _webhook;

}