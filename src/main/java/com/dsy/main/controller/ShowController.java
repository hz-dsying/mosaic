package com.dsy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {
	@RequestMapping(path= {"/", "/index", "/index.jsp", "/toLogin"})
	public String showIndex() {
		return "register";
	}
	
	@RequestMapping("/toGenres")
	public String toGenres() {
		return "genres";
	}
	
	@RequestMapping("/toChangePwd")
	public String toChangePwd() {
		return "changePwd";
	}
	
	@RequestMapping("/manageIndex")
	public String manageIndex() {
		return "manageIndex";
	}
	
	@RequestMapping("/top")
	public String totop() {
		return "top";
	}
	
	@RequestMapping("/menu")
	public String tomenu() {
		return "menu";
	}
	
	@RequestMapping("/welcome")
	public String towelcome() {
		return "welcome";
	}
	

	
	
}
