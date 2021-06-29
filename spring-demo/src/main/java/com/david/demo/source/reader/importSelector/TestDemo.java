package com.david.demo.source.reader.importSelector;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

/**
 * @author fanzunying
 * @date 2021/6/25 18:09
 */
@Primary()
@ComponentScan()
@Import(MyServiceSub.class)
public class TestDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(TestDemo.class);
		ac.refresh();
		MyServiceSub myServiceSub = ac.getBean(MyServiceSub.class);
		MyService myService = ac.getBean(MyService.class);
		System.out.println("myServiceSub = " + myServiceSub);
		System.out.println("myService = " + myService);

		Object o = ac.getBean("com.david.demo.source.reader.importSelector.MyServiceSub");
		Object myService1 = ac.getBean("com.david.demo.source.reader.importSelector.MyService");
		System.out.println("o = " + o);


	}
}
