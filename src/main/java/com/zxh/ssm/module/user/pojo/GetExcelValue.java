package com.zxh.ssm.module.user.pojo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by 郑晓辉 on 2016/10/10.
 */
public class GetExcelValue {
    /**
     * HSSFCell 类型判断、数据处理
     *
     * @param hssfCell 单元格
     * @return 单元格值的String形式的值
     */
    public String getValue(HSSFCell hssfCell) {
        String cellValue = null;
        DecimalFormat df = new DecimalFormat("#");
        try {
            switch (hssfCell.getCellType()) {
                case HSSFCell.CELL_TYPE_STRING:
                    cellValue = hssfCell.getRichStringCellValue().getString().trim();
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(hssfCell)) {
                        cellValue = new SimpleDateFormat("yyyy-MM-dd").format(hssfCell.getDateCellValue());
                    } else {
                        cellValue = df.format(hssfCell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    cellValue = String.valueOf(hssfCell.getBooleanCellValue()).trim();
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    cellValue = hssfCell.getCellFormula();
                    break;
                case HSSFCell.CELL_TYPE_BLANK:
                    cellValue = ".";
                    break;
                default:
                    cellValue = ".";
            }
        } catch (NullPointerException n) {
            System.out.println("Excel单元格数据格式异常 信息：" + n.getMessage());
            cellValue = null;
        }
        return cellValue;
    }

    /**
     * XSSFCell 类型判断、数据处理
     *
     * @param xssfCell 单元格
     * @return 单元格值的String形式的值
     */
    public String getValue(XSSFCell xssfCell) {
        String cellValue = null;
        DecimalFormat df = new DecimalFormat("#");
        try {
            switch (xssfCell.getCellType()) {
                case XSSFCell.CELL_TYPE_STRING:
                    cellValue = xssfCell.getRichStringCellValue().getString().trim();
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    if (HSSFDateUtil.isCellDateFormatted(xssfCell)) {
                        cellValue = new SimpleDateFormat("yyyy-MM-dd").format(xssfCell.getDateCellValue());
                    } else {
                        cellValue = df.format(xssfCell.getNumericCellValue()).toString();
                    }
                    break;
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    cellValue = String.valueOf(xssfCell.getBooleanCellValue()).trim();
                    break;
                case XSSFCell.CELL_TYPE_FORMULA:
                    cellValue = xssfCell.getCellFormula();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    cellValue = ".";
                    break;
                default:
                    cellValue = "default";
            }
        } catch (NullPointerException n) {
            System.out.println("Excel单元格数据格式异常 信息：" + n.getMessage());
            cellValue = ".";
        }
        return cellValue;
    }
}
