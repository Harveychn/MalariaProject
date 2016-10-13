package com.zxh.ssm.module.user.pojo;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
public class ErrorCardInfor<T> {
    private T year;
    private T cardID;
    private T cardNum;
    private T cardStatus;

    public T getCardID() {
        return cardID;
    }

    public void setCardID(T cardID) {
        this.cardID = cardID;
    }

    public T getCardNum() {
        return cardNum;
    }

    public void setCardNum(T cardNum) {
        this.cardNum = cardNum;
    }

    public T getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(T cardStatus) {
        this.cardStatus = cardStatus;
    }

    public T getYear() {
        return year;
    }

    public void setYear(T year) {
        this.year = year;
    }
}
