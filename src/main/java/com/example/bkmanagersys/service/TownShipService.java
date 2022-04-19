package com.example.bkmanagersys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bkmanagersys.pojo.Township;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 11:02
 * @version：1.0
 */
public interface TownShipService extends IService<Township> {
    IPage<Township> getTownShipByOpr(Page<Township> pageParam, String province, String city, String county);
}
