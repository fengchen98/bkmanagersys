package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.ActivityMapper;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.AdminInfo;
import com.example.bkmanagersys.pojo.Culturalcenter;
import com.example.bkmanagersys.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 16:06
 * @version：1.0
 */
@Service("activityServiceImpl")
@Transactional
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public IPage<Activity> getActivityByOpr(Page<Activity> pageParam, String activityname, String activityaddress, String sponsor) {
        QueryWrapper<Activity> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(activityname)) {
            queryWrapper.like("activityname",activityname);
        }
        if (!StringUtils.isEmpty(activityaddress)) {
            queryWrapper.like("activityaddress",activityaddress);
        }
        if (!StringUtils.isEmpty(sponsor)) {
            queryWrapper.like("sponsor",sponsor);
        }
        queryWrapper.orderByDesc("id");

        Page<Activity> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }

    @Override
    public List<Activity> getActivityList() {
        return baseMapper.selectList(null);
    }
}
