package com.zxh.ssm.module.user.pojo;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/6.
 */
public class UploadDBMessage<E,T> {
    private int successInsertNum;
    private int successUpdateNum;
    //读取excel时的错误信息
    private List<E> errorReadingList;
    //读取正常、操作时异常信息
    private List<T> errorOperatingList;

    public int getSuccessInsertNum() {
        return successInsertNum;
    }

    public void setSuccessInsertNum(int successInsertNum) {
        this.successInsertNum = successInsertNum;
    }

    public int getSuccessUpdateNum() {
        return successUpdateNum;
    }

    public void setSuccessUpdateNum(int successUpdateNum) {
        this.successUpdateNum = successUpdateNum;
    }

    public List<T> getErrorOperatingList() {
        return errorOperatingList;
    }

    public void setErrorOperatingList(List<T> errorOperatingList) {
        this.errorOperatingList = errorOperatingList;
    }

    public List<E> getErrorReadingList() {
        return errorReadingList;
    }

    public void setErrorReadingList(List<E> errorReadingList) {
        this.errorReadingList = errorReadingList;
    }
}
