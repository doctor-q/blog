<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>博客详情</title>
</head>
<body>

<#include 'nav.ftl'>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="col-xs-2">
            </div>
            <div class="col-xs-8">
                <div class="row">
                    <h2 class="header center">
                        {{blogDetail.title}}
                    </h2>

                </div>
                <div>
                    <div class="postText">
                        <div id="cnblogs_post_body" class="blogpost-body">
                            {{blogDetail.content}}
                        </div>
                        <div id="MySignature"></div>
                        <div class="clear"></div>
                    </div>
                    <div style="padding: 20px 0 10px 0">
                        文章分类： <a href="#">{{blogDetail.category}}</a>
                    </div>
                </div>
                <div>
                    <span>
                        <a href="#"><i class="ace-icon fa fa-heart"></i>赞({{blogDetail.approvalNum}})</a>
                        &nbsp;&nbsp;
                        <i class="ace-icon fa fa-book"></i>阅读({{blogDetail.readNum}})</span>
                    </span>
                    <span class="pull-right">
                        <i class="ace-icon fa fa-clock-o bigger-110"></i>
                        {{blogDetail.createdAt}}
                    </span>
                </div>
                <div class="hr hr-12 hr-dotted"></div>
                <div>
                    <div class="blue small">评论({{blogDetail.commentNum}})</div>
                    <div class="row">
                        <textarea class="col-xs-12"></textarea>
                        <div>
                            <button class="btn btn-primary btn-sm pull-right">评论</button>
                        </div>
                    </div>
                    <div>
                        <#list commentDetails as commentDetail></#list>
                        <div class="widget-box transparent">
                            <div class="widget-header widget-header-small">
                                <h5 class="widget-title smaller">
                                    <a href="#" class="blue">{{commentDetail.userName}}</a>
                                    <span class="grey">{{commentDetail.createdAt}}评论</span>
                                </h5>

                                <span class="small pull-right">
                                <a class="smaller" href="#">回复</a>
                            </span>
                            </div>

                            <div class="widget-body">
                                <div class="widget-main">
                                    {{commentDetail.comment}}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>