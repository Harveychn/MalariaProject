package com.zxh.ssm.module.user.pojo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/1.
 */
public class DynamicOutbreakVo {
    private int year;
    private int month;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
