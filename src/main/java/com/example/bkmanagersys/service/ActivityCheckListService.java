package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.ActivityCheckList;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 17:07
 * @version：1.0
 */
public interface ActivityCheckListService extends IService<ActivityCheckList> {

    List<ActivityCheckList> getActivityCheckList();
    List<ActivityCheckList> getRejectList();


}
