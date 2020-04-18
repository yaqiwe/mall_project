package com.yaqiwe.mall.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/16 16:04
 * @Version 1.0
 * 商品信息表
 */
@Data
public class CommodityDto {

    /*商品名称*/
    @NotBlank(message = "商品名称不能为空")
    private String commName;

    /*商品图片,用;,;分割*/
    private String[] iconList;

    /*商品库存*/
    private int stock;

    /*商品标签,用;分割*/
    private Integer[] label;

    /*商品价格*/
    private BigDecimal price;

    /*运费*/
    private BigDecimal freight;

    /*商品详情*/
    @NotBlank(message = "商品描述不能为空")
    private String details;

}
