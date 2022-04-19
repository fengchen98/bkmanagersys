package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.AdminInfo;
import com.example.bkmanagersys.pojo.LoginForm;
import org.springframework.stereotype.Service;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/14 16:14
 * @version：1.0
 */

public interface AdminInfoService extends IService<AdminInfo> {
    IPage<AdminInfo> getAdminsByOpr(Page<AdminInfo> pageParam, String adminName);
    AdminInfo login(LoginForm loginForm);
    AdminInfo getAdminById(Long userId);
}
