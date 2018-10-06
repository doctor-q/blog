<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
</head>
<body>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="col-xs-12 center">
                <div>
                    <span class="profile-picture">
                        <img id="avatar" class="editable img-responsive" alt="头像"
                             src="${blogger.header}"/>
                    </span>

                    <div class="space-4"></div>

                    <div class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                        <div class="inline position-relative">
                            <a href="#" class="user-title-label dropdown-toggle" data-toggle="dropdown">
                                <i class="ace-icon fa fa-circle light-green"></i>
                                &nbsp;
                                <span class="white">${blogger.username}</span>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="space-6"></div>

                <div class="profile-contact-info">


                    <div class="space-6"></div>

                    <div class="profile-social-links align-center">
                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
                            <i class="middle ace-icon fa fa-qq fa-2x"></i>
                        </a>

                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
                            <i class="middle ace-icon fa fa-weibo fa-2x red"></i>
                        </a>

                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
                            <i class="middle ace-icon fa fa-github-square fa-2x"></i>
                        </a>

                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Facebook">
                            <i class="middle ace-icon fa fa-facebook-square fa-2x blue"></i>
                        </a>

                        <a href="#" class="tooltip-info" title="" data-original-title="Visit my Twitter">
                            <i class="middle ace-icon fa fa-twitter-square fa-2x light-blue"></i>
                        </a>

                    </div>
                </div>

                <div class="hr hr12 dotted"></div>

                <div class="clearfix">
                    <div class="grid3">
                        <span class="bigger-175 blue">${blogger.followerNum!0}</span>
                        粉丝
                    </div>

                    <div class="grid3">
                        关注
                        <span class="bigger-175 blue">${blogger.attentionNum!0}</span>
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
                            <i class="ace-icon fa fa-caret-right blue"></i>博客：${blogger.blogNum!0}篇
                        </li>

                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>博龄：${blogger.blogAge!0}年
                        </li>

                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>QQ：${blogger.qq!''}
                        </li>

                        <li>
                            <i class="ace-icon fa fa-caret-right blue"></i>
                            邮箱：${blogger.email!''}
                        </li>

                        <li class="divider"></li>

                    </ul>
                </div>

                <div class="hr hr16 dotted"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>