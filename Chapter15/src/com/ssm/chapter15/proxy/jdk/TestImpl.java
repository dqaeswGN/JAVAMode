package com.ssm.chapter15.proxy.jdk;

public class TestImpl implements Test {

	@Override
	public void sayHello(String str) {
		System.out.println("sayHello:"+str);
	}
}
