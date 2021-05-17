package com.david.source.reader.bean;

import com.david.source.reader.bean.a.MyAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/5/9 17:12
 */
@Component
public class UserService {

	@Autowired
	private OrderService orderService;

	public UserService() {
		System.out.println("UserService");
	}

	@PostConstruct
	public void getOrder() {
		System.out.println(orderService);
	}
//
//	public UserService(DemoBean demoBean) {
//		System.out.println("by demoBean");
//	}
//
////	@Autowired(required = false)
//	public UserService(MyAlias myAlias) {
//		System.out.println("by myAlias");
//	}
//
////	@Autowired(required = false)
//	public UserService(MyAlias myAlias, DemoBean demoBean) {
//		System.out.println("by myAlias and demoBean");
//	}
}
