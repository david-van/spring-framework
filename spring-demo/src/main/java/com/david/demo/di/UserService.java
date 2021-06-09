package com.david.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/4/28 22:01
 */
@Component
public class UserService {
	@Autowired
	private OrderService orderService;
	public UserService() {
		System.out.println("userService");
	}
}
