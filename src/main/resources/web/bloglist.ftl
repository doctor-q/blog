<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>博客列表</title>
</head>
<body>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="row">
            <#--排序-->
                <div class="row">
                    <div class="dropdown">
                        <button data-toggle="dropdown" class="btn btn-xs dropdown-toggle" href="#">
                            排序方式
                            <i class="ace-icon fa fa-angle-down icon-only"></i></button>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#" tabindex="-1">综合排序</a>
                            </li>
                            <li>
                                <a href="#" tabindex="-1">阅读量</a>
                            </li>
                            <li>
                                <a href="#" tabindex="-1">时间</a>
                            </li>
                            <li>
                                <a href="#" tabindex="-1">评论数</a>
                            </li>
                        </ul>
                    </div>

                </div>
            <#--列表-->
                <div class="row">
                    <#list blogList as blog>
                        <div class="widget-box transparent">
                            <div class="widget-header widget-header-small">
                                <h5 class="widget-title smaller">
                                    <a href="#" class="blue">{{blog.title}}</a>
                                </h5>

                                <span class="widget-toolbar no-border">
                        <i class="ace-icon fa fa-clock-o bigger-110"></i>
                        {{blog.createdAt}}
                        </span>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    <div style="padding-bottom: 15px">
                                        {{blog.summary}}
                                    </div>
                                    <div>
                                    <span><i class="ace-icon glyphicon glyphicon-user"></i>
                                        作者：<a href="#">牧羊人</a></span>
                                        <span class="pull-right">
                                        <i class="ace-icon fa fa-heart"></i>赞({{blog.approvalNum}})
                                        &nbsp;<i class="ace-icon fa fa-pencil-square-o"></i>评论({{blog.commentNum}})
                                        &nbsp;<i class="ace-icon fa fa-book"></i>阅读({{blog.readNum}})</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="hr hr16 dotted"></div>
                    </#list>
                </div>
            <#--分页-->
                <div class="pull-right">
                    <a href="#">上一页</a>
                    &nbsp;&nbsp;
                    <a href="#">下一页</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>