package com.zxh.ssm.module.user.pojo;

import java.util.Date;

/**
 * Created by 郑晓辉 on 2016/10/6.
 */
public class ErrorPatientInformation<T> {
    private T year;
    private T cardid;
    private T name;
    private T sex;
    private T birthday;
    private T age;
    private T workunit;
    private T tel;
    private T belongs;
    private T address;
    private T career;
    private T addrnationid;

    public T getAddress() {
        return address;
    }

    public void setAddress(T address) {
        this.address = address;
    }

    public T getAddrnationid() {
        return addrnationid;
    }

    public void setAddrnationid(T addrnationid) {
        this.addrnationid = addrnationid;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public T getBelongs() {
        return belongs;
    }

    public void setBelongs(T belongs) {
        this.belongs = belongs;
    }

    public T getBirthday() {
        return birthday;
    }

    public void setBirthday(T birthday) {
        this.birthday = birthday;
    }

    public T getCardid() {
        return cardid;
    }

    public void setCardid(T cardid) {
        this.cardid = cardid;
    }

    public T getCareer() {
        return career;
    }

    public void setCareer(T career) {
        this.career = career;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getSex() {
        return sex;
    }

    public void setSex(T sex) {
        this.sex = sex;
    }

    public T getTel() {
        return tel;
    }

    public void setTel(T tel) {
        this.tel = tel;
    }

    public T getWorkunit() {
        return workunit;
    }

    public void setWorkunit(T workunit) {
        this.workunit = workunit;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }
}
