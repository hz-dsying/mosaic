package com.dsy.main.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dsy.main.pojo.Album;
import com.dsy.main.service.AlbumService;
import com.dsy.main.service.SongService;
import com.dsy.main.util.PageBean;

@WebFilter("/genres.jsp")
public class GenresFilter implements Filter {
	@Autowired
	private SongService songService;
	@Autowired
	private AlbumService albumService;
	
    public GenresFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		List<Album> list = albumService.queryAllAlbum();
		request.getSession().setAttribute("albumList", list);
		
		Object pageBean = request.getAttribute("pageBean");
		if(pageBean==null) {
			String currentPage = request.getParameter("currentPage");
			String type = "所有歌曲";
			String pageSize = "18";
			PageBean pb = songService.listSongsByType(currentPage, pageSize, type);
			request.getSession().setAttribute("type", type);
			request.getSession().setAttribute("pageBean", pb);
			request.getRequestDispatcher("/genres.jsp").forward(request, response);
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
