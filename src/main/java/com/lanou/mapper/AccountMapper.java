package com.lanou.mapper;

import com.lanou.bean.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    //添加
    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

//    Account selectIdCardById(@Param("accountId")Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    int updateByDelete(Account record);
    int updateByStart(Account record);
    int updateByPause(Account record);

   List <Account> selectByIdcardNo(Account record);
    Account selectByIdCard(@Param("idcard")Integer idcard);

    List<Account> findAll();
}