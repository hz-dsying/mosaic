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

			<div class="clear"></div>
		</div>
		<div class="register-full">
			<div class="register-left">
				<div class="register">
					<p>Boom!Boom!Boom!</p>
					<h1>MOSAIC</h1>
					<h2>Music Share Platform</h2>
					<p>欢迎访问MOSAIC音乐分享平台</p>
				</div>
			</div>
			
		<div class="register-right">
				<div class="register-in">
					<a class="book popup-with-zoom-anim button-isi zoomIn animated"
						data-wow-delay=".5s" href="#small-dialog">Change Password </a>
				</div>
				<div class="register-in">
					<a data-wow-delay=".5s" href="${pageContext.request.contextPath}/toLogin">Return Login </a>
				</div>


			</div>	
			
		</div>
	</section>
	<!-- //section -->

	<!-- login form popup-->
	<div class="pop-up">
		<div id="small-dialog" class="mfp-hide book-form">

			<div class="login-form login-form-left">
				<div class="agile-row">
					<h3>Change Password</h3>
					<span class="fa fa-lock"></span>
					<div class="clear"></div>
					<div class="login-agileits-top">
						<form action="${pageContext.request.contextPath}/changePwd" method="post" id="regForm">
							<input type="hidden" name="method" value="login" >
							<input type="text" class="name" name="username" Placeholder="Username" required="" id="username" /> 
							<input type="password" class="password" name="password" Placeholder="Password" required="" /> 
							<input type="password" class="rePassword" name="rePassword" Placeholder="rePassword" required="" /> 
							<input type="submit" value="提交">
						</form>
					</div>

				</div>
			</div>

		</div>
	</div>
	<!-- //login form popup-->
	

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
			$.validator.addMethod("checkUserPwd",
					function(value, element, params) {
						var pass = false;
						// value：输入内容，需要给数据库对比
						$.ajax({
							url : "${pageContext.request.contextPath}/checkUser",
							data : {
								"username" : $("#username").val(),
								"password" : value
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
						required : true
					},
					password : {
						required : true,
						checkUserPwd : true
					},
					rePassword : {
						required : true,
						minlength : 6,
						maxlength : 20
					}

				},
				messages : {
					username : {
						required : "用户名不能为空"
					},
					password : {
						required : "密码不能为空",
						checkUserPwd : "用户名/密码错误"
					},
					rePassword : {
						required : "密码不能为空",
						minlength : "密码长度不能小于6",
						maxlength : "密码长度不能大于20"
					}

				}
			});
		});
	</script>

</body>
</html>