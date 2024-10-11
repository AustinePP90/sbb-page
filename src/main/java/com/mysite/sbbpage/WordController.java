package com.mysite.sbbpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class WordController {
	@Autowired
	private WordService wordService;
	
	@GetMapping
	public String home() {
		return "index";
	}
	
	@GetMapping("/detail")
	public String list() {
		return "detail";
	}
	
	@GetMapping("/words")
//	@ResponseBody
	public String getWordList(@RequestParam(name = "page", defaultValue = "1") int page,
						      @RequestParam(name = "size", defaultValue = "3") int size,
						      Model model) {
		PageDTO pageDTO = wordService.getWordList(page, size);
		model.addAttribute("pageDTO", pageDTO);
		return "list";
	}
	
	@GetMapping("/words/{id}")
	@ResponseBody
	public Word getWord(@PathVariable("id") Integer id) {
		return wordService.getWordById(id);
	}
	
}
