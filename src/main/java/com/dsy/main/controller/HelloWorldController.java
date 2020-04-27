package com.dsy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 只返回界⾯面显示⽤用
//@RestController // 返回JSON数据⽤用
public class HelloWorldController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}
	
	@RequestMapping("/hello1")
	public String hello2() {
		return "hello";
	}
}