package com.david.demo.source.reader.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Aspect
@Component
public class HelloAspect1 {

	// 拦截aop目录下所有类的所有方法
	@Pointcut("execution(* com.david.demo.source.reader.aop..*.*(..)) ")
	public void point() {

	}

	@Before("point()")
	public void before() {
		System.out.println("HelloAspect1 this is from HelloAspect#before...");
	}

	@After("point()")
	public void after() {
		System.out.println(" HelloAspect1  this is from HelloAspect#after...");
	}

	@AfterReturning("point()")
	public void afterReturning() {
		System.out.println(" HelloAspect1 this is from HelloAspect#afterReturning...");
	}

	@AfterThrowing("point()")
	public void afterThrowing() {
		System.out.println("HelloAspect1 this is from HelloAspect#afterThrowing...");
	}

	//此处需要注意：若写了@Around方法，那么最后只会执行@Around和@AfterReturning 其它的都不会执行
//	@Around("point()")
//	public void around() {
//		System.out.println("HelloAspect1 this is from HelloAspect#around...");
//
//	}

}
