package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.BorrowInfo;
import com.example.bkmanagersys.pojo.BorrowInfoCheckList;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 21:30
 * @version：1.0
 */
public interface BorrowInfoCheckListService extends IService<BorrowInfoCheckList> {
    List<BorrowInfoCheckList> getBorrowInfoCheckList();

    List<BorrowInfoCheckList> getRejectList();
}
