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
    <script type="text/javascript" src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
</head>
<body>

<div align="center">
    <h3>文件下载测试</h3>
    <form action="/DownloadDBData/downloadExcel.do" method="post">
        <input type="submit"/>
    </form>
</div>
<div align="center">
    <h3>四级联动测试</h3>
    <hr/>
    选择地区：
    <select id='province'>
        <%--<option>---请选择省份---</option>--%>
    </select>
    <select id='city'>
        <%--<option>---请选择市---</option>--%>
    </select>
    <select id='county'>
        <%--<option>---请选择区---</option>--%>
    </select>
    <select id="village">
        <%--<option>---请选择镇---</option>--%>
    </select>
</div>
</body>
<script type="text/javascript" src="${webRoot}/js/FourLevelLinkage.js"></script>
</html>