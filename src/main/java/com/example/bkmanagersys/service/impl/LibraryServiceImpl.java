package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.LibraryMapper;
import com.example.bkmanagersys.pojo.Culturalcenter;
import com.example.bkmanagersys.pojo.Library;
import com.example.bkmanagersys.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/15 10:56
 * @version：1.0
 */
@Service("libraryServiceImpl")
@Transactional
public class LibraryServiceImpl extends ServiceImpl<LibraryMapper, Library> implements LibraryService {
    @Override
    public IPage<Library> getLibraryByOpr(Page<Library> pageParam, String province, String city, String county) {
        QueryWrapper<Library> queryWrapper=new QueryWrapper<>();
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
        Page<Library> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }
}
