package com.david.demo.source.reader.async;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Component()
@ComponentScan()
@EnableAsync
public class DemoAsync {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoAsync.class);

		ac.refresh();
		ac.start();

		HelloDemo helloDemoIAsync = (HelloDemo) ac.getBean("HelloDemoIAsyncImpl");
		System.out.println("helloDemoIAsync.getClass() = " + helloDemoIAsync.getClass());
		System.out.println("helloDemoIAsync = " + helloDemoIAsync);
		helloDemoIAsync.getInfo();
	}


}
