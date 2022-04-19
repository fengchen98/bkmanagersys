package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.UserInfo;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/17 8:36
 * @version：1.0
 */
public interface UserInfoService extends IService<UserInfo> {
    List<UserInfo> getUserInfoList();

    IPage<UserInfo> getUserInfoByOpr(Page<UserInfo> pageParam, String userid, String usertype, String usertype1, String usertype2);
}
