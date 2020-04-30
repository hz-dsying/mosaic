package com.dsy.main.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsy.main.pojo.User;
import com.dsy.main.pojo.UserRoleKey;
import com.dsy.main.service.CommentService;
import com.dsy.main.service.SongLikesService;
import com.dsy.main.service.UserCommentLikesService;
import com.dsy.main.service.UserRoleService;
import com.dsy.main.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserCommentLikesService userCommentLikesService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private SongLikesService songLikesService;
	@Autowired
	private UserRoleService userRoleService;
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		// 1.通过用户名和密码查找用户
		User user = userService.findByUsernameAndPwd(username, password);
		// 2.将用户存入域中
		session.setAttribute("user", user);
		// 3.根据用户权限跳转页面
		if(user.getRole().equals(3)) {
			// 管理员跳转后台管理页面
			return "redirect:/manageIndex";
//			return "redirect:/hello1";
		}else {
			// 普通用户和会员跳转首页
//			return "genres";
			return "redirect:/listAlbum";
		}
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public String register(User user) {
		// 将用户存入 User
		userService.addUser(user);
		// 将记录存入用户权限表中 user_role
		User u = userService.selectByUsername(user.getUsername());
		UserRoleKey userRole = new UserRoleKey();
		userRole.setUserid(u.getUserid());
		userRole.setRoleid(u.getRole());
		userRoleService.insert(userRole);
		// 跳转登录界面
		return "redirect:/toLogin";
	}
	
	/**
	 * 用户注册时校验用户名是否已存在
	 * @param user
	 * @return
	 */
	@RequestMapping("/checkUsername")
	@ResponseBody
	public Map checkUsername(String username) {
		Map map = new HashMap<>();
		if(userService.selectByUsername(username) != null) {
			map.put("msg", "该用户名已存在");
		}
		return map;
	}
	
	/**
	 * 用户重置密码时判断 用户名/密码 是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/checkUser")
	@ResponseBody
	public Map checkUser(String username, String password) {
		Map map = new HashMap<>();
		if(userService.selectByUsernameAndPwd(username, password) == null) {
			map.put("msg", "用户名/密码错误");
		}
		return map;
	}
	
	/**
	 * 修改用户密码
	 * @param username
	 * @param rePassword
	 * @return
	 */
	@RequestMapping("/changePwd")
	public String changePwd(String username, String rePassword) {
		User user = userService.selectByUsername(username);
		user.setPassword(rePassword);
		userService.updateUser(user);
		return "redirect:/toLogin";
	}
	
	/**
	 * 后台管理用户列表
	 * @param username
	 * @param session
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/listUser")
	public String listUser(String username, HttpSession session) throws IOException {
		List<User> list = new ArrayList<>();
		if(username != null) {
			username = new String(username.getBytes("ISO-8859-1"), "utf-8");
			list = userService.selectByName(username);
		} else {
			list = userService.queryAllUser();
		}
		session.setAttribute("list", list);
		return "user/list";
	}
	
	/**
	 * 后台管理删除用户
	 * @param userid
	 * @return
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer userid) {
		// 删除用户点赞评论表记录 user_comment_likes
		userCommentLikesService.deleteByUser(userid);
		// 删除该用户的评论 comment
		commentService.deleteByUser(userid);
		// 删除该用户收藏的歌曲 song_likes
		songLikesService.deleteByUser(userid);
		// 删除用户权限表中记录 user_role
		userRoleService.deleteByUser(userid);
		// 删除用户 user
		userService.deleteById(userid);
		// 页面跳转
		return "redirect:/listUser";
	}

}
