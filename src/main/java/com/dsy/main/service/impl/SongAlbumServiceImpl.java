package com.dsy.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.SongAlbumMapper;
import com.dsy.main.pojo.SongAlbumExample;
import com.dsy.main.service.SongAlbumService;

@Service
public class SongAlbumServiceImpl implements SongAlbumService {
	@Autowired
	private SongAlbumMapper songAlbumMapper;

	@Override
	public void deleteBySong(Integer songid) {
		SongAlbumExample example = new SongAlbumExample();
		example.createCriteria().andSongidEqualTo(songid);
		songAlbumMapper.deleteByExample(example );
	}

}
