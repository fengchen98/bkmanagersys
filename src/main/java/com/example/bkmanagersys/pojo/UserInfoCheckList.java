package com.example.bkmanagersys.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: bkmanager
 * @description:
 * @author: FENG CHEN
 * @create: 2022-01-18 15:25
 */
@Data
public class UserInfoCheckList {
    private int id;
    private String userid;
    private String idnumber;
    private String stadiumstype;
    private String tel;
    private String usertype;
    private String ststus;
    private String bill;
    private String subscribe;
    private String borrowcount;
    private String billsum;
    private String borrowsum;
    private String newdate;
    private String lastuse;
    private String authorizationdate;
    private String usertype1;
    private String usertype2;
    private String usertype3;
    private String usertype4;
    private String usertype5;
    private String birthday;
    private Date submitdate;
    private String checkdate;
    private String keyboarder;
    private String auditor;
    private int status;

}
