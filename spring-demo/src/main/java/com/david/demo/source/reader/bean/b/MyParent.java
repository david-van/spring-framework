package com.david.demo.source.reader.bean.b;

/**
 * @author fanzunying
 * @date 2021/6/21 15:39
 */
public class MyParent {
	public MyParent() {
		System.out.println("MyParent 空参");
	}

	public MyParent(Son son) {
		System.out.println("MyParent 【son】");
	}
}
