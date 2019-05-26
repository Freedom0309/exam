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
                        <input type="hidden" name="id"  value="${(school.id)!}" >
                    </div>


                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">学校名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" lay-verify="required"
                                   placeholder="请输入学校名称" value="${school.name}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">学校简介</label>
                        <div class="layui-input-inline">
                            <input type="text" name="description" lay-verify="required"
                                   placeholder="请输入简介" value="${school.description}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">地址</label>
                        <div class="layui-input-inline">
                            <input type="text" name="address" lay-verify="required"
                                   placeholder="请输入地址" value="${school.address}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">学校网址</label>
                        <div class="layui-input-inline">
                            <input type="url" name="url" lay-verify="required|url"
                                   placeholder="http://www.example.com" value="${school.url}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <#--<div class="layui-form-item">
                        <label class="layui-form-label">招生层次</label>
                        <div class="layui-input-inline">
                            <input type="text" name="levelxxx" lay-verify="required"
                                   placeholder="请输入招生层次" value="${school.level}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>-->
                    <div class="layui-form-item">
                        <label class="layui-form-label">招生层次</label>
                        <div class="layui-input-inline">
                            <select name="level" lay-filter="school" lay-verify="required">
                                <option value="">请选择招生层次</option>
                                <option value="一本" <#if (school.level == '一本')>selected="selected"</#if>>一本</option>
                                <option value="二本" <#if (school.level == '二本')>selected="selected"</#if>>二本</option>
                                <option value="三本" <#if (school.level == '三本')>selected="selected"</#if>>三本</option>
                                <option value="专科" <#if (school.level == '专科')>selected="selected"</#if>>专科</option>

                            </select>
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">学校类型</label>
                        <div class="layui-input-inline">
                            <input type="text" name="type" lay-verify="required"
                                   placeholder="请输入学校类型" value="${school.type}"
                                   autocomplete="off" class="layui-input">

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <#--<div class="layui-form-item">
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
                    </div>-->

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
    }).use('school/form');
</script>
</body>

</html>
