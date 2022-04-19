package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bkmanagersys.pojo.Activity;
import com.example.bkmanagersys.pojo.ActivityCheckList;
import com.example.bkmanagersys.pojo.Culturalcenter;
import com.example.bkmanagersys.service.ActivityCheckListService;
import com.example.bkmanagersys.service.ActivityService;
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
 * @date 2022/4/15 16:08
 * @version：1.0
 */
@Api(tags = "活动控制器")
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityCheckListService activityCheckListService;

    @ApiOperation("根据活动名称、活动地址、举办方模糊查询,带分页")
    @GetMapping("/getList/{pageNo}/{pageSize}")
    public Result getActivity(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("活动名称")String activityname,
            @ApiParam("活动地址")String activityaddress,
            @ApiParam("举办方")String sponsor){
        //分页带条件查询
        Page<Activity> pageParam=new Page<>(pageNo,pageSize);
        //通过服务层完成查询
        IPage<Activity> page=activityService.getActivityByOpr(pageParam,activityname,activityaddress,sponsor);
        return Result.ok(page);
    }

    @ApiOperation("新增活动信息到审核表")
    @PostMapping("/addActiveToCheckList")
    public Result addActiveToCheckList(
            @ApiParam("要新增的所有的ActivityCheckList的JSON集合")@RequestBody Collection<ActivityCheckList> activities
    ){
        // 接收参数
        // 调用服务层方法完成增加
        activityCheckListService.saveBatch(activities);
        return Result.ok();
    }

    @ApiOperation("新增活动信息到活动表")
    @PostMapping("/addActivity")
    public Result addActivity(
            @ApiParam("要新增的所有的Activity的JSON集合")@RequestBody Collection<Activity> activities
    ){
        // 接收参数
        // 调用服务层方法完成增加
        activityService.saveBatch(activities);
        return Result.ok();
    }

    @ApiOperation("修改活动信息")
    @PostMapping("/updateActivity")
    public Result updateActivity(
            @ApiParam("要修改的Activity") Activity activity
    ){
        // 接收参数
        // 调用服务层方法完成修改
        activityService.updateById(activity);
        return Result.ok();
    }


    @ApiOperation("删除活动信息")
    @DeleteMapping("/deleteActivity")
    public Result deleteActivity(
            @ApiParam("要删除的所有的Activity的id的JSON集合") @RequestBody List<Integer> ids){

        activityService.removeByIds(ids);
        return Result.ok();

    }

    @ApiOperation("统计活动总数")
    @RequestMapping("/count")
    public Result countActivity(){
        int count = activityService.count();
        return Result.ok(count);
    }

    @ApiOperation("获取所有活动信息")
    @RequestMapping("/list")
    public Result getActivityList(){
        List<Activity> list=activityService.getActivityList();
        return Result.ok(list);
    }



}
