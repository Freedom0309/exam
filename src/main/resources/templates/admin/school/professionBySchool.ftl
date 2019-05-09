<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8" />
    <title>数据列表页面</title>
    <!-- layui.css -->
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style>
        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }
        /*可选*/
        .layui-laypage > * {
            float: left;
        }
        .layui-field-title .layui-field-box{
            padding: 10px 20px 10px 30px;
        }
        .layui-table-cell{
            padding-top: 4px;
            height: 45px;
        }
    </style>
</head>
<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">${school.name}专业管理</legend>
    <input type="hidden" name="id" value="${school.id}">
    <div class="layui-inline">
        <div class="layui-input-inline" style="width:auto">
            <button id="delete" class="layui-btn layui-btn-sm">删除</button>
            <button class="layui-btn layui-btn-sm"  onclick="javascript:location.replace(location.href)">
                <i class="layui-icon">&#x1002;</i>
            </button>
        </div>
    </div>


    <div id="dataContent" class="">

        <table class="layui-table" id="pro-school" lay-filter="table"></table>

    </div>
</fieldset>

<!-- layui.js -->
<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/'
    }).use('school/profession');
</script>
</body>
</html>