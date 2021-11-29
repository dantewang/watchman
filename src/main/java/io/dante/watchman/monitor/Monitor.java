package io.dante.watchman.monitor;

import io.dante.watchman.monitor.action.Action;
import io.dante.watchman.monitor.target.Target;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.List;

/**
 * @author Dante Wang
 */
public class Monitor implements Job {

	public static final String ACTIONS = "actions";

	public static final String TARGET = "target";

	@Override
	public void execute(JobExecutionContext jobExecutionContext) {
		var target = (Target)jobExecutionContext.get(TARGET);

		var actions = (List<Action>)jobExecutionContext.get(ACTIONS);

		var sb = new StringBuilder();

		var targetResult = target.probe();

		sb.append(targetResult.status()).append(" -> ").append(targetResult.message()).append("\n");

		for (Action action : actions) {
			try {
				sb.append(action.on(targetResult)).append("\n");
			}
			catch (Exception exception) {
				sb.append(exception.getMessage());
			}
		}

		jobExecutionContext.setResult(sb.toString());
	}

}