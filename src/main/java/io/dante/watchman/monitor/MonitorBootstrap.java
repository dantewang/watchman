package io.dante.watchman.monitor;

import io.dante.watchman.monitor.action.Action;
import io.dante.watchman.monitor.action.ActionFactory;
import io.dante.watchman.monitor.config.ConfigHandler;
import io.dante.watchman.monitor.config.Monitor;
import io.dante.watchman.monitor.job.MonitorJob;
import io.dante.watchman.monitor.target.TargetFactory;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Dante Wang
 */
public class MonitorBootstrap {

	public void start(ConfigHandler configHandler) throws SchedulerException {
		var schedulerFactory = new StdSchedulerFactory();

		var scheduler = schedulerFactory.getScheduler();

		var config = configHandler.getConfig();

		for (var monitorConfig : config.getMonitors()) {
			scheduler.scheduleJob(_buildJob(monitorConfig), _buildTrigger(monitorConfig));
		}

		scheduler.start();
	}

	private Trigger _buildTrigger(Monitor monitorConfig) {
		var triggerConfig = monitorConfig.getTrigger();

		return TriggerBuilder.newTrigger().withIdentity(
			monitorConfig.getName()
		).withSchedule(
			CronScheduleBuilder.cronSchedule(triggerConfig.getCron())
		).build();
	}

	private JobDetail _buildJob(Monitor monitorConfig) {
		var target = TargetFactory.create(monitorConfig.getTarget());

		var actions = new ArrayList<Action>();

		for (var actionConfig : monitorConfig.getActions()) {
			actions.add(ActionFactory.create(actionConfig));
		}

		return JobBuilder.newJob().ofType(
			MonitorJob.class
		).withIdentity(
			monitorConfig.getName()
		).setJobData(
			new JobDataMap(Map.of(MonitorJob.TARGET, target, MonitorJob.ACTIONS, actions))
		).build();
	}


}