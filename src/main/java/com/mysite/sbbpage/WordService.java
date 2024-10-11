package com.mysite.sbbpage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
	@Autowired
	private WordMapper wordMapper;
	
	public Word getWordById(Integer id) {
		return wordMapper.getWordById(id);
	}
	
	public List<Word> getWordList(int page, int size) {
		int offset = (page -1) * size;
		
		return wordMapper.getWordList(offset, size);
	}
}
