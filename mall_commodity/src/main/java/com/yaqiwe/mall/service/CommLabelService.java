package com.yaqiwe.mall.service;

import com.yaqiwe.mall.entity.CommLabel;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:23
 * @Version 1.0
 */
public interface CommLabelService {
    /**
     * 根据类别Id查询标签
     * @param sortId
     * @return
     */
    List<CommLabel> findBySortId(Integer sortId);
}
