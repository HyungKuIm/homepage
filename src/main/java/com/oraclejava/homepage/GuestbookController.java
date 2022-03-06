package com.oraclejava.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@RequestMapping
	String index() {
		return "guestbook/index";
	}
}
