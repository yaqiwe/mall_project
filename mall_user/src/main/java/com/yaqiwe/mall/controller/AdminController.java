package com.yaqiwe.mall.controller;

import com.yaqiwe.mall.entity.Admin;
import com.yaqiwe.mall.service.AdminService;
import com.yaqiwe.mall.util.JwtUtil;
import com.yaqiwe.mall.util.ResoultUtil;
import com.yaqiwe.mall.vo.Resoult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 19:53
 * @Version 1.0
 * 管理员操作
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/registe")
    public Resoult registe(@RequestParam String adminName,@RequestParam String password){
        adminService.registe(adminName,password);
        return ResoultUtil.success("添加管理员成功");
    }

    @PostMapping("/login")
    public Resoult login(@RequestBody Admin user){
        Admin admin= adminService.login(user.getAdminName(),user.getPassword());
        String token= jwtUtil.createJWT(admin.getId(),admin.getAdminName(),admin.getRoles());
        Map<String,Object> amdinInfo=new HashMap<>();
        amdinInfo.put("adminName",admin.getAdminName());
        amdinInfo.put("adminId",admin.getId());
        amdinInfo.put("Roles",admin.getRoles());
        amdinInfo.put("token",token);
        return ResoultUtil.success(amdinInfo);
    }
}
