<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 学校分数线信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet"/>
    <style type="text/css">
        .layui-form-item {
            margin: 20px 0 0 200px
        }

        .imgbox {
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
                <form id="form1" class="layui-form " lay-filter="form">

                    <div class="layui-form-item">
                        <input type="hidden" name="id" value="${(schoolLine.id)!}">
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">学校</label>
                        <div class="layui-input-inline">
                            <select name="schoolId" lay-filter="school" lay-verify="required">
                                <option value="">请选择学校</option>
                        <#list schools as x>
                            <option value="${x.id}"
                                <#if (schoolLine.school.id == x.id)> selected="selected" </#if>
                            >${x.name}</option>
                        </#list>
                            </select>
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">专业</label>
                        <div class="layui-input-inline">
                            <select name="professionId" id="profession" lay-filter="profession" lay-verify="required">
                                <option value="">请选择专业</option>
                                <#if schoolLine.profession??>
                                    <#list professions as x>
                                    <option value="${x.id}"
                                        <#if (schoolLine.profession.id == x.id)> selected="selected" </#if>
                                    >${x.name}</option>
                                    </#list>
                                </#if>

                            </select>
                        </div>
                        <span style="color: red">必填</span>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">专业分数线</label>
                        <div class="layui-input-inline">

                            <input type="number" name="schoolLine" lay-verify="required|number"
                                   placeholder="请输入分数线"
                                       <#if schoolLine??>value="${schoolLine.schoolLine?c}"</#if>
                                   autocomplete="off" class="layui-input">


                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">文理科</label>
                        <div class="layui-input-inline">
                        <#--<input type="text" name="artsScience" lay-verify="required"
                               value="${schoolLine.artsScience}"
                               autocomplete="off" class="layui-input">-->
                            <select name="artsScience" lay-verify="required">
                                <option value="">请选择文理科</option>
                                <option value="文科" <#if (schoolLine.artsScience == '文科')>selected="selected"</#if>>文科
                                </option>
                                <option value="理科" <#if (schoolLine.artsScience == '理科')>selected="selected"</#if>>理科
                                </option>

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
    }).use('schoolline/form');
</script>
</body>

</html>
