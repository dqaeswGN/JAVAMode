package com.lean.ssm.chapter2.proxy;

import com.lean.ssm.chapter2.reflect.ReflectServiceImpl;

public class test {

	public static void main(String[] args) {
//		Jdktest();  
		System.out.println("aaa");
		Cgilbtest();
	}

	public static void Jdktest(){
		JdkproxyExample jdk=new JdkproxyExample();
		HelloWorld proxy=(HelloWorld)jdk.bind(new HelloWorldImpl());
		proxy.sayhello();
	}
	
	public static void Cgilbtest(){
		CglibProxyExample cgb=new CglibProxyExample();
		ReflectServiceImpl impl=(ReflectServiceImpl)cgb.getProxy(ReflectServiceImpl.class);
		impl.sayHello("����");
	}
}
