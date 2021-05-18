package com.david.source.reader.bean.b;

import com.david.source.reader.bean.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fanzunying
 * @date 2021/5/7 17:58
 */
@Component
public class MyAlias {
	@Autowired
	private OrderService orderService;

	@PostConstruct
	public void getOrder() {
		System.out.println("MyAlias" + orderService);
	}
}
