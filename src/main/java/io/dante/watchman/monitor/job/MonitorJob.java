package io.dante.watchman.monitor.job;

import io.dante.watchman.monitor.action.Action;
import io.dante.watchman.monitor.target.Target;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author Dante Wang
 */
public class MonitorJob implements Job {

	public static final String ACTIONS = "actions";

	public static final String TARGET = "target";

	@Override
	@SuppressWarnings(value = "unchecked")
	public void execute(JobExecutionContext jobExecutionContext) {
		var target = (Target)jobExecutionContext.get(TARGET);

		var actions = (List<Action>)jobExecutionContext.get(ACTIONS);

		var sb = new StringBuilder();

		var targetResult = target.probe();

		sb.append(targetResult.status()).append(" -> ").append(targetResult.message()).append("\n");

		for (var action : actions) {
			sb.append("\t");
			try {
				sb.append(action.onResult(targetResult)).append("\n");
			}
			catch (Exception exception) {
				sb.append(exception.getMessage()).append("\n");
			}
		}

		System.out.println(sb);
	}

}