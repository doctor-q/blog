<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>博客列表</title>
</head>
<body>
<#include 'nav.ftl'>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="col-xs-12 col-sm-3 center">
                <div>
                    <span class="profile-picture">
                        <img id="avatar" class="editable img-responsive" alt="Alex's Avatar"
                             src="/assets/images/avatars/profile-pic.jpg"/>
                    </span>

                    <div class="space-4"></div>

                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                        <div class="inline position-relative">
                            <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                <i class="ace-icon fa fa-circle light-green"></i>
                                &nbsp;
                                <span class="white">牧羊人</span>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="space-6"></div>

                <div class="profile-contact-info">


                    <div class="space-6"></div>

                    <div class="profile-social-links align-center">
                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
                            <i class="middle ace-icon fa fa-facebook-square fa-2x blue"></i>
                        </a>

                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Twitter">
                            <i class="middle ace-icon fa fa-twitter-square fa-2x light-blue"></i>
                        </a>

                        <a href="#" class="tooltip-error" title="" data-original-title="Visit my Pinterest">
                            <i class="middle ace-icon fa fa-pinterest-square fa-2x red"></i>
                        </a>
                    </div>
                </div>

                <div class="hr hr12 dotted"></div>

                <div class="clearfix">
                    <div class="grid3">
                        <span class="bigger-175 blue">25</span>
                        粉丝
                    </div>

                    <div class="grid3">
                        关注
                        <span class="bigger-175 blue">12</span>
                        人
                    </div>
                    <div class="grid3">
                        <a href="#" class="btn btn-link">
                            <i class="ace-icon fa fa-plus-circle bigger-120 green"></i>
                            关注他
                        </a>
                    </div>
                </div>

                <div class="hr hr12 dotted"></div>

                <div align="left" style="padding-left: 40px">
                    <ul class="list-unstyled spaced">
                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>博客：32篇
                        </li>

                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>博龄：7年
                        </li>

                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>QQ：1327251984
                        </li>

                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>
                            邮箱：1327251984@qq.com
                        </li>

                        <li class="divider"></li>

                    </ul>
                </div>

                <div class="hr hr16 dotted"></div>
            </div>
            <div class="col-xs-8">
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
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">《我不是药神》 观影有感——为自己挣命</a>
                            </h5>

                            <span class="widget-toolbar no-border">
                        <i class="ace-icon fa fa-clock-o bigger-110"></i>
                        16:22
                        </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <div style="padding-bottom: 15px">
                                    单从电影的角度看，这确实是一部很好的电影。我一直觉得，电影就是讲故事，剧本是故事的框架，而演员是故事的血肉。无疑，这部电影骨架坚实，血肉丰满。
                                    但我今天不想谈这部电影的好与坏，只就故事的些许片段进行讨论。 电影中有这样一幕，黄毛引开警察后被车撞死，在医院程勇质问警官“他只是想活着，有罪吗？”有罪吗？ ...
                                </div>
                                <div>
                                    <span><i class="ace-icon glyphicon glyphicon-user"></i>
                                        作者：<a href="#">牧羊人</a></span>
                                    <span class="pull-right">
                                        <i class="ace-icon fa fa-heart"></i>赞(0)
                                        &nbsp;<i class="ace-icon fa fa-pencil-square-o"></i>评论(0)
                                        &nbsp;<i class="ace-icon fa fa-book"></i>阅读(0)</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hr hr16 dotted"></div>
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">《我不是药神》 观影有感——为自己挣命</a>
                            </h5>

                            <span class="widget-toolbar no-border">
                            <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                16:22
                            </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <div>
                                    单从电影的角度看，这确实是一部很好的电影。我一直觉得，电影就是讲故事，剧本是故事的框架，而演员是故事的血肉。无疑，这部电影骨架坚实，血肉丰满。
                                    但我今天不想谈这部电影的好与坏，只就故事的些许片段进行讨论。 电影中有这样一幕，黄毛引开警察后被车撞死，在医院程勇质问警官“他只是想活着，有罪吗？”有罪吗？ ...
                                </div>
                                <div>
                                    <span><i class="ace-icon glyphicon glyphicon-user"></i>
                                        作者：<a href="#">牧羊人</a></span>
                                    <span class="pull-right">
                                        <i class="ace-icon fa fa-heart"></i>赞(0)
                                        &nbsp;<i class="ace-icon fa fa-pencil-square-o"></i>评论(0)
                                        &nbsp;<i class="ace-icon fa fa-book"></i>阅读(0)</span>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="hr hr16 dotted"></div>
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">《我不是药神》 观影有感——为自己挣命</a>
                            </h5>

                            <span class="widget-toolbar no-border">
                            <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                16:22
                            </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <div>
                                    单从电影的角度看，这确实是一部很好的电影。我一直觉得，电影就是讲故事，剧本是故事的框架，而演员是故事的血肉。无疑，这部电影骨架坚实，血肉丰满。
                                    但我今天不想谈这部电影的好与坏，只就故事的些许片段进行讨论。 电影中有这样一幕，黄毛引开警察后被车撞死，在医院程勇质问警官“他只是想活着，有罪吗？”有罪吗？ ...
                                </div>
                                <div>
                                    <span><i class="ace-icon glyphicon glyphicon-user"></i>
                                        作者：<a href="#">牧羊人</a></span>
                                    <span class="pull-right">
                                        <i class="ace-icon fa fa-heart"></i>赞(0)
                                        &nbsp;<i class="ace-icon fa fa-pencil-square-o"></i>评论(0)
                                        &nbsp;<i class="ace-icon fa fa-book"></i>阅读(0)</span>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="hr hr16 dotted"></div>
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">《我不是药神》 观影有感——为自己挣命</a>
                            </h5>

                            <span class="widget-toolbar no-border">
                            <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                16:22
                            </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <div>
                                    单从电影的角度看，这确实是一部很好的电影。我一直觉得，电影就是讲故事，剧本是故事的框架，而演员是故事的血肉。无疑，这部电影骨架坚实，血肉丰满。
                                    但我今天不想谈这部电影的好与坏，只就故事的些许片段进行讨论。 电影中有这样一幕，黄毛引开警察后被车撞死，在医院程勇质问警官“他只是想活着，有罪吗？”有罪吗？ ...
                                </div>
                                <div>
                                    <span><i class="ace-icon glyphicon glyphicon-user"></i>
                                        作者：<a href="#">牧羊人</a></span>
                                    <span class="pull-right">
                                        <i class="ace-icon fa fa-heart"></i>赞(0)
                                        &nbsp;<i class="ace-icon fa fa-pencil-square-o"></i>评论(0)
                                        &nbsp;<i class="ace-icon fa fa-book"></i>阅读(0)</span>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="hr hr16 dotted"></div>
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">《我不是药神》 观影有感——为自己挣命</a>
                            </h5>

                            <span class="widget-toolbar no-border">
                            <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                16:22
                            </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                <div>
                                    单从电影的角度看，这确实是一部很好的电影。我一直觉得，电影就是讲故事，剧本是故事的框架，而演员是故事的血肉。无疑，这部电影骨架坚实，血肉丰满。
                                    但我今天不想谈这部电影的好与坏，只就故事的些许片段进行讨论。 电影中有这样一幕，黄毛引开警察后被车撞死，在医院程勇质问警官“他只是想活着，有罪吗？”有罪吗？ ...
                                </div>
                                <div>
                                    <span><i class="ace-icon glyphicon glyphicon-user"></i>
                                        作者：<a href="#">牧羊人</a></span>
                                    <span class="pull-right">
                                        <i class="ace-icon fa fa-heart"></i>赞(0)
                                        &nbsp;<i class="ace-icon fa fa-pencil-square-o"></i>评论(0)
                                        &nbsp;<i class="ace-icon fa fa-book"></i>阅读(0)</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hr hr16 dotted"></div>
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