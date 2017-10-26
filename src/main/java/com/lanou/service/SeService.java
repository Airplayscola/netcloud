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
    Account selectByIdCard(Integer idcard);
}
