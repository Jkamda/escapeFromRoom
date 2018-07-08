package com.jrchild.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrchild.domain.Office;
import com.jrchild.persistence.OfficeRepository;

@Service
public class OfficeService {

	@Autowired
	OfficeRepository officeRepository;
	
	
	public void registerOfficeService(Office office) {
		
		officeRepository.save(office);
	}
	
	public List<Office> getOfficeListService() {
		List<Office> list = new ArrayList<>();
		Iterable<Office> offices = officeRepository.findAll();
		offices.forEach(list::add);
		return list;
	}
	
	public List<Object[]> getSelectOfficeCode(){
		return officeRepository.getSelectOfficeCode();
	}
}
