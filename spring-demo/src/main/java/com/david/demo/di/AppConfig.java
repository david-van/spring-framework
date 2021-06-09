package com.david.demo.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author fanzunying
 * @version v1.0.0
 * @date 2021/4/28 22:00
 */
@Configuration
@ComponentScan("com.david.demo.di")
public class AppConfig {

//	@Bean(autowireCandidate = false)
//	public InfoService getInfo() {
//		return new InfoService("myName", "myAge");
//	}

}
