package com.david.demo.source.reader.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 这里测试bean的后置处理器扩展
 *
 * @author fanzunying
 * @date 2021/4/29 18:45
 */
@Component(value = "DemoBean")
//@AliasFor()
@Primary()
@ComponentScan(basePackages = "com.david.demo.source.reader.bean")
//@PropertySource(value = "file:C:\\Users\\fanzunying\\IdeaProjects\\spring\\spring-framework\\spring-demo\\src\\main\\resources\\log4j.properties")
//@EnableLoadTimeWeaving()
//@EnableAspectJAutoProxy
//@ImportResource()
@PropertySource(value = "classpath:log4j.properties")
public class DemoBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//		ac.prepareRefresh();
		ac.register(DemoBean.class);

//		ac.setAllowCircularReferences(false);
//		ac.register(MyBeanPostProcessor.class);
		ac.refresh();
		ac.start();
		BeanDefinition definition = ac.getBeanDefinition("getMyMyAlias");
		System.out.println(definition);
		BeanDefinition demoBean = ac.getBeanDefinition("MyConfig");
		System.out.println(demoBean);
		OrderService bean = ac.getBean(OrderService.class);
		System.out.println("bean = " + bean);
//		for (String name : ac.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
//		DemoBean bean = ac.getBean(DemoBean.class);
//		MyBeanPostProcessor processor = ac.getBean(MyBeanPostProcessor.class);
//		System.out.println(bean);
//		ac.stop();
		ac.close();
	}
}
