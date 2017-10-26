package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Service;
import com.lanou.mapper.AccountMapper;
import com.lanou.mapper.ServiceMapper;
import com.lanou.service.SeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@org.springframework.stereotype.Service
public class SeServiceImpl implements SeService {

    @Resource
    private ServiceMapper serviceMapper;
    @Resource
    private AccountMapper accountMapper;

    public List<Service> findAll() {
        return serviceMapper.findAll();
    }

    public PageInfo<Service> getPageInfo(Integer pageNo, Integer pageSize) {
        return queryCostByPage(pageNo, pageSize);
    }

    public int insertService(Service service) {
        return serviceMapper.insert(service);
    }

    public Account selectByIdCard(String idcard) {
        return accountMapper.selectByIdCard(idcard);
    }

    public Integer updateByDelete(Service service) {
        return serviceMapper.updateByDelete(service);
    }

    public Integer updateByStart(Service service) {
        return serviceMapper.updateByStart(service);
    }

    public Integer updateByPause(Service service) {
        return serviceMapper.updateByPause(service);
    }

    public Service selectBySerPrimaryKey(Integer serviceId) {
        return serviceMapper.selectByPrimaryKey(serviceId);
    }

    public PageInfo<Service> queryCostByPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);
        //获取全部的学员
        List<Service> serviceList = serviceMapper.findAll();
//        System.out.println(costList);

        //使用PageINfo对结果进行包装

        PageInfo<Service> pageInfo = new PageInfo<Service>(serviceList);

//        System.out.println(pageInfo);
        return pageInfo;
    }

}
