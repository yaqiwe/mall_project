package com.yaqiwe.mall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author yaqiwe
 * @Date 2020/4/13 17:29
 * @Version 1.0
 * 数据格式类
 */
@Data
public class Resoult <T> {

    private String message;

    private Integer code;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;
}
