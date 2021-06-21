package com.david.demo.source.reader.bean.b;

import com.david.demo.source.reader.bean.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author fanzunying
 * @date 2021/5/19 13:13
 */
@Configuration(value = "MyConfig")
@Import(OrderService.class)
public class MyConfig {
	private String name = "aaa";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Bean
//	public Son son() {
//		Son son = new Son();
//		System.out.println("son created..." + son.hashCode());
//		return son;
//	}
//
//	@Bean
//	public MyParent parent() {
//		notBeanMethod();
//		Son son = son();
//		System.out.println("parent created...持有的Son是：" + son.hashCode());
//		return new MyParent(son);
//	}
//
//	public void notBeanMethod(){
//		System.out.println("notBeanMethod invoked by 【" + this + "】");
//	}
}
