package com.ws.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public interface HelloWorldService {
	
	@WebMethod
	public String test1(@WebParam(name="name")String name,@WebParam(name="pwd")String pwd);

}
