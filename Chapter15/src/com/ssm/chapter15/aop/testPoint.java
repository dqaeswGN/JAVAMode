package com.ssm.chapter15.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class testPoint {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		test obj=context.getBean(test.class);
		String name="123";
		obj.sayHello(name);
	}

}
