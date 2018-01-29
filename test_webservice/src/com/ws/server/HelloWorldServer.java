package com.ws.server;
import javax.xml.ws.Endpoint;

import com.ws.test.HelloWorldService;
import com.ws.test.impl.HelloWorldServiceImpl;

public class HelloWorldServer {
	public static void main(String[] args){
		System.out.println("server is starting");
		HelloWorldService  server=new HelloWorldServiceImpl();
		String url="http://localhost:8080/hello";
		Endpoint.publish(url,server);
		System.out.println("server is started");
	}
}
