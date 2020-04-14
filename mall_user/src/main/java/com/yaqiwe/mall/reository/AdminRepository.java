package com.yaqiwe.mall.reository;

import com.yaqiwe.mall.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 19:52
 * @Version 1.0
 */
public interface AdminRepository extends JpaRepository<Admin,String> {

    Admin findByAdminName(String adminName);
}
