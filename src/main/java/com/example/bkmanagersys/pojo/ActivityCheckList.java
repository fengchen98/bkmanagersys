package com.example.bkmanagersys.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: bkmanager
 * @description:
 * @author: FENG CHEN
 * @create: 2022-01-18 14:12
 */
@Data
public class ActivityCheckList {
    private int id;
    private String resourceID;
    private String activityname;
    private String activityaddress;
    private String starttime;
    private String endtime;
    private String reservecount;
    private String sponsor;
    private String stadiumsresourcesID;
    private String stadiumsname;
    private Date submitdate;
    private String checkdate;
    private String keyboarder;
    private String auditor;
    private int status;
}
