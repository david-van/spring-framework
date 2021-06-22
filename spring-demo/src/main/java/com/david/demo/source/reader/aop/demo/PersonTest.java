package com.david.demo.source.reader.aop.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.core.DecoratingProxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

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
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvisor(advisor);
		PersonI person = new Person();
		System.out.println("代理前person = " + person);
		proxyFactory.setTarget(person);
		proxyFactory.addInterface(PersonI.class);
		PersonI demo = (PersonI) proxyFactory.getProxy();
//		Person person = new Person();
//		System.out.println("代理前person = " + person);
//		proxyFactory.setTarget(person);
////		proxyFactory.addInterface(PersonI.class);
//		Person demo = (Person) proxyFactory.getProxy();
		System.out.println("代理后person = " + demo);

		// 执行方法
//		demo.run();
//		demo.run(10);
//		demo.say();
//		demo.sayHi("Jack");
//		demo.say("Tom", 666);


		System.out.println(proxyFactory.getTargetClass()); //class com.fsx.maintest.Demo
		System.out.println(proxyFactory.getTargetSource()); //SingletonTargetSource for target object [com.fsx.maintest.Demo@643b1d11]
		System.out.println(Arrays.asList(proxyFactory.getProxiedInterfaces())); //[interface com.fsx.maintest.DemoInterface]
		System.out.println(Arrays.asList(proxyFactory.getAdvisors())); //[org.springframework.aop.support.DefaultPointcutAdvisor: pointcut [Pointcut.TRUE]; advice [com.fsx.maintest.Main$$Lambda$2/1349414238@2ef5e5e3]]


		// 获取类型，看看是JDK代理还是cglib的
//		System.out.println(demo instanceof Proxy); //true  所有的JDK代理都是继承自Proxy的
		System.out.println(demo instanceof SpringProxy); //true
		System.out.println(demo.getClass()); //class com.fsx.maintest.$Proxy0
		System.out.println(Proxy.isProxyClass(demo.getClass())); //true
		System.out.println(AopUtils.isCglibProxy(demo)); //false

		//测试Advised接口、DecoratingProxy的内容
		Advised advised = (Advised) demo;
		System.out.println(Arrays.asList(advised.getProxiedInterfaces())); //[interface com.fsx.maintest.DemoInterface]
		System.out.println(Arrays.asList(advised.getAdvisors())); //[org.springframework.aop.support.DefaultPointcutAdvisor: pointcut [Pointcut.TRUE]; advice [com.fsx.maintest.Main$$Lambda$2/1349414238@2ef5e5e3]]
		System.out.println(advised.isExposeProxy()); //false
		System.out.println(advised.isFrozen()); //false

		//System.out.println(advised.removeAdvice(null));
		DecoratingProxy decoratingProxy = (DecoratingProxy) demo;
		System.out.println(decoratingProxy.getDecoratedClass()); //class com.fsx.maintest.Demo

		System.out.println("-----------------------------------------------------");

		// Object的方法 ==== 所有的Object方法都不会被AOP代理 这点需要注意
		System.out.println(demo.equals(new Object()));
		System.out.println(demo.hashCode());
		System.out.println(demo.getClass());

		// 其余方法都没被拦截  只有toString()被拦截了  咋回事呢？它也不符合切点表达式的要求啊  看下面的解释吧
		// 你被拦截了：方法名为：hello 参数为--[]
		// com.fsx.maintest.Demo@643b1d11
		System.out.println(demo.toString());

	}
}
