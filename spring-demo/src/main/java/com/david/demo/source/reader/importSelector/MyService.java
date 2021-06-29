package com.david.demo.source.reader.importSelector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * @author fanzunying
 * @date 2021/6/25 18:11
 */
public class MyService {

	public MyService() {
		System.out.println("MyService 的构造函数");
	}

	@Bean
	public MyServiceDemo getDemo() {
		System.out.println("父类的bean");
		return new MyServiceDemo();
	}

	@Autowired(required = false)
	public void getDem(Collection<DemoBean> demoBeans) {
		System.out.println("demoBeans = " + demoBeans);
	}

//	@Autowired(required = true)
	public void getRequiredTrue(DemoBean demoBean) {
		System.out.println("getRequiredTrue");
	}

	@Autowired(required = false)
	public void getRequiredFalse(DemoBean demoBean) {
		System.out.println("getRequiredFalse");
	}
}
