package com.david.demo.source.reader.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/25 16:11
 */
@Component("HelloDemoIAsyncImpl")
public class HelloDemoIAsyncImpl implements HelloDemo {
	@Async
	@Override
	public String getInfo() {
		System.out.println("getInfo  当前线程：" + Thread.currentThread().getName());
		return "getInfo";
	}

	@MyAsync
	@Override
	public String getMyInfo() {
		System.out.println("getMyInfo  当前线程：" + Thread.currentThread().getName());
		return "getMyInfo";
	}
}
