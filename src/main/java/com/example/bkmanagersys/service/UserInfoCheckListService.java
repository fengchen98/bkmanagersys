package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.UserInfo;
import com.example.bkmanagersys.pojo.UserInfoCheckList;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/17 8:37
 * @version：1.0
 */
public interface UserInfoCheckListService extends IService<UserInfoCheckList> {
    List<UserInfoCheckList> getUserInfoCheckList();

    List<UserInfoCheckList> getRejectList();
}
