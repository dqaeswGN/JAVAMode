package com.lean.ssm.chapter2.intercept;

import java.lang.reflect.Method;

public interface Interceptor {
	/**
	 * 
	 * @param proxy �������
	 * @param target ��ʵ����
	 * @param method ���з���
	 * @param args  ���з����Ĳ���
	 * @return
	 */
	public boolean before(Object proxy, Object target, Method method, Object[] args);

	public void around(Object proxy, Object target, Method method, Object[] args);

	public void after(Object proxy, Object target, Method method, Object[] args);

}
