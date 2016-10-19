package com.zxh.ssm.module.download.service;

import com.zxh.ssm.module.download.pojo.CategoryFieldsRe;
import com.zxh.ssm.module.download.pojo.DownloadParamVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
public interface DownloadDBDataService {
    List<CategoryFieldsRe> getFieldsNameDownload(String category) throws Exception;

    HSSFWorkbook downloadData(DownloadParamVo downloadParamVo) throws Exception;
}
