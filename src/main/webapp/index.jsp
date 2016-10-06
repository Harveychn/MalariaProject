<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/view/common/tagPage.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>

<br>
<form action="/DynamicOutbreak/subModule1.action" method="post">
    <span>province:<input type="text" name="province"/></span>
    <span>year :<input type="text" name="year"/></span>
    <span>month:<input type="text" name="month"/></span>
    <input type="submit"/>
</form>

<br>
<h3>careerModule.action</h3>
<form action="/AnalyzeController/careerModule.action" method="post">
    <span>province:<input type="text" name="province"/></span>
    <span>beginYear:<input type="text" name="beginYear"/></span>
    <span>endYear:<input type="text" name="endYear"/></span>
    <input type="submit"/>
</form>
<br>
<h3>ageGroupModule.action</h3>
<form action="/AnalyzeController/ageGroupModule.action" method="post">
    <span>province:<input type="text" name="province"/></span>
    <span>beginYear:<input type="text" name="beginYear"/></span>
    <span>endYear:<input type="text" name="endYear"/></span>
    <input type="submit"/>
</form>
<br>
<h3>sexModule.action</h3>
<form action="/AnalyzeController/sexModule.action" method="post">
    <span>province:<input type="text" name="province"/></span>
    <span>beginYear:<input type="text" name="beginYear"/></span>
    <span>endYear:<input type="text" name="endYear"/></span>
    <input type="submit"/>
</form>
<br/>

<h3>uploadFile.action</h3>
<form action="/UploadFile/ToPatient_information.action" method="post" enctype="multipart/form-data">
    <div><input type="file" name="file" accept="application/vnd.ms-excel,
                    application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"></div>
    <input type="submit" value="提交文件"/>
</form>


</body>
</html>
