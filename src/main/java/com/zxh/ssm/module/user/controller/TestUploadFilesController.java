package com.zxh.ssm.module.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
@Controller
@RequestMapping("/TestUploadFilesController")
public class TestUploadFilesController {
    @RequestMapping(value = "/uploadToDB", method = RequestMethod.POST)
    public String uploadToDB(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
//        MultipartFile[] multipartFiles = mr.
        List<MultipartFile> multipartFile = mr.getFiles("files[]");
        System.out.println(multipartFile.size());
        return "common/uploadSuccess";
    }
}
