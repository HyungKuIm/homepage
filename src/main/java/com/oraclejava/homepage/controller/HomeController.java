package com.oraclejava.homepage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	String home() {
		return "home";
	}
	
	@RequestMapping("/intro")
	String intro() {
		return "intro";
	}
	
	@RequestMapping("/gissing")
	String gissing() {
		return "gissing";
	}
	
	@RequestMapping("/japanese")
	String japanese() {
		return "japanese";
	}

	@RequestMapping("/sora")
	String sora() {
		return "forward:/static/index.html";
	}
}
