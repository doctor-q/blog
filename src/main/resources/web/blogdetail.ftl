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
                        Apple放大绝进行反取证
                    </h2>

                </div>
                <div>
                    <div class="postText">
                    <div id="cnblogs_post_body" class="blogpost-body"><p><span style="font-size: 16px">取证说穿了其实就是攻防,这本是正义与邪恶的对决,亦即执法单位与嫌疑犯两者之间的事,但现实生活中要比这复杂多了.</span>
                    </p>
                        <p><span style="font-size: 16px">怎么说呢?举个例子大家便理解了.取证人员费尽心思,用尽各种手法,努力地想要自手机上提取重要迹证,以还原真相,除暴安良.但此时手机厂商却跳出来了,她说为了保障个人隐私,因此她们必须致力于提升安全性,以维护用户权益.</span>
                        </p>
                        <p><span style="font-size: 16px">这下子可好了,所谓的用户,厂商自然无法去区分谁是坏蛋,因此这保障用户的个人稳私,提升安全性的效果,便是使用得取证难度倍增,好人坏人都全给无差别保护到了.</span>
                        </p>
                        <p><span style="font-size: 16px">但当执法单位希望厂商给予必要协助时,却遭厂商悍然拒绝,还一副义正词严表明不想当政府走狗.真的是太可笑了,想藉此突显Apple有多爱用户吗?多为用户的隐私着想吗?其实是为了用户的$$着想吧,总想着如何可以从用户荷包里再多掏出一些来.</span>
                        </p>
                        <p><span style="font-size: 16px">脸书执行长说的好,Apple不该一方面卖一般人负担不起的高价手机,一方面却又企图告诉用户Apple有多在乎他/她们.但库克显然不以为意,就是要卖这么贵怎样~</span>
                        </p>
                        <p><span style="font-size: 16px">不过最近Apple大概是被搞毛了,自上回法鲁克的那支iPhone 5c被破解,加上Graykey横空出世,全是冲着破解iDevice来的. 但Apple却也不是吃白饭来着的,她们决定放大绝,来个釜底抽薪.</span>
                        </p>
                        <p><span style="font-size: 16px">Apple在iOS 11.4.1加入了USB配件功能,默认即会启用,具体功效是-</span></p>
                        <p><span
                                style="font-size: 16px">"让iDevice的取证时效缩减到1小时以内~",若上锁超过1小时,哪怕取证人员已取得代表信任关系的plist也枉然.</span>
                        </p>
                        <p><span style="font-size: 16px"><img
                                src="https://images2018.cnblogs.com/blog/706830/201807/706830-20180722094035901-1889269394.png"
                                alt=""></span></p>
                        <p>&nbsp;</p>
                        <p><span style="font-size: 16px">还不懂吗?演示给各位看一下便知了.拿了一支iOS 11.4.1的iPhone,它曾与嫌疑犯的计算机连接过,建立了信任关系,因此在下图的路径之中会生成一个代表信任关系的plist文件.在过往,取证人员只要拿到这plist,就可以bypass上锁的iDevice而顺利取证.</span>
                        </p>
                        <p><span style="font-size: 16px"><img
                                src="https://images2018.cnblogs.com/blog/706830/201807/706830-20180722094140860-329307733.png"
                                alt=""></span></p>
                        <p><span style="font-size: 16px">先回顾一下先前曾为各位说明过的这代表信任关系的plist之生命周期的重大变化,首先是一旦iDevice关机或重启,先前的plist便无用,但有机会的是,基於人性及使用习惯,人们还是会再去接计算机继续同步,同步后的plist即为有效的取证关键.</span>
                        </p>
                        <p><span style="font-size: 16px">但未料Apple这回直接从Lightning接口下手,若一支iPhone处于上锁状态达一个小时以上,即便你再把它接回1小時前才同步过的计算机,此时会发生一个状况,那就是,计算机不认得这支iPhone了,此时iTunes也不会有反应.就好似你不曾接上任何iDevice一样.</span>
                        </p>
                        <p><span style="font-size: 16px">发生何事呢?去看iPhone便知了,有个讯息提示要"解锁"才行.这就是Apple的大绝,让一切都回归到必须解锁才行,这下子iDevice就难有搞头了.</span>
                        </p>
                        <p><span style="font-size: 16px"><img
                                src="https://images2018.cnblogs.com/blog/706830/201807/706830-20180722094216557-1158355633.png"
                                alt=""></span></p>
                        <p>&nbsp;</p>
                        <p><span style="font-size: 16px">Elcomsoft此时做了一件事,他们也去测试,发现若插入USB Camera等设备,竟可以reset iDevice的counter,即让1小时的限制破功.但最搞笑的她们还公诸于世.难道以为Apple是吃素的,都不会有所反应无动于衷就是了.</span>
                        </p>
                        <p><span style="font-size: 16px">且让我们拭目以待,希望Apple不要一意孤行,不要搞的iPhone成了"反取证神机"的代名词才好.</span></p>
                    </div>
                    <div id="MySignature"></div>
                    <div class="clear"></div>
                </div>
                    <div style="padding: 20px 0 10px 0">
                        文章分类： <a href="#">手机</a>
                    </div>
                </div>
                <div>
                    <span>
                        <a href="#"><i class="ace-icon fa fa-heart"></i>赞(0)</a>
                        &nbsp;&nbsp;
                        <i class="ace-icon fa fa-book"></i>阅读(0)</span>
                    </span>
                    <span class="pull-right">
                        <i class="ace-icon fa fa-clock-o bigger-110"></i>
                        2018-07-22 10:23:55
                    </span>
                </div>
                <div class="hr hr-12 hr-dotted"></div>
                <div>
                    <div class="blue small">评论(2)</div>
                    <div class="row">
                        <textarea class="col-xs-12"></textarea>
                        <div><button class="btn btn-primary btn-sm pull-right">评论</button></div>
                    </div>
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">藏镜人</a>
                                <span class="grey">2018-07-22 10:23:55 评论</span>
                            </h5>

                            <span class="small pull-right">
                                <a class="smaller" href="#">回复</a>
                            </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                却遭厂商悍然拒绝,还一副义正词严表明不想当政府走狗.真的是太可笑了,想藉此突显Apple有多爱用户吗?多为用户的隐私着想吗?其实是为了用户的$$着想吧,总想着如何可以从用户荷包里再。
                                <div class="space-6"></div>
                                <p><a href="#">牧羊人</a>2018-07-22 10:43:55回复<a href="#">藏镜人</a>：一方面却又企图告诉用户Apple有多在乎他/她们。
                                </p>
                                <p><a href="#">牧羊人</a>2018-07-22 10:43:55回复<a href="#">藏镜人</a>：举个例子大家便理解了.取证人员费尽心思,用尽各种手法,努力地想要自手机上提取重要迹证,以还原真相,除暴安良.但此时手机厂商却跳出来了,她说为了保障个人隐私,因此她们必须致力于提升安全性,以维护用户权益.

                                    这下子可好了,所谓的用户,厂商自然无法去区分谁是坏蛋,因此这保障用户的个人稳私,提升安全性的效果,便是使用得取证难度倍增,好人坏人都全给无差别保护到了.

                                    但当执法单位希望厂商给予必要协助时,却遭厂商悍然拒绝,还一副义正词严表明不想当政府走狗.真的是太可笑了,想藉此突显Apple有多爱用户吗?多为用户的隐私着想吗?其实是为了用户的$$着想吧,总想着如何可以从用户荷包里再多掏出一些来.。
                                </p>
                                <p><a href="#">牧羊人</a>2018-07-22 10:43:55回复<a href="#">藏镜人</a>：一方面却又企图告诉用户Apple有多在乎他/她们。
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="widget-box transparent">
                        <div class="widget-header widget-header-small">
                            <h5 class="widget-title smaller">
                                <a href="#" class="blue">藏镜人</a>
                                <span class="grey">2018-07-22 10:23:55 评论</span>
                            </h5>

                            <span class="small pull-right">
                                <a class="smaller" href="#">回复</a>
                            </span>
                        </div>

                        <div class="widget-body">
                            <div class="widget-main">
                                却遭厂商悍然拒绝,还一副义正词严表明不想当政府走狗.真的是太可笑了,想藉此突显Apple有多爱用户吗?多为用户的隐私着想吗?其实是为了用户的$$着想吧,总想着如何可以从用户荷包里再。
                                <div class="space-6"></div>
                                <p><a href="#">牧羊人</a>2018-07-22 10:43:55回复<a href="#">藏镜人</a>：一方面却又企图告诉用户Apple有多在乎他/她们。
                                </p>
                                <p><a href="#">牧羊人</a>2018-07-22 10:43:55回复<a href="#">藏镜人</a>：举个例子大家便理解了.取证人员费尽心思,用尽各种手法,努力地想要自手机上提取重要迹证,以还原真相,除暴安良.但此时手机厂商却跳出来了,她说为了保障个人隐私,因此她们必须致力于提升安全性,以维护用户权益.

                                    这下子可好了,所谓的用户,厂商自然无法去区分谁是坏蛋,因此这保障用户的个人稳私,提升安全性的效果,便是使用得取证难度倍增,好人坏人都全给无差别保护到了.

                                    但当执法单位希望厂商给予必要协助时,却遭厂商悍然拒绝,还一副义正词严表明不想当政府走狗.真的是太可笑了,想藉此突显Apple有多爱用户吗?多为用户的隐私着想吗?其实是为了用户的$$着想吧,总想着如何可以从用户荷包里再多掏出一些来.。
                                </p>
                                <p><a href="#">牧羊人</a>2018-07-22 10:43:55回复<a href="#">藏镜人</a>：一方面却又企图告诉用户Apple有多在乎他/她们。
                                </p>
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