layui.define(['layer', 'table', 'common', 'util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        util = layui.util,
        table = layui.table,
        laypage = layui.laypage;
    table.render({
        elem: '#school'
        // , height: 'full-100'
        , method: 'GET'
        , url: '/scoreline/list' //数据接口
        // , page: true //开启分页
        , cols: [[ //表头
            {field: 'year', align: 'center', title: '年份', sort: true, unresize: false}
            , {field: 'batchNumber', align: 'center', title: '批次', sort: true, unresize: false}
            , {field: 'score', align: 'center', title: '分数线', sort: true, unresize: false}
            , {field: 'artsScience', align: 'center', title: '文理科', sort: true, unresize: false}
            , {fixed: 'right', title: '操作', align: 'center', width: '300', toolbar: '#operator', unresize: false}
        ]]
        , id: 'schoolTable'
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

    //分页
    laypage.render({
        elem: '#school'
        , count: 1000
        , first: '首页'
        , last: '尾页'
        , prev: '<em>←</em>'
        , next: '<em>→</em>'
    });

    //监听工具条
    table.on('tool(table)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            del(data.id);
        } else if (obj.event === 'edit') {
            common.frame_show('编辑', '/scoreline/form?id=' + data.id);
        } else if (obj.event === 'addProfession') {
            common.frame_show('专业管理', '' + data.id);
        }
    });

    //添加数据
    $('#addSchool').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('添加', '/scoreline/form');
        }, 500);
    });

    function del(id) {
        layer.confirm('真的删除么', {
            btn: ['确定', '取消'] //按钮
        }, function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/scoreline/del/" + id,
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

    exports('scoreline/index', {});
});