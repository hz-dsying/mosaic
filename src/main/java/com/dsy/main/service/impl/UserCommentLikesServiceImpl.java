package com.dsy.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.UserCommentLikesMapper;
import com.dsy.main.pojo.UserCommentLikesExample;
import com.dsy.main.pojo.UserCommentLikesKey;
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

	@Override
	public void deleteByComment(List<Integer> ids) {
		UserCommentLikesExample example = new UserCommentLikesExample();
		example.createCriteria().andCommentidIn(ids);
		userCommentLikesMapper.deleteByExample(example );
		
	}

	@Override
	public void deleteByComment(Integer commentid) {
		UserCommentLikesExample example = new UserCommentLikesExample();
		example.createCriteria().andCommentidEqualTo(commentid);
		userCommentLikesMapper.deleteByExample(example);
	}

	@Override
	public UserCommentLikesKey selectByKey(UserCommentLikesKey userCommentLikesKey) {
		UserCommentLikesExample example = new UserCommentLikesExample();
		example.createCriteria().andCommentidEqualTo(userCommentLikesKey.getCommentid()).andUseridEqualTo(userCommentLikesKey.getUserid());
		List<UserCommentLikesKey> list = userCommentLikesMapper.selectByExample(example );
		if(list != null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteByKey(UserCommentLikesKey userCommentLikesKey) {
		userCommentLikesMapper.deleteByPrimaryKey(userCommentLikesKey);
	}

	@Override
	public void insert(UserCommentLikesKey userCommentLikesKey) {
		userCommentLikesMapper.insert(userCommentLikesKey);
	}

}
