package com.yaqiwe.mall.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/18 20:16
 * @Version 1.0
 * 商品详情
 */
@Data
public class CommodityInfoVo {

    @Id
    private String id;

    /*商品名称*/
    private String commName;

    /*商品图片,用;,;分割*/
    private String[] iconList;

    /*商品库存*/
    private int stock;

    /*商品价格*/
    private BigDecimal price;

    /*运费*/
    private BigDecimal freight;

    /*商品详情*/
    private String details;

}
