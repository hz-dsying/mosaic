package com.dsy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {
	@RequestMapping(path= {"/", "/index", "/index.jsp"})
	public String showIndex() {
		return "index";
	}
	/*@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}*/
	
}
