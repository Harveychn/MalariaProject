<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/23
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>地址解析</title>
    <script type="text/javascript" src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
    <script type="text/javascript" src="${webRoot}/js/plugins/baiduApi/geoCodingApi.js"></script>
</head>
<body>
<div align="center">
    <h3>地址经纬度采集测试</h3>
    <div id="test">
        <button id="btn" onclick="doOptions();">点击测试</button>
    </div>
</div>
</body>
</html>
