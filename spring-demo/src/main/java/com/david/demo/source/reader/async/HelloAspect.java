package com.david.demo.source.reader.async;

import com.david.demo.source.reader.aop.HelloDemo;
import com.david.demo.source.reader.aop.HelloDemoI;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @author fanzunying
 * @date 2021/6/21 16:46
 */
@Aspect
@Component
public class HelloAspect {

	private static ExecutorService executor = Executors.newFixedThreadPool(10);

	// 拦截aop目录下所有类的所有方法
	@Pointcut("execution(* com.david.demo.source.reader.async..*.*(..)) ")
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
//	public void around(JoinPoint joinPoint) throws InvocationTargetException, IllegalAccessException {
//	 //这里判断方法上面是否存在指定注解，如果有，用异步线程执行
//		Signature signature = joinPoint.getSignature();
//		Object target = joinPoint.getTarget();
//		Object[] args = joinPoint.getArgs();
//		System.out.println("target = " + target);
//		MethodSignature methodSignature = (MethodSignature) signature;
//		Method method = methodSignature.getMethod();
//
//		Object result = method.invoke(target, args);
//		System.out.println("result = " + result);
////		return result;
//
//
//
//	}

	@Around("point()")
	public Object around(ProceedingJoinPoint joinPoint  ) throws Throwable {
		//这里判断方法上面是否存在指定注解，如果有，用异步线程执行
//		String kind = staticPart.getKind();
//		System.out.println("kind = " + kind);
		Object result;
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Object[] args = joinPoint.getArgs();
		Object target = joinPoint.getTarget();
		Class<?> targetClazz = target.getClass();
		Method targetMethod = targetClazz.getMethod(signature.getName(), signature.getParameterTypes());
		MyAsync annotation = targetMethod.getAnnotation(MyAsync.class);
		Object pointThis = joinPoint.getThis();
		MyAsync myAsync = method.getAnnotation(MyAsync.class);
		if (null != myAsync) {
			Future<Object> submit = executor.submit(() -> {
				try {
					return method.invoke(target, args);
				} catch (Throwable throwable) {
					throwable.printStackTrace();
					return null;
				}
			});
			result = submit.get();
			return result;
		}
		result = method.invoke(target, args);
		return result;


	}


}
