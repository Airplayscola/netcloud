package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Cost;
import com.lanou.mapper.CostMapper;
import com.lanou.service.CostService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
@Service
public class CostServiceImpl implements CostService {

    @Resource
    CostMapper costMapper;

    public List<Cost> findAll() {
        return costMapper.findAll();
    }

    public Integer insert(Cost record) {

        return costMapper.insert(record);
    }

    public Integer delete(Integer costId) {
        return costMapper.deleteByPrimaryKey(costId);
    }

    public Cost findById(Integer costId) {
        return costMapper.selectByPrimaryKey(costId);
    }

    public Integer update(Cost cost) {
        return costMapper.updateByPrimaryKey(cost);
    }

    public Integer updateWithStatus(Cost cost) {
        return costMapper.updateWithStatus(cost);
    }

    public Integer updateWithStartime(Integer costId) {
        return costMapper.updateWithStartTime(costId);
    }

    public Cost selectById(Integer costId) {
        return costMapper.selectByPrimaryKey(costId);
    }

    public List<Cost> selectByBaseCose(Integer baseCost) {
        return costMapper.selectByBaseCost(baseCost);
    }


    public List<Cost> findWithPageInfo(Integer pageNo, Integer pageSize) {

        //目标:获取pageInfo对象
        PageInfo<Cost> pageInfo = queryCostByPage(pageNo, pageSize);
        return pageInfo.getList();
    }


    //得到每页
    public PageInfo<Cost> getPageInfo(Integer pageNo, Integer pageSize) {
//        System.out.println(pageNo);
//        System.out.println(pageSize);
        return queryCostByPage(pageNo, pageSize);
    }

    public PageInfo<Cost> queryCostByPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);
        //获取全部的学员
        List<Cost> costList = costMapper.findAll();
//        System.out.println(costList);

        //使用PageINfo对结果进行包装

        PageInfo<Cost> pageInfo = new PageInfo<Cost>(costList);

//        System.out.println(pageInfo);
        return pageInfo;
    }


}
