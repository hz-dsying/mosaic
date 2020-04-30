package com.dsy.main.service;

public interface SongLikesService {

	/**
	 * 根据用户删除记录
	 * @param userid
	 */
	void deleteByUser(Integer userid);

	/**
	 * 根据歌曲删除记录
	 * @param songid
	 */
	void deleteBySong(Integer songid);

}
