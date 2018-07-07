package com.jrchild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jrchild.annotation.SigninRequired;

@Controller
public class AdminPageController {
	
	@GetMapping(value="/admin")
	@SigninRequired(value= {"admin"})
	public String adminIndex(Model model) {
		return "admin/index";
	}
}
