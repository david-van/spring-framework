package com.david.demo.source.reader.bean.b;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 16:42
 */
@Component
public class MyConfig2 {


	@Bean
	public Son son() {
		Son son = new Son();
		System.out.println("son created..." + son.hashCode());
		return son;
	}

	@Bean
	public MyParent parent() {
		notBeanMethod();
		Son son = son();
		System.out.println("parent created...持有的Son是：" + son.hashCode());
		return new MyParent(son);
	}

	public void notBeanMethod(){
		System.out.println("notBeanMethod invoked by 【" + this + "】");
	}
}
