package com.yaqiwe.mall.controller;

import com.yaqiwe.mall.dto.CommodityDto;
import com.yaqiwe.mall.entity.CommLabel;
import com.yaqiwe.mall.entity.Commodity;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.exception.MallException;
import com.yaqiwe.mall.service.CommLabelService;
import com.yaqiwe.mall.service.CommodityService;
import com.yaqiwe.mall.util.CheckAuthority;
import com.yaqiwe.mall.util.ResoultUtil;
import com.yaqiwe.mall.vo.CommodityVo;
import com.yaqiwe.mall.vo.Resoult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author yaqiwe
 * @Date 2020/4/16 16:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @Autowired
    CommLabelService labelService;

    @Autowired
    CheckAuthority checkAuthority;

    @PostMapping("/addCommodity")
    public Resoult addCommodity(@RequestBody @Validated CommodityDto dto){
        if(!checkAuthority.checkAdmin()){
            throw new MallException(MallEnums.NO_PERMISSION);
        }
        List<CommLabel> byId = labelService.findById(dto.getLabel());
        List<Integer> labelId=byId.stream().map(c->c.getId()).collect(Collectors.toList());
        Commodity commodity=new Commodity();
        BeanUtils.copyProperties(dto,commodity);
        commodity.setIcon(dto.getIconList());
        commodity.setLabel(labelId);
        commodityService.addCommodity(commodity);
        return ResoultUtil.success("添加商品成功");
    }

    @GetMapping("/getComBylabel")
    public Resoult getComByLabel(@RequestParam Integer page,@RequestParam Integer size,@RequestParam Integer LabelId){
        List<Commodity> commodityList=commodityService.getComByLabel(page,size,LabelId);
        List<CommodityVo> voList=new ArrayList<>();
        for (Commodity commodity : commodityList) {
            CommodityVo vo=new CommodityVo();
            BeanUtils.copyProperties(commodity,vo);
            vo.setIcon(commodity.getIcon()[0]);
            voList.add(vo);
        }
        return ResoultUtil.success(voList);
    }
}
