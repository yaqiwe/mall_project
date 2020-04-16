package com.yaqiwe.mall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 20:19
 * @Version 1.0
 * redis序列化配置
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisTemplate<String, Object> redisdDto() {
        RedisTemplate<String, Object> redisT = new RedisTemplate<>();
        StringRedisSerializer strRedis = new StringRedisSerializer();
        //设置可以序列化任何对象
        redisT.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisT.setKeySerializer(strRedis);
        redisT.setHashKeySerializer(strRedis);
        redisT.setHashValueSerializer(strRedis);
        redisT.setConnectionFactory(redisConnectionFactory);
        return redisT;
    }
}
