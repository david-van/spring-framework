package com.david;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/4/28 22:02
 */
@Component
public class OrderService {
	@Autowired
	private UserService userService;
	public OrderService() {
		System.out.println("orderService");
	}
}
