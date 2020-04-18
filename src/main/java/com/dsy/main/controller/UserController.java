package com.dsy.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
			return "redirect:/manageIndex";
		}else {
			// 普通用户和会员跳转首页
			return "redirect:/index";
		}
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		// 1.判断是否有相同用户名的用户
		
		return null;
	}

}
