package com.david.source.reader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/4/29 18:45
 */
@Component(value = "myDemo")
@Primary()
public class Demo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Demo.class);
		ac.refresh();
		Demo bean = ac.getBean(Demo.class);
		System.out.println(bean);
	}
}
