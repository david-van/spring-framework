package com.david.source.reader.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author fanzunying
 * @date 2021/4/30 19:06
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用  postProcessBeforeInitialization ");
		System.out.println("bean = " + bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("调用  postProcessAfterInitialization ");
		System.out.println("bean = " + bean);
		return bean;
	}
}
