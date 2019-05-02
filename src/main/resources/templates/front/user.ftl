<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>-个人中心</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/user.css" rel="stylesheet" />
</head>
<body>
    <!-- 导航 -->
    <nav class="blog-nav layui-header">
        <div class="blog-container">
            <!-- 用户登陆 -->
            <div class="blog-user"></div>
			<a class="blog-logo" href="/">大学生招聘网站</a>
            <!-- 导航菜单 -->
            <ul class="layui-nav" lay-filter="nav">
				<li class="layui-nav-item">
					<a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
				</li>

				<li class="layui-nav-item  layui-this">
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
        	<input id="token" type="hidden">
			<input id="uid" type="hidden">
            <blockquote class="layui-elem-quote sitemap layui-breadcrumb shadow">
                <a href="/" title="网站首页">网站首页</a>
                <a><cite>个人中心</cite></a>
            </blockquote>
            <div class="blog-main">
           		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
		    	<ul class="layui-tab-title">
		    		<li class="layui-this" id="myInfo">我的资料</li>
		    		<li>我的简历</li>
		    		<li>我的投递</li>
		    		<li>修改密码</li>
		    	</ul>
		    	<div class="layui-tab-content">
		    		<!-- 我的资料 -->
		    		<div class="layui-tab-item layui-show">
			    		<form class="layui-form layui-form-pane" method="post">
                            <div class="layui-form-item">
                                    <input type="hidden" name="id" id="id">
                            </div>
			    			<div class="layui-form-item">
						    	<label class="layui-form-label">帐号</label>
					    		<div class="layui-input-inline">
					        		<input id="num" type="text" name="num" required  lay-verify="number" autocomplete="off" class="layui-input">
					        	</div>
					    	</div>
					    	<div class="layui-form-item">
						    	<label class="layui-form-label">姓名</label>
					    		<div class="layui-input-inline">
					        		<input id="name" type="text" name="name" required  lay-verify="required" autocomplete="off" class="layui-input">
					        	</div>
				            	<div class="layui-input-inline">
						    		<input type="radio" name="sex" value="男" title="男">
						    		<input type="radio" name="sex" value="女" title="女">
						    	</div>
					    	</div>

					    	<div class="layui-form-item">
						    	<label class="layui-form-label">电话</label>
					    		<div class="layui-input-inline">
					        		<input id="phone" type="text" name="phone" autocomplete="off" class="layui-input">
					        	</div>
					    	</div>

							<div class="layui-form-item">
								<label class="layui-form-label">邮箱</label>
								<div class="layui-input-inline">
									<input id="email" type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input" >
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">出生日期</label>
								<div class="layui-input-inline">
									<input id="birth" type="text" name="births" autocomplete="off" class="layui-input">
								</div>
							</div>

					   		<div class="layui-form-item">
						   		<div class="layui-input-inline">
									<button class="layui-btn" lay-submit lay-filter="formInfo">确认修改</button>
								</div>
					   		</div>
						</form>
		    		</div>
		    		<!-- 我的简历 -->
    				<div class="layui-tab-item" id="resume">
                        <form class="layui-form layui-form-pane">

                            <input id="resumeId" type="hidden" name="id">

                            <div class="layui-form-item">
                                <label class="layui-form-label">帐号</label>
                                <div class="layui-input-inline">
                                    <input id="resumenum" type="text" name="num" required  lay-verify="number" autocomplete="off" class="layui-input layui-disabled">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-inline">
                                    <input id="resumename" type="text" name="name" required  lay-verify="required" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-input-inline">
                                    <input type="radio" name="sex" value="3" title="男">
                                    <input type="radio" name="sex" value="4" title="女">
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">电话</label>
                                <div class="layui-input-inline">
                                    <input id="resumephone" type="text" name="phone" autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">身份证号</label>
                                <div class="layui-input-inline">
                                    <input id="resumeidNo" type="text" name="idNo" required  lay-verify="number" autocomplete="off" class="layui-input">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">邮箱</label>
                                <div class="layui-input-inline">
                                    <input id="resumeemail" type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input" >
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">教育经历</label>
                                <div class="layui-input-block">
                                    <input id="resumeeducation" type="text" name="education"  autocomplete="off" class="layui-input" >
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">工作经历</label>
                                <div class="layui-input-block">
                                    <textarea placeholder="请输入个人工作经历" class="layui-textarea" name="work" id="resumework"></textarea>
                                </div>
                            </div>

                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">个人评价</label>
                                <div class="layui-input-block">
                                    <textarea placeholder="请输入个人评价" class="layui-textarea" name="personal" id="resumepersonal"></textarea>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <label class="layui-form-label">出生日期</label>
                                <div class="layui-input-inline">
                                    <input id="resumebirth" type="text" name="births" autocomplete="off" class="layui-input">
                                </div>
                            </div>


                            <div class="layui-form-item">
                                <label class="layui-form-label">上传简历</label>
                                <div class="layui-input-block">
                                    <button type="button" class="layui-btn" id="upload">
                                        <i class="layui-icon">&#xe67c;</i>上传简历
                                    </button>
                                    <input type="hidden" name="annexUrl">
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-input-inline">
                                    <button class="layui-btn" lay-submit lay-filter="resume">确认修改</button>
                                </div>
                            </div>

                        </form>
    				</div>

    				<!-- 我的投递 -->
                    <div class="layui-tab-item" id="myMessage">
                        <div class="layui-tab layui-tab-brief" lay-filter="user">
                            <div id="LAY_minemsg" style="margin-top: 10px;">
                                <ul class="mine-msg msgs">
                                </ul>
                            </div>
                        </div>
                    </div>

    				<!-- 密码 -->
    				<div class="layui-tab-item">
    					<form class="layui-form layui-form-pane" method="post">
                            <input type="hidden" id="user" name="id">
                            <div class="layui-form-item">
                                <label class="layui-form-label">旧密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" name="oldP" required  lay-verify="required" autocomplete="off" class="layui-input">
                                </div>

                            </div>
    						<div class="layui-form-item">
						    	<label class="layui-form-label">新密码</label>
					    		<div class="layui-input-inline">
					        		<input type="password" name="newP" required  lay-verify="required" autocomplete="off" class="layui-input">
					        	</div>
					        	<div class="layui-form-mid layui-word-aux">6到18个字符</div>
					   		</div>
					   		<div class="layui-form-item">
						    	<label class="layui-form-label">确认密码</label>
					    		<div class="layui-input-inline">
					        		<input type="password" name="repwd" required  lay-verify="required" autocomplete="off" class="layui-input">
					        	</div>
					        <div class="layui-form-mid layui-word-aux"></div>
					    	</div>
					    	<div class="layui-form-item">
						   		<div class="layui-input-inline">
									<button class="layui-btn" lay-submit lay-filter="formPwd">确认修改</button>
								</div>
					   		</div>
    					</form>
    				</div>

    				<!-- END -->    
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
			<a href="home.html"><i class="fa fa-home fa-fw"></i>&nbsp;招聘信息</a>
		</li>

		<li class="layui-nav-item">
			<a href="resource.ftl"><i class="fa fa-tags fa-fw"></i>&nbsp;个人中心</a>
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
    <script src="${ctx!}/js/user.js"></script>

</body>
</html>