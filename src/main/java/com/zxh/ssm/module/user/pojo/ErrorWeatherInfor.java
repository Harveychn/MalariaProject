package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/12.
 */
public class ErrorWeatherInfor<T> {
    private T districtStationNum;
    private T weatherYear;
    private T weatherMonth;
    private T weatherDay;
    private T precipitation2020;
    private T maximumWindSpeed;
    private T directionMaximumWindSpeed;
    private T avePressure;
    private T aveWindSpeed;
    private T aveTemperature;
    private T aveVaporPressure;
    private T aveRelativeHumidity;
    private T sunshineTime;
    private T dailyMinPressure;
    private T dailyMinTemperature;
    private T dailyMaxPressure;
    private T dailyMaxTemperature;
    private T maxWindSpeed;
    private T directionMaxWindSpeed;
    private T minRelativeHumidity;

    public T getAvePressure() {
        return avePressure;
    }

    public void setAvePressure(T avePressure) {
        this.avePressure = avePressure;
    }

    public T getAveRelativeHumidity() {
        return aveRelativeHumidity;
    }

    public void setAveRelativeHumidity(T aveRelativeHumidity) {
        this.aveRelativeHumidity = aveRelativeHumidity;
    }

    public T getAveTemperature() {
        return aveTemperature;
    }

    public void setAveTemperature(T aveTemperature) {
        this.aveTemperature = aveTemperature;
    }

    public T getAveVaporPressure() {
        return aveVaporPressure;
    }

    public void setAveVaporPressure(T aveVaporPressure) {
        this.aveVaporPressure = aveVaporPressure;
    }

    public T getAveWindSpeed() {
        return aveWindSpeed;
    }

    public void setAveWindSpeed(T aveWindSpeed) {
        this.aveWindSpeed = aveWindSpeed;
    }

    public T getDailyMaxPressure() {
        return dailyMaxPressure;
    }

    public void setDailyMaxPressure(T dailyMaxPressure) {
        this.dailyMaxPressure = dailyMaxPressure;
    }

    public T getDailyMaxTemperature() {
        return dailyMaxTemperature;
    }

    public void setDailyMaxTemperature(T dailyMaxTemperature) {
        this.dailyMaxTemperature = dailyMaxTemperature;
    }

    public T getDailyMinPressure() {
        return dailyMinPressure;
    }

    public void setDailyMinPressure(T dailyMinPressure) {
        this.dailyMinPressure = dailyMinPressure;
    }

    public T getDailyMinTemperature() {
        return dailyMinTemperature;
    }

    public void setDailyMinTemperature(T dailyMinTemperature) {
        this.dailyMinTemperature = dailyMinTemperature;
    }

    public T getDirectionMaximumWindSpeed() {
        return directionMaximumWindSpeed;
    }

    public void setDirectionMaximumWindSpeed(T directionMaximumWindSpeed) {
        this.directionMaximumWindSpeed = directionMaximumWindSpeed;
    }

    public T getDirectionMaxWindSpeed() {
        return directionMaxWindSpeed;
    }

    public void setDirectionMaxWindSpeed(T directionMaxWindSpeed) {
        this.directionMaxWindSpeed = directionMaxWindSpeed;
    }

    public T getDistrictStationNum() {
        return districtStationNum;
    }

    public void setDistrictStationNum(T districtStationNum) {
        this.districtStationNum = districtStationNum;
    }

    public T getMaximumWindSpeed() {
        return maximumWindSpeed;
    }

    public void setMaximumWindSpeed(T maximumWindSpeed) {
        this.maximumWindSpeed = maximumWindSpeed;
    }

    public T getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public void setMaxWindSpeed(T maxWindSpeed) {
        this.maxWindSpeed = maxWindSpeed;
    }

    public T getMinRelativeHumidity() {
        return minRelativeHumidity;
    }

    public void setMinRelativeHumidity(T minRelativeHumidity) {
        this.minRelativeHumidity = minRelativeHumidity;
    }

    public T getPrecipitation2020() {
        return precipitation2020;
    }

    public void setPrecipitation2020(T precipitation2020) {
        this.precipitation2020 = precipitation2020;
    }

    public T getSunshineTime() {
        return sunshineTime;
    }

    public void setSunshineTime(T sunshineTime) {
        this.sunshineTime = sunshineTime;
    }

    public T getWeatherDay() {
        return weatherDay;
    }

    public void setWeatherDay(T weatherDay) {
        this.weatherDay = weatherDay;
    }

    public T getWeatherMonth() {
        return weatherMonth;
    }

    public void setWeatherMonth(T weatherMonth) {
        this.weatherMonth = weatherMonth;
    }

    public T getWeatherYear() {
        return weatherYear;
    }

    public void setWeatherYear(T weatherYear) {
        this.weatherYear = weatherYear;
    }
}
