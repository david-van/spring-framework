package com.david.demo.source.reader.bean;

import com.david.demo.source.reader.bean.b.MyConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/5/9 17:12
 */
@Component
public class UserService implements InitializingBean, BeanPostProcessor {

	@Autowired
//	@Qualifier
	private OrderService orderService;

	@Autowired
	private OrderService orderService11;
//	@Autowired
//	private MyString myString;
//	@Autowired
//	private String string;

	public void initMethod() {
		System.out.println("initMethod()方法执行了");
	}

	public void init() {
		System.out.println("init()方法执行了");
	}

	public UserService() {
		System.out.println("UserService 构造方法");
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

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("调用afterPropertiesSet初始化方法");
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用postProcessBeforeInitialization初始化方法");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用postProcessAfterInitialization初始化方法");
		return bean;
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
