package com.jshoperx.redis.service.impl;

import com.jshoperx.redis.dao.RedisBaseTDao;
import com.jshoperx.redis.service.RedisBaseTService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Service("redisBaseTService")
@Scope("prototype")
public class RedisBaseTServiceImpl<T> implements RedisBaseTService<T> {
	@Resource
	private RedisBaseTDao<T> redisBaseTDao;
	
	@Override
	public void put(String key, T t, Class<T> cls) {
		redisBaseTDao.put(key, t, cls);
		
	}

	@Override
	public T get(String key, Class<T> cls) {
		return redisBaseTDao.get(key, cls);
	}

	@Override
	public void put(String key, T t, Class<T> cls, long timeout, TimeUnit timeUnit) {
		redisBaseTDao.put(key, t, cls, timeout, timeUnit);
	}

	@Override
	public void delete(String key) {
		redisBaseTDao.delete(key);
	}

	@Override
	public void delete(List<String> keys) {
		redisBaseTDao.delete(keys);
	}

}
