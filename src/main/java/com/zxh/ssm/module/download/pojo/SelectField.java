package com.zxh.ssm.module.download.pojo;

/**
 * Created by 郑晓辉 on 2016/10/15.
 */
public class SelectField {
    private String tableAlias;
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
}
