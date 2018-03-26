package com.ssm.chapter15.aop;

import org.springframework.stereotype.Component;

@Component
public class testImpl implements test{

	@Override
	public void sayHello(String name) {
		System.out.println("name="+name);		
	}

}
