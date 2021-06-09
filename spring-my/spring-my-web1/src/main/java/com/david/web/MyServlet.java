package com.david.web;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * @author fanzunying
 * @date 2021/5/12 13:06
 */
public class MyServlet {
	public static void main(String[] args) throws LifecycleException, ClassNotFoundException, IllegalAccessException, InstantiationException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8088);
//		Context context = tomcat.addContext("/",System.getProperty("java.io.tmpdir"));
//		Context context = tomcat.addWebapp("/",System.getProperty("java.io.tmpdir"));
		// 用这两行代码，就可以不用导额外的包，也不会报错
		Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
		context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());

		Connector conn = tomcat.getConnector(); // Tomcat 9.0 必须调用 Tomcat#getConnector() 方法之后才会监听端口
		System.out.println("连接器设置完成: " + conn);
		//添加dispathServlet
//		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//		ac.register(AppConfig.class);
//		DispatcherServlet servlet = new DispatcherServlet(ac);
////		DemoServlet servlet = new DemoServlet();
//		Wrapper wrapper = tomcat.addServlet("/", "mvc", servlet);
//		context.addServletMappingDecoded("/","mvc");
//		wrapper.setLoadOnStartup(1);
//		wrapper.addMapping("*");
		tomcat.start();
		tomcat.getServer().await();
//		Tomcat tomcat = new Tomcat();
//		tomcat.setPort(Integer.getInteger("port", 8080));
//		tomcat.getConnector();
//		Context ctx = tomcat.addWebapp("/", new File("spring-my/spring-my-web1/src/main/com").getAbsolutePath());
//		WebResourceRoot resources = new StandardRoot(ctx);
//		resources.addPreResources(
//				new DirResourceSet(resources, "/WEB-INF/classes", new File("spring-my/spring-my-web1/build/classes").getAbsolutePath(), "/"));
//		ctx.setResources(resources);
//		tomcat.start();
//		tomcat.getServer().await();
	}
}
