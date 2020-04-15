package com.yaqiwe.mall.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:10
 * @Version 1.0
 * 商品类别表
 */
@Data
@Entity
@Table(name = "comm_sort")
public class CommSort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*类别名称*/
    private String sort;
}
