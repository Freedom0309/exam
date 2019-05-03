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
            {field: 'name', align:'center', title: '学校名称',sort: true, unresize:false}
            ,{field: 'description', align:'center', title: '学校简介',unresize:false}
            ,{field: 'address', align:'center', title: '学校地址',unresize:false}
            ,{field: 'url', align:'center', title: '招生连接',unresize:false}
            ,{field: 'level', align:'center', title: '招生层次',unresize:false}
            ,{field: 'type', align:'center', title: '学校类型',templet: '#status',unresize:false}
            ,{fixed: 'right', title:'操作',align:'center',width:'300',toolbar: '#operator',unresize:false}
        ]]
        ,id: 'schoolTable'
        ,page: {
            layout: ['prev', 'page', 'next', 'skip', 'limit', 'count'], //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            groups: 1, //只显示 1 个连续页码
            first: false, //不显示首页
            last: false, //不显示尾页
            limit:10,
            limits:[1,2,3,4,5,6,7,8,9,10]
        }
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/school/form?id='+data.id);
        }else if(obj.event === 'addProfession'){
            common.frame_show('专业管理', '' + data.id);
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
                layer.closeAll();
            });
        },
        editData: function (id) {
            common.frame_show('编辑','/admin/profession/form?id='+id);
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
        layer.confirm('真的删除么', {
            btn: ['确定', '取消'] //按钮
        }, function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/school/del/" + id,
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
        }, function () {
            layer.closeAll();
        });
    }
    exports('school/index', datalist);
});