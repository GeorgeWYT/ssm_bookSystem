package com.flight.hisen.dao;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * 静态注入中间类
 * 完成RedisCache.jedisConnectionFactory的静态注入
 */
public class RedisCacheTransfer {

    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
