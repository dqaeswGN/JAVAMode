package com.lean.ssm.chapter2.intercept;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {
	
	// ��ʵ����
	private Object target = null;
	private String interceptorClass = null;//������ȫ�޶���
	
	public InterceptorJdkProxy(Object target, String interceptorClass) {
		this.target=target;
		this.interceptorClass=interceptorClass;
	}
	public static Object bind(Object target, String interceptorClass){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), new InterceptorJdkProxy(target,interceptorClass));
	}
	
	
	/**
     * ͨ������������÷��������Ƚ����������.
     *
     * @param proxy --��������
     * @param method --�����������÷���
     * @param args -- �����Ĳ���
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (interceptorClass == null) {
            //û��������������ֱ�ӷ���ԭ�з���
            return method.invoke(target, args);
        }
		Object result = null;
		Interceptor interceptor=(Interceptor)Class.forName(interceptorClass).newInstance();
		if(interceptor.before(proxy, target, method, args)){
			result=method.invoke(target, args);
		}else{
			 interceptor.around(proxy, target, method, args);
		}
		//���ú��÷���
        interceptor.after(proxy, target, method, args);
		return result;
	}

}