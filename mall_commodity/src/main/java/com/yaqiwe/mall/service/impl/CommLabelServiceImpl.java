package com.yaqiwe.mall.service.impl;

import com.yaqiwe.mall.entity.CommLabel;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.repository.CommLabelRepository;
import com.yaqiwe.mall.service.CommLabelService;
import com.yaqiwe.mall.util.CheckAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @Autowired
    CheckAuthority checkAuthority;

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
    }

    @Override
    public List<CommLabel> findAll() {
        Sort sort=Sort.by(Sort.Direction.DESC,"sortId");
        List<CommLabel> labels = labelRepository.findAll(sort);
        return labels;
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
    }

    @Override
    public void deleteLabel(Integer labelId) {
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        labelRepository.deleteById(labelId);
    }

}
