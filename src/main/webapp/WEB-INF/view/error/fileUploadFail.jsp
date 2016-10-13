<%--
  Created by IntelliJ IDEA.
  User: 郑晓辉
  Date: 2016/10/4
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<div align="center">
    <h2>文件上传失败！</h2>
    <div style="border: 2px solid #3c3f41">
        <h3>
            失败原因:<span style="color: red"><%=request.getAttribute("fileTypeError")%> <%=request.getAttribute("error")%></span>
        </h3>
    </div>
</div>
</body>
</html>
