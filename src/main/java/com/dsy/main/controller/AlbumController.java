package com.dsy.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsy.main.pojo.Album;
import com.dsy.main.service.AlbumService;

@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	
	/**
	 * 获得所有专辑
	 * @param session
	 * @return
	 */
	@RequestMapping("/listAlbum")
	public String listAlbum(HttpSession session) {
		List<Album> list = albumService.queryAllAlbum();
		session.setAttribute("albumList", list);
		return "genres";
	}

}
