<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/29
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>500错误</title>
    <link href="${webRoot}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">


<div class="middle-box text-center animated fadeInDown">
    <h1>500</h1>
    <h3 class="font-bold">服务器内部错误</h3>

    <div class="error-desc">
        服务器好像出错了...
        <br/>您可以返回看看
        <br/><a href="${webRoot}/WEB-INF/dataDownload.jsp" class="btn btn-primary m-t">主页</a>
    </div>
</div>

<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js?v=2.1.4"></script>
<script src="${webRoot}/js/bootstrap.min.js?v=3.3.6"></script>

</body>

</html>
