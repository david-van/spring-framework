package com.david.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

/**
 * @author fanzunying
 * @date 2021/4/29 17:44
 */
@Component
public class InfoService {
//
//	public InfoService() {
//		System.out.println("moren ");
//	}

	private UserService userService;
	private OrderService orderService;


	@Autowired()
	@ConstructorProperties(value = {"my nam", "123"})
	public InfoService(UserService name, OrderService age) {
		this.userService = name;
		this.orderService = age;
		System.out.println("--------" + name);
		System.out.println("--------" + age);
	}

//	public InfoService(String name) {
//		System.out.println(name);
//	}
}
