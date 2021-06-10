package com.david.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xuaimin on 2018/3/19.
 */
@ControllerAdvice
public class LoginExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	public void jsonErrorHandler(HttpServletResponse response, HttpServletRequest request) {
		System.out.println("LoginExceptionHandler");
	}
}
