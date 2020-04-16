//package com.yaqiwe.mall.util;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.util.List;
//
///**
// * @Author yaqiwe
// * @Date 2020/4/16 13:45
// * @Version 1.0
// */
//public class RedisUtil<T> {
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//
//    public void setRedis(List<T> o,String key) {
//        //将数据转换成JSON
//        String json = JSONObject.toJSONString(o);
//        //对象存放到redis中
//        redisTemplate.opsForValue().set(key, json);
//    }
//
//    public void getRedis(String key){
//        String json=redisTemplate.opsForValue().get(key);
//        List<T> o=JSONObject.parseArray(json,T.class);
//    }
//}
