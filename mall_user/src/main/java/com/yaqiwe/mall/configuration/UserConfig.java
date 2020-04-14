package com.yaqiwe.mall.configuration;

import com.yaqiwe.mall.util.JwtUtil;
import com.yaqiwe.mall.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:52
 * @Version 1.0
 */
@Configuration
public class UserConfig {

    /**
     * 将生成用户Id的算法加入到容器中
     * @return
     */
    @Bean(name = "GetUserId")
    public SnowflakeIdWorker snowflakeUser(){
        return new SnowflakeIdWorker(1,1);
    }

    /**
     * 加密密码的加密算法
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
