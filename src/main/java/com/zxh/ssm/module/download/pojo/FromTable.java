package com.zxh.ssm.module.download.pojo;

/**
 * Created by 郑晓辉 on 2016/10/15.
 */
public class FromTable {
    private String tableName;
    private String tableAlias;

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
