package com.yaqiwe.mall.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:58
 * @Version 1.0
 * 检验是否有权限的工具类
 */
@Component
public class CheckAuthority {

    @Autowired
    HttpServletRequest request;

    /**
     * 检查是否有管理权限
     * @return
     */
    public boolean checkAdmin(){
        String userId= (String) request.getAttribute("claims_admin");
        if(!StringUtils.isEmpty(userId)){
            return true;
        }
        userId= (String) request.getAttribute("claims_super_admin");
        if(!StringUtils.isEmpty(userId)){
            return true;
        }
        return false;
    }

//    /**
//     * 将检查权限类工具类加入容器中
//     * @return
//     */
//    @Bean
//    public CheckAuthority checkAuthority(){
//        return new CheckAuthority();
//    }

}
