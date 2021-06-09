package com.david.demo.source.reader.beanFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;

import javax.annotation.Priority;
import java.util.Arrays;

/**
 * @author fanzunying
 * @date 2021/4/30 14:33
 */
//@Order(3)
@Priority(value = 3)
public class MyBeanDefinitionRegistryPostProcessor implements  /*PriorityOrdered,*/ BeanDefinitionRegistryPostProcessor {
	private String name = "MyBeanDefinitionRegistryPostProcessor";

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println(" MyBeanDefinitionRegistryPostProcessor 调用 postProcessBeanDefinitionRegistry");
//		String[] names = registry.getBeanDefinitionNames();
//		Arrays.stream(names).forEach(System.out::println);
		System.out.println("registry = " + registry);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor 调用 postProcessBeanFactory");
		System.out.println("beanFactory = " + beanFactory);
	}
//
//	@Override
//	public int getOrder() {
//		return 1;
//	}
}
