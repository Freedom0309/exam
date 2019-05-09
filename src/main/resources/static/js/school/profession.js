layui.define(['layer', 'table', 'common', 'util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        common = layui.common,
        util = layui.util,
        table = layui.table,
        laypage = layui.laypage;
    table.render({
        elem: '#profession'
        //, height: 'full-100'
        , method: 'GET'
        , url: '/school/getPressionNotInSchool' //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {type: 'checkbox'}
            , {field: 'name', align: 'center', title: '专业名称', unresize: true}
            , {field: 'description', align: 'center', title: '专业描述', unresize: true}
            , {field: 'future', align: 'center', title: '专业前景', unresize: true}
        ]]
        , id: 'professionTable'
        , page: {
            // count: data.length,
            layout: ['prev', 'page', 'next', 'skip', 'limit', 'count'], //自定义分页布局
            // curr: 1, //设定初始在第 5 页
            groups: 3, //只显示 1 个连续页码
            first: true, //不显示首页
            last: false, //不显示尾页
            limit: 10,
            limits: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
        }
        , where: {id: $('input[name=id]').val()}
    });

    table.render({
        elem: '#pro-school'
        //, height: 'full-100'
        , method: 'GET'
        , url: '/school/getPressionBySchool'//数据接口
        /*, before: function (obj) {
            this.data={'id': $('input[name=id]').val()}
        }*/
        , page: true //开启分页
        , cols: [[ //表头
            {type: 'checkbox'}
            , {field: 'name', align: 'center', title: '专业名称', unresize: true}
            , {field: 'description', align: 'center', title: '专业描述', unresize: true}
            , {field: 'future', align: 'center', title: '专业前景', unresize: true}
        ]]
        , id: 'professionTable'
        , page: {
            // count: data.length,
            layout: ['prev', 'page', 'next', 'skip', 'limit', 'count'], //自定义分页布局
            // curr: 1, //设定初始在第 5 页
            groups: 3, //只显示 1 个连续页码
            first: true, //不显示首页
            last: false, //不显示尾页
            limit: 10,
            limits: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
        }
        , where: {id: $('input[name=id]').val()}
    });

    //监听工具条
    table.on('tool(table)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            del(data.id);
        } else if (obj.event === 'edit') {
            common.frame_show('编辑', '/school/form?id=' + data.id);
        } else if (obj.event === 'addProfession') {
            common.frame_show('专业管理', '/school/profession' + data.id);
        }
    });

    //添加专业到学校
    $('#save').click(function () {
        var datas = table.checkStatus('professionTable');
        var data = datas.data;
        if (datas.data.length == 0) {
            layer.msg('请选择专业', {
                time: 2000,
                icon: 5
            });
            return;
        }
        var schoolId = $('input[name=id]').val();
        var ids = "";
        for (var i = 0; i < data.length; i++) {
            ids += data[i].id + ",";
        }
        ids = ids.substring(0, ids.length - 1);
        $.ajax({
            url: '/school/saveProfession',
            data: {
                ids: JSON.stringify(ids),
                schoolId: schoolId
            },
            dataType: 'json',
            type: 'post',
            success: function (data) {
                layer.msg('保存成功', {
                    time: 2000,
                    icon: 1
                })
                window.location = window.location.href
            }
        });
    });

    //删除学校的专业
    $('#delete').click(function () {
        var datas = table.checkStatus('professionTable');
        var data = datas.data;
        if (datas.data.length == 0) {
            layer.msg('请选择专业', {
                time: 2000,
                icon: 5
            });
            return;
        }
        var schoolId = $('input[name=id]').val();
        var ids = "";
        for (var i = 0; i < data.length; i++) {
            ids += data[i].id + ",";
        }
        ids = ids.substring(0, ids.length - 1);
        $.ajax({
            url: '/school/deleteProfession',
            data: {
                ids: JSON.stringify(ids),
                schoolId: schoolId
            },
            dataType: 'json',
            type: 'post',
            success: function (data) {
                console.log(data)
                if (data.isOk) {
                    layer.msg(data.msg, {
                        time: 2000,
                        icon: 1
                    }, function () {
                        window.location = window.location.href
                    });
                } else {
                    layer.msg(data.msg, {time: 10000});
                }

            }
        });
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
                            //window.location.href = "/admin/school/index";
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

    exports('school/profession', {});
});