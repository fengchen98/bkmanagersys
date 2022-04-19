package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.UserInfoMapper;
import com.example.bkmanagersys.pojo.Book;
import com.example.bkmanagersys.pojo.UserInfo;
import com.example.bkmanagersys.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/17 8:38
 * @version：1.0
 */
@Service("userInfoServiceImpl")
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Override
    public List<UserInfo> getUserInfoList() {
        return baseMapper.selectList(null);
    }

    @Override
    public IPage<UserInfo> getUserInfoByOpr(Page<UserInfo> pageParam, String userid, String usertype, String usertype1, String usertype2) {
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(userid)) {
            queryWrapper.like("userid",userid);
        }
        if (!StringUtils.isEmpty(usertype)) {
            queryWrapper.like("usertype",usertype);
        }
        if (!StringUtils.isEmpty(usertype1)) {
            queryWrapper.like("usertype1",usertype1);
        }
        if (!StringUtils.isEmpty(usertype2)) {
            queryWrapper.like("usertype2",usertype2);
        }
        queryWrapper.orderByDesc("id");

        Page<UserInfo> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }
}
