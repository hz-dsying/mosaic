package com.dsy.main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsy.main.pojo.Comment;
import com.dsy.main.pojo.CommentVo;
import com.dsy.main.pojo.Song;
import com.dsy.main.pojo.UserCommentLikesKey;
import com.dsy.main.service.CommentService;
import com.dsy.main.service.SongService;
import com.dsy.main.service.UserCommentLikesService;
import com.dsy.main.util.PageBean;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@Autowired
	private SongService songService;
	@Autowired
	private UserCommentLikesService userCommentLikesService;
	
	/**
	 * 后台管理评论列表
	 * @param songname
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/listComment")
	public String listComment(String songname, Integer currentPage, Integer pageSize, HttpSession session) throws IOException {
		if(currentPage==null) {
        	currentPage=1;
        }
		if(pageSize==null) {
			pageSize=15;
        }
		// 获得歌曲名
		if(songname != null) {
			songname = "%" + songname + "%";
		} else {
			songname = "%%";
		}
		// 根据歌名模糊搜索歌曲
		List<Song> songs = songService.searchSongBySongname(songname);
		// 获得歌曲id列表
		List<Integer> ids = new ArrayList<>();
		for(Song song : songs) {
			if(!ids.contains(song.getSongid())) {
				ids.add(song.getSongid());
			}
		}
		// 根据歌曲id搜索评论
		PageBean<CommentVo> pageBean = commentService.findPageBean(ids, currentPage, pageSize);
		session.setAttribute("pageBean", pageBean);
		return "comment/list";
	}
	
	/**
	 * 后台管理删除评论
	 * @param commentid
	 * @return
	 */
	@RequestMapping("/deleteComment")
	public String deleteComment(Integer commentid) {
		// 删除用户点赞评论表记录 user_comment_likes
		userCommentLikesService.deleteByComment(commentid);
		// 删除评论 comment
		commentService.deleteById(commentid);
		// 页面跳转
		return "redirect:/listComment";
	}
	
	/**
	 * 对评论进行点赞或取消点赞
	 * @param userid
	 * @param commentid
	 * @param session
	 * @return
	 */
	@RequestMapping("/addOrDeleteUserCommentLike")
	public String addOrDeleteUserCommentLike(Integer userid, Integer commentid, HttpSession session) {
		// 查询评论
		Comment comment = commentService.selectByid(commentid);
		// 查询用户是否点赞评论
		UserCommentLikesKey userCommentLikesKey = new UserCommentLikesKey();
		userCommentLikesKey.setCommentid(commentid);
		userCommentLikesKey.setUserid(userid);
		
		if(userCommentLikesService.selectByKey(userCommentLikesKey) != null) {
			// 已点赞，现取消
			comment.setLikescount(comment.getLikescount() - 1);
			userCommentLikesService.deleteByKey(userCommentLikesKey);
		} else {
			// 未点赞，现点赞
			comment.setLikescount(comment.getLikescount() + 1);
			userCommentLikesService.insert(userCommentLikesKey);
		}
		commentService.update(comment);
		
		
		return "redirect:/songDetail?userid=" + userid + "&songid=" + comment.getSongid();
	}
	
	@RequestMapping("/addComment")
	public String addComment(Integer userid, Integer songid, String commentcontent ) {
		Comment comment = new Comment();
		comment.setUserid(userid);
		comment.setSongid(songid);
		Date date = new Date();
		comment.setCommenttime(date);
		comment.setCommentcontent(commentcontent);
		comment.setLikescount(0);
		commentService.insert(comment);
		return "redirect:/songDetail?userid=" + userid + "&songid=" + songid;
	}

}
