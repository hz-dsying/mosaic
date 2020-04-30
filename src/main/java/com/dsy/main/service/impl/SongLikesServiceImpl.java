package com.dsy.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.SongLikesMapper;
import com.dsy.main.pojo.SongLikesExample;
import com.dsy.main.service.SongLikesService;

@Service
public class SongLikesServiceImpl implements SongLikesService {
	@Autowired
	private SongLikesMapper songLikesMapper;

	@Override
	public void deleteByUser(Integer userid) {
		SongLikesExample example = new SongLikesExample();
		example.createCriteria().andUseridEqualTo(userid);
		songLikesMapper.deleteByExample(example );
	}

	@Override
	public void deleteBySong(Integer songid) {
		SongLikesExample example = new SongLikesExample();
		example.createCriteria().andSongidEqualTo(songid);
		songLikesMapper.deleteByExample(example );		
	}

}
