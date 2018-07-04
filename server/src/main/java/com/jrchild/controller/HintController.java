package com.jrchild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HintController {

	@GetMapping("/userIntro")
	public void sample(Model model) {
		int number = 5;
		model.addAttribute("number", number);
	}
}
