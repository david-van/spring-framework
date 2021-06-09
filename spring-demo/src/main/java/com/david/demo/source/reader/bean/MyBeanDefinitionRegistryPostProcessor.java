package com.david.demo.source.reader.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;

/**
 * @author fanzunying
 * @date 2021/4/30 14:33
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	private String name = "MyBeanDefinitionRegistryPostProcessor";

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		AbstractBeanDefinition userService = (AbstractBeanDefinition) registry.getBeanDefinition("userService");
//		userService.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//beanFactory
	}

}
