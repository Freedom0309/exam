<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>-重置密码</title>
    <link rel="shortcut icon" href="${ctx!}/font-awesome/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/font-awesome/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- 导航菜单 -->
            <a class="blog-logo" href="/">大学生招聘网站</a>
            <!-- 导航菜单 -->
            <ul class="layui-nav" lay-filter="nav">
                <li class="layui-nav-item layui-this">
                    <a href="home.html"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
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
                <a><cite id="cite">重置密码</cite></a>
            </blockquote>
            <div class="blog-main">
           		<div class="layui-tab layui-tab-brief">
			  		<ul class="layui-tab-title">
			    	<li class="layui-this">重置密码</li>
			  		</ul>
				  	<div class="layui-tab-content">
				   		<div class="layui-tab-item layui-show">
				   			<form class="layui-form layui-form-pane" method="post">
				   				<input type="hidden" name="mid" value="${mid }">
					   			<div class="layui-form-item">
								    <label class="layui-form-label">新密码</label>
							    	<div class="layui-input-inline">
							        	<input type="password" name="pwd" required  lay-verify="required" autocomplete="off" class="layui-input">
							        </div>
							        <div class="layui-form-mid layui-word-aux">6到18个字符</div>
							    </div>
							    <div class="layui-form-item">
								    <label class="layui-form-label">确认密码</label>
							    	<div class="layui-input-inline">
							        	<input type="password" name="regpwd" required  lay-verify="required" autocomplete="off" class="layui-input">
							        </div>
							    </div>
							    <div class="layui-form-item">
								   <label class="layui-form-label">人类验证</label>
								   <div class="layui-input-inline">
								       <input type="text" name="verify" required lay-verify="required" autocomplete="off" placeholder="请回答后面问题" class="layui-input">
								   </div>
								   <div class="layui-form-mid">
								       <span style="color:#c00" class="verift-text"></span>
								   </div>
								</div>
								<div class="layui-form-item">
						    		<button class="layui-btn" lay-submit lay-filter="resetForm">立即重置</button>
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
        <p><span>Copyright</span><span>&copy;</span><span>2018</span><a href="http://www.lyblogs.cn">RecruitManagement</a></p>
    </footer>
    <!--侧边导航-->
    <ul class="layui-nav layui-nav-tree layui-nav-side blog-nav-left layui-hide" lay-filter="nav">
        <li class="layui-nav-item layui-this">
            <a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
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
    <script src="${ctx!}/js/
    .js"></script>
</body>
</html>