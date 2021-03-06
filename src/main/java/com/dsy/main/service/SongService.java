package com.dsy.main.service;

import java.util.List;

import com.dsy.main.pojo.Song;
import com.dsy.main.util.PageBean;

public interface SongService {

	Song selectBySongid(Integer songid);

	/**
	 * 根据歌名/歌手查找歌曲
	 * @param word
	 * @return
	 */
	List<Song> searchSongByWord(String word);

	/**
	 * 歌曲分页查询
	 * @param currentPage
	 * @param pageSize
	 * @param type
	 * @return
	 */
	PageBean<Song> listSongsByType(String currentPage, String pageSize, String type);

	/**
	 * 根据歌名模糊查询
	 * @param songname
	 * @return
	 */
	List<Song> searchSongBySongname(String songname);

	/**
	 * 查询所有歌曲
	 * @return
	 */
	List<Song> queryAllSong();

	/**
	 * 删除歌曲
	 * @param songid
	 */
	void deleteById(Integer songid);

	/**
	 * 后台管理分页查询歌曲
	 * @param songname
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean<Song> findPageBean(String songname, Integer currentPage, Integer pageSize);

	/**
	 * 收藏歌曲分页查询
	 * @param currentPage
	 * @param pageSize
	 * @param ids
	 * @return
	 */
	PageBean<Song> listLikeSongsByPage(String currentPage, String pageSize, List<Integer> ids);
	
}
