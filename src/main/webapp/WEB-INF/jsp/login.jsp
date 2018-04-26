<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Login</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
				<div class="name">
					<label>用户名</label><input type="text" class="text" id="value_1" placeholder="用户名" name="value_1" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text" id="value_2" placeholder="密码" name="value_2" tabindex="2">
					<div>
						<input type="button" class="submit" tabindex="3" value="登录" id="loginBtn">
						<input type="button" class="submit" tabindex="4" value="注册" id="goRegister">
					</div>
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>


<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
</div>

<script>
    jQuery(document).ready(function () {
        //注册按钮   转到注册界面
        $("#goRegister").click(function () {
            console.log("click goRegister");
            window.alert("test alert");
            window.location.href = "/registerPage.do";
        })

        $("#loginBtn").click(function () {
            var username = $("#value_1").val();
            var password = $("#value_2").val();
            //check the value
            if (username == "") {
                window.alert("用户名不能为空");
                return false;
            }
            if (password == "") {
                window.alert("密码不能为空");
                return false;
            }
            /**传送后端数据对象  通过ajax进行请求*/
            var data = {accountName: username, password: password};
            $.ajax({
                url: "checkAccount.do", /**请求的url*/
                data: data,
                type: "post", /**post方式*/
                dataType: "json", /**数据类型*/
                beforeSend: function () {
                    /**登录之前  无法继续再按*/
                    $("#loginBtn").enable(false);
                },
                /**后端返回的结果存于result  可以是任意对象类型 比如 map*/
                success: function (result) {
                    /**code to insert*/
                    //根据后端返回的不同结果 做相应处理


                },
                /**error 出现错误*/
                error: function () {
                    window.alert("there are some error");
                }
            })
        })
    });
</script>

</body>
</html>