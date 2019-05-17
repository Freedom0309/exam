﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>学校信息</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/detail.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- 用户登陆 -->
            <div class="blog-user"></div>

            <!-- 导航菜单 -->
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
        <!-- 这个一般才是真正的主体内容 -->
        <div class="blog-container">
            <div class="blog-main">
                <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                	<a href="/" title="网站首页">网站首页</a>
                	<#--<a href="article.html" title="文章专栏">招聘信息</a>-->
                	<#--<a><cite class="title"></cite></a>-->
           		</blockquote>
                <!--左边文章列表-->
                <div class="blog-main-left animated slideInLeft" style="width: 100%;">
                	<!-- 文章内容（使用Kingeditor富文本编辑器发表的） -->
                    <form class="layui-form">
                        <div class="article-detail shadow">

                            <div class="layui-form-item">
                                <input type="hidden" name="id" value="${school.id}">
                            </div>

                            <div class="article-detail-title title">${school.name}</a></div>
                            <div class="article-detail-sign">
                                <hr class="layui-bg-gray">
                                <p>描述：${school.description}</p>
                                <p>类型：${school.type}</p>
                                <p>网址：<a href="${school.url}" target="_blank">${school.url}</a></p>
                                <p>地址：${school.address}</p>
                                <#list batches as x>
                                <p>
                                    <span>文理科：${x.artsScience}</span>
                                    <span>年份：${x.year?c}</span>
                                    <span>批次：${x.batchNumber}</span>
                                    <span>最低位次：${x.lowBatch}</span>
                                    <span>平均位次：${x.avgBatch}</span>
                                    <span>最低录取分：${x.lowScore}</span>
                                    <span>平均录取分：${x.avgScore}</span>
                                </p>
                                </#list>
                            </div>

                            <div class="article-detail-content">
                            </div >


                        </div>
                    </form>
                </div>

            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!-- 底部 -->
    <footer class="blog-footer">
        <p><span>Copyright</span><span>&copy;</span><span>2018</span><a href="http://www.lyblogs.cn">RecruitManagement</a></p>
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
    <script type="text/javascript">
        layui.define([ 'layer',  'form'], function (exports) {
            var $ = layui.jquery,
            layer = layui.layer,
            form  = layui.form ;
            // 修改个人资料
            var user = MyLocalStorage.get("user");
            user = JSON.parse(user);
            form.on('submit(send)', function(data){
                data = data.field;
                console.log(data);
                console.log(user);
                if(user != null){
                    $.ajax({
                        type: 'GET',
                        async:true,
                        url: "/jobSeeker/send?userId="+user.id+"&jobId="+data.id,
                        success:function(result) {
                            if (result.isOk) {
                                layer.msg(result.msg,{icon:1,time:2000});
                            } else {
                                layer.msg(result.msg,{anim:6,time:2000});
                            }
                        }
                    });
                }else{
                    layer.msg("请先登录",{anim:6,time:2000});
                    window.location.href="/user/login";
                }
                return false;
            });
        });
    </script>
</body>
</html>