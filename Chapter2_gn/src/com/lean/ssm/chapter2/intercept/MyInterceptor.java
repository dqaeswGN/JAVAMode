package com.lean.ssm.chapter2.intercept;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {

	@Override
	public boolean before(Object proxy, Object target, Method method,
			Object[] args) {
		System.err.println("���䷽��ǰ�߼�");
		return true;
	}

	@Override
	public void around(Object proxy, Object target, Method method, Object[] args) {
		System.err.println("ȡ���˱���������ķ���");

	}

	@Override
	public void after(Object proxy, Object target, Method method, Object[] args) {
		System.err.println("���䷽�����߼���");

	}

}