<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <style>

        #category-list {
            background: whitesmoke;
        }
        #category-list a{
            height: 50px;
            font-size: larger;
            padding-right: 10px;
        }
    </style>
</head>
<body>
<#include 'nav.ftl'>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="col-xs-1"></div>
            <div class="col-xs-1">
                <div style="height: 100px"></div>

                <div class="list-group" id="category-list">
                    <a class="list-group-item" href="#"><label class="pull-right">人工智能</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">云计算</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">大数据</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">前端</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">后端</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">数据库</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">操作系统</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">物联网</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">运维</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">测试</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">算法</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">编程语言</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">游戏开发</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">区块链</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">架构</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">数学</label></a>
                    <a class="list-group-item" href="#"><label class="pull-right">哲学</label></a>
                </div>
            </div>
            <div class="col-xs-8">
                <div>
                    <div class="header">
                        推荐博主
                    </div>
                    <ul class="ace-thumbnails clearfix">
                        <#list bloggerList as blogger>
                        <li>
                            <a href="/blog/list?bloggerId=${blogger.id}" data-rel="colorbox" class="cboxElement">
                                <img width="150" height="150" alt="150x150" src="${blogger.header}">
                                <div class="text">
                                    <div class="inner">${blogger.username}</div>
                                </div>
                            </a>
                        </li>
                        </#list>
                    </ul>
                </div>
                <div>
                    <div class="col-xs-6 input-group pull-right">
                        <input type="text" class="form-control search-query" placeholder="输入关键字">
                        <span class="input-group-btn">
                        <button type="button" class="btn btn-inverse btn-white">
                            <span class="ace-icon fa fa-search icon-on-right bigger-110"></span>
                            搜索
                        </button>
                    </span>
                    </div>

                    <div class="header">推荐博客</div>

                    <#include 'bloglist.ftl'>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>