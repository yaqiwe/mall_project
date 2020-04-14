package com.yaqiwe.mall.service;

import com.yaqiwe.mall.entity.Admin;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 19:54
 * @Version 1.0
 */
public interface AdminService {

    /**
     * 添加管理员
     * 必须拥有超级管理员角色
     * @param adminName
     * @param password
     */
    void registe(@Size(max = 16,min = 6,message = "请输入6-16位用户名") String adminName,
                 @Size(max = 24,min = 6,message = "请输入6-24位密码")  String password);

    /**
     * 管理员登录
     * @param adminName
     * @param password
     * @return
     */
    Admin login(@NotBlank(message = "用户名不能为空") String adminName,
                @NotBlank(message = "密码不能为空") String password);
}
