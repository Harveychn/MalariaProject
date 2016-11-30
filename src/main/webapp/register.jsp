<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>注册</title>
    <meta name="keywords" content="后台">
    <meta name="description" content="技术">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css" rel="stylesheet">
    
    <link href="${webRoot}/css/plugins/iCheck/register/custom.css" rel="stylesheet">

    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
<style type="text/css">
	body.gray-bg {
    background: #18c8f6;
    height: auto;
    background:url(${webRoot}/css/plugins/iCheck/register/register-img.png) no-repeat center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    ackground-size: cover;
    color: rgba(255,255,255,.95);


/*    background: #18c8f6;
    height: auto;

    background-size: cover;
    */
}
.signinpanel form {
    background: rgba(255, 255, 255, 0.43);
    border: 1px solid rgba(255,255,255,0.4);
    box-shadow: 0 3px 0 rgba(12, 12, 12, 0.03);
    border-radius: 3px;
    padding: 30px;
}
.signinpanel .form-control {
    background: #fff url(../img/user.png) no-repeat 95% center;
    color:#333;
}
.text-muted{
	color: #ffffff;
}
.logo-name{
	font-size:80px !important;
	font-weight: 800;
    letter-spacing: -10px;
    margin-bottom: 0px;
}
</style>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div  class="signinpanel">
            <div>

                <h1 class="logo-name">注&nbsp;册</h1>

            </div>
            <h3>欢迎注册时空的疟疾数据监控系统</h3>
            <p>创建一个新账户</p>
            <form class="m-t" role="form" action="/user/register">
                <div class="form-group">
                    <input type="text" name="useremail" class="form-control" placeholder="请输入邮箱" >
                </div>
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="请输入用户名" >
                </div>
                <div class="form-group">
                    <input type="password" name="userpassword" class="form-control" placeholder="请输入密码" required="">
                </div>
                <div class="form-group">
                    <input type="password" name="confirmpassword" class="form-control" placeholder="请再次输入密码" required="">
                </div>
                <div class="form-group">
                    <input type="text" name="userrealname" class="form-control" placeholder="请输入真实姓名" >
                </div>
                <div class="form-group">
                    <input type="text" name="userphone" class="form-control" placeholder="请输入电话" >
                </div>
                <div class="form-group">
                    <input type="text" name="userunit" class="form-control" placeholder="请输入用户单位" >
                </div>
                <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <strong><input type="checkbox"><i></i> 我同意注册协议</strong></label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login.jsp">点此登录</a>
                </p>
            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${webRoot}/js/jquery.min.js"></script>
    <script src="${webRoot}/js/bootstrap.min.js"></script>
    <!-- iCheck -->
    <script src="${webRoot}/js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>



</body>

</html>
