package com.david.demo.di;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/4/24 20:33
 */
public class Demo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		BeanDefinition appConfig = ac.getBeanDefinition("appConfig");
		System.out.println(appConfig);
		BeanDefinition beanDefinition = ac.getBeanDefinition("infoService");
		ConstructorArgumentValues values = beanDefinition.getConstructorArgumentValues();
		InfoService bean = ac.getBean(InfoService.class);
		System.out.println(bean);
		System.out.println(ac.getBean(OrderService.class));
		System.out.println(ac.getBean(UserService.class));
//		context.refresh();
//		context.getBeanDefinition()

	}

}
