package com.yaqiwe.mall.service.impl;

import com.yaqiwe.mall.entity.CommLabel;
import com.yaqiwe.mall.repository.CommLabelRepository;
import com.yaqiwe.mall.service.CommLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 15:09
 * @Version 1.0
 */
@Service
public class CommLabelServiceImpl implements CommLabelService {

    @Autowired
    CommLabelRepository labelRepository;

    @Override
    public List<CommLabel> findBySortId(Integer sortId) {
        return labelRepository.findBySortId(sortId);
    }
}
