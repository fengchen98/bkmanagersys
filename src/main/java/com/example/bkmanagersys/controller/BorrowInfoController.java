package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bkmanagersys.pojo.Book;
import com.example.bkmanagersys.pojo.BookCheckList;
import com.example.bkmanagersys.pojo.BorrowInfo;
import com.example.bkmanagersys.pojo.BorrowInfoCheckList;
import com.example.bkmanagersys.service.BorrowInfoCheckListService;
import com.example.bkmanagersys.service.BorrowInfoService;
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
 * @date 2022/4/16 21:40
 * @version：1.0
 */
@Api(tags = "借阅信息控制器")
@RestController
@RequestMapping("/borrow")
public class BorrowInfoController {
    @Autowired
    private BorrowInfoService borrowInfoService;
    @Autowired
    private BorrowInfoCheckListService borrowInfoCheckListService;

    @ApiOperation("新增借阅信息到审核表")
    @PostMapping("/addBorrowInfoToCheckList")
    public Result addBorrowInfoToCheckList(
            @ApiParam("要新增的所有的BorrowInfo的JSON集合")@RequestBody Collection<BorrowInfoCheckList> borrowInfoCheckLists
    ){
        // 接收参数
        // 调用服务层方法完成增加
        borrowInfoCheckListService.saveBatch(borrowInfoCheckLists);
        return Result.ok();
    }

    @ApiOperation("新增借阅信息到馆藏表")
    @PostMapping("/addBorrowInfo")
    public Result addBook(
            @ApiParam("要新增的所有的BorrowInfo的JSON集合")@RequestBody Collection<BorrowInfo> borrowInfos
    ){
        // 接收参数
        // 调用服务层方法完成增加
        borrowInfoService.saveBatch(borrowInfos);
        return Result.ok();
    }

    @ApiOperation("获取所有馆藏信息")
    @RequestMapping("/list")
    public Result getBorrowInfoList(){
        List<BorrowInfo> list=borrowInfoService.getBorrowInfoList();
        return Result.ok(list);
    }

    @ApiOperation("删除馆藏信息")
    @DeleteMapping("/deleteBorrowInfo")
    public Result deleteBook(
            @ApiParam("要删除的所有的BorrowInfo的id的JSON集合") @RequestBody List<Integer> ids){

        borrowInfoService.removeByIds(ids);
        return Result.ok();

    }

    @ApiOperation("统计馆藏总数")
    @RequestMapping("/count")
    public Result countBook(){
        int count = borrowInfoService.count();
        return Result.ok(count);
    }

    @ApiOperation("读者编号、身份证号码,电话,书籍名,作者名")
    @GetMapping("/getList/{pageNo}/{pageSize}")
    public Result getBorrowInfo(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("读者编号")String userid,
            @ApiParam("身份证号码")String idnumber,
            @ApiParam("电话")String tel,
            @ApiParam("书籍名")String title,
            @ApiParam("作者名")String author
){
        //分页带条件查询
        Page<BorrowInfo> pageParam=new Page<>(pageNo,pageSize);
        //通过服务层完成查询
        IPage<BorrowInfo> page=borrowInfoService.getBorrowInfoByOpr(pageParam,userid,idnumber,tel,title,author);
        return Result.ok(page);
    }

    @ApiOperation("修改借阅信息")
    @PostMapping("/updateBorrowInfo")
    public Result updateBorrowInfo(
            @ApiParam("要修改的BorrowInfo") BorrowInfo borrowInfo
    ){
        // 接收参数
        // 调用服务层方法完成修改
        borrowInfoService.updateById(borrowInfo);
        return Result.ok();
    }
}
