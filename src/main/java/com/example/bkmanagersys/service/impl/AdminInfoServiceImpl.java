package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.AdminInfoMapper;
import com.example.bkmanagersys.pojo.AdminInfo;
import com.example.bkmanagersys.pojo.LoginForm;
import com.example.bkmanagersys.service.AdminInfoService;
import com.example.bkmanagersys.util.MD5;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/14 16:14
 * @version：1.0
 */
@Service("adminInfoServiceImpl")
@Transactional
public class AdminInfoServiceImpl extends ServiceImpl<AdminInfoMapper, AdminInfo> implements AdminInfoService {
    @Override
    public IPage<AdminInfo> getAdminsByOpr(Page<AdminInfo> pageParam, String adminName) {
        QueryWrapper<AdminInfo> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(adminName)) {
            queryWrapper.like("username",adminName);
        }
        queryWrapper.orderByDesc("id");

        Page<AdminInfo> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }


    @Override
    public AdminInfo login(LoginForm loginForm) {
        QueryWrapper<AdminInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",loginForm.getUsername());
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        AdminInfo admin = baseMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public AdminInfo getAdminById(Long userId) {
        QueryWrapper<AdminInfo> queryWrapper=new QueryWrapper<AdminInfo>();
        queryWrapper.eq("id",userId);
        return baseMapper.selectOne(queryWrapper);
    }







}
