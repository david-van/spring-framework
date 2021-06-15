//package com.david.demo.source.reader.bean;
//
//import org.springframework.context.LifecycleProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * @author fanzunying
// * @date 2021/6/15 19:10
// */
//@Component
//public class MyLifecycleProcessor implements LifecycleProcessor {
//	private volatile boolean running;
//
//	@Override
//	public void onRefresh() {
//		System.out.println("onRefresh");
//		this.running = true;
//	}
//
//	@Override
//	public void onClose() {
//		System.out.println("onClose");
//		this.running = false;
//	}
//
//	@Override
//	public void start() {
//		System.out.println("start");
//		this.running = true;
//	}
//
//	@Override
//	public void stop() {
//		System.out.println("stop");
//		this.running = false;
//	}
//
//	@Override
//	public boolean isRunning() {
//		return this.running;
//	}
//
//}
