package com.example.bkmanagersys.pojo;

import lombok.Data;

/**
 * @program: bkmanager
 * @description:
 * @author: FENG CHEN
 * @create: 2021-12-22 13:12
 */
@Data
public class Library {
    private int id;
    private String name;
    private String agencycode;
    private String agencynumber;
    private String areaname;
    private String postalcode;
    private String tel;
    private String tradecode;
    private String address;
    private String registertype;
    private String group;
    private String level;
    private String status;
    private String ischildrenlibrary;
    private String province;
    private String city;
    private String county;
    private String venueresourceid;
}
