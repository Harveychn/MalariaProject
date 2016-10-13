package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public class ErrorCaseJudgInfor<T> {
    private T year;
    private T cardID;
    private T countyJudgDate;
    private T localJudgeDate;
    private T provinceJudgDate;
    private T judgStatus;

    public T getCardID() {
        return cardID;
    }

    public void setCardID(T cardID) {
        this.cardID = cardID;
    }

    public T getCountyJudgDate() {
        return countyJudgDate;
    }

    public void setCountyJudgDate(T countyJudgDate) {
        this.countyJudgDate = countyJudgDate;
    }

    public T getJudgStatus() {
        return judgStatus;
    }

    public void setJudgStatus(T judgStatus) {
        this.judgStatus = judgStatus;
    }

    public T getLocalJudgeDate() {
        return localJudgeDate;
    }

    public void setLocalJudgeDate(T localJudgeDate) {
        this.localJudgeDate = localJudgeDate;
    }

    public T getProvinceJudgDate() {
        return provinceJudgDate;
    }

    public void setProvinceJudgDate(T provinceJudgDate) {
        this.provinceJudgDate = provinceJudgDate;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }
}
