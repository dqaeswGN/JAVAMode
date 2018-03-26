package com.ssm.chapter15.proxy.jdk;

public class TestMain {
	public static void main(String[] args){
		JdkProxyImpl impl=new JdkProxyImpl();
		Test test=(Test)impl.bind(new TestImpl());
		test.sayHello("asdf");
	}

}
