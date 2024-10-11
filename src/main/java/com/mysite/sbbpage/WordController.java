package com.mysite.sbbpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/words")
public class WordController {
	@Autowired
	private WordService wordService;
	
	@GetMapping
	@ResponseBody
	public List<Word> getWordList(@RequestParam(name = "page", defaultValue = "1") int page,
								  @RequestParam(name = "size", defaultValue = "3") int size) {
		return wordService.getWordList(page, size);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Word getWord(@PathVariable("id") Integer id) {
		return wordService.getWordById(id);
	}
	
}
