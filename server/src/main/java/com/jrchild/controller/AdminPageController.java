package com.jrchild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminPageController {
	
	@GetMapping(value="/admin")
	public String adminIndex(Model model) {
		return "admin/index";
	}
}
