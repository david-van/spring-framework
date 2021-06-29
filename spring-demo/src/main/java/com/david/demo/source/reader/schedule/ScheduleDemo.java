package com.david.demo.source.reader.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author fanzunying
 * @date 2021/6/29 16:15
 */
@ComponentScan()
@EnableScheduling()
public class ScheduleDemo {
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ScheduleDemo.class);

		ac.refresh();
		ac.start();

		ThreadPoolTaskExecutor bean = ac.getBean(ThreadPoolTaskExecutor.class);
		System.out.println("bean = " + bean);
		Thread.sleep(5000L);
		System.out.println("main方法结束");
	}
}
