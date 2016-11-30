<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>基于时空的疟疾数据监控系统</title>

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->

    <link href="${webRoot}/css/navStyle.css" rel="stylesheet" type="text/css" />
    <link href="${webRoot}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${webRoot}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${webRoot}/css/animate.css" rel="stylesheet">
    <link href="${webRoot}/css/style.css" rel="stylesheet">
    <style type="text/css">
        .section {
            text-align: center;
            font: 50px "Microsoft Yahei";
            color: #fff;
        }

        a:focus, a:hover {
            color: #FFFFFF
        }

        .cd-main-nav {
            margin: 1px;
        }

        .cd-main-nav li {
            display: inline-block;
            float: left;
            height: 100%;
            padding: 1.22em 0.4em;
        }

        .my-small-navbar {
            border-radius: 0px;
            margin: 0 !important;
            background-color: rgb(51, 53, 69) !important;
            border: 0;
        }

        .my-fa-bar {
            width: 44px;
            height: 40px;
            line-height: 3;
        }

        .myTitle {
            color: white;
            font-family: "Adobe 宋体 Std L";
            font-size: 200%
        }

        /*.footer{*/
        /*width:0;*/
        /*height: 1%;*/
        /*}*/
        #content-main {
            height: calc(100% - 90px);
            overflow: scroll;
        }

        .nav:first-child {
            list-style: outside none none;
            margin-bottom: 0;
            margin-top: 10%;
            padding-left: 0;
        }
    </style>
</head>

<body class="fixed-sidebar full-height-layout gray-bg skin-1 mini-navbar" style="overflow:hidden">
<header class="cd-main-header animate-search">
    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary my-small-navbar" href="#">
        <i class="fa fa-bars my-fa-bar"></i> </a>
    <nav class="cd-main-nav-wrapper">
        <div class="myTitle" align="center">基于时空的疟疾分析系统</div>
    </nav>
</header>
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">

                <li>
                    <a class="J_menuItem" href="/undone.jsp">
                        <i class="fa fa fa-calculator"></i>
                        <span class="nav-label">执行计算</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="fa fa fa-fire"></i>
                        <span class="nav-label">爆发与分析</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/hotMap.jsp" class="J_menuItem">热力图</a>
                            <a href="/hotMap.jsp" class="J_menuItem">动态迁移</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a class="J_menuItem" href="/charts.jsp">
                        <i class="fa fa fa-bar-chart"></i>
                        <span class="nav-label">数据分析</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <i class="fa fa fa-area-chart"></i>
                        <span class="nav-label">统计预测</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/undone.jsp" class="J_menuItem">1</a>
                            <a href="/undone.jsp" class="J_menuItem">2</a>
                            <a href="/undone.jsp" class="J_menuItem">3</a>
                            <a href="/undone.jsp" class="J_menuItem">4</a>
                            <a href="/undone.jsp" class="J_menuItem">5</a>
                            <a href="/undone.jsp" class="J_menuItem">6</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a class="J_menuItem" href="undone.jsp">
                        <i class="fa fa fa-database"></i>
                        <span class="nav-label">相关数据</span>
                    </a>
                </li>

            </ul>
        </div>

    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">

        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="http://localhost:8080/index.jsp" class="active J_menuTab" data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a>
                    </li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                    </li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                    </li>
                </ul>
            </div>
            <a href="./login.jsp" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 登录</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index.jsp" frameborder="0"
                    data-id="index_v1.html" seamless></iframe>
        </div>
        <!--<div class="footer">-->
        <!--<div class="pull-right">© 2014-2015 <a href="http://www.zi-han.net/" target="_blank">zihan's blog</a>-->
        <!--</div>-->
        <!--</div>-->
    </div>
</div>
<!--右侧部分结束-->

<!-- 全局js -->
<script src="${webRoot}/js/jquery.min.js"></script>
<script src="${webRoot}/js/bootstrap.min.js"></script>
<script src="${webRoot}/js/jquery.metisMenu.js"></script>
<script src="${webRoot}/js/jquery.slimscroll.min.js"></script>

<!-- 自定义js -->
<script src="${webRoot}/js/hplus.js"></script>
<script type="text/javascript" src="${webRoot}/js/contabs.js"></script>

<!-- 第三方插件 -->
<script src="${webRoot}/js/pace.min.js"></script>

</body>

</html>
