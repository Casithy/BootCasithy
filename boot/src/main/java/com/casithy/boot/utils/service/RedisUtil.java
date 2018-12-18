package com.casithy.boot.utils.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月18日 上午9:46:05
 *
 */
@Component
public class RedisUtil {
	
	@Autowired
	private static RedisTemplate redisTemplate;
	
	public static void set(Object key, Object value,Long timeout) {
		redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MINUTES);
	}
	
	public static Object get(Object key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	public static Long getTimeout(Object key) {
		return redisTemplate.getExpire(key, TimeUnit.MINUTES);
	}
	
	public static boolean hasKey(Object key) {
		return redisTemplate.hasKey(key);
	}
}
 