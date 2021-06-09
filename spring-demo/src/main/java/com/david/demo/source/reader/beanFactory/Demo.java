package com.david.demo.source.reader.beanFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 该处主要都源码之BeanFactory后置处理器的扩展
 *
 * @author fanzunying
 * @date 2021/4/29 18:45
 */
@Component(value = "myDemo")
@Primary()
//@Conditional(value = UserService.class)
//@ConditionalOn
public class Demo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Demo.class);
		ac.register(MyBeanFactoryPostProcessor.class);
		ac.register(MyBeanDefinitionRegistryPostProcessor2.class);
		ac.register(MyBeanDefinitionRegistryPostProcessor.class);
//		MyBeanDefinitionRegistryPostProcessor processor = new MyBeanDefinitionRegistryPostProcessor();
//		ac.addBeanFactoryPostProcessor(processor);
//		MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//		ac.addBeanFactoryPostProcessor(myBeanFactoryPostProcessor);
//		ac.register(AspectJWeavingEnabler.class);
		ac.refresh();
		Demo bean = ac.getBean(Demo.class);
		System.out.println(bean);
	}
}
