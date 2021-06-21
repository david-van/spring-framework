package com.david.demo.source.reader.bean.b;

import com.david.demo.source.reader.bean.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * @author fanzunying
 * @date 2021/5/7 17:58
 */
//@Component
@Configuration()
@Import(OrderService.class)
public class MyAlias {
	@Autowired
	private OrderService orderService;

	public MyAlias() {
		System.out.println("MyAlias 构造方法 = ");
	}

	@Bean(value = "getMyMyAlias")
	public MyConfig getMy() {
		MyConfig myConfig = new MyConfig();
		myConfig.setName("new name");
		return myConfig;
	}

	@PostConstruct
	public void getOrder() {
		System.out.println("MyAlias" + orderService);
	}
}
