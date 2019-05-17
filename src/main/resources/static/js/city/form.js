layui.define(['element', 'layer', 'form','laydate'], function (exports) {
    var form = layui.form,
        $ = layui.jquery;

    //自定义验证
    form.verify({
        name: function (value) {
            if (value.length <= 0 || value.length > 20) {
                return "名称必须1到00位"
            }
        },
        description:function (value) {
            if (value.length <= 1 || value.length > 100) {
                return "描述必须2到00位"
            }
        }

    });

    form.on('submit(add)', function (data) {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/city/save",
            data: data.field,
            success: function(ret){
                if(ret.isOk){
                    layer.msg("操作成功", {time: 2000},function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index);
                        parent.location = parent.location.href;
                    });
                }else{
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        });
        return false;
    });

    exports('city/form', {});
});

