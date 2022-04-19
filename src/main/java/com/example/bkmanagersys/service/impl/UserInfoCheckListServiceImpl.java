package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.UserInfoCheckListMapper;
import com.example.bkmanagersys.pojo.BookCheckList;
import com.example.bkmanagersys.pojo.UserInfoCheckList;
import com.example.bkmanagersys.service.UserInfoCheckListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/17 8:39
 * @version：1.0
 */
@Service("userInfoCheckListServiceImpl")
@Transactional
public class UserInfoCheckListServiceImpl extends ServiceImpl<UserInfoCheckListMapper, UserInfoCheckList> implements UserInfoCheckListService {
    @Override
    public List<UserInfoCheckList> getUserInfoCheckList() {
        QueryWrapper<UserInfoCheckList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",0);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserInfoCheckList> getRejectList() {
        QueryWrapper<UserInfoCheckList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",2);
        return baseMapper.selectList(queryWrapper);
    }

}
