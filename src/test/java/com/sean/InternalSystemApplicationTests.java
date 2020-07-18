package com.sean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.sean.service.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InternalSystemApplicationTests {

//	@Autowired
//	private RedisService redisService;
	
	@Test
	public void testRedis() {
		System.out.println("TEST PASS");
//		redisService.set("key1", "redisTest");
//		System.out.println(redisService.get("key1"));
	}
	
}
