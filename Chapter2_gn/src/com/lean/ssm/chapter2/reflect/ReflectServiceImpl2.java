package com.lean.ssm.chapter2.reflect;


public class ReflectServiceImpl2 {
	
	private String name;
	
	public ReflectServiceImpl2(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.err.println("----------------------�ҵ�������:"+name+",hello boy");
	}
	
	

}
