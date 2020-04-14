package com.yaqiwe.mall.controller;

import com.yaqiwe.mall.entity.User;
import com.yaqiwe.mall.service.UserService;
import com.yaqiwe.mall.util.JwtUtil;
import com.yaqiwe.mall.util.ResoultUtil;
import com.yaqiwe.mall.vo.Resoult;
import com.yaqiwe.mall.vo.LogInUserVo;
import com.yaqiwe.mall.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:25
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/registe")
    public Resoult registe(@RequestParam String userName,@RequestParam String password){
        userService.registe(userName,password);
        return ResoultUtil.success("注册成功");
    }

    @PostMapping("/login")
    public Resoult logIn(@RequestParam String userName,@RequestParam String password){
        User user= userService.logIn(userName,password);
        LogInUserVo vo=new LogInUserVo();
        BeanUtils.copyProperties(user,vo);
        vo.setToken(jwtUtil.createJWT(vo.getId(),vo.getUserName(),"user"));
        return ResoultUtil.success(vo);
    }

    @GetMapping("/userInfo")
    public Resoult userInfo(){
        User user=userService.userInfo();
        UserVo vo=new UserVo();
        BeanUtils.copyProperties(user,vo);
        return ResoultUtil.success(vo);
    }
}
