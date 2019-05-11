layui.define(['element', 'layer', 'form','laydate'], function (exports) {
    var form = layui.form,
        $ = layui.jquery;

    form.on('submit(add)', function (data) {
        $.ajax({
            type: "POST",
            dataType: "json",
            url: "/schoolline/save",
            data: data.field,
            success: function(ret){
                if(ret.isOk){
                    layer.msg("操作成功", {time: 2000},function(){
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.location = parent.location.href;
                        parent.layer.close(index);

                    });
                }else{
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        });
        return false;
    });

    form.on('select(school)', function (data) {
        var id = data.value;
        $.ajax({
            url: '/school/getPressionBySchool',
            data: {
                id: id
            },
            method: 'get',
            success: function (data) {
                console.log(data);
                $('#profession').empty();
                var opt='';
                opt += '<option value="">请选择专业</option>';
                $.each(data.data, function (i, obj) {
                    opt += '<option value="'+obj.id+'">'+ obj.name +'</option>';
                });
                
                $('#profession').append(opt);
                form.render();
            }
        });
    });
    exports('scoreline/form', {});
});

