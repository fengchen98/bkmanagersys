package com.example.bkmanagersys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bkmanagersys.pojo.AdminInfo;
import com.example.bkmanagersys.pojo.LoginForm;
import com.example.bkmanagersys.service.AdminInfoService;
import com.example.bkmanagersys.util.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = "系统控制器")
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private AdminInfoService adminInfoService;

    @ApiOperation("通过token口令获取当前登录的用户信息的方法")
    @GetMapping("/getInfo")
    public Result getInfoByToken(
            @ApiParam("token口令")@RequestHeader("token") String token){
        boolean expiration = JwtHelper.isExpiration(token);
        if (expiration) {
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        //从token中解析出 用户id
        Long userId = JwtHelper.getUserId(token);
        Integer userType = JwtHelper.getUserType(token);
        AdminInfo adminInfo=adminInfoService.getAdminById(userId);
        Map<String,Object> map =new LinkedHashMap<>();
        if (userType.intValue()==adminInfo.getRegionlevel()){
            map.put("userType",adminInfo.getRegionlevel());
            map.put("user",adminInfo);
            return Result.ok(map);
        }
        return Result.fail().message("查无此用户");
    }




    @ApiOperation("登录的方法")
    @PostMapping("/login")
    public Result login(
            @ApiParam("登录提交信息的form表单")@RequestBody LoginForm loginForm,
            HttpServletRequest request) {
        // 验证码校验
        HttpSession session = request.getSession();
        String sessionVerifiCode = (String) session.getAttribute("verifiCode");
        String loginVerifiCode = loginForm.getVerifiCode();
        if ("".equals(sessionVerifiCode) || null == sessionVerifiCode) {
            return Result.fail().message("验证码失效,请刷新后重试");
        }
        if (!sessionVerifiCode.equalsIgnoreCase(loginVerifiCode)) {
            return Result.fail().message("验证码有误,请重试");
        }
        // 从session域中移除现有验证码
        session.removeAttribute("verifiCode");
        // 分用户类型进行校验

        // 准备一个map用户存放响应的数据
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            AdminInfo admin = adminInfoService.login(loginForm);
            if (null != admin) {
                // 用户的类型和用户id转换成一个密文,以token的名称向客户端反馈
                map.put("token", JwtHelper.createToken(admin.getId().longValue(),admin.getRegionlevel()));
            } else {
                throw new RuntimeException("用户名或者密码有误");
            }
            return Result.ok(map);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Result.fail().message(e.getMessage());
        }
        //return Result.fail().message("查无此用户");
    }




    @ApiOperation("获取验证码图片")
    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response){
        // 获取图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        // 获取图片上的验证码
        String verifiCode =new String( CreateVerifiCodeImage.getVerifiCode());
        // 将验证码文本放入session域,为下一次验证做准备
        HttpSession session = request.getSession();
        session.setAttribute("verifiCode",verifiCode);
        // 将验证码图片响应给浏览器

        try {
            ImageIO.write(verifiCodeImage,"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
