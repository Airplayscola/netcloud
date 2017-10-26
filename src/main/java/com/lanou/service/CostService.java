package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public interface CostService {

    List<Cost> findAll();

    Integer insert(Cost record);
    Integer delete(Integer costId);

    Cost findById(Integer costId);

    Integer update(Cost cost);
    Integer updateWithStatus(Cost cost);
    Integer updateWithStartime(Integer costId);
    Cost selectById(Integer costId);
    List<Cost> findWithPageInfo(Integer pageNo,Integer pageSize);
    PageInfo<Cost> getPageInfo(Integer pageNo,Integer pageSize);
    List<Cost> selectByBaseCose(Integer baseCost);

}
