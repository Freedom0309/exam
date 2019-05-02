layui.define([ 'layer',  'table','common','util'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        util = layui.util,
        common = layui.common,
        table  = layui.table ;
    table.render({
        elem: '#job'
        ,height: 'full-200'
        ,method:'GET'
        ,url: '/job/list' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'name', align:'center', title: '职位名称',unresize:true}
            ,{field: 'numbers', align:'center', title: '人数',unresize:true}
            ,{field: 'location', align:'center', title: '地点',unresize:true}
            ,{field: 'experience', align:'center', title: '工作经验',unresize:true}
            ,{field: 'title', align:'center', title: '职位要求',unresize:true}
            ,{field: 'treatment', align:'center', title: '待遇',unresize:true}
            ,{field: 'college', align:'center', title: '学院',unresize:true,templet: '<div>{{d.college.name}}</div>'}
            ,{field: 'createTime', align:'center', title: '创建时间',unresize:true,templet: '<div>{{# if(d.createTime!=null){ }}{{ layui.util.toDateString(d.createTime) }}{{# } }}</div>'}
            ,{fixed: 'right',  title:'操作',align:'center',width:'350', toolbar: '#operator',unresize:true}
        ]]
    });

    //监听工具条
    table.on('tool(table)', function(obj){
        var data = obj.data;
        console.log(data.id);
        if(obj.event === 'detail'){
            if($("#detail-view-"+data.id).length > 0){
                $("#detail-view-"+data.id).hide();
                $("#detail-view-"+data.id).remove();
            }else{
                createHtml(obj);
                $("#detail-view-"+data.id).show();
            }
        }else if(obj.event === 'del'){
            del(data.id);
        } else if(obj.event === 'edit'){
            common.frame_show('编辑','/job/form?id='+data.id);
        }else if(obj.event === 'public'){
            changeStatus(data.id);
        }else if(obj.event === 'republic'){
            changeStatus(data.id);
        }
    });

    function changeStatus(id,type) {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/job/change/" + id,
            success: function (ret) {
                if (ret.isOk) {
                    layer.msg("操作成功", {time: 2000}, function () {
                        window.location.href = "/admin/job/index";
                    });
                } else {
                    layer.msg(ret.msg, {time: 2000});
                }
            }
        });
    }

    //添加数据
    $('#addProject').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            common.frame_show('添加','/job/form');
        }, 500);
    });

    function del(id) {
        layer.confirm('真的删除行么', function (index) {
            $.ajax({
                type: "DELETE",
                dataType: "json",
                url: "/job/del/" + id ,
                success: function (ret) {
                    if (ret.isOk) {
                        layer.msg("操作成功", {time: 2000}, function () {
                            layer.close(index);
                            window.location.href = "/admin/job/index";
                        });
                    } else {
                        layer.msg(ret.msg, {time: 2000});
                    }
                }
            });
        });
    }

    function createHtml(obj) {
        var data = obj.data;
        var detailHtml = '';
        detailHtml += '<tr class="detail-view" style="display: none" id="detail-view-'+data.id+'">';
        detailHtml += '<td colspan="10"><blockquote class="layui-elem-quote" style="line-height: 30px;text-align:left;padding-left: 30px;">';
        detailHtml += '<div class="layui-inline layui-word-aux" style="width: 150px">描述:</div>'+data.desc+'</br>';
        detailHtml += '</blockquote></td></tr>';
        obj.tr.after(detailHtml);
    }
    exports('job/index',{});
});