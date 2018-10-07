<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人设置</title>
    <link rel="stylesheet" href="/assets/css/chosen.min.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap-datepicker3.min.css"/>
    <style>
    </style>
</head>
<body>

<#include 'nav.ftl'>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="col-xs-4">
                <#include 'profile.ftl'>
            </div>
            <div class="col-sm-6">
                <div class="tabbable">
                    <ul class="nav nav-tabs" id="myTab">
                        <li class="active">
                            <a data-toggle="tab" href="#form-blogger-info">
                                <i class="green ace-icon glyphicon glyphicon-user bigger-120"></i>
                                个人信息
                            </a>
                        </li>
                        <li>
                            <a data-toggle="tab" href="#form-contact">
                                <i class="ace-icon fa fa-envelope bigger-120"></i>
                                联系方式
                            </a>
                        </li>
                        <li>
                            <a data-toggle="tab" href="#form-category">
                                <i class="ace-icon fa fa-bookmark-o bigger-120"></i>
                                博客分类
                            </a>
                        </li>
                        <li>
                            <a data-toggle="tab" href="#form-followers">
                                <i class="ace-icon fa fa-users bigger-120"></i>
                                我的粉丝
                            </a>
                        </li>
                        <li>
                            <a data-toggle="tab" href="#form-attentions">
                                <i class="ace-icon fa fa-heart bigger-120"></i>
                                我的关注
                            </a>
                        </li>
                    </ul>

                    <div class="tab-content" style="height: 500px">
                        <div id="form-blogger-info" class="tab-pane fade in active">
                            <input name="id" type="hidden" value="${blogger.id!''}">
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">头像：</label></div>
                                <div class="col-xs-9">
                                    <label class="ace-file-input"><input type="file" id="id-input-file-2">
                                        <span class="ace-file-container" data-title="选择">
                                        <span class="ace-file-name" data-title="选择文件 ...">
                                            <i class=" ace-icon fa fa-upload"></i>
                                        </span>
                                    </span>
                                        <a class="remove" href="#">
                                            <i class=" ace-icon fa fa-times"></i>
                                        </a>
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">性别：</label></div>
                                <div class="col-xs-9">
                                    <select class="form-control" name="gender">
                                        <option value="0" <#if blogger.gender == 0>selected="selected"</#if>>男</option>
                                        <option value="1" <#if blogger.gender == 1>selected="selected"</#if>>女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">出生日期：</label></div>
                                <div class="col-xs-9">
                                    <div class="input-group">
                                        <input class="form-control date-picker" id="id-date-picker-1" type="text"
                                               name="birthday" data-date-format="yyyy-mm-dd" value="${blogger.birthday?datetime?string('yyyy-MM-dd')}">
                                        <span class="input-group-addon">
                                            <i class="fa fa-calendar bigger-110"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">地址：</label></div>
                                <div class="col-xs-9"><input class="form-control" name="address" value="${blogger.address!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">公司：</label></div>
                                <div class="col-xs-9"><input class="form-control" name="company" value="${blogger.company!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">职位：</label></div>
                                <div class="col-xs-9"><input class="form-control" name="position" value="${blogger.position!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">婚姻状况：</label></div>
                                <div class="col-xs-9">
                                    <select class="form-control" name="marriageStatus">
                                        <option value="0" <#if blogger.marriageStatus == 0>selected="selected"</#if>>单身待解救</option>
                                        <option value="1" <#if blogger.marriageStatus == 1>selected="selected"</#if>>有对象</option>
                                        <option value="2" <#if blogger.marriageStatus == 2>selected="selected"</#if>>已结婚</option>
                                        <option value="3" <#if blogger.marriageStatus == 3>selected="selected"</#if>>有仔</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-11">
                                    <button class="btn btn-primary btn-sm pull-right" id="btn-blogger-info">提交</button>
                                </div>
                            </div>
                        </div>
                        <div id="form-contact" class="tab-pane fade">
                            <input name="id" type="hidden" value="${blogger.id!''}">
                            <div class="form-group">
                                <div class="col-xs-2">
                                    <label class="pull-right">
                                        手机号<i class="ace-icon glyphicon glyphicon-earphone"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="mobile" value="${blogger.mobile!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">
                                    邮箱<i class="ace-icon fa fa-envelope"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="email" value="${blogger.email!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">
                                    QQ<i class="ace-icon fa fa-qq"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="qq" value="${blogger.qq!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">
                                    Github<i class="ace-icon fa fa-github"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="github" value="${blogger.github!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">
                                    微博<i class="ace-icon fa fa-weibo"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="weibo" value="${blogger.weibo!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">
                                    Facebook<i class="ace-icon fa fa-facebook"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="facebook" value="${blogger.facebook!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-2"><label class="pull-right">
                                    Twitter<i class="ace-icon fa fa-twitter"></i></label></div>
                                <div class="col-xs-9"><input class="form-control" name="twitter" value="${blogger.twitter!''}"></div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-11">
                                    <button class="btn btn-primary btn-sm pull-right" id="btn-contact">提交</button>
                                </div>
                            </div>
                        </div>
                        <div id="form-category" class="tab-pane fade">
                            <ul id="tree1"></ul>
                        </div>
                        <div id="form-followers" class="tab-pane fade">
                            <#list blogger.followers as follower>
                            <div class="profile-activity clearfix">
                                <div>
                                    <img class="pull-left" src="${follower.header!''}">
                                    <a class="user" href="#">${follower.follower}</a>
                                    <span></span>
                                    <div class="time">
                                        <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                        ${follower.createdAt?datetime?string('yyyy-MM-dd HH:mm:ss')}
                                    </div>
                                </div>

                                <div class="tools action-buttons">
                                    <a class="blue" href="" onclick="attention(${follower.followerId}, ${follower.follower})">
                                        关注ta
                                    </a>
                                </div>
                            </div>
                            </#list>
                            <div class="pull-right">
                                <a href="#">上一页</a>&nbsp;&nbsp;&nbsp;<a href="#">下一页</a>
                            </div>
                        </div>
                        <div id="form-attentions" class="tab-pane fade">
                            <#list blogger.attentions as attention>
                            <div class="profile-activity clearfix">
                                <div>
                                    <img class="pull-left" src="${attention.header!''}">
                                    <a class="user" href="#">${attention.blogger}</a>
                                    <span></span>
                                    <div class="time">
                                        <i class="ace-icon fa fa-clock-o bigger-110"></i>
                                        ${attention.createdAt?datetime?string('yyyy-MM-dd HH:mm:ss')}
                                    </div>
                                </div>

                                <div class="tools action-buttons">
                                    <a class="red2" href="" onclick="unAttention(${attention.id}, ${attention.blogger})">
                                        取消关注
                                    </a>
                                </div>
                            </div>
                            </#list>
                            <div class="pull-right">
                                <a href="#">上一页</a>&nbsp;&nbsp;&nbsp;<a href="#">下一页</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!-- /.col -->
        </div>
    </div>
</div>
<script src="/assets/js/chosen.jquery.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/assets/js/chosen.jquery.min.js"></script>
<script src="/assets/js/spinbox.min.js"></script>
<script src="/assets/js/bootstrap-datepicker.min.js"></script>
<script src="/assets/js/bootstrap-datepicker.zh-CN.js"></script>
<script src="/assets/js/moment.min.js"></script>
<script src="/assets/js/tree.min.js"></script>
<script>
    $('.date-picker').datepicker({
        language: 'zh-CN',
        autoclose: true,
        todayHighlight: true
    }).next().on(ace.click_event, function () {
        $(this).prev().focus();
    });

    $('#tree1').ace_tree({
        dataSource: initiateDemoData(),
        multiSelect: true,
        cacheItems: true,
        'open-icon': 'ace-icon tree-minus',
        'close-icon': 'ace-icon tree-plus',
        'itemSelect': true,
        'folderSelect': false,
        'selected-icon': 'ace-icon fa fa-check',
        'unselected-icon': 'ace-icon fa fa-times',
        loadingHTML: '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>'
    });

    function initiateDemoData() {
        var tree_data = {
            'vehicles': {text: 'Vehicles', type: 'folder'},
            'tickets': {text: 'Tickets', type: 'item'},
            'services': {text: 'Services', type: 'item'},
            'personals': {text: 'Personals', type: 'item'}
        };
        tree_data['vehicles']['additionalParameters'] = {
            'children': {
                'cars': {text: 'Cars', type: 'folder'},
                'motorcycles': {text: 'Motorcycles', type: 'item'},
                'boats': {text: 'Boats', type: 'item'}
            }
        };
        tree_data['vehicles']['additionalParameters']['children']['cars']['additionalParameters'] = {
            'children': {
                'classics': {text: 'Classics', type: 'item'},
                'convertibles': {text: 'Convertibles', type: 'item'},
                'coupes': {text: 'Coupes', type: 'item'},
                'hatchbacks': {text: 'Hatchbacks', type: 'item'},
                'hybrids': {text: 'Hybrids', type: 'item'},
                'suvs': {text: 'SUVs', type: 'item'},
                'sedans': {text: 'Sedans', type: 'item'},
                'trucks': {text: 'Trucks', type: 'item'}
            }
        };
        var dataSource = function (options, callback) {
            var $data = null;
            if (!("text" in options) && !("type" in options)) {
                $data = tree_data;//the root tree
                callback({data: $data});
                return;
            }
            else if ("type" in options && options.type === "folder") {
                if ("additionalParameters" in options && "children" in options.additionalParameters)
                    $data = options.additionalParameters.children || {};
                else $data = {}//no data
            }

            if ($data != null)//this setTimeout is only for mimicking some random delay
                setTimeout(function () {
                    callback({data: $data});
                }, parseInt(Math.random() * 500) + 200);
        };
        return dataSource
    }

</script>
<script src="/static/js/settings.js"></script>
</body>
</html>