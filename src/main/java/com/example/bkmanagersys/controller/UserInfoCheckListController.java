package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.bkmanagersys.pojo.Book;
import com.example.bkmanagersys.pojo.BookCheckList;
import com.example.bkmanagersys.pojo.UserInfo;
import com.example.bkmanagersys.pojo.UserInfoCheckList;
import com.example.bkmanagersys.service.UserInfoCheckListService;
import com.example.bkmanagersys.service.UserInfoService;
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
 * @date 2022/4/17 8:42
 * @version：1.0
 */
@Api(tags = "用户审核表控制器")
@RestController
@RequestMapping("/userinfocheck")
public class UserInfoCheckListController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoCheckListService userInfoCheckListService;

    @ApiOperation("通过审核用户信息")
    @RequestMapping("/pass")
    public Result pass(@RequestParam List<Integer> ids){

        for(int id:ids){
            UserInfoCheckList userInfoCheckList = userInfoCheckListService.getById(id);
            UpdateWrapper<UserInfoCheckList> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id" ,id).set("status", 1);
            userInfoCheckListService.update(updateWrapper);
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userInfoCheckList, userInfo);
            userInfoService.save(userInfo);
        }
        return Result.ok();
    }

    //根据ID获取用户信息
    @ApiOperation("获取对应id的用户信息")
    @RequestMapping("/getUserInfoByID")
    public Result getUserInfoByID(@RequestParam List<Integer> ids){
        List<UserInfo> userInfos=new ArrayList<>();
        for(int id:ids){
            UserInfoCheckList userInfoCheckList = userInfoCheckListService.getById(id);
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userInfoCheckList,userInfo);
            userInfos.add(userInfo);
        }

        return Result.ok(userInfos);
    }

    @ApiOperation("驳回用户信息")
    @RequestMapping("/reject")
    public Result reject(@RequestParam List<Integer> ids){

        for(int id:ids){
            UserInfoCheckList userInfoCheckList = userInfoCheckListService.getById(id);
            UpdateWrapper<UserInfoCheckList> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id" ,id).set("status", 2);
            userInfoCheckListService.update(updateWrapper);
        }
        return Result.ok();
    }

    @ApiOperation("获取所有用户信息")
    @RequestMapping("/list")
    public Result getUserInfoCheckList(){
        List<UserInfoCheckList> list=userInfoCheckListService.getUserInfoCheckList();
        return Result.ok(list);
    }




    @ApiOperation("驳回用户信息列表")
    @RequestMapping("/rejectlist")
    public Result getRejectList(){
        List<UserInfoCheckList> list=userInfoCheckListService.getRejectList();
        return Result.ok(list);
    }
}
