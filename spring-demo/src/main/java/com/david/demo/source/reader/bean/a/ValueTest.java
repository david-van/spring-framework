package com.david.demo.source.reader.bean.a;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fanzunying
 * @date 2021/6/25 10:19
 */
@Component
public class ValueTest {
	@Value("${log4j.appender.Console}")
	private String console;
	@Value("#{myBeanDefinitionRegistryPostProcessor.name}")
	private String name;

	@Autowired
	private ValueTest valueTest;

	@PostConstruct
	public void print() {
		System.out.println("console = " + console);
		System.out.println("name = " + name);
	}
}
