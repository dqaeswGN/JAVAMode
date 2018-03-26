package com.ssm.chapter15.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RoleInterceptor4 extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.err.println("进入拦截器之前的执行方法444");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.err.println("拦截器之后的方法444");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
             Object handler, Exception ex) throws Exception {
		System.err.println("无论是否产生异常，都会在渲染视图后执行的方法444");
	}

}
