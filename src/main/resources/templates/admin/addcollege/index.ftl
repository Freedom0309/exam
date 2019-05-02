<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - 新增学院账户</title>
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
    <legend style="text-align:center;">新增学院账户</legend>
</fieldset>
<form class="layui-form layui-form-pane"  lay-filter="form">

    <div class="layui-form-item">
        <label class="layui-form-label">帐号</label>
        <div class="layui-input-inline">
            <input type="text" name="num" lay-verify="required" placeholder="请输入学院号" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">学院名</label>
        <div class="layui-input-inline">
            <input type="text" name="name" lay-verify="name" placeholder="请输入学院名" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="collegeTel" lay-verify="collegeTel" placeholder="请输入学院电话" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">院长</label>
        <div class="layui-input-inline">
            <input type="text" name="collegeChairman" lay-verify="collegeChairman" placeholder="请输入学院院长" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">学院描述</label>
        <div class="layui-input-inline">
            <input type="text" name="collegeDesc" lay-verify="collegeDesc" placeholder="请输入学院描述" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" lay-verify="email" placeholder="请输入学院邮箱" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>




    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="text" name="newPassword" lay-verify="newPassword" placeholder="请输入密码" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码确认</label>
        <div class="layui-input-inline">
            <input type="text" name="password" lay-verify="rePassword" placeholder="请再次输入密码" value=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>
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
        form.verify({
            rePassword: function(value, item){ //value：表单的值、item：表单的DOM对象\
                var newPassword = $("input[name=newPassword]").val();
                if(newPassword !== value){
                    return '两次密码不一致';
                }
            }
        });
        form.on('submit(add)', function (data) {
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "/college/update",
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
