package com.oraclejava.homepage;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	String list(@RequestParam(value="page_num", required = false) Integer pageNum, Model model) {
		
		
		
		String sql = "SELECT COUNT(*) FROM board";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		if (count == 0) {
			model.addAttribute("msg", "no article");
			//return "guestbook/list";
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

	@RequestMapping(value="/update", method=RequestMethod.GET)
	String update(@RequestParam Integer no, Model model) {
		String query = "SELECT * FROM board WHERE no = ?";
		Board board = jdbcTemplate.queryForObject(query, 
				(rs, rowNum) 
					-> new Board(rs.getInt("no"), rs.getString("name"), rs.getString("email"), rs.getString("content"), rs.getDate("date"), rs.getString("pass"))
				, no);
		
		model.addAttribute("board", board);
		
		return "guestbook/update";
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	String update_ok(@ModelAttribute Board board, Model model, RedirectAttributes rttr) {
		String query = "SELECT no FROM board WHERE no = ? AND pass = ?";
		Integer result = -1; 
		try {
			result = jdbcTemplate.queryForObject(query, Integer.class, board.getNo(), board.getPass());
		} catch (EmptyResultDataAccessException e) {
			result = 0;
		}
		if (result != 0) {  // 비밀번호가 맞을 때 UPDATE 실행
			query = "UPDATE board SET content = ? WHERE no = ?";
			int resultCnt = jdbcTemplate.update(query, board.getContent(), board.getNo());
			
			if (resultCnt > 0) {
				rttr.addFlashAttribute("msg", "글이 수정되었습니다.");
				return "redirect:/guestbook/list";
			} else {
				rttr.addFlashAttribute("msg", "오류가 발생했습니다.");
				return "redirect:/guestbook/list";
			}
		}
		else {
			rttr.addFlashAttribute("msg", "비밀번호 입력이 안되었거나 잘못된 비밀번호 입니다.");
			return "redirect:/guestbook/list";
		}
			
		
		
	}

	@RequestMapping("/write")
	String write() {
		return "guestbook/write";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	String add(@ModelAttribute Board board, RedirectAttributes rttr) {
		String sql = "INSERT INTO board(name, email, pass, content, date) VALUES (?,?,?,?, now())";
		
		int result = jdbcTemplate.update(sql,  board.getName(), board.getEmail(), board.getPass(), board.getContent());
		
		if (result == 1) {
			rttr.addAttribute("msg", "글이 등록되었습니다.");
		} else {
			rttr.addAttribute("msg", "글 등록시 문제가 발생했습니다.");
		}
		
		return "redirect:/guestbook/list";
	}

}
