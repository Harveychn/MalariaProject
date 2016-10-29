<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/23
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>数据下载</title>
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="${webRoot}/css/myCss/categoryChoose.css" rel="stylesheet" type="text/css"/>
    <link href="${webRoot}/css/animate.css" rel="stylesheet" type="text/css"/>
    <style>
        body {
            background: url("${webRoot}/images/backImage.jpeg") repeat;
        }
    </style>
    <script src="${webRoot}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${webRoot}/js/myJs/categoryChoose.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <div id="rowContainer" align="center">
        <div id="diseaseDiv" class="myCol1" onclick="handleClick1();">
            <div id="disease" class="message">疟疾数据</div>
        </div>
        <div id="weatherDiv" class="myCol2" onclick="handleClick2();">
            <div id="weather" class="message">气候数据</div>
        </div>
        <div id="stationDiv" class="myCol3" onclick="handleClick3();">
            <div id="station" class="message">观测站数据</div>
        </div>
    </div>
</div>
</body>
</html>
