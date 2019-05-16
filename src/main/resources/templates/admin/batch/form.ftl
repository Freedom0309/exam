<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 学生信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet"/>
    <style type="text/css">
        .layui-form-item {
            margin: 20px 0 0 200px
        }

        .layui-form-label {
            width: 85px;
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
                        <input type="hidden" name="id" value="${(batch.id)!}">
                    </div>

                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">学校</label>
                        <div class="layui-input-inline">
                            <select name="schoolId" lay-verify="required">
                                <option value="">请选择学校</option>
                                <#list schools as x>
                                    <option value="${x.id}"
                                    <#if (x.id == batch.school.id)>selected</#if>>${x.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>


                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">年份</label>
                        <div class="layui-input-inline">
                            <#if batch??>
                                <input type="number" name="year" lay-verify="required|number"
                                       placeholder="请输入年份" value="${batch.year?c}"
                                       autocomplete="off" class="layui-input ">
                            <#else >
                                <input type="number" name="year" lay-verify="required|number"
                                       placeholder="请输入年份" value="${batch.year}"
                                       autocomplete="off" class="layui-input ">
                            </#if>
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">批次</label>
                        <div class="layui-input-inline">
                            <input type="text" name="batchNumber" lay-verify="required|number"
                                   placeholder="请输入批次" value="${batch.batchNumber}"
                                   autocomplete="off" class="layui-input ">
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">文理科</label>
                        <div class="layui-input-inline">
                            <#--<input type="text" name="artsScience" lay-verify="required" value="${batch.artsScience}"
                                   autocomplete="off" class="layui-input">
-->
                            <select name="artsScience"  lay-verify="required">
                                <option value="">请选择文理科</option>
                                <option value="文科" <#if (batch.artsScience == '文科')>selected="selected"</#if>>文科</option>
                                <option value="理科" <#if (batch.artsScience == '理科')>selected="selected"</#if>>理科</option>

                            </select>

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">最低录取位次</label>
                        <div class="layui-input-inline">
                            <#if batch??>
                                <input type="number" name="lowBatch" lay-verify="required|number"
                                       placeholder="请输入最低录取位次" value="${batch.lowBatch?c}"
                                       autocomplete="off" class="layui-input">
                            <#else>
                                <input type="number" name="lowBatch" lay-verify="required|number"
                                       placeholder="请输入最低录取位次" value="${batch.lowBatch}"
                                       autocomplete="off" class="layui-input">
                            </#if>
                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">平均录取位次</label>
                        <div class="layui-input-inline">
                            <#if batch??>
                                <input type="number" name="avgBatch" lay-verify="required|number"
                                       placeholder="请输入平均录取位次" value="${batch.avgBatch?c}"
                                       autocomplete="off" class="layui-input">
                            <#else >
                                <input type="number" name="avgBatch" lay-verify="required|number"
                                       placeholder="请输入平均录取位次" value="${batch.avgBatch}"
                                       autocomplete="off" class="layui-input">
                            </#if>

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">最低录取分数</label>
                        <div class="layui-input-inline">
                            <#if batch??>
                                <input type="number" name="lowScore" lay-verify="required|number"
                                       placeholder="请输入最低录取分数" value="${batch.lowScore?c}"
                                       autocomplete="off" class="layui-input">
                            <#else >
                                <input type="number" name="lowScore" lay-verify="required|number"
                                       placeholder="请输入最低录取分数" value=""
                                       autocomplete="off" class="layui-input">
                            </#if>

                        </div>
                        <span style="color: red">必填</span>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">平均录取分数</label>
                        <div class="layui-input-inline">
                            <#if batch??>
                                <input type="number" name="avgScore" lay-verify="required|number"
                                       placeholder="请输入平均录取分数" value="${batch.avgScore?c}"
                                       autocomplete="off" class="layui-input">
                            <#else >
                                <input type="number" name="avgScore" lay-verify="required|number"
                                       placeholder="请输入平均录取分数" value=""
                                       autocomplete="off" class="layui-input">
                            </#if>

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
    }).use('batch/form');
</script>
</body>

</html>
