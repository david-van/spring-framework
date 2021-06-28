package com.david.demo.source.reader.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanzunying
 * @date 2021/6/28 16:53
 */
//@Configuration
public class HelloBean {

	public HelloBean() {
		System.out.println("HelloBean 构造函数");
	}

	@Bean
	public HelloBeanBdProcessor getHelloBeanBdProcessor() {
		return new HelloBeanBdProcessor();
	}

}
