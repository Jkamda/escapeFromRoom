package com.jrchild.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
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
	
	@GetMapping("/login")
	public String login(Model model,HttpSession session) {
		if(session.getAttribute("isLogin") != null && (boolean) session.getAttribute("isLogin")) {
			String[] roles = (String[]) session.getAttribute("role");
			if(ArrayUtils.contains(roles,"admin")) {
				return "redirect:admin";
			}
		}
		return "login";
	}
	
	@GetMapping("/office")
	public ModelAndView officePage(ModelAndView mv) {
		
		mv.setViewName("admin/office");
		
		Iterable<Office> list = officeService.getOfficeListService();
		mv.addObject("officeList", list);
		
		return mv;

	}
	
}
