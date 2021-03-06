package com.dsy.main.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsy.main.pojo.Comment;
import com.dsy.main.pojo.Song;
import com.dsy.main.pojo.SongLikesKey;
import com.dsy.main.pojo.User;
import com.dsy.main.service.CommentService;
import com.dsy.main.service.SongAlbumService;
import com.dsy.main.service.SongLikesService;
import com.dsy.main.service.SongService;
import com.dsy.main.service.UserCommentLikesService;
import com.dsy.main.util.PageBean;
import com.google.gson.Gson;

import sun.misc.BASE64Encoder;

@Controller
public class SongController {
	@Autowired
	private SongService songService;
	@Autowired
	private UserCommentLikesService userCommentLikesService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private SongLikesService songLikesService;
	@Autowired
	private SongAlbumService songAlbumService;
	
	/**
	 * 歌曲下载
	 * @param request
	 * @param response
	 * @param filename
	 * @throws IOException
	 */
	@RequestMapping("/download")
	public void downloadSong(HttpServletRequest request, HttpServletResponse response, Integer songid) throws IOException {
		//真实文件名 filename
		Song song = songService.selectBySongid(songid);
        String filename = song.getSongname();
        System.out.println("filename:"+filename);
        //下载文件名
        String name = null;//

        String agent = request.getHeader("user-agent");

        //解决乱码
        if (agent.contains("MSIE") || agent.contains("TRIDENT") || agent.contains("EDGE")) {
            // IE浏览器
            name = URLEncoder.encode(filename, "utf-8");
            name = filename.replace("+", "%20");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            name = "=?utf-8?B?"
                    + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            name = URLEncoder.encode(filename, "utf-8");
        }
        //设置响应头，告诉浏览器，这是附件，是让下载的，名字一定要是下载文件名
        response.setHeader("Content-Disposition","attachment;filename="+name);

        //获得环境
        ServletContext context = request.getServletContext();
        //通过环境，输入应用相对路径，获得真实路径
//        String realPath = context.getRealPath("songs" + song.getSongurl());
        String realPath = "D:\\java\\eclipse-workspace\\mosaic\\src\\main\\resources\\static\\songs" + song.getSongurl();
        System.out.println("realPath:"+realPath);
        InputStream is = new FileInputStream(realPath);
        ServletOutputStream os = response.getOutputStream();

        byte[] bys = new byte[1024];
        int len = -1;
        while((len = is.read(bys)) != -1){
            os.write(bys, 0, len);
        }

        is.close();
	}
	
	/**
	 * 用户“我喜欢”歌曲列表显示
	 * @param userid
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/listLikeSong")
	public String listLikeSong(Integer userid, HttpServletRequest request, HttpSession session) {
		List<SongLikesKey> list = songLikesService.selectByUser(userid);
		// 获得歌曲ids
		List<Integer> ids = new ArrayList<>();
		for(SongLikesKey s : list) {
			ids.add(s.getSongid());
		}
		// 分页
		String currentPage = request.getParameter("currentPage");
		String pageSize = "18";
		if(currentPage==null) {
        	currentPage="1";
        }
		PageBean<Song> pb = songService.listLikeSongsByPage(currentPage, pageSize, ids);
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("type", "我的收藏");
		session.setAttribute("pageBean", pb);
		return "genres";
	}
	
	/**
	 * 前台歌曲展示
	 * @param word
	 * @param request
	 * @param session
	 * @throws IOException 
	 */
	@RequestMapping("/listSong")
	public String listSong(HttpServletRequest request, HttpSession session) throws IOException {
		String type = request.getParameter("type");
		type = new String(type.getBytes("ISO-8859-1"), "utf-8");
		System.out.println(type);
		// 分页
		String currentPage = request.getParameter("currentPage");
		String pageSize = "18";
		if(currentPage==null) {
        	currentPage="1";
        }
		PageBean<Song> pb;
		if(type.equals("我的收藏")) {
			String userid = request.getParameter("userid");
			List<SongLikesKey> list = songLikesService.selectByUser(Integer.valueOf(userid));
			// 获得歌曲ids
			List<Integer> ids = new ArrayList<>();
			for(SongLikesKey s : list) {
				ids.add(s.getSongid());
			}
			pb = songService.listLikeSongsByPage(currentPage, pageSize, ids);
		} else {
			pb = songService.listSongsByType(currentPage, pageSize, type);
		}
		
		session.setAttribute("currentPage", currentPage);
		session.setAttribute("type", type);
		session.setAttribute("pageBean", pb);
		return "genres";
	}
	
	/**
	 * 上一页
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/listFormerSong")
	public String listFormerSong(HttpServletRequest request, HttpSession session) throws IOException {
		String type = request.getParameter("type");
		type = new String(type.getBytes("ISO-8859-1"), "utf-8");
		String nowcurrentPage = request.getParameter("currentPage");
		int intcurrentPage = Integer.parseInt(nowcurrentPage);
		
		String currentPage = Integer.toString(intcurrentPage-1);
		String pageSize = "18";
		
		PageBean<Song> pb;
		if(type.equals("我的收藏")) {
			String userid = request.getParameter("userid");
			List<SongLikesKey> list = songLikesService.selectByUser(Integer.valueOf(userid));
			// 获得歌曲ids
			List<Integer> ids = new ArrayList<>();
			for(SongLikesKey s : list) {
				ids.add(s.getSongid());
			}
			pb = songService.listLikeSongsByPage(currentPage, pageSize, ids);
		} else {
			pb = songService.listSongsByType(currentPage, pageSize, type);
		}
		
		
		
		if(intcurrentPage==1) {
			return "genres";
        }else{
        	session.setAttribute("currentPage", currentPage);
    		session.setAttribute("type", type);
    		session.setAttribute("pageBean", pb);
    		return "genres";
        }
	}
	
	/**
	 * 下一页
	 * @param request
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/listNextSong")
	public String listNextSong(HttpServletRequest request, HttpSession session) throws IOException {
		String type = request.getParameter("type");
		type = new String(type.getBytes("ISO-8859-1"), "utf-8");
		String nowcurrentPage = request.getParameter("currentPage");
		int intcurrentPage = Integer.parseInt(nowcurrentPage);
		
		String currentPage = Integer.toString(intcurrentPage+1);
		String pageSize = "18";
		
		
		PageBean<Song> pb;
		if(type.equals("我的收藏")) {
			String userid = request.getParameter("userid");
			List<SongLikesKey> list = songLikesService.selectByUser(Integer.valueOf(userid));
			// 获得歌曲ids
			List<Integer> ids = new ArrayList<>();
			for(SongLikesKey s : list) {
				ids.add(s.getSongid());
			}
			pb = songService.listLikeSongsByPage(currentPage, pageSize, ids);
		} else {
			pb = songService.listSongsByType(currentPage, pageSize, type);
		}
		
		if(intcurrentPage==pb.getTotalPage()) {
			return "genres";
        }else{
        	session.setAttribute("currentPage", currentPage);
    		session.setAttribute("type", type);
    		session.setAttribute("pageBean", pb);
    		return "genres";
        }
	}
	
	/**
	 * 歌曲搜索
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping("/searchSong")
	@ResponseBody
	public void searchSong(String word, HttpServletResponse response) throws IOException {
		word = new String(word.getBytes("ISO-8859-1"), "utf-8");
		word = "%" + word + "%";
		System.out.println("111111111" + word);
		List<Song> list = songService.searchSongByWord(word);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("text/plain;charset=utf-8");
		response.getWriter().write(json);
	}
	
	/**
	 * 后台管理歌曲列表
	 * @param songname
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/listSongs")
	public String listSongs(String songname, Integer currentPage, Integer pageSize, HttpSession session) throws IOException {
		if(songname != null) {
			songname = "%" + songname + "%";
		} else {
			songname = "%%";
		}
		if(currentPage==null) {
        	currentPage=1;
        }
		if(pageSize==null) {
			pageSize=15;
        }
		PageBean<Song> pageBean = songService.findPageBean(songname, currentPage, pageSize);
		session.setAttribute("pageBean", pageBean);
		return "song/list";
	}
	
	/**
	 * 后台管理删除歌曲
	 * @param songid
	 * @return
	 */
	@RequestMapping("/deleteSong")
	public String deleteSong(Integer songid) {
		// 删除用户点赞评论表记录 user_comment_likes
			// 1.获得该歌曲的评论
		List<Comment> selectBySong = commentService.selectBySong(songid);
			// 2.获得评论id列表
		List<Integer> ids = new ArrayList<>();
		for(Comment c : selectBySong) {
			ids.add(c.getCommentid());
		}
			// 3.删除记录
		userCommentLikesService.deleteByComment(ids);
		// 删除该歌曲的评论 comment
		commentService.deleteBySong(songid);
		// 删除该用户收藏的歌曲 song_likes
		songLikesService.deleteBySong(songid);
		// 删除歌曲专辑表 song_album
		songAlbumService.deleteBySong(songid);
		// 删除歌曲 song
		songService.deleteById(songid);
		// 页面跳转
		return "redirect:/listSongs";
	}
	
	/**
	 * 对歌曲进行收藏或取消收藏
	 * @param userid
	 * @param songid
	 * @return
	 */
	@RequestMapping("/addOrDeleteLikeSong")
	public String addOrDeleteLikeSong(Integer userid, Integer songid, HttpSession session) {
		// 默认0，表示未收藏
		int isCollect = 0;
		SongLikesKey songLikesKey = new SongLikesKey();
		songLikesKey.setSongid(songid);
		songLikesKey.setUserid(userid);
		songLikesService.selectByUserAndSong(songLikesKey);
		// 查找记录是否存在
		if(songLikesService.selectByUserAndSong(songLikesKey) != null) {
			// 记录存在。原先已收藏，现取消收藏
			songLikesService.deleteBySongLikesKey(songLikesKey);
		} else {
			// 记录不存在。原先未收藏，现收藏
			songLikesService.insert(songLikesKey);
			isCollect = 1;
		}
		// 根据isCollect的值显示收藏图片
		session.setAttribute("isCollect", isCollect);
		return "songDetail";
	}
	
	
	
	
	/**
	 * 歌曲详情
	 */
	@RequestMapping("/songDetail")
	public String songDetail(int songid, HttpSession session) {
		Song song = songService.selectBySongid(songid);
		session.setAttribute("song", song);
		return "songDetail";
	}

}
