package com.yaqiwe.mall.reository;

import com.yaqiwe.mall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:21
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User,String> {

    User findByUserName(String userName);
}
