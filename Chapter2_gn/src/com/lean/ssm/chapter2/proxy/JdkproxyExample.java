package com.lean.ssm.chapter2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JdkproxyExample implements InvocationHandler {
	
	// ��ʵ����
	private Object target = null;
		
	/**
	* ��������������ʵ����Ĵ����ϵ�������ش������
	* 
	* @param target��ʵ����
	* @return �������
	*/
	/**
	 * Object java.lang.reflect.Proxy.newProxyInstance(ClassLoader loader, 
	 * 												   Class<?>[] interfaces, 
	 * 												   InvocationHandler h) 
	 * 												throws IllegalArgumentException
	 * loader - �����������������
	 * interfaces - ������Ҫʵ�ֵĽӿ��б�
	 * h - ָ�ɷ������õĵ��ô������ 
	 */
	public Object bind(Object target) {
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	
	/**
	 * �������߼�
	 * 
	 * @param proxy
	 *            --�������
	 * @param method
	 *            --��ǰ���ȷ���
	 * @param args
	 *            --��ǰ��������
	 * @return ����������
	 * @throws Throwable
	 *             �쳣
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("��������߼�����");
		System.out.println("�ڵ�����ʵ����֮ǰ�ķ���");
		Object object=method.invoke(target, args);
		System.out.println("�ڵ�����ʵ����֮��ķ���");
		return object;
	}


}
