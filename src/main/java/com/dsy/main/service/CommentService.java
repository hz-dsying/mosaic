package com.dsy.main.service;

public interface CommentService {

	/**
	 * 根据用户删除评论
	 * @param userid
	 */
	void deleteByUser(Integer userid);

	/**
	 * 根据歌曲删除评论
	 * @param songid
	 */
	void deleteBySong(Integer songid);

}
