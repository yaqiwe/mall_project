package com.yaqiwe.mall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @Author yaqiwe
 * @Date 2020/4/16 21:19
 * @Version 1.0
 */
@Data
public class CommodityVo {

    @JsonProperty("commodityId")
    private String id;

    /*商品名称*/
    private String commName;

    /*商品图片*/
    private String icon;

    /*商品价格*/
    private BigDecimal price;
}
