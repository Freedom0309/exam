var $;
layui.use(['jquery','form','util','upload','laydate'], function () {
    $ = layui.jquery;
    var util = layui.util,
     form = layui.form,
	 laydate = layui.laydate,
     upload = layui.upload;

    laydate.render({
        // elem: '#birth' //指定元素
    });

    var user = MyLocalStorage.get("user");
    if (user!=null && user!='') {
    	user = JSON.parse(user);
    	var sex = 0 ;
    	var resumeSex = 3;
        $("#id").val(user.id);
        $("#user").val(user.id);
    	$("#num").val(user.num);
    	$("#name").val(user.name);
    	$("#phone").val(user.phone);
    	$("#email").val(user.email);
        $("#birth").val(user.birth.substr(0,10));

        if(user.sex == "女"){
        	sex = 1;
		}else{
        	sex = 0;
		}
        console.log($(".layui-form-radio"));
    	$(".layui-form-radio").get(sex).click();
    } else {
    	layer.msg('会话已过期,请先去登陆',{anim:6,time:2000});
    	location.href =  "/user/login";
    }


    // 修改个人资料
    form.on('submit(formInfo)', function(data){
    	data = data.field;
    	$.ajax({
    		type: 'GET',
    		data: data,
    		async:true,
    		url: "/jobSeeker/update",
    		success:function(result) {
    			if (result.isOk) {
    				MyLocalStorage.put("user", JSON.stringify(result.data), 360*24*3);
    				layer.msg("修改成功!",{icon:1});
                    window.location.href = "/user/index";
    			} else {
    				layer.msg(result.msg,{anim:6});
    			}
    		}
    	});
    	return false;
    });

    //上传文件设置
    upload.render({
        elem: '#upload' ,//绑定元素
        url: '/upload',
        accept: 'file',
        size:0,
        before: function(input) {
            console.log($(input));
            box = $("#upload").parent('.layui-input-block');
            console.log(box);
            if (box.next('div').length > 0) {
                box.next('div').html('<div class="imgbox"><p>上传中...</p></div>');
            } else {
                box.after('<div class="layui-input-block"><div class="imgbox"><p>上传中...</p></div></div>');
            }
        },
        done: function(res) {
            if (res.isOk) {
                box.next('div').find('div.imgbox').html('<p>下载地址：<a href="' + res.data.downloadUrl + '">' + res.data.fileName + '</a></p>');
                box.find('input[type=hidden]').val(res.book.id);
            } else {
                box.next('div').find('p').html('上传失败...')
            }
        }
    });

	// 修改密码
    form.on('submit(formPwd)', function(data){
    	data = data.field;
    	if (data.newP.length<6 || data.newP.length>18) {
    		layer.msg("密码必须6到18个字符",{anim:6});
    		return false;
    	}
    	if (data.newP!=data.repwd) {
    		layer.msg("两次密码输入不一致",{anim:6});
    		return false;
    	}

    	$.ajax({
    		type: 'get',
    		data: data,
    		async:true,
    		url: "/jobSeeker/changePass",
    		success:function(result) {
    			if (result.isOk) {
    				layer.msg("修改成功!",{icon:1});
                    window.location.href = "/user/index";
    			} else {
    				layer.msg(result.msg,{anim:6});
    			}
    		}
    	});
    	return false;
    });
    
    // 激活邮箱
    // $("#activaEmailBtn").click(function(){
		// $("#activeEmail").css('display','');
		// $("#activeEmail").click();
		// if (user.isActive=='Y') {
		// 	$("#activeEmaliShow").append("<br />"+"<p>您的邮箱："+user.email+"&nbsp;<i style=\"color: #B1B1B1\">(已成功激活)</i></p><br/><br/><br/><br/>");
		// } else {
		// 	$("#activeEmaliShow").append("<br />"+
    // 						"<p>您的邮箱："+user.email+"&nbsp;<i style=\"color: red\">(尚未激活)</i></p>"+
		// 					"<br /><br /><br /><br />"+
    // 						"<p>1.如果您未收到邮件，或激活链接失效，您可以<a class=\"link\" href=\"javascript:sendEmail()\">重新发送邮件</a>，或者<a href=\"javascript:updateEmail()\" class=\"link\">更换邮箱； </a></p>"+
    // 						"<br />"+
    // 						"<p>2. 如果您始终没有收到 zuoqy博客 发送的邮件，请注意查看您邮箱中的垃圾邮件；</p>"+
    // 						"<br />"+
    // 						"<p>3. 如果你实在无法激活邮件，您还可以联系：zuoqy@zuoqy.cn </p>"+
    // 						"<br/><br/><br/><br/>");
		// }
    // });
	
	// 清空全部消息
	// $("#LAY_msg").click(function() {
	// 	$(".msgs").empty();
	// });
});

//更换邮箱
// function updateEmail() {
// 	location.href = _contextPath + "/user.html";
// }

//发送邮件-激活邮箱
// function sendEmail() {
// 	var user = JSON.parse(MyLocalStorage.get("user"));
// 	$.ajax({
// 		type: 'post',
// 		data: {uid:user.uid,token:user.token},
// 		async:true,
// 		url: "/usre/activeEmail/send.do",
// 		success:function(result) {
// 			if (result.isOk) {
// 				layer.alert('已将激活邮箱地址发至您的邮箱,请注意查收', {icon: 1,anim: 1});
// 			} else {
// 				layer.msg(result.msg,{anim:6});
// 			}
// 		}
// 	});
// }