package com.jrchild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	@GetMapping("/userIntro")
	public String sample(Model model) {
				
		model.addAttribute("number", 2);
					
		return "userIntro";

	}
	
}
