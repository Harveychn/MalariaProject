package com.zxh.ssm.module.user.pojo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/3.
 */
public class AnalyzeVo {
    private int beginYear;
    private int endYear;
    private String province;
    //年龄组左边界
    private int virtualAgeDownLimit;
    //年龄组右边界
    private int virtualAgeUpLimit;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getVirtualAgeDownLimit() {
        return virtualAgeDownLimit;
    }

    public void setVirtualAgeDownLimit(int virtualAgeDownLimit) {
        this.virtualAgeDownLimit = virtualAgeDownLimit;
        this.virtualAgeUpLimit = virtualAgeDownLimit + 9;
    }

    public int getVirtualAgeUpLimit() {
        return virtualAgeUpLimit;
    }

}
