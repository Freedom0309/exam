layui.define([ 'layer',  'table','common','util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        util = layui.util,
        table  = layui.table ;
    table.render({
        elem: '#school'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/school/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'name', align:'center', title: '学校名称',unresize:true}
            ,{field: 'description', align:'center', title: '学校简介',unresize:true}
            ,{field: 'address', align:'center', title: '学校地址',unresize:true}
            ,{field: 'url', align:'center', title: '招生连接',unresize:true,templet: '<div>{{d.college.name}}</div>'}
            ,{field: 'level', align:'center', title: '招生层次',unresize:true,}
            ,{field: 'type', align:'center', title: '学校类型',templet: '#status',unresize:true}
            ,{fixed: 'right', title:'操作',align:'center',width:'200',toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/school/form?id='+data.id);
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

    //添加数据
    $('#addSchool').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('添加','/school/form');
        }, 500);
    });

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
                            window.location.href = "/admin/school/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }
    exports('school/index', datalist);
});