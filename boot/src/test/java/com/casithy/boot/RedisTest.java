package com.casithy.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月18日 上午9:46:05
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class RedisTest {
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void setss() {
		System.out.println(redisTemplate.hasKey("first"));
		System.out.println(redisTemplate.hasKey("firsts"));
		System.out.println(redisTemplate.delete("firsts"));
		System.out.println(redisTemplate.delete("first"));
	}
}
 