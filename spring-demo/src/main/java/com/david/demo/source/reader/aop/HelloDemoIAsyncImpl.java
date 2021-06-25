package com.david.demo.source.reader.aop;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/25 16:11
 */
@Component("HelloDemoIAsyncImpl")
public class HelloDemoIAsyncImpl implements HelloDemoI {
	@Async
	@Override
	public void getInfo() {
		System.out.println("当前线程：" + Thread.currentThread().getName());
	}
}
