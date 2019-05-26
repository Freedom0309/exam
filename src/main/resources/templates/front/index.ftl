﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <title>陕西高考志愿填报信息管理平台</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet"/>
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet"/>
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet"/>
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/index.css" rel="stylesheet"/>
    <style>

        .layui-form-item .layui-input-inline {
            float: right;
            width: 65px;
            margin: 10px 0px 0px 0px;
        }

        .layui-btn {
            background-color: #ffffff;
            color: #444;
        }
    </style>
</head>
<body>
<!-- 导航 -->
<nav class="blog-nav layui-header">
    <div class="blog-container">
        <!-- 用户登陆 -->

        <a class="blog-logo" href="/">陕西高考志愿填报信息管理平台</a>
        <!-- 导航菜单 -->
        <div class="blog-user"></div>

        <ul class="layui-nav" lay-filter="nav">
            <li class="layui-nav-item layui-this">
                <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;学校信息</a>
            </li>

            <li class="layui-nav-item">
                <a href="/school/recommend"><i class="fa fa-home fa-fw"></i>&nbsp;学校推荐</a>
            </li>

            <li class="layui-nav-item">
                <a href="/user/index"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
            </li>
        </ul>
        <!-- 手机和平板的导航开关 -->
        <a class="blog-navicon" href="javascript:;">
            <i class="fa fa-navicon"></i>
        </a>
    </div>
</nav>
<!-- 主体（一般只改变这里的内容） -->
<div class="blog-body">
    <div class="layui-carousel blog-bg" id="carousel">
        <div carousel-item>
            <div class="bg bg_a"></div>
            <div class="bg bg_b"></div>
            <div class="bg bg_c"></div>
            <div class="bg bg_d"></div>
            <div class="bg bg_e"></div>
        </div>
    </div>
    <div class="blog-container">
        <div class="blog-main">
            <!-- 网站公告提示 -->
            <div class="home-tips shadow">
                <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                <div class="home-tips-container">
                    <span style="color: #009688">有事做有所期待，日子就是幸福的</span>
                    <span style="color: #009688">用心每一天，不忘初心，方能走远</span>
                    <span style="color: #009688">偷偷挤进一缕斜阳，送来满满幸福</span>
                </div>
                <div class="layui-layout-right layui-hide btn-comment">
                    <span>留言板</span>
                </div>
            </div>
            <div class="layui-hide comment">

                <div style="backg  round-color: #F2F2F2;">
                    <div class="layui-row layui-col-space15">
                        <div class="layui-col-md12" id="card">
                        <#--<div class="layui-card">
                                <div class="layui-card-header">标题</div>
                                <div class="layui-card-body">
                                    内容
                                </div>
                            </div>
                            <div class="layui-card">
                                <div class="layui-card-header">标题</div>
                                <div class="layui-card-body">
                                    内容
                                </div>
                            </div>-->
                        </div>
                    </div>

                </div>

                <div class="">
                    <form id="form1" class="layui-form " lay-filter="form">
                        <input type="text" name="userId" class="layui-hide userId"/>
                        <textarea class="layui-textarea" lay-verify="required" name="content"
                                  placeholder="请输入内容"></textarea>

                        <div class="layui-form-item">
                            <div class="layui-input-inline">
                                <button class="layui-btn" lay-submit="" lay-filter="save">保存</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
            <!--左边文章列表-->
            <div class="blog-main-left animated slideInLeft" id="jobList">
					<@jobList>
						<#list list as x>
							<div class="article shadow animated fadeInLeft">
                            <#--<div class="article-left ">
                                <img src="${ctx!}/images/01.jpg" alt="${x.name}"/>
                            </div>-->

                                <div class="article-right">
                                    <div class="article-title">
                                        <a href="/school/detail/${x.id}">学校名称：${x.name}</a>
                                    </div>
                                    <div class="article-abstract">
                                        学校级别：${x.level}
                                    </div>
                                    <div class="article-abstract">
                                        学校类型：${x.type}
                                    </div>
                                    <div class="article-abstract">
                                        学校地址：${x.address}
                                    </div>
                                </div>
                                <div class="clear"></div>
                            <#--<div class="article-footer">
                                <span><i class="fa fa-clock-o"></i>&nbsp;&nbsp;${x.createTime}</span>
                                <span class="article-author"><i class="fa fa-user"></i>&nbsp;&nbsp;${x.title}</span>
                                <span><i class="fa fa-tag"></i>&nbsp;&nbsp;<a href="#">${x.experience}</a></span>
                            </div>-->
                            </div>
                        </#list>
                    </@jobList>
            </div>
            <!--右边小栏目-->
            <div class="blog-main-right">
                <div class="blog-search">
                    <form class="layui-form" action="">
                        <div class="layui-form-item">
                            <div class="search-keywords  shadow">
                                <input type="text" name="key" placeholder="请输入学校名称" autocomplete="off"
                                       class="layui-input ">
                            </div>
                            <div class="search-submit  shadow">
                                <a class="search-btn" lay-submit lay-filter="schoolSearch"><i class="fa fa-search"></i></a>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="search-keywords  shadow">
                                <input type="text" name="proName" placeholder="请输入专业名称" autocomplete="off"
                                       class="layui-input ">
                            </div>
                            <div class="search-submit  shadow">
                                <a class="search-btn" lay-submit lay-filter="professionSearch"><i
                                        class="fa fa-search"></i></a>
                            </div>
                        </div>
                    </form>
                </div>
                <!--推荐/点击排行-->
                <div class="layui-tab layui-tab-brief shadow animated fadeInRight" lay-filter="docDemoTabBrief">
                    <ul class="layui-tab-title">
                        <li class="layui-this">点击名称</li>
                        <!--<li>站长推荐</li>-->
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <ul class="blog-module-ul">
                                    <@jobList>
                                        <#list list as x>
                                        <#--<#if x_index == 0>
                                            <li><i class="layui-badge-rim layui-bg-red">${x_index+1}</i>&nbsp;&nbsp;<a href="/school/detail/${x.id}">${x.name}</a></li>
                                        <#elseif x_index == 1>
                                            <li><i class="layui-badge-rim layui-bg-orange">${x_index+1}</i>&nbsp;&nbsp;<a href="/school/detail/${x.id}">${x.name}</a></li>
                                        <#elseif x_index == 2>
                                            <li><i class="layui-badge-rim layui-bg-green">${x_index+1}</i>&nbsp;&nbsp;<a href="/school/detail/${x.id}">${x.name}</a></li>
                                        <#else >
                                        </#if>-->
                                               <li><i class="layui-badge-rim">${x_index+1}</i>&nbsp;&nbsp;<a
                                                       href="/school/detail/${x.id}">${x.name}</a></li>

                                        </#list>
                                    </@jobList>

                            <#--<li><i class="layui-badge-rim layui-bg-red">1</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">Java开发工程师</a></li>-->
                            <#--<li><i class="layui-badge-rim layui-bg-orange">2</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">高级php开发工程师</a></li>-->
                            <#--<li><i class="layui-badge-rim layui-bg-green">3</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">c#软件工程师!</a></li>-->
                            <#--<li><i class="layui-badge-rim">4</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">办公室文员</a></li>-->
                            <#--<li><i class="layui-badge-rim">5</i>&nbsp;&nbsp;<a href="/jobSeeker/job/1">销售总监/经理</a></li>-->
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="blog-module shadow">
                    <div class="blog-module-title">友情链接</div>
                    <ul class="blogroll">
                        <li><a target="_blank" href="http://www.layui.com/" title="Layui">Layui</a></li>
                    </ul>

                </div>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
<!-- 底部 -->
<footer class="blog-footer">
    <p><span>Copyright</span><span>&copy;</span><span>2018</span>陕西高考志愿填报信息管理平台</p>
</footer>
<!--侧边导航-->
<ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
    <li class="layui-nav-item layui-this">
        <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;学校信息</a>
    </li>

    <li class="layui-nav-item">
        <a href="/user/index"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
    </li>
</ul>

<!--遮罩-->
<div class="blog-mask animated layui-hide"></div>
<!-- layui.js -->
<script src="${ctx!}/layui/layui.js"></script>
<!-- 全局脚本 -->
<script src="${ctx!}/js/global.js"></script>
<script src="${ctx!}/js/canvas-particle.js"></script>
<!-- 本页脚本 -->
<script src="${ctx!}/js/index.js"></script>
<script type="text/javascript">
    layui.define(['layer', 'form'], function (exports) {
        var $ = layui.jquery,
                form = layui.form;
        //监听学校提交
        form.on('submit(schoolSearch)', function (data) {
            $.ajax({
                type: "GET",
                dataType: "json",
                data: data.field,
                url: "/school/searchSchool",
                success: function (result) {
                    if (result.isOk) {
                        console.log(result.data);
                        createHtml(result.data);
                    } else {
                        layer.msg(result.msg, {anim: 6});
                    }
                }
            });
            return false;
        });

        //监听专业提交
        form.on('submit(professionSearch)', function (data) {
            $.ajax({
                type: "GET",
                dataType: "json",
                data: data.field,
                url: "/profession/searchProfession",
                success: function (result) {
                    if (result.isOk) {
                        console.log(result.data);
                        createProfession(result.data);
                    } else {
                        layer.msg(result.msg, {anim: 6});
                    }
                }
            });
            return false;
        });
        var user = MyLocalStorage.get("user");
        if (user != null && user != '') {
            user = JSON.parse(user);
            $(".userId").val(user.id);
        }
        //打开关闭留言板
        $(".btn-comment").on('click', function () {
            if ($(".comment").hasClass("layui-hide")) {
                var userId = $('.userId').val();
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    url: "/comment/list",
                    data: {id: userId},
                    success: function (result) {
                        if (result.isOk) {
                            if (result.data.length > 0)
                                createComment(result.data);
                        } else {
                            layer.msg(result.msg, {anim: 6});
                        }
                    }
                });
                $(".comment").removeClass("layui-hide");
            } else {
                $(".comment").addClass("layui-hide");
            }
        });
        //监听留言
        form.on('submit(save)', function (data) {
            var userId = $('.userId').val();
            var content = data.field.content;
            $.ajax({
                type: "POST",
                dataType: "json",
                data: {
                    content: content,
                    userId: userId
                },
                url: "/comment/save",
                success: function (result) {
                    if (result.isOk) {
                        console.log(result.data);
                        if (result.data.length > 0)
                            createComment(result.data);
                        window.location = window.location.href;

                    } else {
                        layer.msg(result.msg, {anim: 6});
                    }
                }
            });
            return false;
        });

        function createComment(data) {
            obj = $("#card");
            obj.empty();
            var detailHtml = '';
            for (var i = 0; i < data.length; i++) {
                detailHtml += '<div class="layui-card">';
                detailHtml += '<div class="layui-card-header">' + data[i].jobSeeker.name + '&nbsp;&nbsp;留言时间：&nbsp;&nbsp;' + data[i].time + '</div>';
                detailHtml += '<div class="layui-card-body">' + data[i].content + '</div>';
                detailHtml += '</div>';
            }
            obj.append(detailHtml);
        }

        function createHtml(data) {
            obj = $("#jobList");
            obj.empty();
            var detailHtml = '';
            for (var i = 0; i < data.length; i++) {
                detailHtml += '<div class="article shadow animated fadeInLeft">';
                detailHtml += '<div class="article-right">';
                detailHtml += '<div class="article-title">';
                detailHtml += '<a href="/school/detail/' + data[i].id + '">学校名称：' + data[i].name + '</a></div>';
                detailHtml += '<div class="article-abstract">级别：' + data[i].level + '</div>';
                detailHtml += '<div class="article-abstract">类型：' + data[i].type + '</div>';
                detailHtml += '<div class="article-abstract">地址：' + data[i].address + '</div>';

                detailHtml += '</div>';
                detailHtml += '<div class="clear"></div>';
                detailHtml += '</div>';
            }
            obj.append(detailHtml);
        }

        function createProfession(data) {
            obj = $("#jobList");
            obj.empty();
            var detailHtml = '';
            $.each(data, function (i, obj) {

                detailHtml += '<div class="article shadow animated fadeInLeft">';
                detailHtml += '<div class="article-right">';
                // detailHtml += '<div class="article-title">';
                // detailHtml += '<a>学校名称：' + obj[0].name + '</a></div>';
                detailHtml += '<div class="article-title">专业名称：' + obj.name + '</div>';
                detailHtml += '<div class="article-abstract">描述：' + obj.description + '</div>';
                detailHtml += '<div class="article-abstract">前景：' + obj.future + '</div>';
                detailHtml += '</div>';
                detailHtml += '<div class="clear"></div>';
                detailHtml += '</div>';
            });
            obj.append(detailHtml);
        }
    });
</script>
</body>
</html>