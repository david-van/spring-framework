package com.david.demo.source.reader.aop.demo;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.*;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;
import org.springframework.core.DecoratingProxy;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author fanzunying
 * @date 2021/6/21 19:22
 */
public class PersonTest {
	public static void main(String[] args) {
//		test01();
//		test02();
//		test03();
//		test04();
		test05();
	}

	private static void test05() {

		PersonI person = new Person();
		MethodInterceptor interceptor = new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				Method method = invocation.getMethod();
				System.out.println("方法之前执行了---------" + method.getName());
				Object result = method.invoke(invocation.getThis(), invocation.getArguments());
				System.out.println("方法之后执行了---------" + method.getName());
				return result;
			}
		};
		BeforeAdvice beforeAdvice = new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("before 方法之前执行了---------" + method.getName());
				//此处属于重复调用了
//				method.invoke(target, args);
//				System.out.println("before 方法之后执行了---------" + method.getName());
			}
		};

		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("say");
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(pointcut);
		advisor.setAdvice(interceptor);
		advisor.setAdvice(beforeAdvice);
		// 创建一个流程切入点
		//也就是在那个类中的那个方法中执行被代理对象的方法的时候，能够进行配置，完成代理功能
		ControlFlowPointcut controlFlowPointcut = new ControlFlowPointcut(PersonTest.class, "test05");
		//会被后面的set覆盖
		advisor.setPointcut(controlFlowPointcut);

		// 创建一个复合切点 把上面两者并且进来
		ComposablePointcut cut = new ComposablePointcut();
		//交集
		cut.intersection((Pointcut) controlFlowPointcut).intersection((Pointcut) pointcut);
		//并集
		cut.union((Pointcut) controlFlowPointcut).union((Pointcut) pointcut);
		advisor.setPointcut(cut);


		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(person);
		proxyFactory.addAdvisor(advisor);


		PersonI person1 = (Person) proxyFactory.getProxy();
		person1.run(22);
		person1.run();
		person1.say();


	}

	private static void test04() {
		PersonI person = new Person();
		MethodInterceptor interceptor = invocation -> {
			Method method = invocation.getMethod();
			System.out.println("方法之前执行了---------" + method.getName());
			Object result = method.invoke(invocation.getThis(), invocation.getArguments());
			System.out.println("方法之后执行了---------" + method.getName());
			return result;
		};
		NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
		pointcut.addMethodName("say");
		Advisor advisor = new DefaultPointcutAdvisor(pointcut, interceptor);
//		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
//		advisor.setMappedName("run");
//		advisor.setAdvice(interceptor);


		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(person);
		proxyFactory.addAdvisor(advisor);
//		proxyFactory.addAdvice(interceptor);

		PersonI person1 = (Person) proxyFactory.getProxy();
		person1.run(22);
		person1.run();
		person1.say();
	}

	private static void test03() {
		PersonI person = new Person();
		MethodInterceptor interceptor = invocation -> {
			Method method = invocation.getMethod();
			System.out.println("方法之前执行了---------" + method.getName());
			Object result = method.invoke(invocation.getThis(), invocation.getArguments());
			System.out.println("方法之后执行了---------" + method.getName());
			return result;
		};
		//设置方法名advice
		NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
		advisor.setMappedName("run");
		advisor.setAdvice(interceptor);


		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(person);
		proxyFactory.addAdvisor(advisor);


		PersonI person1 = (Person) proxyFactory.getProxy();
		person1.run(22);
		person1.run();
		person1.say();
	}

	private static void test02() {
		PersonI person = new Person();
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(person);
		proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target) -> {
			System.out.println("方法之前执行了  ");
		});

		PersonI person1 = (Person) proxyFactory.getProxy();
		person1.run(22);
		System.out.println(person1.getClass().getName()); //com.fsx.service.HelloServiceImpl$$EnhancerBySpringCGLIB$$9b28670f

		//===============演示AopUtils==================

		// AopUtils.isAopProxy:是否是代理对象
		System.out.println(AopUtils.isAopProxy(person1)); // true
		System.out.println(AopUtils.isJdkDynamicProxy(person1)); // false
		System.out.println(AopUtils.isCglibProxy(person1)); // true

		// 拿到目标对象
		System.out.println(AopUtils.getTargetClass(person1)); //class com.fsx.service.HelloServiceImpl

		// selectInvocableMethod:方法@since 4.3  底层依赖于方法MethodIntrospector.selectInvocableMethod
		// 只是在他技术上做了一个判断： 必须是被代理的方法才行（targetType是SpringProxy的子类,且是private这种方法，且不是static的就不行）
		// Spring MVC的detectHandlerMethods对此方法有大量调用~~~~~
		Method method = ClassUtils.getMethod(Person.class, "run");
		System.out.println(AopUtils.selectInvocableMethod(method, Person.class)); //public java.lang.Object com.fsx.service.HelloServiceImpl.hello()

		// 是否是equals方法
		// isToStringMethod、isHashCodeMethod、isFinalizeMethod  都是类似的
		System.out.println(AopUtils.isEqualsMethod(method)); //false

		// 它是对ClassUtils.getMostSpecificMethod,增加了对代理对象的特殊处理。。。
		System.out.println(AopUtils.getMostSpecificMethod(method, PersonI.class));
	}

	private static void test01() {
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
		demo.run(10);
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
