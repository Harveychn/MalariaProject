package com.zxh.ssm.module.dynamicOutbreak.pojo;

/**
 * Created by 郑晓辉 on 2016/10/20.
 */
public class Pretreatment {
    private String provinceName;
    private String cityName;
    private String countyName;
    private String townName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
