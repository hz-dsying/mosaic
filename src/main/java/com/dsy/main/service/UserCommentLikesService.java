package com.dsy.main.service;

import java.util.List;

import com.dsy.main.pojo.UserCommentLikesKey;

public interface UserCommentLikesService {

	/**
	 * 根据用户删除记录
	 * @param userid
	 */
	void deleteByUser(Integer userid);

	/**
	 * 根据评论删除记录
	 * @param ids
	 */
	void deleteByComment(List<Integer> ids);

	/**
	 * 根据评论删除记录
	 * @param commentid
	 */
	void deleteByComment(Integer commentid);

	/**
	 * 根据用户/评论查找记录
	 * @param userCommentLikesKey
	 */
	UserCommentLikesKey selectByKey(UserCommentLikesKey userCommentLikesKey);

	/**
	 * 根据用户/评论删除记录
	 * @param userCommentLikesKey
	 */
	void deleteByKey(UserCommentLikesKey userCommentLikesKey);

	/**
	 * 插入记录
	 * @param userCommentLikesKey
	 */
	void insert(UserCommentLikesKey userCommentLikesKey);

}
