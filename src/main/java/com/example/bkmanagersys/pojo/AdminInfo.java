package com.example.bkmanagersys.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: bkmanager
 * @description:
 * @author: FENG CHEN
 * @create: 2021-12-21 14:22
 */
@Data
@TableName("admininfo")
public class AdminInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String mail;
    private String tel;
    private String region;
    private String venue;
    private String roles;
    private Integer regionlevel;
    private String createdate;
    private String modifydate;
    private String lastlogindate;
    private String portraitPath;// 头像的图片路径



}
