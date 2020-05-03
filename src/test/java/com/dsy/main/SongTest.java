package com.dsy.main;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dsy.main.pojo.Song;
import com.dsy.main.service.SongService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.yml")
public class SongTest {
	@Autowired
	private SongService songService;
	
	@Test
	public void test01() {
		String word = "丁";
		List<Song> list = songService.searchSongByWord(word);
		System.out.println(list);
	}
	
	@Test
	public void test02() {
		String word = "一";
		List<Song> list = songService.searchSongBySongname(word);
		System.out.println(list);
	}
	
	@Test
	public void test03() {
		List<Song> list = songService.queryAllSong();
		System.out.println(list.size());
	}
	
	@Test
	public void test04() {
		List<Song> list = songService.queryAllSong();
		System.out.println(list.size());
	}
	

}
