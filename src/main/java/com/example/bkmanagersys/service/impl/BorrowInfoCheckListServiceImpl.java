package com.example.bkmanagersys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bkmanagersys.mapper.BorrowInfoCheckListMapper;
import com.example.bkmanagersys.pojo.BookCheckList;
import com.example.bkmanagersys.pojo.BorrowInfoCheckList;
import com.example.bkmanagersys.service.BorrowInfoCheckListService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author FengChen
 * @description:
 * @date 2022/4/16 21:37
 * @version：1.0
 */
@Service("borrowInfoCheckListServiceImpl")
@Transactional
public class BorrowInfoCheckListServiceImpl extends ServiceImpl<BorrowInfoCheckListMapper, BorrowInfoCheckList> implements BorrowInfoCheckListService {
    @Override
    public List<BorrowInfoCheckList> getBorrowInfoCheckList() {
        QueryWrapper<BorrowInfoCheckList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",0);
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<BorrowInfoCheckList> getRejectList() {
        QueryWrapper<BorrowInfoCheckList> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status",2);
        return baseMapper.selectList(queryWrapper);
    }
}
