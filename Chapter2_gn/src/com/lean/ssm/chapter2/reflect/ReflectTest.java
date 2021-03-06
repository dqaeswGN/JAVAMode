package com.lean.ssm.chapter2.reflect;

import java.lang.reflect.Method;

public class ReflectTest {
	public static ReflectServiceImpl getInstance1(){
		ReflectServiceImpl object=null;
		try{
			object=(ReflectServiceImpl) Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
			Method method=object.getClass().getMethod("sayHello", String.class);
			method.invoke(object,"��һ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	public static ReflectServiceImpl2 getInstance2() {
	    ReflectServiceImpl2 object = null;
	    try {
	        object =  (ReflectServiceImpl2) Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl2").
	            getConstructor(String.class).newInstance("����");
	        Method method=object.getClass().getMethod("sayHello");
			method.invoke(object);
	    } catch (Exception ex) {
	            ex.printStackTrace();
	    }
	    return object;
	}
	
	public static void main(String[] args) {
		getInstance1();
		getInstance2();
	}

}
