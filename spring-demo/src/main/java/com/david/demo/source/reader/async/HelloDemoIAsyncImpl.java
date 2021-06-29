package com.david.demo.source.reader.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author fanzunying
 * @date 2021/6/25 16:11
 */
@Component("HelloDemoIAsyncImpl")
public class HelloDemoIAsyncImpl implements HelloDemo {
	@Async(value = "")
	@Override
	public String getInfo() {
		System.out.println("getInfo  当前线程：" + Thread.currentThread().getName());
		return "getInfo";
	}

	@Async
	@Override
	public Future<String> getInfoAsync() {
		System.out.println("getInfoAsync  当前线程：" + Thread.currentThread().getName());
		return new FutureTask<String>((Callable) () -> "getInfoAsync");
	}

	@MyAsync
	@Override
	public String getMyInfo() {
		System.out.println("getMyInfo  当前线程：" + Thread.currentThread().getName());
		return "getMyInfo";
	}
}
