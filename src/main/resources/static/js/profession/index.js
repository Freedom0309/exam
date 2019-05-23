layui.define(['layer', 'table', 'common', 'util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        util = layui.util,
        table = layui.table;
    table.render({
        elem: '#school'
        , height: 'full-100'
        , method: 'GET'
        , url: '/profession/list' //数据接口
        , cols: [[ //表头
            {field: 'name', align: 'center', title: '专业名称', unresize: true}
            , {field: 'description', align: 'center', title: '专业描述', unresize: true}
            , {field: 'future', align: 'center', title: '专业前景', unresize: true}
            , {field: 'compensation', align: 'center', title: '平均薪资', unresize: true}
            , {fixed: 'right', title: '操作', align: 'center', width: '200', toolbar: '#operator', unresize: true}
        ]]
        , id: 'professionTable'
        , page: {
            layout: [ 'limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
            // curr: 1, //设定初始在第 5 页
            groups: 3, //只显示 1 个连续页码
            first: true, //显示首页
            last: true, //不显示尾页
            limit: 5,
            limits: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
        }
    });

    //监听工具条
    table.on('tool(table)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            del(data.id);
        } else if (obj.event === 'edit') {
            common.frame_show('编辑', '/profession/form?id=' + data.id);
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
            common.frame_show('编辑', '/admin/profession/form?id=' + id);
        }
    };

    //添加数据
    $('#addProfession').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('添加', '/profession/form');
        }, 500);
    });

    function del(id) {
        layer.confirm('真的删除么', {
            btn: ['确定', '取消'] //按钮
        }, function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/profession/del/" + id,
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("删除成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location = window.location.href;
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

    exports('profession/index', datalist);
});