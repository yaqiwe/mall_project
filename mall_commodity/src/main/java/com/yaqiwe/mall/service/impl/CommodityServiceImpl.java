package com.yaqiwe.mall.service.impl;

import com.yaqiwe.mall.entity.Commodity;
import com.yaqiwe.mall.repository.CommodityRepository;
import com.yaqiwe.mall.service.CommodityService;
import com.yaqiwe.mall.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author yaqiwe
 * @Date 2020/4/16 16:39
 * @Version 1.0
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityRepository commodityRepository;

    @Resource(name = "commodityId")
    SnowflakeIdWorker getId;


    @Override
    public void addCommodity(Commodity commodity) {
        commodity.setId(getId.nextId()+"");
        commodity.setType("1");
        commodityRepository.save(commodity);
    }

    @Override
    public List<Commodity> getComByLabel(Integer page, Integer size,Integer labelId) {
        List<Commodity> commodityList = commodityRepository.findByLabel("%"+labelId+";%",(page-1)*size,size);
        return commodityList;
    }
}
