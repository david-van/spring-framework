package com.david.source.reader.bean;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.util.logging.Level;

/**
 * 这里测试bean的后置处理器扩展
 *
 * @author fanzunying
 * @date 2021/4/29 18:45
 */
@Component(value = "DemoBean")
//@AliasFor()
@Primary()
@ComponentScan(basePackages = "com.david.source.reader.bean")
//@EnableLoadTimeWeaving()
@EnableAspectJAutoProxy
public class DemoBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DemoBean.class);
//		ac.setAllowCircularReferences(false);
//		ac.register(MyBeanPostProcessor.class);
		ac.refresh();
//		DemoBean bean = ac.getBean(DemoBean.class);
//		MyBeanPostProcessor processor = ac.getBean(MyBeanPostProcessor.class);
//		System.out.println(bean);
	}
}
