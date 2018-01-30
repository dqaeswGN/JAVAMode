package com.lean.ssm.chapter2.intercept;

import com.lean.ssm.chapter2.proxy.HelloWorld;
import com.lean.ssm.chapter2.proxy.HelloWorldImpl;

public class test {

	public static void main(String[] args) {
		testinterceptor();

	}

	public static void testinterceptor(){
		HelloWorld hw=(HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.lean.ssm.chapter2.intercept.MyInterceptor");
		hw.sayhello();
	}
}