package com.dsy.main.service;

import java.util.List;

import com.dsy.main.pojo.SongLikesKey;

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

	/**
	 * 根据用户查找记录
	 * @param userid
	 */
	List<SongLikesKey> selectByUser(Integer userid);

	/**
	 * 根据用户歌曲查找记录
	 * @param songLikesKey
	 */
	SongLikesKey selectByUserAndSong(SongLikesKey songLikesKey);

	/**
	 * 根据用户歌曲删除记录
	 * @param songLikesKey
	 */
	void deleteBySongLikesKey(SongLikesKey songLikesKey);

	/**
	 * 插入记录
	 * @param songLikesKey
	 */
	void insert(SongLikesKey songLikesKey);

	

}
