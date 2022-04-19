package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.ActivityCheckList;
import com.example.bkmanagersys.pojo.Book;
import com.example.bkmanagersys.pojo.BookCheckList;
import com.example.bkmanagersys.service.BookCheckListService;
import com.example.bkmanagersys.service.BookService;
import com.example.bkmanagersys.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 21:12
 * @version：1.0
 */
@Api(tags = "馆藏审核表控制器")
@RestController
@RequestMapping("/bookcheck")
public class BookCheckListController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCheckListService bookCheckListService;

    @ApiOperation("通过审核馆藏信息")
    @RequestMapping("/pass")
    public Result pass(@RequestParam List<Integer> ids){

        for(int id:ids){
            BookCheckList bookCheckList = bookCheckListService.getById(id);
            UpdateWrapper<BookCheckList> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id" ,id).set("status", 1);
            bookCheckListService.update(updateWrapper);
            Book book = new Book();
            BeanUtils.copyProperties(bookCheckList, book);
            bookService.save(book);
        }
        return Result.ok();
    }

    //根据ID获取馆藏信息
    @ApiOperation("获取对应id的馆藏信息")
    @RequestMapping("/getBookByID")
    public Result getBookByID(@RequestParam List<Integer> ids){
        List<Book> books=new ArrayList<>();
        for(int id:ids){
            BookCheckList bookCheckList = bookCheckListService.getById(id);
            Book book = new Book();
            BeanUtils.copyProperties(bookCheckList,book);
            books.add(book);
        }

        return Result.ok(books);
    }

    @ApiOperation("驳回馆藏信息")
    @RequestMapping("/reject")
    public Result reject(@RequestParam List<Integer> ids){

        for(int id:ids){
            BookCheckList bookCheckList = bookCheckListService.getById(id);
            UpdateWrapper<BookCheckList> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id" ,id).set("status", 2);
            bookCheckListService.update(updateWrapper);
        }
        return Result.ok();
    }

    @ApiOperation("获取所有馆藏信息")
    @RequestMapping("/list")
    public Result getBookCheckList(){
        List<BookCheckList> list=bookCheckListService.getBookCheckList();
        return Result.ok(list);
    }




    @ApiOperation("驳回活动信息列表")
    @RequestMapping("/rejectlist")
    public Result getRejectList(){
        List<BookCheckList> list=bookCheckListService.getRejectList();
        return Result.ok(list);
    }

}
