package com.ssm.chapter15.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ssm.chapter15.aop")
public class AopConfig {
	@Bean
	public Pointout getPointout(){
		return new Pointout();
	}

}
