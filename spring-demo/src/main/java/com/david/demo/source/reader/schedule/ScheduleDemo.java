package com.david.demo.source.reader.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

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

//		ThreadPoolTaskExecutor bean = ac.getBean(ThreadPoolTaskExecutor.class);
//		System.out.println("bean = " + bean);
		Thread.sleep(5000L);
		System.out.println("main方法结束");
	}

	public static void test01() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setPoolSize(2);
		taskScheduler.initialize(); // 务必调用此方法来启动

		// 执行任务
		// 执行一次
		taskScheduler.execute(() -> System.out.println(Thread.currentThread().getName() + "  我只会被执行一次~~~"));
		// 周期性执行
		taskScheduler.schedule(() -> System.out.println(Thread.currentThread().getName() + " 我会被多次执行~~~"), new CronTrigger("0/2 * * * * ?"));
//		taskScheduler.submit()
		// 此处：若你有周期性的任务，这里不要shutdown()
		//taskScheduler.shutdown();


		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.initialize();
		 // executor没有 schedule 的能力








	}
}
