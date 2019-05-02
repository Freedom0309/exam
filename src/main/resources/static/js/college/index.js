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
        ,url: '/college/hcList' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'num', align:'center', title: '需求编号',unresize:true}
            ,{field: 'name', align:'center', title: '需求标题',unresize:true}
            ,{field: 'desc', align:'center', title: '需求描述',unresize:true}
            ,{field: 'college', align:'center', title: '需求标题',unresize:true,templet: '<div>{{d.college.name}}</div>'}
            ,{field: 'create_time', align:'center', title: '创建时间',unresize:true,templet: '<div>{{# if(d.createTime!=null){ }}{{ layui.util.toDateString(d.createTime) }}{{# } }}</div>'}
            ,{field: 'status', align:'center', title: '状态',templet: '#status',unresize:true}
            ,{fixed: 'right', title:'操作',align:'center',width:'200',toolbar: '#operator',unresize:true}
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
                url: "/admin/deleteCollege/?id=" + id,
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/college/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    exports('college/index', datalist);
});