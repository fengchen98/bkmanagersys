package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.Book;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 20:49
 * @version：1.0
 */
public interface BookService extends IService<Book> {
    List<Book> getBookList();

    IPage<Book> getBookByOpr(Page<Book> pageParam, String title, String author);
}
