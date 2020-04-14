package com.yaqiwe.mall.service;

import com.yaqiwe.mall.entity.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:23
 * @Version 1.0
 */
@Validated
public interface UserService {

    /**
     * 用户注册
     * @param userName
     * @param password
     */
    void registe(@Size(max = 16,min = 6,message = "请输入6-16位用户名") String userName,
                 @Size(max = 24,min = 6,message = "请输入6-24位密码")  String password);

    /**
     * 用户登录验证
     * @param userName
     * @param password
     * @return
     */
    User logIn(@NotBlank(message = "用户名不能为空") String userName,
               @NotBlank(message = "密码不能为空") String password);

    /**
     * 获取当前用户的信息
     * @return
     */
    User userInfo();
}
