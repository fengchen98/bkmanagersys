package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.ActivityCheckListMapper;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.ActivityCheckList;
import com.example.bkmanagersys.service.ActivityCheckListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 17:07
 * @version：1.0
 */
@Service("activityCheckListServiceImpl")
@Transactional
public class ActivityCheckListServiceImpl extends ServiceImpl<ActivityCheckListMapper, ActivityCheckList>implements ActivityCheckListService {

    @Override
    public List<ActivityCheckList> getActivityCheckList() {
        QueryWrapper<ActivityCheckList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",0);
        return baseMapper.selectList(queryWrapper);
    }



   /* @Override
    public void updateActivityById(List<Integer> ids,List<ActivityCheckList> activityCheckLists) {
        for (ActivityCheckList activityCheckList:activityCheckLists) {
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.in("id",ids);
            activityCheckList.setStatus(2);
            baseMapper.update(activityCheckList,queryWrapper);
        }
    }*/


    @Override
    public List<ActivityCheckList> getRejectList() {
        QueryWrapper<ActivityCheckList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",2);
        return baseMapper.selectList(queryWrapper);
    }


}
