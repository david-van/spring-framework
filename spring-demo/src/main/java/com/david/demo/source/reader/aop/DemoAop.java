package com.david.demo.source.reader.aop;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Component()
@ComponentScan(basePackages = "com.david.demo.source.reader.aop")
public class DemoAop {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoAop.class);

		ac.refresh();
		ac.start();

		HelloDemoI helloDemo = (HelloDemoI) ac.getBean("helloDemo");
		helloDemo.getInfo();
		HelloDemoI bean = (HelloDemoI) ac.getBean("proxyFactoryBean");

		bean.getInfo();
		System.out.println("bean.getClass() = " + bean.getClass());
//		HelloDemo bean = ac.getBean(HelloDemo.class);
//		System.out.println("bean = " + bean);
//		bean.getInfo();



		ac.close();
	}


}
