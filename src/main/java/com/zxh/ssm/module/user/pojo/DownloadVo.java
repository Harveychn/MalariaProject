package com.zxh.ssm.module.user.pojo;

import java.util.List;

/**
 * 前台封装参数类
 *
 */
public class DownloadVo {
    //0表示全部、1表示男、2表示女
    private int sex;
    //数据年份开始年份、结束年份，包含区间边界
    private int beginYear;
    private int endYear;
    //年龄区间、包含区间边界
    private int minAge;
    private int maxAge;
    //地区 多级联动到乡
    private String address;

    private List<String> fieldNames;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(int beginYear) {
        this.beginYear = beginYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public List<String> getFieldNames() {
        return fieldNames;
    }

    public void setFieldNames(List<String> fieldNames) {
        this.fieldNames = fieldNames;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
