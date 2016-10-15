package com.zxh.ssm.module.download.pojo;

/**
 * Created by 郑晓辉 on 2016/10/15.
 */
public class SQLQuery {
    private String select;
    private String from;
    private String where;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}
