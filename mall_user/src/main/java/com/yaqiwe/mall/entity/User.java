package com.yaqiwe.mall.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 16:50
 * @Version 1.0
 */
@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private String Id;

    /*用户名*/
    private String userName;

    /*密码*/
    private String password;

    /*昵称*/
    private String nickName;

    /*注册日期*/
    private Timestamp regdate;

    /*修改日期*/
    private Timestamp updateTime;

    /*性别*/
    private String sex;

    /*生日*/
    private Timestamp birthday;

    /*头像*/
    private String photo;
}
