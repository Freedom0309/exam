﻿<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; Charset=utf-8">
    <meta http-equiv="Content-Language" content="zh-CN">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <title>陕西高考志愿填报信息管理平台</title>
    <link rel="shortcut icon" href="${ctx!}/images/logo.png" type="image/x-icon">
    <!--Layui-->
    <link href="${ctx!}/layui/css/layui.css" rel="stylesheet" />
    <!--font-awesome-->
    <link href="${ctx!}/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <!--全局样式表-->
    <link href="${ctx!}/css/global.css" rel="stylesheet" />
    <link href="${ctx!}/css/animate.min.css" rel="stylesheet" />
    <!-- 本页样式表 -->
    <link href="${ctx!}/css/index.css" rel="stylesheet" />
    <style>
        .layui-select-title{
            width: 303px;
        }
        .layui-form-select .layui-edge {
            right: -100px;
        }
        .layui-form-label{
            width: 50px;
            text-align: left;
        }
        .layui-form-select dl {
            min-width: 159%;
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
				<li class="layui-nav-item">
					<a href="/"><i class="fa fa-home fa-fw"></i>&nbsp;学校信息</a>
				</li>

                <li class="layui-nav-item layui-this">
                    <a href="/school/recommend"><i class="fa fa-home fa-fw"></i>&nbsp;推荐学校</a>
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
            <div class="blog-main">
                <!-- 网站公告提示 -->
                <div class="home-tips shadow">
                    <i style="float:left;line-height:17px;" class="fa fa-volume-up"></i>
                    <div class="home-tips-container">
                        <span style="color: #009688">有事做有所期待，日子就是幸福的</span>
                        <span style="color: #009688">用心每一天，不忘初心，方能走远</span>
                        <span style="color: #009688">偷偷挤进一缕斜阳，送来满满幸福</span>
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

                                <div class="layui-inline" style="background: #ffffff;">
                                    <label class="layui-form-label">省份</label>
                                    <div class="layui-input-inline" style="">
                                        <select name="provinceId" lay-filter="province" lay-verify="required" lay-search="">
                                            <option value="">请选省份</option>
                                            <#list provinces as x>
                                                <option value="${x.id}">${x.name}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item">

                                <div class="layui-inline" style="background: #ffffff;">
                                    <label class="layui-form-label">城市</label>
                                    <div class="layui-input-inline" style="">
                                        <select name="city" id="city" lay-verify="required" lay-search="">
                                            <option value="">请选择城市</option>
                                            <#list cities as x >
                                                <option value="${x.name}">${x.name}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item">

                                <div class="layui-inline" style="background: #ffffff;">
                                    <label class="layui-form-label">文理科</label>
                                    <div class="layui-input-inline" style="">
                                        <select name="arts" lay-verify="required" lay-search="">
                                            <option value="">请选择</option>
                                            <option value="理科">理科</option>
                                            <option value="文科">文科</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="search-keywords  shadow">
                                    <input type="text" name="score" lay-verify="required|number" placeholder="请输入分数" autocomplete="off" class="layui-input ">
                                </div>
                                <div class="search-submit  shadow">
                                    <a class="search-btn" lay-submit lay-filter="formSearch"><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <#--<div class="layui-form-item">
                                <div class="search-keywords  shadow">
                                    <input type="text" name="grade" lay-verify="required|number" placeholder="请输入位次" autocomplete="off" class="layui-input ">
                                </div>
                                <div class="search-submit  shadow">
                                    <a class="search-btn" lay-submit lay-filter="formSearch"><i class="fa fa-search"></i></a>
                                </div>
                            </div>-->
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
                                               <li><i class="layui-badge-rim">${x_index+1}</i>&nbsp;&nbsp;<a href="/school/detail/${x.id}">${x.name}</a></li>

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
		<p><span>Copyright</span><span>&copy;</span><span>2019</span>陕西高考志愿填报信息管理平台</p>
	</footer>

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
        layui.define([ 'layer','form'], function (exports) {
            var $ = layui.jquery,
                    form  = layui.form ;
            //监听评论提交
            form.on('submit(formSearch)', function (data) {
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    data: data.field,
                    url: "/profession/recommendProfession",
                    success:function(result) {
                        if (result.isOk) {
                            console.log(result.data);
                            createHtml(result.data);
                        } else {
                            layer.msg(result.msg,{anim:6});
                        }
                    }
                });
                return false;
            });

            form.on('select(province)', function (data) {
                console.log(data.field)
                var id = $('select[name=provinceId]').val();
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    url: "/city/getCity",
                    data: {
                        provinceId: id
                    },
                    success: function (d) {
                        if(d.isOk){
                            createCity(d.data);
                            form.render();
                        }else {
                            layer.msg(d.msg, {anim: 6})
                        }
                    }
                });
            })

            function createCity(data) {
                obj = $("#city");
                obj.empty();
                var city = "<option value=''>请选择城市</option>";
                $.each(data, function (i, o) {
                    city += "<option value='"+o.name+"'>"+o.name+"</option>";
                })
                obj.append(city);
            }
            function createHtml(data) {
                obj = $("#jobList");
                obj.empty();
                var detailHtml = '';
                $.each(data, function (i, obj) {
                    detailHtml += '<div class="article shadow animated fadeInLeft">';
                    detailHtml += '<div class="article-right">';
                    detailHtml += '<div class="article-title">';
                    detailHtml += '<a>学校名称：'+obj[2]+'</a></div>';
                    detailHtml += '<div class="article-abstract">专业：'+obj[1]+'</div>';
                    detailHtml += '<div class="article-abstract">录取分数：'+obj[3]+'</div>';
                    // detailHtml += '<div class="article-abstract">地址：'+obj[2]+'</div>';
                    detailHtml += '</div>';
                    detailHtml += '<div class="clear"></div>';
                    detailHtml += '</div>';
                });
               /* for(var i=0;i<data.length;i++){
                    detailHtml += '<div class="article shadow animated fadeInLeft">';
                    detailHtml += '<div class="article-right">';
                    detailHtml += '<div class="article-title">';
                    detailHtml += '<a>学校名称：'+data[i]+'</a></div>';
                    detailHtml += '<div class="article-abstract">专业：'+data[i]+'</div>';
                    detailHtml += '<div class="article-abstract">类型：'+data[i]+'</div>';
                    detailHtml += '<div class="article-abstract">地址：'+data[i]+'</div>';
                    detailHtml += '</div>';
                    detailHtml += '<div class="clear"></div>';
                    detailHtml += '</div>';
                }*/
                obj.append(detailHtml);
            }

        });
    </script>
</body>
</html>