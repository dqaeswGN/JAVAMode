package com.lean.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {
	
	private String name;
	
	public ReflectServiceImpl2(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.err.println("----------------------我的名字是:"+name+",hello boy");
	}
	
	

}
