<%@ page import="com.zxh.ssm.module.user.pojo.DynamicOutbreakVo" %>
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

<a href="/DynamicOutbreak/subModule1.action?dynamicOutbreakVo" target="_blank">
    动态爆发测试Module 1
</a>

<br>
<form action="/DynamicOutbreak/subModule1.action">
    <span>year :<input type="text" name="year"/></span>
    <span>month:<input type="text" name="month"></span>
    <input type="submit"/>
</form>
</body>
</html>
