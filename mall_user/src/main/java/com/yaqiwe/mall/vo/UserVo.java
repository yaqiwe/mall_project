package com.yaqiwe.mall.vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author yaqiwe
 * @Date 2020/4/14 16:09
 * @Version 1.0
 * 登录成功返回前端的用户数据
 */
@Data
public class UserVo {

    private String Id;

    /*用户名*/
    private String userName;

    /*昵称*/
    private String nickName;

    /*注册日期*/
    private Timestamp regdate;

    /*性别*/
    private String sex;

    /*生日*/
    private Timestamp birthday;

    /*头像*/
    private String photo;

}
