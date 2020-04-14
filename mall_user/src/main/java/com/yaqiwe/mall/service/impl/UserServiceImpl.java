package com.yaqiwe.mall.service.impl;

import com.yaqiwe.mall.entity.User;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.reository.UserRepository;
import com.yaqiwe.mall.service.UserService;
import com.yaqiwe.mall.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:24
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Resource(name = "GetUserId")
    SnowflakeIdWorker getUserId;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    HttpServletRequest request;


    @Override
    public void registe(String userName,String password) {
        User user=userRepository.findByUserName(userName);
        if(user!=null){
            throw new MallException(MallEnums.USER_EXIST);
        }
        user=new User();
        user.setId(getUserId.nextId()+"");
        user.setUserName(userName);
        user.setRegdate(new Timestamp(new Date().getTime()));
        user.setPhoto("http://b-ssl.duitang.com/uploads/item/201704/10/20170410095843_SEvMy.thumb.700_0.jpeg");
        user.setPassword(encoder.encode(userName+password));
        userRepository.save(user);
    }

    @Override
    public User logIn(String userName, String password) {
        User user=userRepository.findByUserName(userName);
        if(user!=null){
            if(encoder.matches(userName+password,user.getPassword())){
                return user;
            }
        }
        throw new MallException(MallEnums.USER_LOGIN_ERROE);
    }

    @Override
    public User userInfo() {
        User user=userRepository.findById((String) request.getAttribute("claims_user")).get();
        return user;
    }
}
