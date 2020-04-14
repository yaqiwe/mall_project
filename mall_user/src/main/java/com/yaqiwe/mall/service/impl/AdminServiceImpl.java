package com.yaqiwe.mall.service.impl;

import com.yaqiwe.mall.entity.Admin;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.reository.AdminRepository;
import com.yaqiwe.mall.service.AdminService;
import com.yaqiwe.mall.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 19:54
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    HttpServletRequest request;

    @Resource(name = "GetUserId")
    SnowflakeIdWorker getUserId;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public void registe(String adminName, String password) {
        String adminId = (String) request.getAttribute("claims_super_admin");
        if(adminId==null || adminId.isEmpty()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        Admin admin=adminRepository.findByAdminName(adminName);
        if(admin!=null){
            throw new MallException(MallEnums.ADMIN_EXIST);
        }
        admin=new Admin();
        admin.setAdminName(adminName);
        admin.setId(getUserId.nextId()+"");
        admin.setPassword(encoder.encode(adminName+password));
        admin.setRoles("admin");
        adminRepository.save(admin);
    }

    @Override
    public Admin login(String adminName, String password) {
        Admin admin=adminRepository.findByAdminName(adminName);
        if(admin!=null){
            boolean matches = encoder.matches(adminName + password, admin.getPassword());
            if(matches){
                return admin;
            }
        }
        throw new MallException(MallEnums.USER_LOGIN_ERROE);
    }

}
