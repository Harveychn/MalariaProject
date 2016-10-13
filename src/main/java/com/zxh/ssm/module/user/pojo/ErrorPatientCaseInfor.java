package com.zxh.ssm.module.user.pojo;


/**
 * Created by 郑晓辉 on 2016/10/10.
 */
public class ErrorPatientCaseInfor<T> {
    private T year;

    private T cardid;

    private T casecategory1;

    private T casecategory2;

    private T illdate;

    private T confirmdate;

    private T deathdate;

    private T diseasename;

    private T fillcarddoc;

    private T fillcarddate;

    private T notes;

    public T getCardid() {
        return cardid;
    }

    public void setCardid(T cardid) {
        this.cardid = cardid;
    }

    public T getCasecategory1() {
        return casecategory1;
    }

    public void setCasecategory1(T casecategory1) {
        this.casecategory1 = casecategory1;
    }

    public T getCasecategory2() {
        return casecategory2;
    }

    public void setCasecategory2(T casecategory2) {
        this.casecategory2 = casecategory2;
    }

    public T getConfirmdate() {
        return confirmdate;
    }

    public void setConfirmdate(T confirmdate) {
        this.confirmdate = confirmdate;
    }

    public T getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(T deathdate) {
        this.deathdate = deathdate;
    }

    public T getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(T diseasename) {
        this.diseasename = diseasename;
    }

    public T getFillcarddate() {
        return fillcarddate;
    }

    public void setFillcarddate(T fillcarddate) {
        this.fillcarddate = fillcarddate;
    }

    public T getFillcarddoc() {
        return fillcarddoc;
    }

    public void setFillcarddoc(T fillcarddoc) {
        this.fillcarddoc = fillcarddoc;
    }

    public T getIlldate() {
        return illdate;
    }

    public void setIlldate(T illdate) {
        this.illdate = illdate;
    }

    public T getNotes() {
        return notes;
    }

    public void setNotes(T notes) {
        this.notes = notes;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }
}
