package io.dante.watchman.monitor.action;

import com.slack.api.Slack;
import com.slack.api.webhook.WebhookPayloads;

import io.dante.watchman.monitor.config.ActionConfig;
import io.dante.watchman.monitor.target.TargetResult;

import java.util.Map;

/**
 * @author Dante Wang
 */
public class SlackAction extends BaseAction {

	public static final String NAME = "slack";

	public static SlackAction from(ActionConfig actionConfig) {
		Map<String, String> params = actionConfig.getParams();

		return new SlackAction(actionConfig.getStatus(), params.get("webhook"));
	}

	public SlackAction(String status, String webhook) {
		super(status);

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