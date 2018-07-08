package com.jrchild.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrchild.domain.Hint;
import com.jrchild.service.HintService;

@RestController
public class HintController {

	
	@Autowired
	private HintService hintService;
	
	
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
	
	@GetMapping(value="/api/v1/hints")
	public List<Hint> hintList(){
		return hintService.getHintListService();
	}
	
	@GetMapping(value="/api/v1/hints/{hintCode}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Hint> getHintResult(@PathVariable String hintCode){
		
		return hintService.getHintResult(hintCode);
	}
	
}
