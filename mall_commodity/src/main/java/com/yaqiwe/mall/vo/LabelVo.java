package com.yaqiwe.mall.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 17:26
 * @Version 1.0
 * 标签返回格式
 */
@Data
public class LabelVo implements Serializable {

    /*类别Id*/
    @JsonProperty("sortId")
    private Integer id;

    /*类别名称*/
    @JsonProperty("sortName")
    private String sort;

    private List<LabelInfo> labelList;

    public LabelVo(Integer id, String sort) {
        this.id = id;
        this.sort = sort;
        labelList=new ArrayList<>();
    }

    @Data
    public static class LabelInfo{
        /*标签所属类别ID*/
        @JsonProperty("labelId")
        private Integer id;

        /*标签名称*/
        @JsonProperty("labelIName")
        private String label;

        public LabelInfo(Integer id, String label) {
            this.id = id;
            this.label = label;
        }
    }

}
