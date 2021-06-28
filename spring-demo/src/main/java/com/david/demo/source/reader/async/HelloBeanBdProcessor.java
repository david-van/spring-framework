package com.david.demo.source.reader.async;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author fanzunying
 * @date 2021/6/28 16:53
 */
public class HelloBeanBdProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public HelloBeanBdProcessor() {
		System.out.println("HelloBeanBdProcessor 构造函数");
	}
}
