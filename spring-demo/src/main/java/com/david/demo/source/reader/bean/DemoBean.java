package com.david.demo.source.reader.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

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
//@PropertySource(value = "file:C:\\Users\\fanzunying\\IdeaProjects\\spring\\spring-framework\\spring-demo\\src\\main\\resources\\application.properties")
//@EnableLoadTimeWeaving()
//@EnableAspectJAutoProxy
public class DemoBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoBean.class);
//		ac.setAllowCircularReferences(false);
//		ac.register(MyBeanPostProcessor.class);
		ac.refresh();
		BeanDefinition definition = ac.getBeanDefinition("getMyMyAlias");
		System.out.println(definition);
		BeanDefinition demoBean = ac.getBeanDefinition("MyConfig");
		System.out.println(demoBean);
//		for (String name : ac.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
//		DemoBean bean = ac.getBean(DemoBean.class);
//		MyBeanPostProcessor processor = ac.getBean(MyBeanPostProcessor.class);
//		System.out.println(bean);
	}
}
