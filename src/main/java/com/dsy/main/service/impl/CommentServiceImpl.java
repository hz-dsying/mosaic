package com.dsy.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.CommentMapper;
import com.dsy.main.pojo.Comment;
import com.dsy.main.pojo.CommentExample;
import com.dsy.main.pojo.CommentVo;
import com.dsy.main.pojo.Song;
import com.dsy.main.pojo.User;
import com.dsy.main.service.CommentService;
import com.dsy.main.service.SongService;
import com.dsy.main.service.UserService;
import com.dsy.main.util.PageBean;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private SongService songService;

	@Override
	public void deleteByUser(Integer userid) {
		CommentExample example = new CommentExample();
		example.createCriteria().andUseridEqualTo(userid);
		commentMapper.deleteByExample(example );
	}

	@Override
	public void deleteBySong(Integer songid) {
		CommentExample example = new CommentExample();
		example.createCriteria().andSongidEqualTo(songid);
		commentMapper.deleteByExample(example );
	}

	@Override
	public List<Comment> selectBySong(Integer songid) {
		CommentExample example = new CommentExample();
		example.createCriteria().andSongidEqualTo(songid);
		List<Comment> list = commentMapper.selectByExample(example );
		return list;
	}

	@Override
	public List<Comment> selectBySongids(List<Integer> ids) {
		CommentExample example = new CommentExample();
		example.createCriteria().andSongidIn(ids);
		List<Comment> list = commentMapper.selectByExample(example );
		return list;
	}

	@Override
	public List<Comment> queryAllComment() {
		CommentExample example = new CommentExample();
		List<Comment> list = commentMapper.selectByExample(example );
		return list;
	}

	@Override
	public void deleteById(Integer commentid) {
		commentMapper.deleteByPrimaryKey(commentid);
	}

	@Override
	public PageBean<CommentVo> findPageBean(List<Integer> ids, Integer currentPage, Integer pageSize) {
		CommentExample example = new CommentExample();
		// 1.通过数据库查询totalCount，所有的记录条数
		example.createCriteria().andSongidIn(ids);
		int totalCount = (int) commentMapper.countByExample(example);
		// 2.创建PageBean对象
		PageBean<CommentVo> pb = new PageBean<CommentVo>(totalCount, currentPage, pageSize);
		// 3.查询用户列表
		List<Comment> list = commentMapper.selectByExample(example);
		int m = currentPage * pageSize;
		if(m > list.size()) {
			m = list.size();
		}		
		List<Comment> comments = list.subList((currentPage-1) * pageSize, m);
		// 4.将list拼接到pageBean中
		// Comment返回类型转换为CommentVo
		List<CommentVo> list2 = new ArrayList<>();
		for(Comment comment : comments) {
			CommentVo commentVo = new CommentVo();
			commentVo.setCommentid(comment.getCommentid());
			User user = userService.selectByUserid(comment.getUserid());
			commentVo.setUser(user);
			Song song = songService.selectBySongid(comment.getSongid());
			commentVo.setSong(song);
			commentVo.setCommentcontent(comment.getCommentcontent());
			commentVo.setLikescount(comment.getLikescount());
			list2.add(commentVo);
		}
		pb.setList(list2);
		// 5.返回完整的pageBean对象
		return pb;
	}

	@Override
	public Comment selectByid(Integer commentid) {
		Comment comment = commentMapper.selectByPrimaryKey(commentid);
		return comment;
	}

	@Override
	public void update(Comment comment) {
		commentMapper.updateByPrimaryKey(comment);
	}

	@Override
	public void insert(Comment comment) {
		commentMapper.insert(comment);
	}

}
