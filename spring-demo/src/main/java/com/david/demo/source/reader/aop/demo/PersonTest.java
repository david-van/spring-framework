package com.david.demo.source.reader.aop.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author fanzunying
 * @date 2021/6/21 19:22
 */
public class PersonTest {
	public static void main(String[] args) {
		//String pointcutExpression = "execution( int com.fsx.maintest.Person.run() )"; // 会拦截Person.run()方法
		//String pointcutExpression = "args()"; // 所有没有入参的方法会被拦截。  比如：run()会拦截,但是run(int i)不会被拦截
		// ... AspectJExpressionPointcut支持的表达式 一共有11种（也就是Spring全部支持的切点表达式类型）

		//切点的声明
		String pointcutExpression = "execution(* com.david.demo.source.reader.aop..*.*(..))";


		//声明一个aspectj切点,一张切面
		AspectJExpressionPointcut cut = new AspectJExpressionPointcut();
		cut.setExpression(pointcutExpression); // 设置切点表达式

		// 声明一个通知（此处使用环绕通知 MethodInterceptor ）
		Advice advice = (MethodInterceptor) invocation -> {
			System.out.println("============>放行前拦截...");
			Object obj = invocation.proceed();
			System.out.println("============>放行后拦截...");
			return obj;
		};

		//切面=切点+通知
		// 它还有个构造函数：DefaultPointcutAdvisor(Advice advice); 用的切面就是Pointcut.TRUE，所以如果你要指定切面，请使用自己指定的构造函数
		// Pointcut.TRUE：表示啥都返回true，也就是说这个切面作用于所有的方法上/所有的方法
		// addAdvice();方法最终内部都是被包装成一个 `DefaultPointcutAdvisor`，且使用的是Pointcut.TRUE切面，因此需要注意这些区别  相当于new DefaultPointcutAdvisor(Pointcut.TRUE,advice);
		Advisor advisor = new DefaultPointcutAdvisor(cut, advice);

		// =============================================================
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvisor(advisor);
		factory.setTargetClass(Person.class);
		Person p = (Person) factory.getProxy();

		// 执行方法
		p.run();
		p.run(10);
		p.say();
		p.sayHi("Jack");
		p.say("Tom", 666);

	}
}
