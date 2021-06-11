package com.david.web;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author fanzunying
 * @date 2021/5/12 13:15
 */
@Configuration
@ComponentScan
@EnableWebMvc // 启用Spring MVC
public class AppConfig implements WebMvcConfigurer, HandlerInterceptor {
//
//	@Bean
//	public MappedInterceptor getInfo() {
//		HandlerInterceptor interceptor;
//		HandlerInterceptor interceptor1 = new HandlerInterceptor() {
//
//		};
//		String[] includePatterns = {"/*"}, excludePatterns = {""};
//		MappedInterceptor mappedInterceptor = new MappedInterceptor(includePatterns, excludePatterns, interceptor1);
//		return mappedInterceptor;
//	}

	//// 通过继承 WebMvcConfigurerAdapter
	// 方式一：最源生的使用方式:直接注册进去即可
	//// 其实它也挺强大，支持includePatterns和exclude...
	//// 其实它底层原理是一个依赖于`InterceptorRegistration`，它是个普通类，协助create一个`MappedInterceptor`
	//// 由此可见最终底层还是使用的`MappedInterceptor`哦~~~~~
	//@Override
	//public void addInterceptors(InterceptorRegistry registry) {
	//    registry.addInterceptor(new HelloInterceptor())
	//            .addPathPatterns() // 就是includePatterns
	//            .excludePathPatterns();
	//}

	// 方式二：如果说上述方式是交给Spring去帮我自动处理，这种方式相当于自己手动来处理~~~~~
	//  请务必注意：此处的返回值必须是MappedInterceptor，而不能是HandlerInterceptor  否则不生效~~~
	// 因为BeanFactoryUtils.beansOfTypeIncludingAncestors(obtainApplicationContext(), MappedInterceptor.class, true, false)
	// 这个方法它只去找MappedInterceptor类型，如果你是父类型，那就匹配不上了的~~~  这个工厂方法的Bean定义信息有关~~
	@Bean
	public MappedInterceptor myHandlerInterceptor() {
		HandlerInterceptor interceptor1 = new HandlerInterceptor() {

		};
		String[] includePatterns = {"/api/v1/hello"};
		MappedInterceptor handlerInterceptor = new MappedInterceptor(includePatterns, interceptor1);
		return handlerInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AppConfig());
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new FastJsonHttpMessageConverter());
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("handler = " + handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		response.setStatus(500);
		System.out.println("modelAndView = " + modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Thread.sleep(3000L);
		System.out.println("handler = " + handler);
	}
}
