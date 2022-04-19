package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bkmanagersys.pojo.Culturalcenter;
import com.example.bkmanagersys.service.AdminInfoService;
import com.example.bkmanagersys.service.CulturalcenterService;
import com.example.bkmanagersys.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 10:07
 * @version：1.0
 */
@Api(tags = "文化馆控制器")
@RestController
@RequestMapping("/culturalcenter")
public class CulturalcenterController {
    @Autowired
    private CulturalcenterService culturalcenterService;

    @ApiOperation("根据省市县名称模糊查询,带分页")
    @GetMapping("/getList/{pageNo}/{pageSize}")
    public Result getCulturalcenter(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("省")String province,
            @ApiParam("市")String city,
            @ApiParam("县")String county){
        //分页带条件查询
        Page<Culturalcenter> pageParam=new Page<>(pageNo,pageSize);
        //通过服务层完成查询
        IPage<Culturalcenter> page=culturalcenterService.getCulturalcenterByOpr(pageParam,province,city,county);
        return Result.ok(page);
    }

    @ApiOperation("新增或修改文化馆信息,有id属性是修改,没有则是增加")
    @PostMapping("/saveOrUpdateCulturalCenter")
    public Result saveOrUpdateCulturalCenter(
            @ApiParam("JSON的CulturalCenter对象")@RequestBody Culturalcenter culturalcenter
    ){
        // 接收参数
        // 调用服务层方法完成增加或者修改
        culturalcenterService.saveOrUpdate(culturalcenter);
        return Result.ok();
    }


    @ApiOperation("删除文化馆信息")
    @DeleteMapping("/deleteCulturalCenter")
    public Result deleteCulturalCenter(
            @ApiParam("要删除的所有的CulturalCenter的id的JSON集合") @RequestBody List<Integer> ids){

        culturalcenterService.removeByIds(ids);
        return Result.ok();

    }





}
