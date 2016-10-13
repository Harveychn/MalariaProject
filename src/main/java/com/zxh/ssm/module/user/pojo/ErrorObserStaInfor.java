package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/12.
 */
public class ErrorObserStaInfor<T> {
    private T districtStationNum;
    private T stationName;
    private T provinves;
    private T lat;
    private T lng;
    private T altitude;
    private T startYear;
    private T startMonth;
    private T endYear;
    private T endMonth;
    private T lackMeasurement;

    public T getAltitude() {
        return altitude;
    }

    public void setAltitude(T altitude) {
        this.altitude = altitude;
    }

    public T getDistrictStationNum() {
        return districtStationNum;
    }

    public void setDistrictStationNum(T districtStationNum) {
        this.districtStationNum = districtStationNum;
    }

    public T getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(T endMonth) {
        this.endMonth = endMonth;
    }

    public T getEndYear() {
        return endYear;
    }

    public void setEndYear(T endYear) {
        this.endYear = endYear;
    }

    public T getLackMeasurement() {
        return lackMeasurement;
    }

    public void setLackMeasurement(T lackMeasurement) {
        this.lackMeasurement = lackMeasurement;
    }

    public T getLat() {
        return lat;
    }

    public void setLat(T lat) {
        this.lat = lat;
    }

    public T getLng() {
        return lng;
    }

    public void setLng(T lng) {
        this.lng = lng;
    }

    public T getProvinves() {
        return provinves;
    }

    public void setProvinves(T provinves) {
        this.provinves = provinves;
    }

    public T getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(T startMonth) {
        this.startMonth = startMonth;
    }

    public T getStartYear() {
        return startYear;
    }

    public void setStartYear(T startYear) {
        this.startYear = startYear;
    }

    public T getStationName() {
        return stationName;
    }

    public void setStationName(T stationName) {
        this.stationName = stationName;
    }
}
