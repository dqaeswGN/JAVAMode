package com.ssm.chapter15.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class Pointout {
	@Pointcut("execution(* com.ssm.chapter15.aop.testImpl.sayHello(..))")
	public void print(){
		
	}
	@Before("print()")
	public void before(){
		System.out.println("before...");
	}
	@After("print()")
	public void after(){
		System.out.println("after...");
	}
	@AfterReturning("print()")
	public void afterReturning(){
		System.out.println("afterReturning...");
	}
	@AfterThrowing("print()")
	public void afterThrowing(){
		System.out.println("afterThrowing...");
	}
	/**
	 * 环绕通知
	 * @param pt
	 */
	@Around("print()")
	public void arount(ProceedingJoinPoint pt) {
		System.out.println("around before....");
		try {
			pt.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around after..");
	}
}
