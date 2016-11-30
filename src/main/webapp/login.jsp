<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录</title>
    <meta name="keywords" content="后台">
    <meta name="description" content="后台">
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css" rel="stylesheet">
    <link href="${webRoot}/css/plugins/login/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <style type="text/css">
    	.btn-success{
    		background-color:#39A7DA;
    		border-color:#39A7DA;
    	}
    </style>
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>基于时空的疟疾数据监控系统</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>后台</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                    </ul>
                    <!--<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>-->
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="/user/login">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到时空的疟疾数据监控系统</p>
                    <input type="text" name="useremail" class="form-control uname" placeholder="邮箱" />
                    <input type="password" name="userpassword" class="form-control pword m-b" placeholder="密码" />
                    <strong><a href="">忘记密码&nbsp;&nbsp;&nbsp;</a></strong>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>还没有账号？ <a href="register.jsp">立即注册&raquo;</a></strong>
                    <a> <input type="submit" name="submit" class="btn btn-success btn-block" value="登陆" id="login"/></a>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2016 开发
            </div>
        </div>
    </div>
</body>

</html>
