package com.dsy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {
	@RequestMapping(path= {"/", "/index", "/index.jsp", "/toLogin"})
	public String showIndex() {
		return "register";
	}
	
	@RequestMapping("/toChangePwd")
	public String toChangePwd() {
		return "changePwd";
	}
	
	
}
