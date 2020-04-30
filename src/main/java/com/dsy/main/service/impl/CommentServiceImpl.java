package com.dsy.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.CommentMapper;
import com.dsy.main.pojo.CommentExample;
import com.dsy.main.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;

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

}
