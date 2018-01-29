package com.ws.test.impl;

import javax.jws.WebService;

import com.ws.test.HelloWorldService;


@WebService(endpointInterface="com.ws.test.HelloWorldService",serviceName="Hello_Webservice")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String test1(String name, String pwd) {
		System.out.println("hello name="+name+"pwd="+pwd);
		return "hello name="+name+"pwd="+pwd;
	}

}
