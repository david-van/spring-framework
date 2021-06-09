//package com.david.web;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
///**
// * @author fanzunying
// * @date 2021/6/9 18:34
// */
//@WebFilter("/*")
//public class MyFilter implements Filter {
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("init");
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter");
//		chain.doFilter(request, response);
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("destroy");
//	}
//}
