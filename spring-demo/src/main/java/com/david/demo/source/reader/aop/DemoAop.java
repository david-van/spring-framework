package com.david.demo.source.reader.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Component()
@ComponentScan(basePackages = "com.david.demo.source.reader.aop")
@EnableAspectJAutoProxy
//@EnableAsync
public class DemoAop {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoAop.class);

		ac.refresh();
		ac.start();

		HelloDemoI helloDemo = (HelloDemoI) ac.getBean("HelloDemo");
		helloDemo.getInfo();
		HelloDemoI bean = (HelloDemoI) ac.getBean("proxyFactoryBean");

		bean.getInfo();
		System.out.println("bean.getClass() = " + bean.getClass());
		HelloDemoI helloDemoIAsync = (HelloDemoI) ac.getBean("HelloDemoIAsyncImpl" );
		System.out.println("helloDemoIAsync = " + helloDemoIAsync);
		helloDemoIAsync.getInfo();


		ac.close();
	}


}
