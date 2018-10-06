<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nav</title>
    <link rel="stylesheet" href="/assets/css/jquery-ui.custom.min.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style"/>
    <link rel="stylesheet" href="/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="/assets/css/ace-rtl.min.css"/>
</head>
<body>
<div class="header_right wow fadeInLeft animated animated" data-wow-delay=".5s"
     style="visibility: visible; animation-delay: 0.5s; animation-name: fadeInLeft;">
    <nav class="navbar navbar-default">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
            <nav class="link-effect-7" id="link-effect-7">
                <ul class="nav navbar-nav">
                    <li class="active act"><a href="/index">主页</a></li>
                    <li><a href="/blog/list">博客</a></li>
                    <li><a href="/about">关于作者</a></li>
                </ul>
            </nav>
            <span class="pull-right" style="padding-top: 10px;color: white">
            <#if profile??>
                <a href="/blog/add" style="color: white">写博客</a>
                &nbsp;&nbsp;&nbsp;<a href="#" style="color: white">${profile.username}</a>
                &nbsp;&nbsp;&nbsp;<a href="/settings/${profile.id}" style="color: white">设置</a>
            <#else >
                <a href="/login" style="color: white">登录</a>
                &nbsp;&nbsp;&nbsp;<a href="/register" style="color: white">注册</a>
            </#if>
        </span>
        </div>
        <!-- /.navbar-collapse -->
    </nav>
</div>

<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/jquery.cookie.js"></script>
<script src="/assets/js/jquery-ui.custom.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>

<!-- ace scripts -->
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>
<script src="/assets/js/ace-extra.min.js"></script>
<script src="/static/js/common.js"></script>
</body>
</html>