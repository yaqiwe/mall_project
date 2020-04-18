package com.yaqiwe.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yaqiwe.mall.entity.CommLabel;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.repository.CommLabelRepository;
import com.yaqiwe.mall.service.CommLabelService;
import com.yaqiwe.mall.util.CheckAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 15:09
 * @Version 1.0
 */
@Service
public class CommLabelServiceImpl implements CommLabelService {

    @Autowired
    CommLabelRepository labelRepository;

    @Autowired
    CheckAuthority checkAuthority;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    private final String LabekRedis="LabelList";

    @Override
    public List<CommLabel> findBySortId(Integer sortId) {
        return labelRepository.findBySortId(sortId);
    }

    @Override
    public void addLabel(Integer sortId, String label) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        CommLabel commLabel=new CommLabel();
        commLabel.setLabel(label);
        commLabel.setSortId(sortId);
        labelRepository.save(commLabel);
        redisTemplate.delete(LabekRedis);
    }

    @Override
    public List<CommLabel> findAll() {
        String json=redisTemplate.opsForValue().get(LabekRedis);
        if(!StringUtils.isEmpty(json)){
            List<CommLabel> labels=JSONObject.parseArray(json,CommLabel.class);
            return labels;
        }else {
            Sort sort = Sort.by(Sort.Direction.DESC, "sortId");
            List<CommLabel> labels = labelRepository.findAll(sort);
            json = JSONObject.toJSONString(labels);
            redisTemplate.opsForValue().set(LabekRedis,json,3, TimeUnit.HOURS);
            return labels;
        }
    }

    @Override
    public void update(Integer sortId,String label,Integer labelId) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        CommLabel commLabel=new CommLabel();
        commLabel.setId(labelId);
        commLabel.setSortId(sortId);
        commLabel.setLabel(label);
        labelRepository.save(commLabel);
        redisTemplate.delete(LabekRedis);
    }

    @Override
    public void deleteLabel(Integer labelId) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        labelRepository.deleteById(labelId);
        redisTemplate.delete(LabekRedis);
    }

    @Override
    public List<CommLabel> findById(List<Integer> id) {
        return labelRepository.findByIdIn(id);
    }

}
