package com.yaqiwe.mall.controller;

import com.yaqiwe.mall.entity.CommLabel;
import com.yaqiwe.mall.entity.CommSort;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.service.CommLabelService;
import com.yaqiwe.mall.service.CommSortService;
import com.yaqiwe.mall.util.ResoultUtil;
import com.yaqiwe.mall.vo.Resoult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:20
 * @Version 1.0
 * 商品类别操作
 */
@RestController
@RequestMapping("/sort")
public class SortController {

    @Autowired
    CommSortService sortService;

    @Autowired
    CommLabelService labelService;

    @PostMapping("/addSort")
    public Resoult addSort(@RequestParam String sort){
        sortService.addSort(sort);
        return ResoultUtil.success("增加商品类别成功");
    }

    @DeleteMapping("/deleteSort/{sortId}")
    public Resoult deleteSort(@PathVariable Integer sortId){
        List<CommLabel> labels= labelService.findBySortId(sortId);
        if(labels.size()==0){
            sortService.deleteSort(sortId);
            return ResoultUtil.success("成功删除商品类别");
        }
        return ResoultUtil.error(MallEnums.LABEL_NOT_NULL);
    }

    @PutMapping("/update")
    public Resoult update(@RequestBody CommSort sort){
        sortService.update(sort.getId(),sort.getSort());
        return ResoultUtil.success("修改类别成功");
    }

    @GetMapping
    public Resoult findAll(){
        List<CommSort> sorts=sortService.findAll();
        return ResoultUtil.success(sorts);
    }
}
