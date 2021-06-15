package com.david.demo.source.reader.bean;

import org.springframework.context.SmartLifecycle;

/**
 * @author fanzunying
 * @date 2021/6/15 19:30
 */
public class MySmartLifecycle implements SmartLifecycle {
	private volatile boolean running;
	@Override
	public void start() {
		System.out.println("start");
		this.running = true;
	}

	@Override
	public void stop() {
		System.out.println("stop");
		this.running = false;
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}

}
