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
                        <input type="hidden" name="id"  value="${(province.id)!}" >
                    </div>


                    <div class="layui-form-item" style="margin-top: 10px">
                        <label class="layui-form-label">省份名称</label>
                        <div class="layui-input-inline">
                            <input type="text" name="name" lay-verify="required"  placeholder="请输入身份名称"
                                   value="${province.name}"
                                   autocomplete="off" class="layui-input ">
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
    }).use('province/form');
</script>
</body>

</html>
