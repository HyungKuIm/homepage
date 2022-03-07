package com.oraclejava.homepage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
//	@Autowired
//    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping
	String index() {
		return "guestbook/index";
	}
	
	@RequestMapping("/list")
	String list(Model model, RedirectAttributes rttr) {
		String sql = "SELECT COUNT(*) FROM board";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if (count == 0) {
			rttr.addAttribute("msg", "no article");
			return "redirect:/";
		}
		
		sql = "SELECT * FROM board ORDER BY no DESC";
		List<Map<String, Object>> boardList = jdbcTemplate.queryForList(sql);
		
		model.addAttribute("boardList", boardList);
		
		return "guestbook/list";
	}
}
