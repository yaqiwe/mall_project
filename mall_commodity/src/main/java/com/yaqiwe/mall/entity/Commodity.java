package com.yaqiwe.mall.entity;

import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import lombok.Data;
import sun.security.util.ArrayUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "commodity")
public class Commodity {
    @Id
    private String id;

    /*商品名称*/
    private String commName;

    /*商品图片,用;,;分割*/
    private String icon;

    /*商品库存*/
    private int stock;

    /*商品标签,用;分割*/
    private String label;

    /*商品价格*/
    private BigDecimal price;

    /*运费*/
    private BigDecimal freight;

    /*商品详情*/
    private String details;

    /*商品状态1上架0下架*/
    private String type="1";

    public void setIcon(String... icons) {
        if (icons.length!=3){
            throw new MallException(MallEnums.COMMODITY_ICON_ERROR);
        }
        this.icon=listToString(icons);
    }

    public String[] getIcon() {
        return icon.split(";,;");
    }


    private String listToString(String... strings){
        String re="";
        for (String s : strings) {
            re+=s+";,;";
        }
        /*切除掉最后得分隔符*/
        re=re.substring(0,re.length()-";,;".length());
        return re;
    }

    public void setLabel(List<Integer> labels) {
        this.label = "";
        for (Integer s : labels) {
            this.label+=s+";";
        }
    }

    public void setLabel(String labels) {
        this.label = labels;
    }

}
