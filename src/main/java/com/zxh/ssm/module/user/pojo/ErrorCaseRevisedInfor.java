package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public class ErrorCaseRevisedInfor<T> {
    private T year;

    private T cardID;

    private T diseasePreRevised;

    private T revisedReportDate;

    private T revisedFinalJudgDate;

    private T finalJudgDeathDate;

    private T reviseUser;

    private T reviseUserUnit;

    private T delDate;

    private T delUser;

    private T delUserUnit;

    private T delReason;

    public T getCardID() {
        return cardID;
    }

    public void setCardID(T cardID) {
        this.cardID = cardID;
    }

    public T getDelDate() {
        return delDate;
    }

    public void setDelDate(T delDate) {
        this.delDate = delDate;
    }

    public T getDelReason() {
        return delReason;
    }

    public void setDelReason(T delReason) {
        this.delReason = delReason;
    }

    public T getDelUser() {
        return delUser;
    }

    public void setDelUser(T delUser) {
        this.delUser = delUser;
    }

    public T getDelUserUnit() {
        return delUserUnit;
    }

    public void setDelUserUnit(T delUserUnit) {
        this.delUserUnit = delUserUnit;
    }

    public T getDiseasePreRevised() {
        return diseasePreRevised;
    }

    public void setDiseasePreRevised(T diseasePreRevised) {
        this.diseasePreRevised = diseasePreRevised;
    }

    public T getFinalJudgDeathDate() {
        return finalJudgDeathDate;
    }

    public void setFinalJudgDeathDate(T finalJudgDeathDate) {
        this.finalJudgDeathDate = finalJudgDeathDate;
    }

    public T getRevisedFinalJudgDate() {
        return revisedFinalJudgDate;
    }

    public void setRevisedFinalJudgDate(T revisedFinalJudgDate) {
        this.revisedFinalJudgDate = revisedFinalJudgDate;
    }

    public T getRevisedReportDate() {
        return revisedReportDate;
    }

    public void setRevisedReportDate(T revisedReportDate) {
        this.revisedReportDate = revisedReportDate;
    }

    public T getReviseUser() {
        return reviseUser;
    }

    public void setReviseUser(T reviseUser) {
        this.reviseUser = reviseUser;
    }

    public T getReviseUserUnit() {
        return reviseUserUnit;
    }

    public void setReviseUserUnit(T reviseUserUnit) {
        this.reviseUserUnit = reviseUserUnit;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }
}
