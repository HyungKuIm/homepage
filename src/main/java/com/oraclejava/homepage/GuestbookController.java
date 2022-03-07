package com.oraclejava.homepage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	String list(@RequestParam(value="page_num", required = false) Integer pageNum, Model model, RedirectAttributes rttr) {
		
		
		
		String sql = "SELECT COUNT(*) FROM board";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if (count == 0) {
			rttr.addAttribute("msg", "no article");
			return "redirect:/";
		}
		
		int page_max = 10;
		int total = count;
		double page_check = (double)total / page_max;
		int page_total = total / page_max;
		
		int page_num = (pageNum == null) ? pageNum = 1 : pageNum;
		int pg_cal = ((page_num-1) / page_max) * page_max;
		int pg_start = pg_cal + 1;
		int pg_end = pg_start + page_max;
		int prev = pg_start - page_max;
		
		if (page_total < page_check) {
			page_total += 1;
		}
		
		// db limit 갯수 계산
		int skip_record = 0;
		if (page_num > 1) {
			skip_record = (page_num - 1) * page_max;
		}
		
		sql = "SELECT * FROM board ORDER BY no DESC LIMIT ?,?";
		List<Map<String, Object>> boardList = jdbcTemplate.queryForList(sql, skip_record, page_max);
		
		model.addAttribute("boardList", boardList);
		
		model.addAttribute("prev", prev);
		model.addAttribute("pg_start", pg_start);
		model.addAttribute("page_total", page_total);
		model.addAttribute("page_num", page_num);
		model.addAttribute("pg_end", pg_end);
		
		return "guestbook/list";
	}
}
