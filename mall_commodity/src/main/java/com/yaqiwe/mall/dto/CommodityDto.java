package com.yaqiwe.mall.dto;

import com.yaqiwe.mall.entity.Commodity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    /*商品图片*/
    @NotNull(message = "商品图片不能为空")
    private String[] iconList;

    /*商品库存*/
    private int stock;

    /*商品标签*/
    private List<Integer> label;

    /*商品价格*/
    @NotNull(message = "商品价格不能为空")
    private BigDecimal price;

    /*运费*/
    @NotNull(message = "运费不能为空")
    private BigDecimal freight;

    /*商品详情*/
    @NotBlank(message = "商品描述不能为空")
    private String details;

    public Commodity dotToCommodity(CommodityDto dto){
        Commodity commodity=new Commodity();
        BeanUtils.copyProperties(dto,commodity);
        commodity.setIcon(dto.getIconList());
        commodity.setLabel(dto.getLabel());
        return commodity;
    }
}
