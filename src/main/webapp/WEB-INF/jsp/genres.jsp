<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<title>MOSAIC</title>
<meta name="description"
	content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<link rel="stylesheet" href="js/jPlayer/jplayer.flat.css"
	type="text/css" />
<link rel="stylesheet" href="css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="css/animate.css" type="text/css" />
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="css/simple-line-icons.css" type="text/css" />
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link rel="stylesheet" href="css/app.css" type="text/css" />
<!--[if lt IE 9]>
    <script src="js/ie/html5shiv.js"></script>
    <script src="js/ie/respond.min.js"></script>
    <script src="js/ie/excanvas.js"></script>
  <![endif]-->
</head>
<body class="">
	<section class="vbox">
		<header
			class="bg-white-only header header-md navbar navbar-fixed-top-xs">
			<div class="navbar-header aside bg-info dk nav-xs">
				<a class="btn btn-link visible-xs"
					data-toggle="class:nav-off-screen,open" data-target="#nav,html">
					<i class="icon-list"></i>
				</a>  <a class="btn btn-link visible-xs" data-toggle="dropdown"
					data-target=".user"> <i class="icon-settings"></i>
				</a>
			</div>

			<form
				class="navbar-form navbar-left input-s-lg m-t m-l-n-xs hidden-xs"
				role="search">
				<div class="form-group">
					<div class="input-group">
						<span class="input-group-btn">
							<button type="submit"
								class="btn btn-sm bg-white btn-icon rounded">
								<i class="fa fa-search"></i>
							</button>
						</span> 
						 <input type="text" class="form-control input-sm no-border rounded" placeholder="Search songs, albums..." id="word" name="word">
						 <div id="list" style="width:131px; border:1px solid gray; 
         background-color: white; position: absolute;top:28px; z-index: 1000; display: none">
      </div>
            		</div>
				</div>
			</form>
			<div class="navbar-right ">
				<ul class="nav navbar-nav m-n hidden-xs nav-user user">
					
					<c:if test="${empty user}">
						<li class="hidden-xs"><a
							href="${pageContext.request.contextPath}/toLogin"> <span>登录</span>
						</a></li>
						<li class="hidden-xs"><a
							href="${pageContext.request.contextPath}/toLogin"> <span>注册</span>
						</a></li>
					</c:if>
					<c:if test="${!empty user}">
						<li class="hidden-xs"><a href="${pageContext.request.contextPath}/profile.jsp"> <span>${user.username}</span>
						</a></li>
						<li class="hidden-xs"><a href="#"> <span>欢迎您</span>
						</a></li>
						<li class="hidden-xs"><a href="${pageContext.request.contextPath}/toLogin"> <span>安全退出</span>
						</a></li>
					</c:if>
				</ul>
			</div>
		</header>
		<section>
			<section class="hbox stretch">

				<section id="content">
					<section class="vbox">
						<section class="w-f-md" id="bjax-target">
							<section class="hbox stretch">
								<!-- side content -->
								<aside class="aside bg-light dk" id="sidebar">
									<section class="vbox animated fadeInUp">
										<section class="scrollable hover">
											<div
												class="list-group no-radius no-border no-bg m-t-n-xxs m-b-none auto">
												<form action="${pageContext.request.contextPath }/listSong" >
													<input type="hidden" name="userid" value="${user.userid}">
													<!-- <input type="hidden" name="method" value="songType"> -->
													<a href="${pageContext.request.contextPath }/listSong">
														<button name="type" value="所有歌曲" class="list-group-item"
															style="width: 100%">所有歌曲</button>
													</a> 
													<c:if test="${!empty user}">
														<a href="${pageContext.request.contextPath }/listSong">
															<button name="type" value="我的收藏" class="list-group-item"
																style="width: 100%">我的收藏</button>
														</a> 
													</c:if>
													<c:forEach items="${albumList}" var="album">
														<a href="${pageContext.request.contextPath }/listSong">
															<button name="type" value="${album.albumname }" class="list-group-item"
																style="width: 100%">${album.albumname }</button>
														</a>
													</c:forEach>
													
													<!-- <a href="genres.html">
														<button name="type" value="为情所困" class="list-group-item"
															style="width: 100%">为情所困</button>
													</a>  -->

												</form>

											</div>
										</section>
									</section>
								</aside>
								<!-- / side content -->
								<section>
									<section class="vbox">
										<section class="scrollable padder-lg">
											<h2 class="font-thin m-b">${type}</h2>
											<div class="row row-sm">
												<c:forEach items="${pageBean.list }" var="song">
													<div class="col-xs-6 col-sm-4 col-md-3 col-lg-2" style="z-index: 1">
														<div class="item">
															<div class="pos-rlt">
																<div class="item-overlay opacity r r-2x bg-black">
																	<div class="center text-center m-t-n">
																		<a
																			href="${pageContext.request.contextPath }/songDetail?songid=${song.songid}"><i
																			class="fa fa-play-circle i-2x"></i></a>
																	</div>
																</div>
																<a href="${pageContext.request.contextPath }/songDetail?songid=${song.songid}"><img
																	src="${pageContext.request.contextPath }/img/${song.imgurl }"
																	alt="" class="r r-2x img-full" style="height: 300px"></a>
															</div>
															<div class="padder-v">
																<a href="#" data-bjax
																	data-target="#bjax-target" data-el="#bjax-el"
																	data-replace="true" class="text-ellipsis">${song.songname }</a>
																<a href="#" data-bjax
																	data-target="#bjax-target" data-el="#bjax-el"
																	data-replace="true"
																	class="text-ellipsis text-xs text-muted">${song.singer }</a>
															</div>
														</div>
													</div>
												</c:forEach>
											</div>	
												<div style="float:none;width:500px"  class="col-xs-6 col-sm-4 col-md-3 col-lg-2" >
											<ul class="pagination pagination">
						                        <li><a href="${pageContext.request.contextPath }/listFormerSong?currentPage=${currentPage}&type=${type}&userid=${user.userid}"><i class="fa fa-chevron-left"></i></a></li>
						                        <c:forEach begin="1" end="${pageBean.totalPage }" step="1" var="i">
						                        <li><a href="${pageContext.request.contextPath }/listSong?currentPage=${i}&type=${type}&userid=${user.userid}">${i }</a></li>
												</c:forEach>
						                        <li><a href="${pageContext.request.contextPath }/listNextSong?currentPage=${currentPage}&type=${type}&userid=${user.userid}"><i class="fa fa-chevron-right"></i></a></li>
						                      </ul>
												
												</div>
										</section>
									</section>
								</section>
							</section>
						</section>
						
					</section>
					<a href="#" class="hide nav-off-screen-block"
						data-toggle="class:nav-off-screen,open" data-target="#nav,html"></a>
				</section>
			</section>
		</section>
	</section>
	<script src="js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.js"></script>
	<!-- App -->
	<script src="js/app.js"></script>
	<script src="js/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="js/app.plugin.js"></script>
	<script type="text/javascript" src="js/jPlayer/jquery.jplayer.min.js"></script>
	<script type="text/javascript"
		src="js/jPlayer/add-on/jplayer.playlist.min.js"></script>
	<script type="text/javascript">	

	</script>	
	<script type="text/javascript">
								$(function(){
									$("#word").keyup(function(){
										// 局部刷新，想要获得商品名，显示到input下面添加新的列表
										$.get(
											"${pageContext.request.contextPath}/searchSong",
											{
												"word": $("#word").val()
											},
											function(data){
												$("#list").empty();
												for (var i = 0 ;i < data.length; i++) {
													if ( i > 7) {
														break;
													}
													$("#list").append("<a href='${pageContext.request.contextPath }/songDetail?songid="+data[i].songid+"' ><div style='cursor:pointer' onmouseover='over(this)' onmouseout='out(this)' onclick='go(this)'>"+data[i].songname+"</div></a>");
												}
												$("#list").css("display", "block");
											},
											"json"
										);

									}); 
								});
								function over(obj) {
									$(obj).css("background-color", "gray");
									}
									function out(obj) {
										$(obj).css("background-color", "white");
									}
									function go(obj) {
										$("#word").val($(obj).html());
										$("#list").css("display", "none");
									}
									function to(val) {
								            $("#currentPage").val(parseInt($("#currentPage").val())+val);
								            $("#page").submit();
							        }
							</script>
</body>
</html>