package com.jrchild.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HintController {

	
	@GetMapping(value="/hintCount")
	public Object hintCount(@CookieValue(value = "hintCount", defaultValue = "5") Long hintCount, HttpServletResponse response) {
		
		hintCount--;
		System.out.println(hintCount);
		if(hintCount==0) {
			Cookie cookie = new Cookie("hintCount", "6");
			cookie.setMaxAge(60*60); // 60분
			response.addCookie(cookie);	
		}else {
			
			Cookie cookie = new Cookie("hintCount", hintCount.toString());
			cookie.setMaxAge(60*60); // 60분
			response.addCookie(cookie);	
			
		}
		
		return hintCount;
	}

}
