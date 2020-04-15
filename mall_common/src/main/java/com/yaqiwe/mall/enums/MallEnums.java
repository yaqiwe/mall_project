package com.yaqiwe.mall.enums;

import lombok.Getter;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:36
 * @Version 1.0
 * 状态码枚举类
 */

@Getter
public enum MallEnums {
    UNKNOWN_ERROR(10001,"未知错误"),
    PARAMETER_ERROR(10002,"参数校验错误"),
    PARAMETER_NOT_PRESENT(10003,"请传递相应的参数"),
    NOT_SUPPORTED(10004,"请求方式错误"),
    NO_PERMISSION(10005,"权限不足"),
    TYPE_MISMATCH(10006,"参数类型错误"),

    USER_EXIST(20001,"用户账号已存在"),
    USER_LOGIN_ERROE(20002,"用户名或密码错误"),
    ADMIN_EXIST(20003,"管理员账户已存在"),

    LABEL_NOT_NULL(30001,"请删除类别下所有标签后重试"),
    SORT_IS_NULL(30002,"类别不存在"),
    ;

    private Integer code;
    private String msg;

    MallEnums(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
