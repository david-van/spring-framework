package com.david.source.reader.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;

import javax.annotation.Priority;

/**
 * @author fanzunying
 * @date 2021/4/30 14:33
 */
//@Order(1)
@Priority(value = 11)
public class MyBeanDefinitionRegistryPostProcessor2 implements /*PriorityOrdered, */BeanDefinitionRegistryPostProcessor {
	private String name = "MyBeanDefinitionRegistryPostProcessor2";

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println(" MyBeanDefinitionRegistryPostProcessor2 调用 postProcessBeanDefinitionRegistry");
//		String[] names = registry.getBeanDefinitionNames();
//		Arrays.stream(names).forEach(System.out::println);
		System.out.println("registry = " + registry);
//		registry.registerBeanDefinition();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor2 调用 postProcessBeanFactory");
		System.out.println("beanFactory = " + beanFactory);
//		beanFactory.beande
	}

//	@Override
//	public int getOrder() {
//		return 2;
//	}
}
