package com.david.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @author fanzunying
 * @date 2021/5/12 13:15
 */
@Configuration
@ComponentScan
@EnableWebMvc // 启用Spring MVC
public class AppConfig {

	@Bean
	public MappedInterceptor getInfo() {
		HandlerInterceptor interceptor;
		HandlerInterceptor interceptor1 = new HandlerInterceptor() {

		};
		String[] includePatterns = {"/*"}, excludePatterns = {""};
		MappedInterceptor mappedInterceptor = new MappedInterceptor(includePatterns, excludePatterns, interceptor1);
		return mappedInterceptor;
	}
}
