package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bkmanagersys.pojo.Library;
import com.example.bkmanagersys.pojo.Township;
import com.example.bkmanagersys.service.TownShipService;
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
 * @date 2022/4/15 11:10
 * @version：1.0
 */
@Api(tags = "文化站控制器")
@RestController
@RequestMapping("/townShip")
public class TownShipController {
    @Autowired
    private TownShipService townShipService;

    @ApiOperation("根据省市县名称模糊查询,带分页")
    @GetMapping("/getList/{pageNo}/{pageSize}")
    public Result getTownShip(
            @PathVariable("pageNo") Integer pageNo,
            @PathVariable("pageSize") Integer pageSize,
            @ApiParam("省")String province,
            @ApiParam("市")String city,
            @ApiParam("县")String county){
        //分页带条件查询
        Page<Township> pageParam=new Page<>(pageNo,pageSize);
        //通过服务层完成查询
        IPage<Township> page=townShipService.getTownShipByOpr(pageParam,province,city,county);
        return Result.ok(page);
    }

    @ApiOperation("新增或修改文化站信息,有id属性是修改,没有则是增加")
    @PostMapping("/saveOrUpdateTownShip")
    public Result saveOrUpdateTownShip(
            @ApiParam("JSON的Library对象")@RequestBody Township township
    ){
        // 接收参数
        // 调用服务层方法完成增加或者修改
        townShipService.saveOrUpdate(township);
        return Result.ok();
    }


    @ApiOperation("删除文化站信息")
    @DeleteMapping("/deleteTownship")
    public Result deleteTownship(
            @ApiParam("要删除的所有的township的id的JSON集合") @RequestBody List<Integer> ids){

        townShipService.removeByIds(ids);
        return Result.ok();

    }
}
