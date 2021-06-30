package com.david.demo.source.reader.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
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

		System.out.println("tasks = " + tasks);
	}

	@Bean
	public ThreadPoolTaskScheduler getTaskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
//		scheduler.setPoolSize(2);
		scheduler.setThreadNamePrefix("this is my --");
		return scheduler;
	}
}
