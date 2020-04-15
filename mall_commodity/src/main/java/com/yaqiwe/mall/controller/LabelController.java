package com.yaqiwe.mall.controller;

import com.yaqiwe.mall.entity.CommLabel;
import com.yaqiwe.mall.entity.CommSort;
import com.yaqiwe.mall.enums.MallEnums;
import com.yaqiwe.mall.service.CommLabelService;
import com.yaqiwe.mall.service.CommSortService;
import com.yaqiwe.mall.util.ResoultUtil;
import com.yaqiwe.mall.vo.LabelVo;
import com.yaqiwe.mall.vo.Resoult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 16:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    CommLabelService labelService;

    @Autowired
    CommSortService sortService;

    @PostMapping("/addLabel")
    public Resoult addLabel(@RequestBody CommLabel label){
        CommSort sort=sortService.findById(label.getSortId());
        if(sort==null){
            return ResoultUtil.error(MallEnums.SORT_IS_NULL);
        }
        labelService.addLabel(label.getSortId(),label.getLabel());
        return ResoultUtil.success("添加标签成功");
    }

    @GetMapping("/findAll")
    public Resoult findAll(){
        List<CommLabel> labels=labelService.findAll();
        List<CommSort> sorts = sortService.findAll();
        List<LabelVo> voList=new ArrayList<>();
        /**
         * sorts集合的id排列规则必须和labels的sortId的排列规则一样
         * 否则排序结果错误
         */
        int i=0,labelsSice=labels.size();
        for (CommSort sort : sorts) {
            LabelVo vo=new LabelVo(sort.getId(),sort.getSort());
            while (i < labelsSice) {
                CommLabel label=labels.get(i);
                //如果当前标签和类别匹配，则接下来几个标签可能都是该类别的标签
                if(label.getSortId().equals(sort.getId())){
                    vo.getLabelList().add(new LabelVo.LabelInfo(label.getId(),label.getLabel()));
                    i++;
                }else {
                    //如果当前的类别和标签不匹配则说明该类别所有标签已经组装完成
                    //跳出循环
                    break;
                }
            }
            voList.add(vo);
        }
        return ResoultUtil.success(voList);
    }

    @PutMapping("/update")
    public Resoult update(@RequestBody CommLabel label){
        CommSort sort=sortService.findById(label.getSortId());
        if(sort==null){
            return ResoultUtil.error(MallEnums.SORT_IS_NULL);
        }
        labelService.update(label.getSortId(),label.getLabel(),label.getId());
        return ResoultUtil.success("修改标签成功");
    }

    @DeleteMapping("/deleteLabel/{labelId}")
    public Resoult deleteLabel(@PathVariable Integer labelId){
        labelService.deleteLabel(labelId);
        return ResoultUtil.success("删除标签成功");
    }
}
