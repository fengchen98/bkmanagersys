package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.LibraryMapper;
import com.example.bkmanagersys.mapper.TownShipMapper;
import com.example.bkmanagersys.pojo.Library;
import com.example.bkmanagersys.pojo.Township;
import com.example.bkmanagersys.service.LibraryService;
import com.example.bkmanagersys.service.TownShipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 11:03
 * @version：1.0
 */
@Service("townShipServiceImpl")
@Transactional
public class TownShipServiceImpl extends ServiceImpl<TownShipMapper,Township> implements TownShipService {
    @Override
    public IPage<Township> getTownShipByOpr(Page<Township> pageParam, String province, String city, String county) {
        QueryWrapper<Township> queryWrapper=new QueryWrapper<>();
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
        Page<Township> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}
