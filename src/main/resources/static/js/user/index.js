layui.define([ 'layer',  'table','common','util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        util = layui.util,
        table  = layui.table ;
    table.render({
        elem: '#plan'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/jobSeeker/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'num', align:'center', title: '账号',unresize:true}
            ,{field: 'name', align:'center', title: '姓名',unresize:true}
            ,{field: 'phone', align:'center', title: '电话',unresize:true}
            ,{field: 'sex', align:'center', title: '性别',unresize:true}
            ,{field: 'email', align:'center', title: '邮箱',unresize:true}
            ,{field: 'birth', align:'center', title: '生日',unresize:true,templet: '<div>{{# if(d.birth!=null){ }}{{ layui.util.toDateString(d.birth) }}{{# } }}</div>'}
            ,{field: 'status', align:'center', title: '状态',unresize:true}
            ,{field: 'updateTime', align:'center', title: '更新时间',unresize:true,templet: '<div>{{# if(d.updateTime!=null){ }}{{ layui.util.toDateString(d.updateTime) }}{{# } }}</div>'}
            ,{fixed: 'right',  title:'操作',align:'center', toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/admin/plan/form?id='+data.id);
        }
    });


    //输出接口，主要是两个函数，一个删除一个编辑
    var datalist = {
        deleteData: function (id) {
            layer.confirm('确定删除？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                del(id);
            }, function () {

            });
        },
        editData: function (id) {
            common.frame_show('编辑','/admin/plan/form?id='+id);
        }
    };
    function del(id) {
        layer.confirm('真的删除行么', function (index) {
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/admin/deleteJobSeeker/?id=" + id,
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/lab/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    exports('admin/lab/index', datalist);
});