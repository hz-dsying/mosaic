<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //custom-theme -->
<!-- Google fonts -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
	rel="stylesheet">
<!-- Google fonts -->

<!-- css files -->
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="all">
<!-- //css files -->

<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->

<link href="css/popup-box.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- popup box css -->

</head>
<!-- body starts -->
<body>

	<!-- section -->
	<section class="register">
		<div class="header">
			<div class="logo">
				<a href="#">MOSAIC</a>
			</div>
			<!-- <div class="social">
                <li><a href="#"><span class="fa fa-facebook"></span></a></li>
                <li><a href="#"><span class="fa fa-twitter"></span></a></li>
                <li><a href="#"><span class="fa fa-linkedin"></span></a></li>
                <li><a href="#"><span class="fa fa-google-plus"></span></a></li>
        </div> -->
			<div class="clear"></div>
		</div>
		<!-- <div class="tlinks">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div> -->
		<div class="register-full">
			<div class="register-left">
				<div class="register">
					<p>Boom!Boom!Boom!</p>
					<h1>MOSAIC</h1>
					<h2>Music Share Platform</h2>
					<p>欢迎访问MOSAIC音乐分享平台</p>
					<!-- <div class="content3">
					<ul>
						<li><a class="" href="#"> New Project</a></li>
						<li><a class="read" href="#"> Get Started</a></li>
					</ul>
				</div> -->
				</div>
			</div>
			<div class="register-right">
				<div class="register-in">
					<a class="book popup-with-zoom-anim button-isi zoomIn animated"
						data-wow-delay=".5s" href="#small-dialog2">register here »</a>
				</div>
				<div class="register-in middle">
					<a class="book popup-with-zoom-anim button-isi zoomIn animated"
						data-wow-delay=".5s" href="#small-dialog">login here »</a>
				</div>
				<div class="register-in">
					<!-- <a class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog1">Subscribe here »</a> -->
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- copyright -->
		<p class="agile-copyright">Copyright &copy; 2020.Company name All
			rights reserved. BoomBoomBoom</p>
		<!-- //copyright -->
	</section>
	<!-- //section -->



	<!-- login form popup-->
	<div class="pop-up">
		<div id="small-dialog" class="mfp-hide book-form">

			<div class="login-form login-form-left">
				<div class="agile-row">
					<h3>Login to your site</h3>
					<span class="fa fa-lock"></span>
					<div class="clear"></div>
					<div class="login-agileits-top">
						<form action="${pageContext.request.contextPath}/login" method="post">
							<input type="hidden" name="method" value="login" >
							<input type="text" class="name" name="username" Placeholder="Username" required="" /> 
							<input type="password" class="password" name="password" Placeholder="Password" required="" /> 
							<input type="submit" value="Login">
						</form>
					</div>
					<div class="login-agileits-bottom">
						<h6>
							<a href="#">修改密码</a>
						</h6>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- //login form popup-->
	
	<!-- register form popup-->
	<div class="pop-up">
		<div id="small-dialog2" class="mfp-hide book-form">

			<div class="login-form login-form-left">
				<div class="agile-row">
					<h3>Register form</h3>
					<div class="login-agileits-top">
						<form action="${pageContext.request.contextPath}/register" method="post" id="regForm">
							<input type="hidden" name="method" value="register" >
							<input type="text" class="username" name="username" Placeholder="Username" required=""  id="username" autocomplete="off"/> 
							<input type="password" class="password" name="password" Placeholder="Password" required="" id="password"/>
							<input type="email" class="email" name="email" Placeholder="Email" required="" id="email" autocomplete="off"/> 
							<input type="text" class="mobilenumber" name="mobilenumber" Placeholder="Phone Number" required="" id="mobilenumber" autocomplete="off"/>
							<br>
							<input type="radio" class="role" name="role" value="1" id="role_1" checked required=""><label for="role_1">普通用户</label>
							<input type="radio" class="role" name="role" value="2" id="role_2" required=""><label for="role_2">会员</label>
							<input type="radio" class="role" name="role" value="3" id="role_3" required=""><label for="role_3">管理员</label>
							<br>
							
							<!-- <div class="login-check">
								<label class="checkbox"><input type="checkbox"
									name="checkbox" checked=""><i> </i> I Accept to the <a
									href="#">Terms &amp; Conditions</a></label>
							</div> -->
							<input type="submit" value="Register">
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- //register form popup-->

	<!-- js -->
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<!-- //js -->

	<!--popup-js-->
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});

		});
	</script>
	<!--//popup-js-->

	<script type="text/javascript">
		$(function() {
			// 自定义校验规则
			$.validator.addMethod("checkUser",
					function(value, element, params) {
						var pass = false;
						// value：输入内容，需要给数据库对比
						$.ajax({
							url : "${pageContext.request.contextPath}/checkUsername",
							data : {
								"username" : value
							},
							success : function(data) {
								// data.msg==null -> true -> 校验通过
								// data.msg!=null -> false -> 校验不通过
								pass=(data.msg==null);
							},
							dataType : "json",
							async : false
						// 必须同步
						});
						return pass; // 返回true表示校验通过
					});
			$("#regForm").validate({
				rules : {
					username : {
						required : true,
						minlength : 3,
						maxlength : 12,
						checkUser : true
					},
					password : {
						required : true,
						minlength : 6,
						maxlength : 20
					},
					email : {
						email:true
					},
					mobilenumber : {
						minlength : 11,
						maxlength : 11
					},
					role : {
						required : true
					}
				},
				messages : {
					username : {
						required : "用户名不能为空",
						minlength : "用户名长度不能小于3",
						maxlength : "用户名长度不能大于12",
						checkUser : "用户名已存在"
					},
					password : {
						required : "密码不能为空",
						minlength : "密码长度不能小于6",
						maxlength : "密码长度不能大于20"
					},
					email : {
						email : "邮箱格式不正确!"
					},
					mobilenumber : {
						minlength : "手机号长度为11",
						maxlength : "手机号长度为11"
					},
					role : {
						required : "用户权限不能为空"
					}
				}
			});
		});
	</script>

<!-- 	<script>
		$(function() {
			$("#username").onblur(function() {
				$.post("${pageContext.request.contextPath}/checkUsername", {
					"username" : $("#username").val()
				}, function(data) {
					if (data.msg!=null) { //校验不通过，已存在
						alert(data.msg);
					} else{
						alert("通过");
					}
				}, "json");
			});
		});
	</script> -->

</body>
<!-- //body ends -->
</html>