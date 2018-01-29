package com.ws.server;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.ws.test.HelloWorldService;

public class HelloWorldTest {
	public static void main(String[] args){
		JaxWsProxyFactoryBean  factory=new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWorldService.class);
		factory.setAddress("http://localhost:8080/hello?wsdl");
		HelloWorldService service=(HelloWorldService)factory.create();
		System.out.println("���������������ͻ���"+service.test1("����", "11111"));
	}
}
