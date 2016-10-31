package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.whole.mapper.CardInformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToCardInforService;
import com.zxh.ssm.module.whole.pojo.CardInformation;
import com.zxh.ssm.module.whole.pojo.CardInformationKey;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/11.
 */
@Service
public class UploadToCardInforServiceImpl implements UploadToCardInforService {

    @Resource
    private CardInformationMapper cardInformationMapper;

    private RowDataSorted<ErrorCardInfor<String>, CardInformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<CardInformation> cardInformations = new ArrayList<>();
        List<ErrorCardInfor<String>> errorCardInfors = new ArrayList<>();
        CardInformation cardInformation = null;
        ErrorCardInfor<String> errorCardInfor = null;
        InputStream inputStream = new FileInputStream(path);
        if (path.endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = workbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                for (int numRow = 1; numRow <= hssfSheet.getLastRowNum(); numRow++) {
                    HSSFRow hssfRow = hssfSheet.getRow(numRow);
                    if (hssfRow != null) {
                        cardInformation = new CardInformation();
                        errorCardInfor = new ErrorCardInfor<>();
                        HSSFCell year = hssfRow.getCell(0);
                        HSSFCell cardId = hssfRow.getCell(1);
                        HSSFCell cardNum = hssfRow.getCell(2);
                        HSSFCell cardStatus = hssfRow.getCell(3);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                cardInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                cardInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(cardId).equals(".")) {
                                    cardInformation.setCardnum(excelValue.getValue(cardId));
                                }
                                if (!excelValue.getValue(cardStatus).equals(".")) {
                                    cardInformation.setCardstatus(excelValue.getValue(cardStatus));
                                }
                                cardInformations.add(cardInformation);
                                continue;
                            }
                            continue;
                        } catch (Exception e) {
                            System.out.println("读取card_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCardInfor.setYear(excelValue.getValue(year));
                            errorCardInfor.setCardID(excelValue.getValue(cardId));
                            errorCardInfor.setCardNum(excelValue.getValue(cardNum));
                            errorCardInfor.setCardStatus(excelValue.getValue(cardStatus));
                            errorCardInfors.add(errorCardInfor);
                            continue;
                        }
                    }
                }
            }
        } else if (path.endsWith(".xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                for (int numRow = 1; numRow <= xssfSheet.getLastRowNum(); numRow++) {
                    XSSFRow xssfRow = xssfSheet.getRow(numRow);
                    if (xssfRow != null) {
                        cardInformation = new CardInformation();
                        errorCardInfor = new ErrorCardInfor<>();
                        XSSFCell year = xssfRow.getCell(0);
                        XSSFCell cardId = xssfRow.getCell(1);
                        XSSFCell cardNum = xssfRow.getCell(2);
                        XSSFCell cardStatus = xssfRow.getCell(3);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                if (!excelValue.getValue(cardId).equals(".")) {
                                    cardInformation.setCardnum(excelValue.getValue(cardId));
                                }
                                if (!excelValue.getValue(cardStatus).equals(".")) {
                                    cardInformation.setCardstatus(excelValue.getValue(cardStatus));
                                }
                                cardInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                cardInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                cardInformations.add(cardInformation);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("读取card_information相关表格数据时出现了问题 信息:" + e.getMessage());
                            errorCardInfor.setYear(excelValue.getValue(year));
                            errorCardInfor.setCardNum(excelValue.getValue(cardNum));
                            errorCardInfor.setCardID(excelValue.getValue(cardId));
                            errorCardInfor.setCardStatus(excelValue.getValue(cardStatus));
                            errorCardInfors.add(errorCardInfor);
                            continue;
                        }
                    }
                }
            }
        }
        RowDataSorted<ErrorCardInfor<String>, CardInformation> rowDataSorted = new RowDataSorted<>();
        rowDataSorted.setErrorReadingList(errorCardInfors);
        rowDataSorted.setKeyNotNullList(cardInformations);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorCardInfor<String>, CardInformation> saveDataToCardInfor(String path) throws Exception {
        RowDataSorted<ErrorCardInfor<String>, CardInformation> rowDataSorted
                = getExcelData(path);
        UploadDBMessage<ErrorCardInfor<String>, CardInformation> uploadDBMessage
                = new UploadDBMessage<>();
        List<CardInformation> excelRows = rowDataSorted.getKeyNotNullList();
        uploadDBMessage.setErrorReadingList(rowDataSorted.getErrorReadingList());
        List<CardInformation> errorOperatingList = new ArrayList<>();
        List<CardInformation> insertDataList = new ArrayList<>();
        List<CardInformation> updateDataList = new ArrayList<>();
        CardInformation rowData = null;
        CardInformationKey cardInformationKey = new CardInformationKey();
        for (int i = 0; i < excelRows.size(); i++) {
            rowData = excelRows.get(i);
            if (null == rowData.getYear() || null == rowData.getCardid()){
                continue;
            }
            cardInformationKey.setYear(rowData.getYear());
            cardInformationKey.setCardid(rowData.getCardid());
            if (cardInformationMapper.selectByPrimaryKey(cardInformationKey) != null) {
                updateDataList.add(rowData);
                continue;
            }
            insertDataList.add(rowData);
        }
        int insertNum = 0;
        for (int i = 0; i < insertDataList.size(); i++) {
            CardInformation current = insertDataList.get(i);
            try {
                if (cardInformationMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("card_information插入数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("car_information插入数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        int updateNum = 0;
        for (int i = 0; i < updateDataList.size(); i++) {
            CardInformation current = updateDataList.get(i);
            try {
                if (cardInformationMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("card_information更新数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("car_information更新数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        return uploadDBMessage;
    }
}
