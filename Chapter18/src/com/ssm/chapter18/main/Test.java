package com.ssm.chapter18.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
		
		String key="hash";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("f1", "val1");
		map.put("f2", "val2");
		// �൱��hmset����
		redisTemplate.opsForHash().putAll(key, map);
		// �൱��hset����
		redisTemplate.opsForHash().put(key, "f3", "6");
		
		Object value = redisTemplate.opsForHash().get(key, "f2");
		System.out.println(value);
		
	}

}