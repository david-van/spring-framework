package com.david.demo.source.reader.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Proxy;
import java.time.LocalTime;

/**
 * @author fanzunying
 * @date 2021/6/29 16:16
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

//	@Autowired
//	private ThreadPoolTaskExecutor executor;


	@Scheduled(cron = "0/1 * * * * ?")
	@Override
	public void jobOne() {
		System.out.println("Proxy.isProxyClass(this.getClass()) = " + Proxy.isProxyClass(this.getClass()));
		System.out.println("this.getClass().getName() = " + this.getClass().getName());
		System.out.println("jobOne  当前线程：" + Thread.currentThread().getName());
		System.out.println("我执行了---" + LocalTime.now());
	}
}
