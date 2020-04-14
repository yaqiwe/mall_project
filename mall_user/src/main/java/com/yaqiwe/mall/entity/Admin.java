package com.yaqiwe.mall.entity;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 19:42
 * @Version 1.0
 * 管理员表
 */
@Entity
@Table(name = "admin")
@Data
public class Admin {
    @Id
    private String id;

    /*管理员账户*/
    private String adminName;

    /*密码*/
    private String password;

    /*管理员角色*/
    private String roles;
}
