package com.dsy.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.SongLikesMapper;
import com.dsy.main.pojo.SongLikesExample;
import com.dsy.main.pojo.SongLikesKey;
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

	@Override
	public List<SongLikesKey> selectByUser(Integer userid) {
		SongLikesExample example = new SongLikesExample();
		example.createCriteria().andUseridEqualTo(userid);
		List<SongLikesKey> list = songLikesMapper.selectByExample(example);
		return list;
	}

	@Override
	public SongLikesKey selectByUserAndSong(SongLikesKey songLikesKey) {
		SongLikesExample example = new SongLikesExample();
		example.createCriteria().andUseridEqualTo(songLikesKey.getUserid()).andSongidEqualTo(songLikesKey.getSongid());
		List<SongLikesKey> list = songLikesMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteBySongLikesKey(SongLikesKey songLikesKey) {
		songLikesMapper.deleteByPrimaryKey(songLikesKey);
	}

	@Override
	public void insert(SongLikesKey songLikesKey) {
		songLikesMapper.insert(songLikesKey);
	}

	

}
