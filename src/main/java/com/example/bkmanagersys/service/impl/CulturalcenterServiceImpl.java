package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.AdminInfoMapper;
import com.example.bkmanagersys.mapper.CulturalcenterMapper;
import com.example.bkmanagersys.pojo.AdminInfo;
import com.example.bkmanagersys.pojo.Culturalcenter;
import com.example.bkmanagersys.service.AdminInfoService;
import com.example.bkmanagersys.service.CulturalcenterService;
import com.example.bkmanagersys.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 10:23
 * @version：1.0
 */
@Service("culturalcenterServiceImpl")
@Transactional
public class CulturalcenterServiceImpl extends ServiceImpl<CulturalcenterMapper, Culturalcenter> implements CulturalcenterService {
    @Override
    public IPage<Culturalcenter> getCulturalcenterByOpr(Page<Culturalcenter> pageParam, String province, String city, String county) {
        QueryWrapper<Culturalcenter> queryWrapper=new QueryWrapper<>();
        if (!StringUtils.isEmpty(province)) {
            queryWrapper.like("province",province);
        }
        if (!StringUtils.isEmpty(city)) {
            queryWrapper.like("city",city);
        }
        if (!StringUtils.isEmpty(county)) {
            queryWrapper.like("county",county);
        }
        queryWrapper.orderByDesc("id");
        Page<Culturalcenter> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}
