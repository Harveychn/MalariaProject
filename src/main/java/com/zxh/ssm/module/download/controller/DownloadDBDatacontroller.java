package com.zxh.ssm.module.download.controller;

import com.zxh.ssm.module.download.pojo.CategoryFieldsRe;
import com.zxh.ssm.module.download.service.DownloadDBDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
@Controller
@RequestMapping("/DownloadDBData")
public class DownloadDBDataController {
    @Resource
    private DownloadDBDataService downloadDBDataService;

    @RequestMapping("/fieldNameDownloadable")
    public
    @ResponseBody
    List<CategoryFieldsRe> fieldNameDownloadable(@RequestParam(value = "dataCategory") String Category) throws Exception {

        List<CategoryFieldsRe> categoryFieldsRes = downloadDBDataService.getFieldsNameDownload(Category);
        if (categoryFieldsRes != null) {
            return categoryFieldsRes;
        }
        return null;
    }



}
