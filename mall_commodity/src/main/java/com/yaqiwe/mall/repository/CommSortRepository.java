package com.yaqiwe.mall.repository;

import com.yaqiwe.mall.entity.CommSort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author yaqiwe
 * @Date 2020/4/15 14:18
 * @Version 1.0
 */
public interface CommSortRepository extends JpaRepository<CommSort, Integer> {
    void deleteCommSortById(Integer... sortId);
}
