package com.yaqiwe.mall.config;

import com.yaqiwe.mall.util.CheckAuthority;
import com.yaqiwe.mall.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 15:04
 * @Version 1.0
 *
 */
@Configuration
public class commodityConfig {

    /**
     * 生成商品Id
     * @return
     */
    @Bean(name = "commodityId")
    public SnowflakeIdWorker snowflakeIdWorker(){
        return new SnowflakeIdWorker(1,1);
    }
}
