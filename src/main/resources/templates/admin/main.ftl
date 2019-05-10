﻿<!DOCTYPE html>

<html >
<head>
    <meta charset="utf-8" />
    <title>陕西高考志愿填报信息管理平台</title>
    <link rel="shortcut icon" href="${ctx}/images/jcohy.png" type="image/x-icon">
    <!-- layui.css -->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <!-- font-awesome.css -->
    <link href="${ctx!}/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- animate.css -->
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="${ctx!}/css/main.css" rel="stylesheet" />
</head>
<body>
    <div class="layui-layout layui-layout-admin">
        <!--顶部-->
        <div class="layui-header">
            <div class="ht-console">
                <div class="ht-user">
                    <img src="${ctx!}/images/jcohy.png" />
                    <a class="ht-user-name">${role}</a>
                </div>
            </div>
            <span class="sys-title">陕西高考志愿填报信息管理平台</span>
            <ul class="ht-nav">
                <li class="ht-nav-item">
                    <a id="updatePassword" style="cursor: pointer"><i class="fa fa-power-off fa-fw"></i>修改密码</a>
                    <input type="hidden" value="${Session.user.num?c}" id="num">
                    <input type="hidden" value="${Session.role}" id="role">
                    <input type="hidden" value="${Session.user.id}" >
                </li>
                <li class="ht-nav-item">
                    <a href="${ctx!}/logout"><i class="fa fa-power-off fa-fw"></i>注销</a>
                </li>
            </ul>
        </div>
        <!--侧边导航-->
        <div class="layui-side">
            <div class="layui-side-scroll">
                <ul class="layui-nav layui-nav-tree" lay-filter="leftnav">
                    <li class="layui-nav-item layui-this">
                        <a href="javascript:;"><i class="fa fa-home"></i>首页</a>
                    </li>

                    <#--<li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>求职者管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/lab/index" data-id="1">求职者账户管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/plan/index" data-id="2">求职者简历管理</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>学院管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/addcollege/index" data-id="3">新增学院账户</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/college/index" data-id="4">学院账户管理</a></dd>
                        </dl>
                    </li>-->

                    <#--<li class="layui-nav-item">-->
                        <#--<a href="javascript:;"><i class="fa fa-user"></i>招聘信息管理</a>-->
                        <#--<dl class="layui-nav-child">-->
                            <#--<dd><a href="javascript:;" data-url="${ctx!}/admin/managereq/index" data-id="5">请求审核</a></dd>-->
                            <#--<dd><a href="javascript:;" data-url="${ctx!}/admin/job/index" data-id="6">职位管理</a></dd>-->
                            <#--<dd><a href="javascript:;" data-url="${ctx!}/admin/check/index" data-id="7">应聘人员审核</a></dd>-->
                        <#--</dl>-->
                    <#--</li>-->

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>招聘信息管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/job/index" data-id="6">职位管理</a></dd>
                        </dl>
                    </li>

                   <#-- <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>审核管理</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/managereq/index" data-id="5">请求审核</a></dd>
                        </dl>
                    </li>

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>应聘人员审核</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/check/index" data-id="7">应聘人员审核</a></dd>
                        </dl>
                    </li>-->

                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>学校信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/school/index" data-id="8">学校信息管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/profession/index" data-id="9">专业信息管理</a></dd>
                        </dl>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="fa fa-user"></i>分数信息</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/schoolline/index" data-id="10">学校分数线管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/scoreline/index" data-id="11">省控线管理</a></dd>
                            <dd><a href="javascript:;" data-url="${ctx!}/admin/batch/index" data-id="12">批次管理</a></dd>
                        </dl>
                    </li>

                </ul>
            </div>
        </div>
        <!--收起导航-->
        <div class="layui-side-hide layui-bg-cyan">
            <i class="fa fa-long-arrow-left fa-fw"></i>收起导航
        </div>
        <!--主体内容-->
        <div class="layui-body">
            <div style="margin:0;position:absolute;top:15px;bottom:0px;width:100%;" class="layui-tab layui-tab-brief" lay-filter="tab" lay-allowclose="true">
                <ul class="layui-tab-title">
                    <li lay-id="0" class="layui-this">首页</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <p style="padding: 10px 15px; margin-bottom: 20px; margin-top: 10px; border:1px solid #ddd;display:inline-block;">
                            陕西高考志愿填报信息管理平台
                            <span style="padding-left:1em;">用户帐号：${Session.user.num?c}</span>
                            <span style="padding-left:1em;">用户姓名：${Session.user.name}</span>
                            <#--<span style="padding-left:1em;">角色：${Session.role}</span>-->
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <!--底部信息-->
        <div class="layui-footer">
            <p style="line-height:44px;text-align:center;">Copyright © 2018 - RM. All Rights Reserved</p>
        </div>

    <script src="${ctx!}/js/plugins/layui/layui.js"></script>

    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '${ctx!}/js/'
        }).use('main');
    </script>
</body>
</html>