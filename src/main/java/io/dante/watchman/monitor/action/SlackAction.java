package io.dante.watchman.monitor.action;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookPayloads;

import io.dante.watchman.monitor.target.TargetResult;

/**
 * @author Dante Wang
 */
public class SlackAction extends BaseAction {

	public SlackAction(String on, String webhook) {
		super(on);

		_webhook = webhook;
	}

	@Override
	protected String doAction(TargetResult targetResult) throws Exception {
		var slack = Slack.getInstance();

		var webhookResponse = slack.send(
			_webhook, WebhookPayloads.payload(payload -> payload.text(targetResult.message())));

		return webhookResponse.toString();
	}

	private final String _webhook;

}