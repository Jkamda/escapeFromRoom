package com.jrchild.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrchild.domain.Office;
import com.jrchild.service.OfficeService;

@RestController
public class OfficeController {
	
	@Autowired
	OfficeService officeService;
	
	@PostMapping(value="/api/v1/office/register")
	public void registerOffice(@RequestBody Office office) {
		
	
		System.out.println(office);
		officeService.registerOfficeService(office);
	}
	
	@GetMapping(value="/api/v1/office")
	public List<Office> getOfficeList() {
		return  officeService.getOfficeListService();
	}
}
