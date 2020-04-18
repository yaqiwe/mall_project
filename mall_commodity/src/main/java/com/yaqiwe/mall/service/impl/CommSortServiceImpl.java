package com.yaqiwe.mall.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yaqiwe.mall.entity.CommSort;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.repository.CommSortRepository;
import com.yaqiwe.mall.service.CommSortService;
import com.yaqiwe.mall.util.CheckAuthority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:44
 * @Version 1.0
 */
@Service
@Slf4j
public class CommSortServiceImpl implements CommSortService {
    @Autowired
    CommSortRepository sortRepository;

    @Autowired
    CheckAuthority checkAuthority;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    private final String SortRedis="SortList";

    @Override
    public void addSort(String sort) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        CommSort commSort=new CommSort();
        commSort.setSort(sort);
        sortRepository.save(commSort);
        redisTemplate.delete(SortRedis);
    }

    @Override
    public void deleteSort(Integer sortId) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        sortRepository.deleteById(sortId);
        redisTemplate.delete(SortRedis);
    }

    @Override
    public void update(Integer sortId, String sort) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
//        log.info("CommSortServiceImpl update sortId:{}  sort:{}",sortId,sort);
        CommSort commSort=new CommSort();
        commSort.setId(sortId);
        commSort.setSort(sort);
        sortRepository.save(commSort);
        redisTemplate.delete(SortRedis);
    }

    @Override
    public List<CommSort> findAll() {
        String json=redisTemplate.opsForValue().get(SortRedis);
        if(!StringUtils.isEmpty(json)){
            List<CommSort> sorts=JSONObject.parseArray(json,CommSort.class);
            return sorts;
        }else {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            List<CommSort> sorts = sortRepository.findAll(sort);
            json = JSONObject.toJSONString(sorts);
            redisTemplate.opsForValue().set(SortRedis,json,3, TimeUnit.HOURS);
            return sorts;
        }
    }

    @Override
    public CommSort findById(Integer sortId) {
        Optional<CommSort> byId = sortRepository.findById(sortId);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }


}
