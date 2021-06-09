package com.david.demo.source.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/4/28 22:02
 */
@Component()
@Order(value = 5)
public class OrderService {

//	@Autowired
//	private UserService userService;

	public OrderService() {
		System.out.println("orderService");
	}
}
