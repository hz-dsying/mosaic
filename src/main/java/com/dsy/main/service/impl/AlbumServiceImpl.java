package com.dsy.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.AlbumMapper;
import com.dsy.main.pojo.Album;
import com.dsy.main.pojo.AlbumExample;
import com.dsy.main.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private AlbumMapper albumMapper;

	@Override
	public List<Album> queryAllAlbum() {
		AlbumExample example = new AlbumExample();
		List<Album> list = albumMapper.selectByExample(example);
		return list;
	}

}
