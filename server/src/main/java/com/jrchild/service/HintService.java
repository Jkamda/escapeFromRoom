package com.jrchild.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrchild.domain.Hint;
import com.jrchild.persistence.HintRepository;

@Service
public class HintService {
	
	@Autowired
	HintRepository hintRepository;
	
	public List<Hint> getHintListService() {
		List<Hint> list = new ArrayList<>();
		Iterable<Hint> hints = hintRepository.findAll();
		hints.forEach(list::add);
		return list;
	}
	
	// je.kim
	public boolean registerHintService(Hint hint) {
		hintRepository.save(hint);
		return true;
	}
}
