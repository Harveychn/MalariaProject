package com.zxh.ssm.module.user.service.impl;

import com.zxh.ssm.module.whole.mapper.WeatherDataMapper;
import com.zxh.ssm.module.user.pojo.*;
import com.zxh.ssm.module.user.service.UploadToWeatherService;
import com.zxh.ssm.module.whole.pojo.WeatherData;
import com.zxh.ssm.module.whole.pojo.WeatherDataKey;
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
 * Created by 郑晓辉 on 2016/10/12.
 */
@Service
public class UploadToWeatherServiceImpl implements UploadToWeatherService {
    @Resource
    private WeatherDataMapper weatherDataMapper;

    private RowDataSorted<ErrorWeatherInfor<String>, WeatherData> getExcelData(String path) throws Exception {
        GetExcelValue excelValue = new GetExcelValue();
        List<ErrorWeatherInfor<String>> errorWeatherInfors = new ArrayList<>();
        List<WeatherData> weatherDatas = new ArrayList<>();
        ErrorWeatherInfor<String> errorWeatherInfor = null;
        WeatherData weatherData = null;
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
                        errorWeatherInfor = new ErrorWeatherInfor<>();
                        weatherData = new WeatherData();
                        HSSFCell districtStationNum = hssfRow.getCell(0);
                        HSSFCell weatherYear = hssfRow.getCell(1);
                        HSSFCell weatherMonth = hssfRow.getCell(2);
                        HSSFCell weatherDay = hssfRow.getCell(3);
                        HSSFCell precipitation2020 = hssfRow.getCell(4);
                        HSSFCell maximumWindSpeed = hssfRow.getCell(5);
                        HSSFCell directionMaximumWindSpeed = hssfRow.getCell(6);
                        HSSFCell avePressure = hssfRow.getCell(7);
                        HSSFCell aveWindSpeed = hssfRow.getCell(8);
                        HSSFCell aveTemperature = hssfRow.getCell(9);
                        HSSFCell aveVaporPressure = hssfRow.getCell(10);
                        HSSFCell aveRelativeHumidity = hssfRow.getCell(11);
                        HSSFCell sunshineTime = hssfRow.getCell(12);
                        HSSFCell dailyMinPressure = hssfRow.getCell(13);
                        HSSFCell dailyMinTemperature = hssfRow.getCell(14);
                        HSSFCell dailyMaxPressure = hssfRow.getCell(15);
                        HSSFCell dailyMaxTemperature = hssfRow.getCell(16);
                        HSSFCell maxWindSpeed = hssfRow.getCell(17);
                        HSSFCell directionMaxWindSpeed = hssfRow.getCell(18);
                        HSSFCell minRelativeHumidity = hssfRow.getCell(19);
                        try {
                            if (!excelValue.getValue(districtStationNum).equals(".") && !excelValue.getValue(weatherYear).equals(".")
                                    && !excelValue.getValue(weatherMonth).equals(".") && !excelValue.getValue(weatherDay).equals(".")) {
                                weatherData.setDistrictstationnum(Integer.parseInt(excelValue.getValue(districtStationNum)));
                                weatherData.setWeatheryear(Integer.parseInt(excelValue.getValue(weatherYear)));
                                weatherData.setWeathermonth(Integer.parseInt(excelValue.getValue(weatherMonth)));
                                weatherData.setWeatherday(Integer.parseInt(excelValue.getValue(weatherDay)));
                                weatherData.setPrecipitation2020(excelValue.getValue(precipitation2020));
                                if (!excelValue.getValue(maximumWindSpeed).equals(".")) {
                                    weatherData.setMaximumwindspeed(Integer.parseInt(excelValue.getValue(maximumWindSpeed)));
                                }
                                weatherData.setDirectionmaximumwindspeed(excelValue.getValue(directionMaximumWindSpeed));

                                if (!excelValue.getValue(avePressure).equals(".")) {
                                    weatherData.setAvepressure(Integer.parseInt(excelValue.getValue(avePressure)));
                                }

                                if (!excelValue.getValue(aveWindSpeed).equals(".")) {
                                    weatherData.setAvewindspeed(Integer.parseInt(excelValue.getValue(aveWindSpeed)));
                                }
                                if (!excelValue.getValue(aveTemperature).equals(".")) {
                                    weatherData.setAvetemperature(Integer.parseInt(excelValue.getValue(aveTemperature)));
                                }
                                if (!excelValue.getValue(aveVaporPressure).equals(".")) {
                                    weatherData.setAvevaporpressure(Integer.parseInt(excelValue.getValue(aveVaporPressure)));
                                }
                                if (!excelValue.getValue(aveRelativeHumidity).equals(".")) {
                                    weatherData.setAverelativehumidity(Integer.parseInt(excelValue.getValue(aveRelativeHumidity)));
                                }
                                if (!excelValue.getValue(sunshineTime).equals(".")) {
                                    weatherData.setSunshinetime(Integer.parseInt(excelValue.getValue(sunshineTime)));
                                }
                                if (!excelValue.getValue(dailyMinPressure).equals(".")) {
                                    weatherData.setDailyminpressure(Integer.parseInt(excelValue.getValue(dailyMinPressure)));
                                }
                                if (!excelValue.getValue(dailyMinTemperature).equals(".")) {
                                    weatherData.setDailymintemperature(Integer.parseInt(excelValue.getValue(dailyMinTemperature)));
                                }
                                if (!excelValue.getValue(dailyMaxPressure).equals(".")) {
                                    weatherData.setDailymaxpressure(Integer.parseInt(excelValue.getValue(dailyMaxPressure)));
                                }
                                if (!excelValue.getValue(dailyMaxTemperature).equals(".")) {
                                    weatherData.setDailymaxtemperature(Integer.parseInt(excelValue.getValue(dailyMaxTemperature)));
                                }
                                if (!excelValue.getValue(maxWindSpeed).equals(".")) {
                                    weatherData.setMaxwindspeed(Integer.parseInt(excelValue.getValue(maxWindSpeed)));
                                }
                                if (!excelValue.getValue(directionMaxWindSpeed).equals(".")) {
                                    weatherData.setDirectionmaxwindspeed(excelValue.getValue(directionMaxWindSpeed));
                                }
                                if (!excelValue.getValue(minRelativeHumidity).equals(".")) {
                                    weatherData.setMinrelativehumidity(Integer.parseInt(excelValue.getValue(minRelativeHumidity)));
                                }
                                weatherDatas.add(weatherData);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("上传文件时读取weather_data表格数据出现异常 信息：" + e.getMessage());
                            errorWeatherInfor.setDistrictStationNum(excelValue.getValue(districtStationNum));
                            errorWeatherInfor.setWeatherYear(excelValue.getValue(weatherYear));
                            errorWeatherInfor.setWeatherMonth(excelValue.getValue(weatherMonth));
                            errorWeatherInfor.setWeatherDay(excelValue.getValue(weatherDay));
                            errorWeatherInfor.setPrecipitation2020(excelValue.getValue(precipitation2020));
                            errorWeatherInfor.setMaximumWindSpeed(excelValue.getValue(maximumWindSpeed));
                            errorWeatherInfor.setDirectionMaximumWindSpeed(excelValue.getValue(directionMaximumWindSpeed));
                            errorWeatherInfor.setAvePressure(excelValue.getValue(avePressure));
                            errorWeatherInfor.setAveWindSpeed(excelValue.getValue(aveWindSpeed));
                            errorWeatherInfor.setAveTemperature(excelValue.getValue(aveTemperature));
                            errorWeatherInfor.setAveVaporPressure(excelValue.getValue(aveVaporPressure));
                            errorWeatherInfor.setAveRelativeHumidity(excelValue.getValue(aveRelativeHumidity));
                            errorWeatherInfor.setSunshineTime(excelValue.getValue(sunshineTime));
                            errorWeatherInfor.setDailyMinPressure(excelValue.getValue(dailyMinPressure));
                            errorWeatherInfor.setDailyMinTemperature(excelValue.getValue(dailyMinTemperature));
                            errorWeatherInfor.setDailyMaxPressure(excelValue.getValue(dailyMaxPressure));
                            errorWeatherInfor.setDailyMaxTemperature(excelValue.getValue(dailyMaxTemperature));
                            errorWeatherInfor.setMaxWindSpeed(excelValue.getValue(maxWindSpeed));
                            errorWeatherInfor.setDirectionMaxWindSpeed(excelValue.getValue(directionMaxWindSpeed));
                            errorWeatherInfor.setMinRelativeHumidity(excelValue.getValue(minRelativeHumidity));
                            errorWeatherInfors.add(errorWeatherInfor);
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
                        errorWeatherInfor = new ErrorWeatherInfor<>();
                        weatherData = new WeatherData();
                        XSSFCell districtStationNum = xssfRow.getCell(0);
                        XSSFCell weatherYear = xssfRow.getCell(1);
                        XSSFCell weatherMonth = xssfRow.getCell(2);
                        XSSFCell weatherDay = xssfRow.getCell(3);
                        XSSFCell precipitation2020 = xssfRow.getCell(4);
                        XSSFCell maximumWindSpeed = xssfRow.getCell(5);
                        XSSFCell directionMaximumWindSpeed = xssfRow.getCell(6);
                        XSSFCell avePressure = xssfRow.getCell(7);
                        XSSFCell aveWindSpeed = xssfRow.getCell(8);
                        XSSFCell aveTemperature = xssfRow.getCell(9);
                        XSSFCell aveVaporPressure = xssfRow.getCell(10);
                        XSSFCell aveRelativeHumidity = xssfRow.getCell(11);
                        XSSFCell sunshineTime = xssfRow.getCell(12);
                        XSSFCell dailyMinPressure = xssfRow.getCell(13);
                        XSSFCell dailyMinTemperature = xssfRow.getCell(14);
                        XSSFCell dailyMaxPressure = xssfRow.getCell(15);
                        XSSFCell dailyMaxTemperature = xssfRow.getCell(16);
                        XSSFCell maxWindSpeed = xssfRow.getCell(17);
                        XSSFCell directionMaxWindSpeed = xssfRow.getCell(18);
                        XSSFCell minRelativeHumidity = xssfRow.getCell(19);
                        try {
                            if (!excelValue.getValue(districtStationNum).equals(".") && !excelValue.getValue(weatherYear).equals(".")
                                    && !excelValue.getValue(weatherMonth).equals(".") && !excelValue.getValue(weatherDay).equals(".")) {
                                weatherData.setDistrictstationnum(Integer.parseInt(excelValue.getValue(districtStationNum)));
                                weatherData.setWeatheryear(Integer.parseInt(excelValue.getValue(weatherYear)));
                                weatherData.setWeathermonth(Integer.parseInt(excelValue.getValue(weatherMonth)));
                                weatherData.setWeatherday(Integer.parseInt(excelValue.getValue(weatherDay)));

                                weatherData.setPrecipitation2020(excelValue.getValue(precipitation2020));
                                if (!excelValue.getValue(maximumWindSpeed).equals(".")) {
                                    weatherData.setMaximumwindspeed(Integer.parseInt(excelValue.getValue(maximumWindSpeed)));
                                }
                                weatherData.setDirectionmaximumwindspeed(excelValue.getValue(directionMaximumWindSpeed));

                                if (!excelValue.getValue(avePressure).equals(".")) {
                                    weatherData.setAvepressure(Integer.parseInt(excelValue.getValue(avePressure)));
                                }

                                if (!excelValue.getValue(aveWindSpeed).equals(".")) {
                                    weatherData.setAvewindspeed(Integer.parseInt(excelValue.getValue(aveWindSpeed)));
                                }
                                if (!excelValue.getValue(aveTemperature).equals(".")) {
                                    weatherData.setAvetemperature(Integer.parseInt(excelValue.getValue(aveTemperature)));
                                }
                                if (!excelValue.getValue(aveVaporPressure).equals(".")) {
                                    weatherData.setAvevaporpressure(Integer.parseInt(excelValue.getValue(aveVaporPressure)));
                                }
                                if (!excelValue.getValue(aveRelativeHumidity).equals(".")) {
                                    weatherData.setAverelativehumidity(Integer.parseInt(excelValue.getValue(aveRelativeHumidity)));
                                }
                                if (!excelValue.getValue(sunshineTime).equals(".")) {
                                    weatherData.setSunshinetime(Integer.parseInt(excelValue.getValue(sunshineTime)));
                                }
                                if (!excelValue.getValue(dailyMinPressure).equals(".")) {
                                    weatherData.setDailyminpressure(Integer.parseInt(excelValue.getValue(dailyMinPressure)));
                                }
                                if (!excelValue.getValue(dailyMinTemperature).equals(".")) {
                                    weatherData.setDailymintemperature(Integer.parseInt(excelValue.getValue(dailyMinTemperature)));
                                }
                                if (!excelValue.getValue(dailyMaxPressure).equals(".")) {
                                    weatherData.setDailymaxpressure(Integer.parseInt(excelValue.getValue(dailyMaxPressure)));
                                }
                                if (!excelValue.getValue(dailyMaxTemperature).equals(".")) {
                                    weatherData.setDailymaxtemperature(Integer.parseInt(excelValue.getValue(dailyMaxTemperature)));
                                }
                                if (!excelValue.getValue(maxWindSpeed).equals(".")) {
                                    weatherData.setMaxwindspeed(Integer.parseInt(excelValue.getValue(maxWindSpeed)));
                                }
                                if (!excelValue.getValue(minRelativeHumidity).equals(".")) {
                                    weatherData.setMinrelativehumidity(Integer.parseInt(excelValue.getValue(minRelativeHumidity)));
                                }
                                if (!excelValue.getValue(directionMaxWindSpeed).equals(".")) {
                                    weatherData.setDirectionmaxwindspeed(excelValue.getValue(directionMaxWindSpeed));
                                }
                                weatherDatas.add(weatherData);
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("上传文件时读取weather_data表格数据出现异常 信息：" + e.getMessage());
                            errorWeatherInfor.setDistrictStationNum(excelValue.getValue(districtStationNum));
                            errorWeatherInfor.setWeatherYear(excelValue.getValue(weatherYear));
                            errorWeatherInfor.setWeatherMonth(excelValue.getValue(weatherMonth));
                            errorWeatherInfor.setWeatherDay(excelValue.getValue(weatherDay));
                            errorWeatherInfor.setPrecipitation2020(excelValue.getValue(precipitation2020));
                            errorWeatherInfor.setMaximumWindSpeed(excelValue.getValue(maximumWindSpeed));
                            errorWeatherInfor.setDirectionMaximumWindSpeed(excelValue.getValue(directionMaximumWindSpeed));
                            errorWeatherInfor.setAvePressure(excelValue.getValue(avePressure));
                            errorWeatherInfor.setAveWindSpeed(excelValue.getValue(aveWindSpeed));
                            errorWeatherInfor.setAveTemperature(excelValue.getValue(aveTemperature));
                            errorWeatherInfor.setAveVaporPressure(excelValue.getValue(aveVaporPressure));
                            errorWeatherInfor.setAveRelativeHumidity(excelValue.getValue(aveRelativeHumidity));
                            errorWeatherInfor.setSunshineTime(excelValue.getValue(sunshineTime));
                            errorWeatherInfor.setDailyMinPressure(excelValue.getValue(dailyMinPressure));
                            errorWeatherInfor.setDailyMinTemperature(excelValue.getValue(dailyMinTemperature));
                            errorWeatherInfor.setDailyMaxPressure(excelValue.getValue(dailyMaxPressure));
                            errorWeatherInfor.setDailyMaxTemperature(excelValue.getValue(dailyMaxTemperature));
                            errorWeatherInfor.setMaxWindSpeed(excelValue.getValue(maxWindSpeed));
                            errorWeatherInfor.setMinRelativeHumidity(excelValue.getValue(minRelativeHumidity));
                            errorWeatherInfor.setDirectionMaxWindSpeed(excelValue.getValue(directionMaxWindSpeed));
                            errorWeatherInfors.add(errorWeatherInfor);
                            continue;
                        }
                    }
                }
            }
        }
        RowDataSorted<ErrorWeatherInfor<String>, WeatherData> rowDataSorted
                = new RowDataSorted<>();
        rowDataSorted.setErrorReadingList(errorWeatherInfors);
        rowDataSorted.setKeyNotNullList(weatherDatas);
        return rowDataSorted;
    }

    public UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> saveDataToWeather(String path) throws
            Exception {
        RowDataSorted<ErrorWeatherInfor<String>, WeatherData> rowDataSorted = getExcelData(path);
        List<ErrorWeatherInfor<String>> errorReadingList = rowDataSorted.getErrorReadingList();
        List<WeatherData> errorOperatingList = new ArrayList<>();
        List<WeatherData> insertList = new ArrayList<>();
        List<WeatherData> updateList = new ArrayList<>();
        List<WeatherData> excelRows = rowDataSorted.getKeyNotNullList();
        WeatherData rowData = null;
        WeatherDataKey weatherDataKey = new WeatherDataKey();
        for (int i = 0; i < excelRows.size(); i++) {
            rowData = excelRows.get(i);
            if (null == rowData.getDistrictstationnum() || null == rowData.getWeatheryear() || null == rowData.getWeathermonth() || null == rowData.getWeatherday()) {
                continue;
            }
            weatherDataKey.setDistrictstationnum(rowData.getDistrictstationnum());
            weatherDataKey.setWeatheryear(rowData.getWeatheryear());
            weatherDataKey.setWeathermonth(rowData.getWeathermonth());
            weatherDataKey.setWeatherday(rowData.getWeatherday());
            if (weatherDataMapper.selectByPrimaryKey(weatherDataKey) != null) {
                updateList.add(rowData);
                continue;
            }
            insertList.add(rowData);
        }
        int insertNum = 0;
        for (int i = 0; i < insertList.size(); i++) {
            WeatherData current = insertList.get(i);
            try {
                if (weatherDataMapper.insert(current) == 1) {
                    insertNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("weather_data插入数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("weather_data插入数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        int updateNum = 0;
        for (int i = 0; i < updateList.size(); i++) {
            WeatherData current = updateList.get(i);
            try {
                if (weatherDataMapper.updateByPrimaryKey(current) == 1) {
                    updateNum += 1;
                    continue;
                }
            } catch (DuplicateKeyException d) {
                System.out.println("weather_data更新数据主键重复异常 信息：" + d.getMessage());
                errorOperatingList.add(current);
                continue;
            } catch (Exception e) {
                System.out.println("weather_data更新数据出现异常 信息： " + e.getMessage());
                errorOperatingList.add(current);
                continue;
            }
        }
        UploadDBMessage<ErrorWeatherInfor<String>, WeatherData> uploadDBMessage
                = new UploadDBMessage<>();
        uploadDBMessage.setErrorReadingList(errorReadingList);
        uploadDBMessage.setErrorOperatingList(errorOperatingList);
        uploadDBMessage.setSuccessInsertNum(insertNum);
        uploadDBMessage.setSuccessUpdateNum(updateNum);
        return uploadDBMessage;
    }
}
