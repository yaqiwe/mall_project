package com.yaqiwe.mall.service;

import com.yaqiwe.mall.entity.Commodity;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/16 16:37
 * @Version 1.0
 */
@Validated
public interface CommodityService {

    /**
     * 添加商品
     * @param commodity
     */
    void addCommodity(Commodity commodity);

    /**
     * 按标签分页查询商品
     * @param page
     * @param size
     * @param labelId
     * @return
     */
    List<Commodity> getComByLabel(@NotNull(message = "页数不能为空") Integer page,
                                  @NotNull(message = "每页数据数不能为空") Integer size,
                                  @NotNull(message = "标签Id不能为空")  Integer labelId);
}
