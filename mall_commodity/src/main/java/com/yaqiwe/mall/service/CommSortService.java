package com.yaqiwe.mall.service;

import com.yaqiwe.mall.entity.CommSort;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:23
 * @Version 1.0
 */
@Validated
public interface CommSortService {
    /**
     * 添加商品类别
     * @param sort
     */
    void addSort(String sort);

    /**
     * 删除商品类别
     * @param sortId
     */
    void deleteSort(Integer sortId);

    /**
     * 修改标签
     * @param sortId
     * @param sort
     */
    void update(@NotNull(message = "类别Id不能为空") Integer sortId,
                @NotBlank(message = "类别名称不能为空") String sort);

    /**
     * 查询所有标签列表
     * 按照Id倒序
     * @return
     */
    List<CommSort> findAll();

    /**
     * 根据Id查询类别
     * @param sortId
     * @return
     */
    CommSort findById(Integer sortId);
}
