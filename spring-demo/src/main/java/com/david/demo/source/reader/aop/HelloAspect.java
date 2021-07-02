package com.david.demo.source.reader.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Aspect
@Component
@Order(10)
public class HelloAspect {

	// 拦截aop目录下所有类的所有方法
	@Pointcut("execution(* com.david.demo.source.reader.aop..*.*(..)) ")
//	// AService下面所有外部调用方法，都会拦截。备注：只能是AService的方法，子类不会拦截的，如果HelloDemo是接口，那么需要写实现类
//	@Pointcut("within(com.david.demo.source.reader.aop.HelloDemo)")
	public void point() {

	}

	@Before("point()")
	public void before() {
		System.out.println("this is from HelloAspect#before...");
	}

	@After("point()")
	public void after() {
		System.out.println("this is from HelloAspect#after...");
	}

	@AfterReturning("point()")
	public void afterReturning() {
		System.out.println("this is from HelloAspect#afterReturning...");
	}

	@AfterThrowing("point()")
	public void afterThrowing() {
		System.out.println("this is from HelloAspect#afterThrowing...");
	}

	//此处需要注意：若写了@Around方法，那么最后只会执行@Around和@AfterReturning 其它的都不会执行
//	@Around("point()")
//	public void around() {
//		System.out.println("this is from HelloAspect#around...");
//
//	}

	public static void main(String[] args) {
		AspectJProxyFactory factory = new AspectJProxyFactory();
		// 注意：此处类上面的@Aspect注解必不可少
		factory.setTarget(new HelloDemo());
		//不设置接口，使用cglib，设置了使用jdk
		factory.setInterfaces(HelloDemoI.class);
		factory.addAspect(HelloAspect.class);
		HelloDemoI helloDemoI = factory.getProxy();
		helloDemoI.getInfo();

		//class com.david.demo.source.reader.aop.HelloDemo$$EnhancerBySpringCGLIB$$85a2452e
		//class com.sun.proxy.$Proxy27
		System.out.println(helloDemoI.getClass());
	}

}
