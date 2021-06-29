package com.david.demo.source.reader.async;


import com.david.demo.source.reader.importSelector.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Component()
@ComponentScan()
@EnableAsync(/*annotation = MyAsync.class*/)
@Import(MyService.class)
public class DemoAsync {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoAsync.class);

		ac.refresh();
		ac.start();

		HelloDemo helloDemoIAsync = (HelloDemo) ac.getBean("HelloDemoIAsyncImpl");
		System.out.println("helloDemoIAsync.getClass() = " + helloDemoIAsync.getClass());
		System.out.println("helloDemoIAsync = " + helloDemoIAsync);
		String myInfo = helloDemoIAsync.getMyInfo();
		String info = helloDemoIAsync.getInfo();
//		Future<String> future = helloDemoIAsync.getInfoAsync();
//		System.out.println("future.get() = " + future.get());
		Thread.sleep(1000L);
		System.out.println("info = " + info);
		System.out.println("myInfo = " + myInfo);


//		AsyncConfigurationSelector bean = ac.getBean(AsyncConfigurationSelector.class);
//		System.out.println("bean = " + bean);
	}


}
