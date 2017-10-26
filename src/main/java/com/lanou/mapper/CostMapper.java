package com.lanou.mapper;

import com.lanou.bean.Cost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostMapper {
    int deleteByPrimaryKey(Integer costId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> findAll();

    int updateWithStatus(Cost record);

    int updateWithStartTime(Integer costId);

    List<Cost> selectByBaseCost(@Param("baseCost") Integer baseCost);
}