package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.BookCheckList;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 20:57
 * @version：1.0
 */
public interface BookCheckListService extends IService<BookCheckList> {
    List<BookCheckList> getBookCheckList();

    List<BookCheckList> getRejectList();
}
