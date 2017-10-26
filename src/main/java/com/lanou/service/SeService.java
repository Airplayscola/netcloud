package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Service;

import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
public interface SeService {

    List<Service> findAll();

    //分页
    PageInfo<Service> getPageInfo(Integer pageNo, Integer pageSize);

    //添加
    int insertService(Service service);

    //根据idcardNo查找
    Account selectByIdCard(String idcard);

    //删除状态
    Integer updateByDelete(Service service);

    //更新暂停状态
    Integer updateByStart(Service service);

    //更新启用状态
    Integer updateByPause(Service service);

    //根据id查找
    Service selectBySerPrimaryKey(Integer serviceId);
}
