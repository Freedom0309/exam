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
    <legend style="text-align:center;">需求管理</legend>
    <button class="layui-btn" style="position: relative;float: right;right: 100px;" onclick="javascript:location.replace(location.href)">
        <i class="layui-icon">&#x1002;</i>
    </button>
    <div style="padding: 40px 0px 0px 80px;">
        <div class="layui-inline">
            <div class="layui-input-inline" style="width:auto">
            </div>
        </div>
    </div>


    <div class="layui-field-box">
        <div id="dataContent" class="">

            <table class="layui-hide" id="plan" lay-filter="table"></table>
            <script type="text/html" id="operator">
                <a class="layui-btn layui-btn-danger " lay-event="del">删除</a>
            </script>

            <script type="text/html" id="status">
                <form class="layui-form" action="">
                    <div class="layui-form-item" style="margin:0;">
                        {{#  if(d.status == 0){ }}
                        <span class="sys-title">请求已发布，待审核</span>
                        {{#  } else if(d.status == 1){ }}
                        <span class="sys-title">请求已通过，招聘信息未发布</span>
                        {{#  } else if(d.status == 2){ }}
                        <span class="sys-title">请求已通过，招聘信息已发布</span>
                        {{#  } else if(d.status == 3){ }}
                        <span class="sys-title">请求已拒绝，理由：{{d.reason}}</span>
                        {{#  } }}
                    </div>
                </form>
            </script>
        </div>
    </div>
</fieldset>

<!-- layui.js -->
<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base: '${ctx}/js/'
    }).use('college/index');
</script>
</body>
</html>