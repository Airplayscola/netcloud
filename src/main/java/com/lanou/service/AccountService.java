package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;

import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
public interface AccountService {
    List<Account> findAll();
    //添加
    Integer insert(Account record);

    //分页
    PageInfo<Account> getPageInfo(Integer pageNo, Integer pageSize);

    //删除
    Integer delete(Integer accountId);
    //根据id查询
    Account selectByPrimaryKey(Integer accountId);
    //修改
    Integer update(Account account);

    //删除状态
    Integer updateByDelete(Account account);

    //更新暂停状态
    Integer updateByStart(Account account);

    //更新启用状态
    Integer updateByPause(Account account);

    //根据idcard查询
    List<Account> selectByIdcardNo(Account account);


}
