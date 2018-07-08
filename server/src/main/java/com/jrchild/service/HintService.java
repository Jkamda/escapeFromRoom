package com.jrchild.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrchild.domain.HintCode;
import com.jrchild.persistence.HintCodeRepository;

@Service
public class HintService {
	@Autowired
	private HintCodeRepository HintCodeRepository;

	public List<HintCode> getHintListService() {
		List<HintCode> list = new ArrayList<>();
		Iterable<HintCode> hints = HintCodeRepository.findAll();
		hints.forEach(list :: add);
		return list;
	}
	
	
}
