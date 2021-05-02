package com.david.source.reader.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

/**
 * 这里测试bean的后置处理器扩展
 *
 * @author fanzunying
 * @date 2021/4/29 18:45
 */
@Component(value = "DemoBean")
@Primary()
public class DemoBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoBean.class);
		ac.register(MyBeanPostProcessor.class);
//		Level.CONFIG
		ac.refresh();
		DemoBean bean = ac.getBean(DemoBean.class);
		System.out.println(bean);
	}
}
