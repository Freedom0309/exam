layui.define(['layer', 'table', 'common', 'util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        util = layui.util,
        table = layui.table,
        laypage = layui.laypage;
    table.render({
        elem: '#batch'
        // , height: 'full-100'
        , method: 'GET'
        , url: '/batch/list' //数据接口
        , cols: [[ //表头
            {field: 'schoolName', align: 'center', title: '学校', sort: true, unresize: false,  templet: function(d){console.log(d);return d.school;}}
            , {field: 'year', align: 'center', title: '年份', sort: true, unresize: false}
            , {field: 'batchNumber', align: 'center', title: '批次', sort: true, unresize: false}
            , {field: 'artsScience', align: 'center', title: '文理科', sort: true, unresize: false}
            , {field: 'lowBatch', align: 'center', title: '最低录取批次', sort: true, unresize: false}
            , {field: 'avgBatch', align: 'center', title: '平均录取批次', sort: true, unresize: false}
            , {field: 'lowScore', align: 'center', title: '最低录取批次', sort: true, unresize: false}
            , {field: 'avgScore', align: 'center', title: '平均录取批次', sort: true, unresize: false}
            , {fixed: 'right', title: '操作', align: 'center', width: '300', toolbar: '#operator', fixed: 'right'}
        ]]
        , id: 'batchTable'
        // ,page: true
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
            common.frame_show('编辑', '/batch/form?id=' + data.id);
        } else if (obj.event === 'addProfession') {
            common.frame_show('专业管理', '' + data.id);
        }
    });

    //添加数据
    $('#addSchool').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('添加', '/batch/form');
        }, 500);
    });

    function del(id) {
        layer.confirm('真的删除么', {
            btn: ['确定', '取消'] //按钮
        }, function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/batch/del/" + id,
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
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

    exports('batch/index', {});
});