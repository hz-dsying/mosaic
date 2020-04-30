package com.dsy.main.service;

import java.util.List;

import com.dsy.main.pojo.Album;

public interface AlbumService {

	/**
	 * 获得所有专辑
	 * @return
	 */
	List<Album> queryAllAlbum();

}
