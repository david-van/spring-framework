package com.david.demo.source.reader.bean;

import com.david.demo.source.reader.bean.b.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
//	@Qualifier
	private OrderService orderService;

	@Autowired
	private OrderService orderService11;
//	@Autowired
//	private MyString myString;
//	@Autowired
//	private String string;

	public UserService() {
		System.out.println("UserService");
	}

	@Bean(value = "getMyUserService")
	public MyConfig getMy() {
		return new MyConfig();
	}

	@PostConstruct
	public void getOrder() {
		System.out.println(orderService);
		System.out.println("-------" + orderService11);
//		System.out.println("-------" + myString);
//		System.out.println("-------" + string);
//		try {
//			System.out.println("-------" + myString.getObject());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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
