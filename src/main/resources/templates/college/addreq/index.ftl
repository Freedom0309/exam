<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 新增用人需求</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="${ctx!}/js/plugins/layui/css/layui.css" rel="stylesheet" />
    <style type="text/css">
        .layui-form-item{
            margin: 50px 0 0 200px
        }
    </style>
</head>

<body>

<fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field">
    <legend style="text-align:center;">新增用人需求</legend>
</fieldset>
<form class="layui-form layui-form-pane"  lay-filter="form">


    <div class="layui-form-item" style="visibility: hidden">
        <label class="layui-form-label">学院id</label>
        <div class="layui-input-inline">
            <input type="text" name="college" lay-verify="required" placeholder="学院id" value="${(Session.user.id)?c!}"
                   autocomplete="off" class="layui-input" style="color: #d2d2d2!important" disabled>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">需求编号</label>
        <div class="layui-input-inline">
            <input type="text" name="num" lay-verify="number" placeholder="请输入需求编号" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">需求名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="name" placeholder="请输入职位名称" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">需求描述：</label>
        <div class="layui-input-block">
            <textarea id="description" name="desc" placeholder="请输入内容：必填" lay-verify="required" class="layui-textarea" style="width: 60%"></textarea>
        </div>
    </div>

    <#--<div class="layui-form-item">-->
        <#--<label class="layui-form-label">需求描述</label>-->
        <#--<div class="layui-input-inline">-->
            <#--<input type="text" name="desc" lay-verify="desc" placeholder="请输入岗位描述" value=""-->
                   <#--autocomplete="off" class="layui-input">-->
        <#--</div>-->
    <#--</div>-->

    <div class="layui-form-item">
        <button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
    </div>

</form>

<script src="${ctx!}/js/plugins/layui/layui.js"></script>
<script src="${ctx!}/js/common.js"></script>
<!-- layui规范化用法 -->
<script type="text/javascript">
    layui.config({
        base : "${ctx!}/js/"
    }).use(['form','layer','jquery', 'element'], function () {
        var $ = layui.jquery,
                form = layui.form,
                layer = layui.layer;
        //监听登陆提交
//        form.verify({
//            rePassword: function(value, item){ //value：表单的值、item：表单的DOM对象\
//                var newPassword = $("input[name=newPassword]").val();
//                if(newPassword !== value){
//                    return '两次密码不一致';
//                }
//            }
//        });
        form.on('submit(add)', function (data) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/college/addHc",
                data: data.field,
                success: function(ret){
                    console.log(ret);
                    if(ret.isOk){
                        layer.msg("添加成功", {time: 2000},function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index);
                        });
                    }else{
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
            return false;
        });
    });
</script>
</body>

</html>
