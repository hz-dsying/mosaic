package com.dsy.main.controller;

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
import com.dsy.main.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
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
//			return "redirect:/manageIndex";
			return "redirect:/hello1";
		}else {
			// 普通用户和会员跳转首页
			return "genres";
		}
	}
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public String register(User user) {
		// 1.将用户存入数据库
		userService.addUser(user);
		// 2.跳转登录界面
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
	 */
	@RequestMapping("/listUser")
	public String listUser(String username, HttpSession session) {
		List<User> list = new ArrayList<>();
		if(username != null) {
			User user = userService.selectByUsername(username);
			list.add(user);
		} else {
			 list = userService.queryAllUser();
		}
		session.setAttribute("list", list);
		return "list";
	}

}
