package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.BorrowInfo;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 21:30
 * @version：1.0
 */
public interface BorrowInfoService extends IService<BorrowInfo> {
    List<BorrowInfo> getBorrowInfoList();


    IPage<BorrowInfo> getBorrowInfoByOpr(Page<BorrowInfo> pageParam, String userid, String idnumber, String tel, String title, String author);
}
