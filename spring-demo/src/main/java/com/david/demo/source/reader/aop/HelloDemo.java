package com.david.demo.source.reader.aop;

import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 17:29
 */
@Component
public class HelloDemo {
	public void getInfo() {
		System.out.println("目标类方法：getInfo");
	}
}
