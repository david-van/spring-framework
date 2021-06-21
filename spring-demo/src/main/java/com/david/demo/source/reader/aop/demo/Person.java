package com.david.demo.source.reader.aop.demo;

/**
 * @author fanzunying
 * @date 2021/6/21 19:20
 */
public class Person {

	public int run() {
		System.out.println("我在run...");
		return 0;
	}

	public void run(int i) {
		System.out.println("我在run...<" + i + ">");
	}

	public void say() {
		System.out.println("我在say...");
	}

	public void sayHi(String name) {
		System.out.println("Hi," + name + ",你好");
	}

	public int say(String name, int i) {
		System.out.println(name + "----" + i);
		return 0;
	}
}
