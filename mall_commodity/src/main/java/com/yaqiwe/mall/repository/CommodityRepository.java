package com.yaqiwe.mall.repository;

import com.yaqiwe.mall.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author yaqiwe
 * @Date 2020/4/16 16:24
 * @Version 1.0
 */
public interface CommodityRepository extends JpaRepository<Commodity,String> {

    @Query(nativeQuery = true,value = "select * FROM commodity WHERE label LIKE ? LIMIT ?,? ")
    List<Commodity> findByLabel(String laabeId, Integer startLimit, Integer endLimit);
}