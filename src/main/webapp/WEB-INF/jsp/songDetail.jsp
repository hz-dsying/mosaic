<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>歌曲详情页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="My Play Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' media="all" />
<!-- //bootstrap -->
<link href="css/dashboard.css" rel="stylesheet">
<!-- Custom Theme files -->
<link href="css/Style_D.css" rel='stylesheet' type='text/css' media="all" />
<script src="js/jquery-1.11.1.min.js"></script>
<!--start-smoth-scrolling-->
<!-- fonts -->
<link href='css/49917424aee4451bbe76043431741de5.css' rel='stylesheet' type='text/css'>
<link href='css/0b8a048186ab488fab859edf052b9bcc.css' rel='stylesheet' type='text/css'>
<!-- //fonts -->
</head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div id="navbar" class="navbar-collapse collapse">
			<div class="header-top-right">
				<div class="signin">
					<c:if test="${user.role==2 }">
						<a href="${pageContext.request.contextPath}/download?songid=${song.songid}">歌曲下载</a>
					</c:if>
				</div>	
				<div class="signin">
					<a href="${pageContext.request.contextPath}/listAlbum" class="play-icon popup-with-zoom-anim">返回首页</a>		
				</div>
				<div class="signin">
					<c:if test="${empty user}">
						<a href="${pageContext.request.contextPath}/toLogin" class="play-icon popup-with-zoom-anim">登录</a>		
					</c:if>
				</div>
				<div class="signin">
					<c:if test="${!empty user}">
						<a href="${pageContext.request.contextPath}/toLogin" class="play-icon popup-with-zoom-anim">安全退出</a>
					</c:if>
				</div>
				<div class="clearfix"> </div>
			</div>
        </div>
		<div class="clearfix"> </div>
      </div>
    </nav>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="show-top-grids">
				<div class="col-sm-8 single-left">
					<div class="song">
						<div class="song-info">
							<h3>${song.songname }</h3>	
							<h5>歌手：${song.singer }</h5>
						</div>
						<div class="video-grid">
							<audio controls="controls" >
								<source src="songs${song.songurl }" ></source>
							</audio>
							<br>
							<br>
							<div>
								<button>
									<a href="${pageContext.request.contextPath }/addOrDeleteLikeSong?userid=${user.userid}&songid=${song.songid}">
										<c:if test="${isCollect==1 }">
											<h5>歌曲已收藏，点击取消</h5>
										</c:if>
										<c:if test="${isCollect==0 }">
											<h5>点击收藏歌曲</h5>
										</c:if>
									</a>
								</button>
							</div>
							<br>
						</div>
					</div>

					<div class="clearfix"> </div>
					
					<div class="all-comments">
						<div class="all-comments-info">
							<a href="#">All Comments</a>
							<div class="box">
								<form action="${pageContext.request.contextPath }/addComment" method="post">
									<input type="hidden" name="userid" value="${user.userid}">
									<input type="hidden" name="songid" value="${song.songid}">
									<textarea name="commentcontent" placeholder="我的评论......" required=" "></textarea>
									<input type="submit" value="SEND">
									<div class="clearfix"> </div>
								</form>
							</div>

						</div>
						<div class="media-grids">
							<c:forEach items="${list }" var="commentPo">
								<div class="media">
									<h5>${commentPo.user.username }</h5>
									<div class="media-body">
										<p>${commentPo.commentcontent }</p>
										<span>评论点赞数   :  ${commentPo.likescount }   </span>
										<c:if test="${commentPo.isCheck==1 }">
											<span><a href="${pageContext.request.contextPath }/addOrDeleteUserCommentLike?commentid=${commentPo.commentid}&userid=${user.userid}">已点赞，点击取消</a></span>
										</c:if>
										<c:if test="${commentPo.isCheck==0 }">
											<span><a href="${pageContext.request.contextPath }/addOrDeleteUserCommentLike?commentid=${commentPo.commentid}&userid=${user.userid}">点击点赞</a></span>
										</c:if>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="clearfix"> </div>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>