package com.yaqiwe.mall.entity;

import lombok.Data;
import org.omg.CORBA.INTERNAL;

import javax.persistence.*;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:15
 * @Version 1.0
 * 商品标签表
 */
@Entity
@Data
@Table(name = "comm_label")
public class CommLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*标签所属类别ID*/
    private Integer sortId;

    /*标签名称*/
    private String label;
}
