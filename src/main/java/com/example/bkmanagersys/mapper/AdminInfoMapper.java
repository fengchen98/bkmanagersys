package com.example.bkmanagersys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bkmanagersys.pojo.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/14 16:16
 * @version：1.0
 */
@Repository
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {

}
