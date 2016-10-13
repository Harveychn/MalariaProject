package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.user.mapper.PatientInformationMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToPIService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/4.
 */
@Service
public class UploadToPIServiceImpl implements UploadToPIService {

    @Resource
    private PatientInformationMapper patientInformationMapper;

    /**
     * 根据path，对不同版本的Excel文档进行数据的读取
     *
     * @param path Excel文档路径
     * @return 数据的实体List
     * @throws Exception
     */
    private RowDataSorted<ErrorPatientInformation<String>, PatientInformation> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<PatientInformation> list = new ArrayList<PatientInformation>();
        List<ErrorPatientInformation<String>> errorPatientInformationList = new ArrayList<>();
        ErrorPatientInformation<String> errorPatientInformation = null;
        PatientInformation patientInformation = null;

        InputStream is = new FileInputStream(path);
        if (path.endsWith("xls")) {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        patientInformation = new PatientInformation();
                        errorPatientInformation = new ErrorPatientInformation();
                        HSSFCell year = hssfRow.getCell(0);
                        HSSFCell cardId = hssfRow.getCell(1);
                        HSSFCell name = hssfRow.getCell(2);
                        HSSFCell sex = hssfRow.getCell(3);
                        HSSFCell career = hssfRow.getCell(4);
                        HSSFCell birthday = hssfRow.getCell(5);
                        HSSFCell age = hssfRow.getCell(6);
                        HSSFCell workUnit = hssfRow.getCell(7);
                        HSSFCell tel = hssfRow.getCell(8);
                        HSSFCell belongs = hssfRow.getCell(9);
                        HSSFCell address = hssfRow.getCell(10);
                        HSSFCell addrNationId = hssfRow.getCell(11);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                patientInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                patientInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(name).equals(".")) {
                                    patientInformation.setName(excelValue.getValue(name));
                                }
                                if (!excelValue.getValue(career).equals(".")) {
                                    patientInformation.setCareer(excelValue.getValue(career));
                                }
                                if (!excelValue.getValue(sex).equals(".")) {
                                    patientInformation.setSex(excelValue.getValue(sex));
                                }
                                if (!excelValue.getValue(birthday).equals(".")) {
                                    patientInformation.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(excelValue.getValue(birthday)));
                                } else {
                                    patientInformation.setBirthday(null);
                                }
                                if (!excelValue.getValue(age).equals(".")) {
                                    patientInformation.setAge(excelValue.getValue(age));
                                }
                                if (!excelValue.getValue(workUnit).equals(".")) {
                                    patientInformation.setWorkunit(excelValue.getValue(workUnit));
                                }
                                if (!excelValue.getValue(tel).equals(".")) {
                                    patientInformation.setTel(excelValue.getValue(tel));
                                }
                                if (!excelValue.getValue(belongs).equals(".")) {
                                    patientInformation.setBelongs(excelValue.getValue(belongs));
                                }
                                if (!excelValue.getValue(address).equals(".")) {
                                    patientInformation.setAddress(excelValue.getValue(address));
                                }
                                if (!excelValue.getValue(addrNationId).equals(".")) {
                                    patientInformation.setAddrnationid(Integer.valueOf(excelValue.getValue(addrNationId)));
                                } else {
                                    patientInformation.setAddrnationid(0);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("【！读取数据时出了异常】 message:" + e.getMessage());
                            //数据不是按规定填写的，数据格式均为String展示用
                            errorPatientInformation.setYear(excelValue.getValue(year));
                            errorPatientInformation.setCardid(excelValue.getValue(cardId));
                            errorPatientInformation.setName(excelValue.getValue(name));
                            errorPatientInformation.setCareer(excelValue.getValue(career));
                            errorPatientInformation.setSex(excelValue.getValue(sex));
                            errorPatientInformation.setBirthday(excelValue.getValue(birthday));
                            errorPatientInformation.setAge(excelValue.getValue(age));
                            errorPatientInformation.setWorkunit(excelValue.getValue(workUnit));
                            errorPatientInformation.setTel(excelValue.getValue(tel));
                            errorPatientInformation.setBelongs(excelValue.getValue(belongs));
                            errorPatientInformation.setAddress(excelValue.getValue(address));
                            errorPatientInformation.setAddrnationid(excelValue.getValue(addrNationId));
                            errorPatientInformationList.add(errorPatientInformation);
                            continue;
                        }

                        list.add(patientInformation);
                        continue;
                    }
                }
            }
        } else if (path.endsWith("xlsx")) {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        patientInformation = new PatientInformation();
                        errorPatientInformation = new ErrorPatientInformation();
                        XSSFCell year = xssfRow.getCell(0);
                        XSSFCell cardId = xssfRow.getCell(1);
                        XSSFCell name = xssfRow.getCell(2);
                        XSSFCell sex = xssfRow.getCell(3);
                        XSSFCell career = xssfRow.getCell(4);
                        XSSFCell birthday = xssfRow.getCell(5);
                        XSSFCell age = xssfRow.getCell(6);
                        XSSFCell workUnit = xssfRow.getCell(7);
                        XSSFCell tel = xssfRow.getCell(8);
                        XSSFCell belongs = xssfRow.getCell(9);
                        XSSFCell address = xssfRow.getCell(10);
                        XSSFCell addrNationId = xssfRow.getCell(11);
                        try {
                            if (!excelValue.getValue(year).equals(".") && !excelValue.getValue(cardId).equals(".")) {
                                patientInformation.setYear(Integer.parseInt(excelValue.getValue(year)));
                                patientInformation.setCardid(Integer.parseInt(excelValue.getValue(cardId)));
                                if (!excelValue.getValue(name).equals(".")) {
                                    patientInformation.setName(excelValue.getValue(name));
                                }
                                if (!excelValue.getValue(career).equals(".")) {
                                    patientInformation.setCareer(excelValue.getValue(career));
                                }
                                if (!excelValue.getValue(sex).equals(".")) {
                                    patientInformation.setSex(excelValue.getValue(sex));
                                }
                                if (!excelValue.getValue(birthday).equals(".")) {
                                    patientInformation.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(excelValue.getValue(birthday)));
                                } else {
                                    patientInformation.setBirthday(null);
                                }
                                if (!excelValue.getValue(age).equals(".")) {
                                    patientInformation.setAge(excelValue.getValue(age));
                                }
                                if (!excelValue.getValue(workUnit).equals(".")) {
                                    patientInformation.setWorkunit(excelValue.getValue(workUnit));
                                }
                                if (!excelValue.getValue(tel).equals(".")) {
                                    patientInformation.setTel(excelValue.getValue(tel));
                                }
                                if (!excelValue.getValue(belongs).equals(".")) {
                                    patientInformation.setBelongs(excelValue.getValue(belongs));
                                }
                                if (!excelValue.getValue(addrNationId).equals(".")) {
                                    patientInformation.setAddrnationid(Integer.valueOf(excelValue.getValue(addrNationId)));
                                } else {
                                    patientInformation.setAddrnationid(0);
                                }
                                if (!excelValue.getValue(address).equals(".")) {
                                    patientInformation.setAddress(excelValue.getValue(address));
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("【！读取数据时出了异常】 message:" + e.getMessage());
                            //数据不是按规定填写的，数据格式均为String展示用
                            errorPatientInformation.setYear(excelValue.getValue(year));
                            errorPatientInformation.setCardid(excelValue.getValue(cardId));
                            errorPatientInformation.setName(excelValue.getValue(name));
                            errorPatientInformation.setSex(excelValue.getValue(sex));
                            errorPatientInformation.setBirthday(excelValue.getValue(birthday));
                            errorPatientInformation.setAge(excelValue.getValue(age));
                            errorPatientInformation.setWorkunit(excelValue.getValue(workUnit));
                            errorPatientInformation.setTel(excelValue.getValue(tel));
                            errorPatientInformation.setBelongs(excelValue.getValue(belongs));
                            errorPatientInformation.setCareer(excelValue.getValue(career));
                            errorPatientInformation.setAddress(excelValue.getValue(address));
                            errorPatientInformation.setAddrnationid(excelValue.getValue(addrNationId));
                            errorPatientInformationList.add(errorPatientInformation);
                            continue;
                        }
                        list.add(patientInformation);
                        continue;
                    }
                }
            }
        }
        RowDataSorted<ErrorPatientInformation<String>, PatientInformation> rowDataSorted = new RowDataSorted<>();
        rowDataSorted.setKeyNotNullList(list);
        rowDataSorted.setErrorReadingList(errorPatientInformationList);
        return rowDataSorted;
    }

    /**
     * 根据文件路径，读取excel文件数据
     *
     * @param path excel文件路径
     * @return 操作状态封装类
     * @throws Exception
     */
    public UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> saveDataToPatientInformation(String path) throws Exception {
        //读取excel数据、处理错误数据
        RowDataSorted<ErrorPatientInformation<String>, PatientInformation> rowDataSorted = getExcelData(path);
        List<PatientInformation> excelDataList = rowDataSorted.getKeyNotNullList();
        List<ErrorPatientInformation<String>> errorReadingList = rowDataSorted.getErrorReadingList();
        //上传文件信息
        UploadDBMessage<ErrorPatientInformation<String>, PatientInformation> uploadDBMessage = new UploadDBMessage<>();
        uploadDBMessage.setErrorReadingList(errorReadingList);

        PatientInformation excelRowData = new PatientInformation();
        //有记录则更新，无记录则插入,主键为空的数据全部丢弃
        PatientInformationKey patientInformationKey = new PatientInformationKey();

        List<PatientInformation> updateDataList = new ArrayList<>();
        List<PatientInformation> insertDataList = new ArrayList<>();
        List<PatientInformation> errorOperatingList = new ArrayList<>();
        //数据遍历分类
        for (int i = 0; i < excelDataList.size(); i++) {
            excelRowData = excelDataList.get(i);
            patientInformationKey.setYear(excelRowData.getYear());
            patientInformationKey.setCardid(excelRowData.getCardid());
            if (patientInformationMapper.selectByPrimaryKey(patientInformationKey) != null) {
                updateDataList.add(excelRowData);
                excelRowData = null;
                continue;
            }
            insertDataList.add(excelRowData);
            excelRowData = null;
            continue;
        }
        //插入操作
        int insertRecordNum = 0;
        for (int i = 0; i < insertDataList.size(); i++) {
            PatientInformation current = insertDataList.get(i);
            try {
                if (patientInformationMapper.insert(current) == 1) {
                    insertRecordNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("【！插入操作主键重复异常】 message:" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("【！插入操作Exception抛出】message:" + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        //更新操作
        int updateRecordNum = 0;
        for (int i = 0; i < updateDataList.size(); i++) {
            PatientInformation current = updateDataList.get(i);
            try {
                if (patientInformationMapper.updateByPrimaryKey(current) == 1) {
                    updateRecordNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("【！更新操作主键重复异常】 message:" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("【！更新操作Exception抛出】message:" + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        //操作结果信息（包括成功插入及更新信息数、错误数据信息、主键为空的数据信息）
        uploadDBMessage.setSuccessInsertNum(insertRecordNum);
        uploadDBMessage.setSuccessUpdateNum(updateRecordNum);
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        return uploadDBMessage;
    }

}