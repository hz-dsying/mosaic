package com.dsy.main.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dsy.main.pojo.Comment;
import com.dsy.main.pojo.CommentPo;
import com.dsy.main.pojo.Song;
import com.dsy.main.pojo.SongLikesKey;
import com.dsy.main.pojo.User;
import com.dsy.main.pojo.UserCommentLikesKey;
import com.dsy.main.service.CommentService;
import com.dsy.main.service.SongLikesService;
import com.dsy.main.service.SongService;
import com.dsy.main.service.UserCommentLikesService;
import com.dsy.main.service.UserService;

@WebFilter("/songDetail.jsp")
public class SongDetailFilter implements Filter {
	@Autowired
	private SongLikesService songLikesService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	@Autowired
	private SongService songService;
	@Autowired
	private UserCommentLikesService userCommentLikesService;
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		// 判断歌曲是否收藏
		int userid = Integer.valueOf(request.getParameter("userid"));
		int songid = Integer.valueOf(request.getParameter("songid"));
		SongLikesKey songLikesKey = new SongLikesKey();
		songLikesKey.setSongid(songid);
		songLikesKey.setUserid(userid);
		// 默认0，表示未收藏
		int isCollect = 0;
		if(songLikesService.selectByUserAndSong(songLikesKey) != null) {
			// 已收藏
			isCollect = 1;
		}
		request.getSession().setAttribute("isCollect", isCollect);
		
		// 显示歌曲评论
		List<Comment> comments = commentService.selectBySong(songid);
		// Comment返回类型转换为CommentPo
		List<CommentPo> list = new ArrayList<>();
		for(Comment comment : comments) {
			CommentPo commentPo = new CommentPo();
			commentPo.setCommentid(comment.getCommentid());
			User user = userService.selectByUserid(comment.getUserid());
			commentPo.setUser(user);
			Song song = songService.selectBySongid(comment.getSongid());
			commentPo.setSong(song);
			commentPo.setCommentcontent(comment.getCommentcontent());
			commentPo.setLikescount(comment.getLikescount());
			// 用户是否点赞，0未点赞，1点赞
			UserCommentLikesKey userCommentLikesKey = new UserCommentLikesKey();
			userCommentLikesKey.setCommentid(comment.getCommentid());
			userCommentLikesKey.setUserid(userid);
			if(userCommentLikesService.selectByKey(userCommentLikesKey) != null) {
				// 用户已点赞
				commentPo.setIsCheck(1);
			} else {
				// 用户未点赞
				commentPo.setIsCheck(0);
			}
			list.add(commentPo);
		}
		request.getSession().setAttribute("list", list);
		
		
		chain.doFilter(request, response);
	}

	

}
