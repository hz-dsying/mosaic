package com.dsy.main.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsy.main.dao.AlbumMapper;
import com.dsy.main.dao.SongAlbumMapper;
import com.dsy.main.dao.SongMapper;
import com.dsy.main.pojo.Album;
import com.dsy.main.pojo.AlbumExample;
import com.dsy.main.pojo.Song;
import com.dsy.main.pojo.SongAlbumExample;
import com.dsy.main.pojo.SongAlbumKey;
import com.dsy.main.pojo.SongExample;
import com.dsy.main.service.SongService;
import com.dsy.main.util.PageBean;

@Service
public class SongServiceImpl implements SongService {
	@Autowired
	private SongMapper songMapper;
	@Autowired
	private SongAlbumMapper songAlbumMapper;
	@Autowired
	private AlbumMapper albumMapper;

	@Override
	public Song selectBySongid(Integer songid) {
		Song song = songMapper.selectByPrimaryKey(songid);
		return song;
	}

	@Override
	public List<Song> searchSongByWord(String word) {
		SongExample example = new SongExample();
		example.createCriteria().andSongnameLike(word);
		List<Song> list1 = songMapper.selectByExample(example);
		
		example.clear();
		example.createCriteria().andSingerLike(word);
		List<Song> list2 = songMapper.selectByExample(example);
		
		list1.addAll(list2);
		List<Song> list = new ArrayList<Song>(new TreeSet<Song>(list1)); 
		return list;
	}

	@Override
	public PageBean listSongsByType(String currentPageStr, String pageSizeStr, String type) {
		int currentPage = 0;
		int pageSize = 0;
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.valueOf(currentPageStr);
		}
		
		if (pageSizeStr == null) {
			pageSize = 18;
		} else {
			pageSize = Integer.valueOf(pageSizeStr);
		}
		long l = 0;
		List<Song> sl;
		if("所有歌曲".equals(type)) {
			// 获得总数
			SongExample example = new SongExample();
			l = songMapper.countByExample(example);
			
			// 获得歌曲list
			sl = songMapper.selectByExample(example);
		} else {
			// 获得总数
			AlbumExample example = new AlbumExample();
			example.createCriteria().andAlbumnameEqualTo(type);
			List<Album> list = albumMapper.selectByExample(example);//获得专辑id
			SongAlbumExample example1 = new SongAlbumExample();
			example1.createCriteria().andAlbumidEqualTo(list.get(0).getAlbumid());
			l = songAlbumMapper.countByExample(example1 );
			
			// 获得歌曲list
			List<SongAlbumKey> l1 = songAlbumMapper.selectByExample(example1);
			List<Integer> ids = new ArrayList<Integer>();
			for(SongAlbumKey sa : l1) {
				ids.add(sa.getSongid());
			}
			SongExample example2 = new SongExample();
			example2.createCriteria().andSongidIn(ids);
			sl = songMapper.selectByExample(example2 );
		}
		
		int totalCount = (int) l; // 总数
		if(currentPage < 1) {
			currentPage = 1;
		}
		if((currentPage -1) * pageSize > sl.size()) {
			currentPage = currentPage -1;
		}
		int m = currentPage * pageSize;
		if(m > sl.size()) {
			m = sl.size();
		}
		List<Song> list = sl.subList((currentPage-1) * pageSize, m);
		
		PageBean<Song> pb = new PageBean<Song>(totalCount, currentPage, pageSize);
		pb.setList(list);
		return pb;
	}

	@Override
	public List<Song> searchSongBySongname(String songname) {
		SongExample example = new SongExample();
		example.createCriteria().andSongnameLike(songname);
		List<Song> list = songMapper.selectByExample(example );
		return list;
	}

	@Override
	public List<Song> queryAllSong() {
		SongExample example = new SongExample();
		List<Song> list = songMapper.selectByExample(example );
		return list;
	}

	@Override
	public void deleteById(Integer songid) {
		songMapper.deleteByPrimaryKey(songid);
		
	}

}
