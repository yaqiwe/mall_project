package com.yaqiwe.mall.service;

import com.yaqiwe.mall.entity.CommLabel;
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
public interface CommLabelService {
    /**
     * 根据类别Id查询标签
     * @param sortId
     * @return
     */
    List<CommLabel> findBySortId(Integer sortId);

    /**
     * 添加标签
     * @param sortId
     * @param label
     */
    void addLabel(@NotNull(message = "类别Id不能为空") Integer sortId,
                  @NotBlank(message = "标签名称不能为空") String label);

    /**
     * 查询所有标签
     * 并按照sortId倒序查询
     * @return
     */
    List<CommLabel> findAll();

    /**
     * 修改标签信息
     * @param sortId
     * @param label
     */
    void update(@NotNull(message = "类别Id不能为空") Integer sortId,
                @NotBlank(message = "标签名称不能为空") String label,
                @NotNull(message = "标签Id不能为空")Integer labelId);

    /**
     * 删除标签
     * @param labelId
     */
    void deleteLabel(Integer labelId);

    /**
     * 根据标签Id查询标签
     * @param id
     * @return
     */
    List<CommLabel> findById(List<Integer> id);
}
