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
				</a> <a href="${pageContext.request.contextPath}/index.jsp"
					class="navbar-brand text-lt"> <i class="icon-earphones"></i> <img
					src="images/logo.png" alt="." class="hide"> <span
					class="hidden-nav-xs m-l-sm">MOSAIC</span>
				</a> <a class="btn btn-link visible-xs" data-toggle="dropdown"
					data-target=".user"> <i class="icon-settings"></i>
				</a>
			</div>
			<ul class="nav navbar-nav hidden-xs">
				<li><a href="#nav,.navbar-header"
					data-toggle="class:nav-xs,nav-xs" class="text-muted"> <i
						class="fa fa-indent text"></i> <i class="fa fa-dedent text-active"></i>
				</a></li>
			</ul>
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
					<li class="hidden-xs"><a href="#" class="dropdown-toggle lt"
						data-toggle="dropdown"> <i class="icon-bell"></i> <span
							class="badge badge-sm up bg-danger count">2</span>
					</a>
						<section class="dropdown-menu aside-xl animated fadeInUp">
							<section class="panel bg-white">
								<div class="panel-heading b-light bg-light">
									<strong>You have <span class="count">2</span>
										notifications
									</strong>
								</div>
								<div class="list-group list-group-alt">
									<a href="#" class="media list-group-item"> <span
										class="pull-left thumb-sm"> <img src="images/a0.png"
											alt="..." class="img-circle">
									</span> <span class="media-body block m-b-none"> Use awesome
											animate.css<br> <small class="text-muted">10
												minutes ago</small>
									</span>
									</a> <a href="#" class="media list-group-item"> <span
										class="media-body block m-b-none"> 1.0 initial released<br>
											<small class="text-muted">1 hour ago</small>
									</span>
									</a>
								</div>
								<div class="panel-footer text-sm">
									<a href="#" class="pull-right"><i class="fa fa-cog"></i></a> <a
										href="#notes" data-toggle="class:show animated fadeInRight">See
										all the notifications</a>
								</div>
							</section>
						</section></li>
					<c:if test="${empty user}">
						<li class="hidden-xs"><a
							href="${pageContext.request.contextPath}/signin.jsp"> <span>登录</span>
						</a></li>
						<li class="hidden-xs"><a
							href="${pageContext.request.contextPath}/signup.jsp"> <span>注册</span>
						</a></li>
					</c:if>
					<c:if test="${!empty user}">
						<li class="hidden-xs"><a href="${pageContext.request.contextPath}/profile.jsp"> <span>${user.username}</span>
						</a></li>
						<li class="hidden-xs"><a href="#"> <span>欢迎您</span>
						</a></li>
					</c:if>
				</ul>
			</div>
		</header>
		<section>
			<section class="hbox stretch">
				<!-- .aside -->
				<aside class="bg-dark dk nav-xs aside hidden-print" id="nav">
					<section class="vbox">
						<section class="w-f-md scrollable">
							<div class="slim-scroll" data-height="auto"
								data-disable-fade-out="true" data-distance="0" data-size="10px"
								data-railOpacity="0.2">



								<!-- nav -->
								<nav class="nav-primary hidden-xs">
									<ul class="nav bg clearfix">
										<li class="hidden-nav-xs padder m-t m-b-sm text-xs text-muted">
											Discover</li>
										<li><a
											href="${pageContext.request.contextPath}/index.jsp"> <i
												class="icon-disc icon  "></i> <span class="font-bold">What's
													new</span>
										</a></li>
										<li><a
											href="${pageContext.request.contextPath}/genres.jsp">
												<i class="icon-music-tone-alt icon text-info"></i> <span
												class="font-bold">Genres</span>
										</a></li>
										<li><a
											href="${pageContext.request.contextPath}/events.jsp"> <i
												class="icon-drawer icon  "></i> <b
												class="badge bg-primary pull-right">6</b> <span
												class="font-bold">Events</span>
										</a></li>
										<li><a
											href="${pageContext.request.contextPath}/listen.jsp"> <i
												class="icon-list icon   "></i> <span class="font-bold">Listen</span>
										</a></li>
										<li><a
											href="${pageContext.request.contextPath}/video.jsp"
											data-target="#content" data-el="#bjax-el" data-replace="true">
												<i class="icon-social-youtube icon   "></i> <span
												class="font-bold">Video</span>
										</a></li>
										<li class="m-b hidden-nav-xs"></li>
									</ul>
								</nav>
								<!-- / nav -->
							</div>
						</section>

						<footer class="footer hidden-xs no-padder text-center-nav-xs">
							<div class="bg hidden-xs ">
							</div>
						</footer>
					</section>
				</aside>
				<!-- /.aside -->
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
												<form
													action="${pageContext.request.contextPath }/SongServlet"
													id="songType">
													<input type="hidden" name="method" value="songType">
													<a href="genres.html">
														<button name="type" value="所有歌曲" class="list-group-item"
															style="width: 100%">全部</button>
													</a> <a href="genres.html">
														<button name="type" value="为情所困" class="list-group-item"
															style="width: 100%">为情所困</button>
													</a> <a href="genres.html">
														<button name="type" value="欢乐颂歌" class="list-group-item"
															style="width: 100%">欢乐颂歌</button>
													</a> <a href="genres.html">
														<button name="type" value="心潮澎湃" class="list-group-item"
															style="width: 100%">心潮澎湃</button>
													</a>

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
																			href="${pageContext.request.contextPath }/AddSongServlet?songid=${song.song_id}"><i
																			class="fa fa-play-circle i-2x"></i></a>
																	</div>
																</div>
																<a href="track-detail.html"><img
																	src="${pageContext.request.contextPath }${song.imgurl }"
																	alt="" class="r r-2x img-full" style="height: 300px"></a>
															</div>
															<div class="padder-v">
																<a href="track-detail.html" data-bjax
																	data-target="#bjax-target" data-el="#bjax-el"
																	data-replace="true" class="text-ellipsis">${song.name }</a>
																<a href="track-detail.html" data-bjax
																	data-target="#bjax-target" data-el="#bjax-el"
																	data-replace="true"
																	class="text-ellipsis text-xs text-muted">${song.artist }</a>
															</div>
														</div>
													</div>
												</c:forEach>
												<div style="float:none;width:500px"  class="col-xs-6 col-sm-4 col-md-3 col-lg-2" >
												
											<ul class="pagination pagination">
						                        <li><a href="${pageContext.request.contextPath }/SongServlet?method=formerPage&currentPage=${currentPage}&type=${type}"><i class="fa fa-chevron-left"></i></a></li>
						                        <c:forEach begin="1" end="${pageBean.totalPage }" step="1" var="i">
						                        <li><a href="${pageContext.request.contextPath }/SongServlet?method=songType&currentPage=${i}&type=${type}">${i }</a></li>
												</c:forEach>
						                        <li><a href="${pageContext.request.contextPath }/SongServlet?method=nextPage&currentPage=${currentPage}&type=${type}"><i class="fa fa-chevron-right"></i></a></li>
						                      </ul>
												
												</div>
										</section>
									</section>
								</section>
							</section>
						</section>
						<footer class="footer bg-info dker">
							<div id="jp_container_N">
								<div class="jp-type-playlist">
									<div id="jplayer_N" class="jp-jplayer hide"></div>
									<div class="jp-gui">
										<div class="jp-video-play hide">
											<a class="jp-video-play-icon">play</a>
										</div>
										<div class="jp-interface">
											<div class="jp-controls">
												<div>
													<a class="jp-previous"><i
														class="icon-control-rewind i-lg"></i></a>
												</div>
												<div>
													<a class="jp-play"><i class="icon-control-play i-2x"></i></a>
													<a class="jp-pause hid"><i
														class="icon-control-pause i-2x"></i></a>
												</div>
												<div>
													<a class="jp-next"><i class="icon-control-forward i-lg"></i></a>
												</div>
												<div class="hide">
													<a class="jp-stop"><i class="fa fa-stop"></i></a>
												</div>
												<div>
													<a class="" data-toggle="dropdown" data-target="#playlist"><i
														class="icon-list"></i></a>
												</div>
												<div class="jp-progress hidden-xs">
													<div class="jp-seek-bar dk">
														<div class="jp-play-bar bg-info"></div>
														<div class="jp-title text-lt">
															<ul>
																<li></li>
															</ul>
														</div>
													</div>
												</div>
												<div
													class="hidden-xs hidden-sm jp-current-time text-xs text-muted"></div>
												<div
													class="hidden-xs hidden-sm jp-duration text-xs text-muted"></div>
												<div class="hidden-xs hidden-sm">
													<a class="jp-mute" title="mute"><i
														class="icon-volume-2"></i></a> <a class="jp-unmute hid"
														title="unmute"><i class="icon-volume-off"></i></a>
												</div>
												<div class="hidden-xs hidden-sm jp-volume">
													<div class="jp-volume-bar dk">
														<div class="jp-volume-bar-value lter"></div>
													</div>
												</div>
												<div>
													<a class="jp-shuffle" title="shuffle"><i
														class="icon-shuffle text-muted"></i></a> <a
														class="jp-shuffle-off hid" title="shuffle off"><i
														class="icon-shuffle text-lt"></i></a>
												</div>
												<div>
													<a class="jp-repeat" title="repeat"><i
														class="icon-loop text-muted"></i></a> <a
														class="jp-repeat-off hid" title="repeat off"><i
														class="icon-loop text-lt"></i></a>
												</div>
												<div class="hide">
													<a class="jp-full-screen" title="full screen"><i
														class="fa fa-expand"></i></a> <a class="jp-restore-screen"
														title="restore screen"><i
														class="fa fa-compress text-lt"></i></a>
												</div>
											</div>
										</div>
									</div>
									<div class="jp-playlist dropup" id="playlist">
										<ul class="dropdown-menu aside-xl dker">
											<!-- The method Playlist.displayPlaylist() uses this unordered list -->
											<li class="list-group-item"></li>
										</ul>
									</div>
									<div class="jp-no-solution hide">
										<span>Update Required</span> To play the media you will need
										to either update your browser to a recent version or update
										your <a href="http://get.adobe.com/flashplayer/"
											target="_blank">Flash plugin</a>.
									</div>
								</div>
							</div>
						</footer>
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
	$(document).ready(function(){
		/* var song = ${song}; */
		
		/* var tempTitle = "${song.name}";
		var tempArtist = "${song.artist}";
		var tempMp3 = "${pageContext.request.contextPath}${song.songurl}";
		var tempPoster = "${pageContext.request.contextPath}${song.imgurl}";  */
		
		var songList = ${songList};
		console.log(songList);
		
  	myPlaylist = new jPlayerPlaylist({
    jPlayer: "#jplayer_N",
    cssSelectorAncestor: "#jp_container_N"
  },  /* [
    {
      title:"I'm Yours.mp3",
      artist:"Jason Mraz",
      mp3:"music/Jason Mraz - I'm Yours.mp3",
      poster: "images/m0.jpg"
    },
    {
      title:"${song.name}",
      artist:"${song.artist}",
      mp3:"${pageContext.request.contextPath}${song.songurl}",
      poster: "${pageContext.request.contextPath}${song.imgurl}"
    } 
  ]  */
  eval(songList)
  , {
    playlistOptions: {
      enableRemoveControls: true,
      autoPlay: false
    },
    swfPath: "js/jPlayer",
    supplied: "webmv, ogv, m4v, oga, mp3",
    smoothPlayBar: true,
    keyEnabled: true,
    audioFullScreen: false
  });
  
  $(document).on($.jPlayer.event.pause, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').removeClass('animate');
    $('.jp-play-me').removeClass('active');
    $('.jp-play-me').parent('li').removeClass('active');
  });

  $(document).on($.jPlayer.event.play, myPlaylist.cssSelector.jPlayer,  function(){
    $('.musicbar').addClass('animate');
  });

  $(document).on('click', '.jp-play-me', function(e){
    e && e.preventDefault();
    var $this = $(e.target);
    if (!$this.is('a')) $this = $this.closest('a');

    $('.jp-play-me').not($this).removeClass('active');
    $('.jp-play-me').parent('li').not($this.parent('li')).removeClass('active');

    $this.toggleClass('active');
    $this.parent('li').toggleClass('active');
    if( !$this.hasClass('active') ){
      myPlaylist.pause();
    }else{
      var i = Math.floor(Math.random() * (1 + 7 - 1));
      myPlaylist.play(i);
    }
    
  });
  
 /*  var tempTitle = "${song.name}";
	var tempArtist = "${song.artist}";
	var tempMp3 = "${pageContext.request.contextPath}${song.songurl}";
	var tempPoster = "${pageContext.request.contextPath}${song.imgurl}"; */
 /*  myPlaylist.add({ 
		title:tempTitle, 
		artist:tempArtist, 
		mp3:tempMp3, 
		poster: tempPoster 
		});  */

});
	</script>	
	<script type="text/javascript">
								$(function(){
									$("#word").keyup(function(){
										// 局部刷新，想要获得商品名，显示到input下面添加新的列表
										$.get(
											"${pageContext.request.contextPath}/FindSongBySongNameServlet",
											{
												"word": $("#word").val()
											},
											function(data){
												$("#list").empty();
												for (var i = 0 ;i < data.length; i++) {
													if ( i > 7) {
														break;
													}
													$("#list").append("<a href='${pageContext.request.contextPath }/AddSongServlet?songid="+data[i].songid+"' ><div style='cursor:pointer' onmouseover='over(this)' onmouseout='out(this)' onclick='go(this)'>"+data[i].name+"</div></a>");
												}
												$("#list").css("display", "block");
											},
											"json"
										);
										/* $.get(
												"${pageContext.request.contextPath}/FindSongBySongArtistNameServlet",
												{
													"word": $("#word").val()
												},
												function(data){
													$("#list").empty();
													for (var i = 0 ;i < data.length; i++) {
														if ( i > 7) {
															break;
														}
														$("#list").append("<a href='${pageContext.request.contextPath }/AddSongServlet?songid="+data[i].songid+"' ><div style='cursor:pointer' onmouseover='over(this)' onmouseout='out(this)' onclick='go(this)'>"+data[i].name+"</div></a>");
													}
													$("#list").css("display", "block");
												},
												"json"
											);*/
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