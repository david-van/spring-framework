package com.david.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuaimin on 2018/3/19.
 */
@ControllerAdvice(basePackages = {})
public class MyGlobalHandler {

	@ExceptionHandler(value = RuntimeException.class)
	public void jsonErrorHandler(HttpServletResponse response, HttpServletRequest request) {
		System.out.println("LoginExceptionHandler");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("InitBinder--binder");
	}
}
