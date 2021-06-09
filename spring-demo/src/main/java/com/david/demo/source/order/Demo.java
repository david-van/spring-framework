package com.david.demo.source.order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fanzunying
 * @date 2021/4/30 16:45
 */
public class Demo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Demo.class);
		ac.register(OrderService.class);
		ac.register(UserService.class);
		ac.refresh();
	}
}
