package com.zxh.ssm.module.user.pojo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/6.
 */
public class RowDataSorted<E,T> {
    //读取excel时异常
    private List<E> errorReadingList;
    private List<T> keyNotNullList;

    public List<T> getKeyNotNullList() {
        return keyNotNullList;
    }

    public void setKeyNotNullList(List<T> keyNotNullList) {
        this.keyNotNullList = keyNotNullList;
    }

    public List<E> getErrorReadingList() {
        return errorReadingList;
    }

    public void setErrorReadingList(List<E> errorReadingList) {
        this.errorReadingList = errorReadingList;
    }
}
