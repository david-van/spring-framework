package com.david.web;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuaimin on 2018/3/19.
 */
@ControllerAdvice
public class MyGlobalHandler3 implements ResponseBodyAdvice<Object> {

	@ExceptionHandler(BeanCurrentlyInCreationException.class)
	public void jsonErrorHandler(HttpServletResponse response, HttpServletRequest request) {
		System.out.println("LoginExceptionHandler2");
	}

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		System.out.println("returnType = " + returnType);
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		System.out.println("body = " + body);
		return body;
	}
}
