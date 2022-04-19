package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.ActivityCheckList;
import com.example.bkmanagersys.pojo.Book;
import com.example.bkmanagersys.pojo.BookCheckList;
import com.example.bkmanagersys.service.BookCheckListService;
import com.example.bkmanagersys.service.BookService;
import com.example.bkmanagersys.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 20:44
 * @version：1.0
 */
@Api(tags = "馆藏控制器")
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCheckListService bookCheckListService;

    @ApiOperation("新增馆藏信息到审核表")
    @PostMapping("/addBookToCheckList")
    public Result addBookToCheckList(
            @ApiParam("要新增的所有的BookToCheckList的JSON集合")@RequestBody Collection<BookCheckList> bookCheckLists
    ){
        // 接收参数
        // 调用服务层方法完成增加
        bookCheckListService.saveBatch(bookCheckLists);
        return Result.ok();
    }

    @ApiOperation("新增馆藏信息到馆藏表")
    @PostMapping("/addBook")
    public Result addBook(
            @ApiParam("要新增的所有的Book的JSON集合")@RequestBody Collection<Book> books
    ){
        // 接收参数
        // 调用服务层方法完成增加
        bookService.saveBatch(books);
        return Result.ok();
    }

    @ApiOperation("获取所有馆藏信息")
    @RequestMapping("/list")
    public Result getBookList(){
        List<Book> list=bookService.getBookList();
        return Result.ok(list);
    }

    @ApiOperation("删除馆藏信息")
    @DeleteMapping("/deleteBook")
    public Result deleteBook(
            @ApiParam("要删除的所有的Book的id的JSON集合") @RequestBody List<Integer> ids){

        bookService.removeByIds(ids);
        return Result.ok();

    }

    @ApiOperation("统计馆藏总数")
    @RequestMapping("/count")
    public Result countBook(){
        int count = bookService.count();
        return Result.ok(count);
    }

    @ApiOperation("根据书名、作者名模糊查询,带分页")
    @GetMapping("/getList/{pageNo}/{pageSize}")
    public Result getBook(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("书名")String title,
            @ApiParam("作者名")String author){
        //分页带条件查询
        Page<Book> pageParam=new Page<>(pageNo,pageSize);
        //通过服务层完成查询
        IPage<Book> page=bookService.getBookByOpr(pageParam,title,author);
        return Result.ok(page);
    }

    @ApiOperation("修改馆藏信息")
    @PostMapping("/updateBook")
    public Result updateBook(
            @ApiParam("要修改的Book") Book book
    ){
        // 接收参数
        // 调用服务层方法完成修改
        bookService.updateById(book);
        return Result.ok();
    }


}
