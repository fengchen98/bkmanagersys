package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.Culturalcenter;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 10:21
 * @version：1.0
 */
public interface CulturalcenterService extends IService<Culturalcenter> {
    IPage<Culturalcenter> getCulturalcenterByOpr(Page<Culturalcenter> pageParam, String province, String city, String county);
}
