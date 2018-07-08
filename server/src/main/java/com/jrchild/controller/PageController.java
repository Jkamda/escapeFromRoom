package com.jrchild.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jrchild.domain.Hint;
import com.jrchild.domain.Office;
import com.jrchild.domain.Room;
import com.jrchild.service.OfficeService;
import com.jrchild.service.RoomService;

@Controller
public class PageController {
	
	
	@Autowired
	OfficeService officeService;
	
	@Autowired
	RoomService roomService;
	
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
	
	@GetMapping("/room")
	public ModelAndView roomPage(ModelAndView mv) {
		
		mv.setViewName("admin/room");
		
		Iterable<Office> list2 = officeService.getOfficeListService();
		mv.addObject("officeList", list2);
		Iterable<Room> list = roomService.getRoomListService();
		mv.addObject("roomList", list);
		
		return mv;

	}
	
	@GetMapping("/hint")
	public ModelAndView hintPage(ModelAndView mv) {
		mv.setViewName("admin/hint");
		return mv;
	}
	
	
}
