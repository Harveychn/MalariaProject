package com.zxh.ssm.module.download.pojo;

import java.util.List;

/**
 * download step1
 * 获取类别数据字段
 */
public class CategoryFieldsRe {
    private String fieldName;
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
