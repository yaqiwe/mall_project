package com.yaqiwe.mall.config;

import com.yaqiwe.mall.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 16:51
 * @Version 1.0
 * 登录验证的配置类
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    JwtInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        List<String> PathList=new ArrayList<>();
        PathList.add("/user/login");  //登录
        PathList.add("/user/registe");    //注册
        PathList.add("/admin/login");    //管理员登录
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(PathList);
    }
}
