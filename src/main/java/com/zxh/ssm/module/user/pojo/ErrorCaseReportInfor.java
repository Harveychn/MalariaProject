package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public class ErrorCaseReportInfor<T> {
    private T year;
    private T cardID;
    private T reportUnitAreaCode;
    private T reportUnit;
    private T unitType;
    private T reportInputDate;
    private T inputUser;
    private T inputUserUnit;

    public T getCardID() {
        return cardID;
    }

    public void setCardID(T cardID) {
        this.cardID = cardID;
    }

    public T getInputUser() {
        return inputUser;
    }

    public void setInputUser(T inputUser) {
        this.inputUser = inputUser;
    }

    public T getInputUserUnit() {
        return inputUserUnit;
    }

    public void setInputUserUnit(T inputUserUnit) {
        this.inputUserUnit = inputUserUnit;
    }

    public T getReportInputDate() {
        return reportInputDate;
    }

    public void setReportInputDate(T reportInputDate) {
        this.reportInputDate = reportInputDate;
    }

    public T getReportUnit() {
        return reportUnit;
    }

    public void setReportUnit(T reportUnit) {
        this.reportUnit = reportUnit;
    }

    public T getReportUnitAreaCode() {
        return reportUnitAreaCode;
    }

    public void setReportUnitAreaCode(T reportUnitAreaCode) {
        this.reportUnitAreaCode = reportUnitAreaCode;
    }

    public T getUnitType() {
        return unitType;
    }

    public void setUnitType(T unitType) {
        this.unitType = unitType;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }
}
