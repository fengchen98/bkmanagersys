package com.example.bkmanagersys.pojo;

import lombok.Data;

/**
 * @program: bkmanager
 * @description:
 * @author: FENG CHEN
 * @create: 2021-12-15 23:46
 */
@Data
public class Activity {
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
}
