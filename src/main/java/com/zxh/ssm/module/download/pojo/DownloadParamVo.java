package com.zxh.ssm.module.download.pojo;

import java.util.List;

/**
 * 前段提交参数封装类
 * 包括
 * 1.用户选择的数据字段
 * 2.地区
 * 3.时间区间
 * 4.年龄区间
 * 5.性别
 */
public class DownloadParamVo {
    //用户选择的展示数据字段
    private List<String> selectedName;
    //数据地区
    private String location;
    //时间区间
    private int beginYear;
    private int endYear;
    //年龄区间
    private int minAge;
    private int maxAge;
    /*性别：
        0:全部
        1：男
        2：女
    */
    private int sex;

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

    public List<String> getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(List<String> selectedName) {
        this.selectedName = selectedName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
