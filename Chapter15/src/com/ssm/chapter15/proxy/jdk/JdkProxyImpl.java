package com.ssm.chapter15.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyImpl implements InvocationHandler{
	
	//真实对象
	private Object target=null;
	
	//创建代理关系
	public Object bind(Object target){
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
									  target.getClass().getInterfaces(), 
									  this);
	}
	

	@Override
	public Object invoke(Object proxy, Method method, Object[] objs)
			throws Throwable {
		System.out.println("进入代理逻辑方法了.......");
		Object obj=method.invoke(target, objs);
		System.out.println("出口");
		return obj;
	}
	
}
