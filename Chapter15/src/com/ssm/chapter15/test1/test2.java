package com.ssm.chapter15.test1;

import java.lang.reflect.Method;

public class test2 {

	public static void main(String[] args) {
		test1234();

	}
	
	public static test1 test123(){
		test1 object=null;
		try {
			object=(test1)Class.forName("com.ssm.chapter15.test1.test1").newInstance();
			
			
		} catch (ClassNotFoundException  | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public static Object test1234(){
		test1 object=null;
		
		try {
			object=(test1)Class.forName("com.ssm.chapter15.test1.test1").getConstructor(String.class).newInstance("123");
			Method method=object.getClass().getMethod("sayHello", String.class);
			method.invoke(object,"123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

}
