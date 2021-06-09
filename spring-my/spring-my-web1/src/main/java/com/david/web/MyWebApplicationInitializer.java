package com.david.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author fanzunying
 * @date 2021/5/12 13:07
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer/*,11javax.servlet.ServletContainerInitializer*/ {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register( AppConfig.class);
//        DispatcherServlet servlet = new DispatcherServlet(ac);
//        Wrapper wrapper = tomcat.addServlet("/", "mvc", servlet);
//        context.addServletMappingDecoded("/","mvc");
//        wrapper.setLoadOnStartup(1);
//        wrapper.addMapping("*");
	}

//	@Override
//	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
//		this.onStartup(ctx);
//	}
}
