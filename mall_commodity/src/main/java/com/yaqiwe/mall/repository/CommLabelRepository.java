package com.yaqiwe.mall.repository;

import com.yaqiwe.mall.entity.CommLabel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:17
 * @Version 1.0
 */
public interface CommLabelRepository extends JpaRepository<CommLabel,Integer> {

    List<CommLabel> findBySortId(Integer sortId);

    List<CommLabel> findByIdIn(Integer... id);
}
