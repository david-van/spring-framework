package com.david.demo.source.reader.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Service;

/**
 * @author fanzunying
 * @date 2021/5/17 17:39
 */
@Service
public class OrderService  implements BeanFactoryAware {
	public OrderService() {
		System.out.println("orderService构造方法");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("OrderService 的 BeanFactory");
	}
}
