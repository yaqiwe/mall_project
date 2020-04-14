package com.yaqiwe.mall.exception;

import com.yaqiwe.mall.enums.MallEnums;
import lombok.Getter;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 18:10
 * @Version 1.0
 */
@Getter
public class MallException extends RuntimeException {

    private Integer code;

    public MallException(MallEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }

    public MallException(String message) {
        super(message);
        this.code = 10004;
    }
}
