package com.dsy.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.UserCommentLikesMapper;
import com.dsy.main.pojo.UserCommentLikesExample;
import com.dsy.main.service.UserCommentLikesService;

@Service
public class UserCommentLikesServiceImpl implements UserCommentLikesService {
	@Autowired
	private UserCommentLikesMapper userCommentLikesMapper;

	@Override
	public void deleteByUser(Integer userid) {
		UserCommentLikesExample example = new UserCommentLikesExample();
		example.createCriteria().andUseridEqualTo(userid);
		userCommentLikesMapper.deleteByExample(example );
	}

}
