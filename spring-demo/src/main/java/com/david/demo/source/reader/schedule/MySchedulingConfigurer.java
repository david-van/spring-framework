package com.david.demo.source.reader.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author fanzunying
 * @date 2021/6/29 18:20
 */
@Configuration
public class MySchedulingConfigurer implements SchedulingConfigurer {
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		Set<ScheduledTask> set = taskRegistrar.getScheduledTasks();
		System.out.println("set = " + set);
		List<CronTask> tasks = taskRegistrar.getCronTaskList();
		for (CronTask task : tasks) {
			Runnable runnable = task.getRunnable();
			CronTrigger trigger = (CronTrigger) task.getTrigger();
			String expression = task.getExpression();

		}
		taskRegistrar.destroy();
		System.out.println("tasks = " + tasks);
	}
}
