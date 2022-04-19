package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.Culturalcenter;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 16:05
 * @version：1.0
 */
public interface ActivityService extends IService<Activity> {
    IPage<Activity> getActivityByOpr(Page<Activity> pageParam, String activityname, String activityaddress, String sponsor);

    List<Activity> getActivityList();
}
