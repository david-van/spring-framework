package com.david.source.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/4/28 22:01
 */
@Component
@Order(value = 3)
public class UserService {
//	@Autowired
//	private OrderService orderService;

	public UserService() {
		System.out.println("userService");
	}
}
