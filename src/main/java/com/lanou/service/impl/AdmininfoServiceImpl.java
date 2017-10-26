package com.lanou.service.impl;

import com.lanou.bean.AdminInfo;
import com.lanou.mapper.AdminInfoMapper;
import com.lanou.service.AdminInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/20.
 */
@Service
public class AdmininfoServiceImpl implements AdminInfoService{

    @Resource
    private AdminInfoMapper adminInfoMapper;

    public AdminInfo select(AdminInfo adminInfo) {
        return adminInfoMapper.select(adminInfo);
    }
}
