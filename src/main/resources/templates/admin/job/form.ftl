<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 学生信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style type="text/css">
        .layui-form-item{
            margin: 20px 0 0 200px
        }
        .imgbox{
            margin-top: 20px;
            font-size: 16px;
            color: red;
        }
    </style>
</head>

<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">添加</legend>
</fieldset>
<div class="container-fluid larry-wrapper">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <section class="panel panel-padding">
                <form id="form1" class="layui-form "  lay-filter="form">

                    <div class="layui-form-item">
                        <input type="hidden" name="id"  value="${(job.id)!}" >
                    </div>


                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">职位编号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="num" lay-verify="required"  placeholder="请输入职位名" value="${job.num}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">职位名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" lay-verify="required"  placeholder="请输入职位名" value="${job.name}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">人数</label>
                        <div class="layui-input-inline">
                            <input type="text" name="numbers" lay-verify="number" placeholder="请输入人数" value="${job.numbers}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">地点</label>
                        <div class="layui-input-inline">
                            <input type="text" name="location" lay-verify="required" placeholder="请输入地点" value="${job.location}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">工作经验</label>
                        <div class="layui-input-inline">
                            <input type="text" name="experience" lay-verify="required" placeholder="请输入工作经验" value="${job.experience}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">职位要求</label>
                        <div class="layui-input-inline">
                            <input type="text" name="title" lay-verify="required" placeholder="请输入职位要求" value="${job.title}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">待遇</label>
                        <div class="layui-input-inline">
                            <input type="text" name="treatment" lay-verify="required" placeholder="请输入待遇，" value="${job.treatment}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">元/月，必填</span>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">描述：</label>
                        <div class="layui-input-block">
                                <textarea id="description" name="desc" placeholder="请输入内容：必填" lay-verify="required" class="layui-textarea" style="width: 60%">${(job.desc)!}</textarea>
                        </div>
                    </div>

                    <#--<div class="layui-form-item">-->
                        <#--<label class="layui-form-label">学院</label>-->
                        <#--<div class="layui-input-inline">-->
                            <#--<select name="college" lay-filter="college" lay-verify="required">-->
                                <#--<option value="">请选择学院</option>-->
                            <#--<#list colleges as x>-->
                                <#--<option value="${x.id}"-->
                                    <#--<#if (job.college.name == x.name)> selected="selected" </#if>-->
                                <#-->${x.name}</option>-->
                            <#--</#list>-->
                            <#--</select>-->
                        <#--</div>-->
                        <#--<span style="color: red">必填</span>-->
                    <#--</div>-->

                    <div class="layui-form-item">
                        <label class="layui-form-label">所属需求</label>
                        <div class="layui-input-inline">
                            <select name="requirement" lay-filter="requirement" lay-verify="required">
                                <option value="">请选择需求</option>
                            <#list requirements as x>
                                <option value="${x.id}"
                                    <#if (job.requirement.name == x.name)> selected="selected" </#if>
                                >${x.name}</option>
                            </#list>
                            </select>
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>

<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<script src="${ctx!}/js/common.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/'
    }).use('job/form');
</script>
</body>

</html>
