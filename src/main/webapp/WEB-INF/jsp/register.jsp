<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%String ctxPath = request.getContextPath();%> <!-- 设置一个变量，获取页面加载路径 -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Register Page</title>

	<!-- CSS -->
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/form-elements.css">
	<link rel="stylesheet" href="css/style.css">

	<link rel="shortcut icon" href="ico/favicon.png">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">Bootstrap Registration Form Template</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="top-navbar-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
							<span class="li-text">
								Put some text or
							</span>
					<a href="#"><strong>links</strong></a>
					<span class="li-text">
								here, or some icons:
							</span>
					<span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-envelope"></i></a>
								<a href="#"><i class="fa fa-skype"></i></a>
							</span>
				</li>
			</ul>
		</div>
	</div>
</nav>

<!-- Top content -->
<div class="top-content">
	<div class="inner-bg">
		<div class="container">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2 text">
					<h1><strong>Bootstrap</strong> Registration Form</h1>
					<div class="description">
						<p>
							This is a free responsive registration form made with Bootstrap.
							Download it on <a href="#"><strong>AZMIND</strong></a>, customize and use it as you like!
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 book">
					<img src="img/ebook.png" alt="">
				</div>
				<div class="col-sm-5 form-box">
					<div class="form-top">
						<div class="form-top-left">
							<h3>Get our eBook</h3>
							<p>Fill in the form below to get instant access:</p>
						</div>
						<div class="form-top-right">
							<i class="fa fa-pencil"></i>
						</div>
					</div>
					<div class="form-bottom">
						<form role="form" action="" method="post" class="registration-form">
							<div class="form-group">
								<label class="sr-only" for="form-first-name">First name</label>
								<input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name">
							</div>
							<div class="form-group">
								<label class="sr-only" for="form-last-name">Last name</label>
								<input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
							</div>
							<div class="form-group">
								<label class="sr-only" for="form-email">Email</label>
								<input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">
							</div>
							<div class="form-group">
								<label class="sr-only" for="form-code">ActiveCode</label>
								<input type="text" name="form-code" placeholder="ActiveCode.." class="form-code form-control" id="form-code">
							</div>
							<button type="submit" class="btn" id="register">注册RightNow</button>
							<button type="button" class="btn" id="sendCode">发送验证码</button>
							<button type="submit" class="btn" id="returnLogin">返回登录界面</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<!-- Javascript -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="js/jquery.backstretch.min.js"></script>
<script src="js/retina-1.1.0.min.js"></script>
<script src="js/scripts.js"></script>

<script>
    var sendedCode = 1234; //被发送的验证码

    $(document).ready(function () {
        $("#sendCode").click(function () {
            var email = $("#form-email").val();
            /**
             * 正则匹配
             */
            var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
            if(!pattern.test(email)){
                window.alert("请输入正确的邮箱格式")
                return;
            }
            /**
             * 发送邮件的ajax请求
             * code to insert
             * 邮件为 email
             */

            window.alert("验证码已经发送到您的邮箱，请查收");
        });

        $("#returnLogin").click(function () {
            //转url到登录页面
            window.alert("成功返回登录页面");
            window.location.href = "/loginPage.do";
        });
        $("#register").click(function () {
            //也是转到登录界面  不过会先跳出一个弹窗注册成功
            //先判断用户输入的值是否和预期一致
            window.alert("注册成功")
            window.location.href = "/loginPage.do";
        });
    })

</script>

</body>
</html>