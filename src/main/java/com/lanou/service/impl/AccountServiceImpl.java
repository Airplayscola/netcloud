package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.mapper.AccountMapper;
import com.lanou.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    //查询所有
    public List<Account> findAll() {
        return accountMapper.findAll();
    }

    //添加
    public Integer insert(Account record) {
        return accountMapper.insert(record);
    }

    //分页
    public PageInfo<Account> getPageInfo(Integer pageNo, Integer pageSize) {
        return queryCostByPage(pageNo, pageSize);
    }

    public Integer delete(Integer accountId) {
        return accountMapper.deleteByPrimaryKey(accountId);
    }

    public Account selectByPrimaryKey(Integer accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    //修改
    public Integer update(Account account) {
        return accountMapper.updateByPrimaryKey(account);
    }

    //修改为删除状态
    public Integer updateByDelete(Account account) {
        return accountMapper.updateByDelete(account);
    }

    //修改为启用状态
    public Integer updateByStart(Account account) {
        return accountMapper.updateByStart(account);
    }

    //修改为暂停状态
    public Integer updateByPause(Account account) {
        return accountMapper.updateByPause(account);
    }

    public List<Account> selectByIdcardNo(Account account) {
        return accountMapper.selectByIdcardNo(account);
    }


    public PageInfo<Account> queryCostByPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 5 : pageSize;

        PageHelper.startPage(pageNo, pageSize);
        //获取全部的学员
        List<Account> accountList = accountMapper.findAll();
//        System.out.println(costList);

        //使用PageINfo对结果进行包装

        PageInfo<Account> pageInfo = new PageInfo<Account>(accountList);

//        System.out.println(pageInfo);
        return pageInfo;
    }
}
