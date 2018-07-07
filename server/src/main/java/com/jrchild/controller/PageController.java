package com.jrchild.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jrchild.domain.Office;
import com.jrchild.service.OfficeService;

@Controller
public class PageController {
	
	
	@Autowired
	OfficeService officeService;
	
	@GetMapping("/userIntro")
	public String sample(Model model) {
				
		model.addAttribute("number", 2);
					
		return "userIntro";

	}
	
	@GetMapping("/office")
	public ModelAndView officePage(ModelAndView mv) {
		
		mv.setViewName("office");
		
		Iterable<Office> list = officeService.getOfficeListService();
		mv.addObject("officeList", list);
		
		return mv;

	}
	
}
