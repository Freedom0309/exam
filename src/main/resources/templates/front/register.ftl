<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
    <title>-注册</title>
    <link rel="shortcut icon" href="images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet"/>
    <link href="${ctx!}/webjars/bootstrap/4.0.0/css/bootstrap.css" rel="stylesheet"/>
    <link href="${ctx!}/webjars/bootstrap-datetimepicker/2.4.2/css/bootstrap-datetimepicker.css" rel="stylesheet"/>
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet"/>
<#--<!-- 本页样式表 &ndash;&gt;-->
<#--<link href="${ctx!}/css/login.css" rel="stylesheet" />-->
</head>
<body>
<!-- 导航 -->
<nav class="blog-nav layui-header">
    <div class="blog-container">
        <a class="blog-logo" href="/">陕西高考志愿填报信息管理平台</a>
        <!-- 导航菜单 -->
        <ul class="layui-nav" lay-filter="nav">
            <li class="layui-nav-item layui-this">
                <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;学校信息</a>
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
    <div class="blog-container">
        <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
            <a href="index.ftl" title="网站首页">网站首页</a>
            <a><cite>登陆注册</cite></a>
        </blockquote>
        <div class="blog-main">
            <div class="layui-tab layui-tab-brief shadow">
                <ul class="layui-tab-title">
                    <li>登陆</li>
                    <li class="layui-this">注册</li>
                </ul>
                <div class="layui-tab-content">
                    <!-- 登陆 -->
                    <div class="layui-tab-item">
                        <form class="layui-form layui-form-pane" method="post">
                            <div class="layui-form-item">
                                <label class="layui-form-label">帐号</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="num" required lay-verify="num" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">密码框</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" required lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" lay-submit lay-filter="loginForm">立即登陆</button>
                            <#--<span style="padding-left: 20px">-->
                            <#--<a href="javascript:forgetPwd()">忘记密码?</a>-->
                            <#--</span>-->
                            </div>
                        </form>
                    </div>
                    <div class="layui-tab-item layui-show">
                        <form class="layui-form layui-form-pane" method="post">
                            <div class="layui-form-item">
                                <label class="layui-form-label">帐号</label>
                                <div class="layui-input-inline">
                                    <input type="email" name="num" required lay-verify="number" autocomplete="off"
                                           class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">将会成为您唯一的登陆名</div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="name" required lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">性别</label>
                                <div class="layui-input-inline">
                                    <input type="radio" name="sex" value="男" title="男">
                                    <input type="radio" name="sex" value="女" title="女">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">年龄</label>
                                <div class="layui-input-inline">
                                    <input type="number" name="age" required lay-verify="required|number" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">出生日期</label>
                                <div class="layui-input-inline">
                                    <input id="birth" type="text"
                                           class="form-control"
                                           placeholder="yyyy-MM-dd" name="birth"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">电话</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="phone" required lay-verify="number" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input id="email" type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input" >
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="password" required lay-verify="required"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">3到18个字符</div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="rePassword" required lay-verify="required"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <button class="layui-btn" lay-submit lay-filter="regForm">立即注册</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- 底部 -->
<footer class="blog-footer">
    <p><span>Copyright</span><span>&copy;</span><span>2018</span><a href="http://www.lyblogs.cn">RecruitManagement</a>
    </p>
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
<!--bootstrap.js-->
<script src="${ctx!}/webjars/jquery/3.0.0/jquery.js" type="text/javascript"></script>
<script src="${ctx!}/webjars/bootstrap/4.0.0/js/bootstrap.js" type="text/javascript"></script>
<script src="${ctx!}/webjars/bootstrap-datetimepicker/2.4.2/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<script src="${ctx!}/webjars/bootstrap-datetimepicker/2.4.2/js/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>

<!-- 全局脚本 -->
<script src="${ctx!}/js/global.js"></script>
<script src="${ctx!}/js/canvas-particle.js"></script>
<!-- 本页脚本 -->
<script src="${ctx!}/js/login.js"></script>
<script src="${ctx!}/js/datetime.js"></script>

</body>
</html>