package com.jrchild.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Value("${adminUserId}")
	private String adminUserId;
	@Value("${adminPassword}")
	private String adminPassword;
	
	//로그인
	@RequestMapping(value="/login",produces = {"application/json;charset=UTF-8"},method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> login(
			@RequestBody Map<String, String> param,
			HttpSession session
			){
		
		String user_id = param.get("user_id");
		String user_password = param.get("user_password");
		
		if(adminUserId.equals(user_id) && adminPassword.equals(user_password)) {
			session.setAttribute("isLogin", true);
			session.setAttribute("mId", "admin");
			session.setAttribute("role", new String[] {"admin"});
		}else {
			throw new SecurityException("로그인 실패");
		}
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("status", true);
		return result;
	}
		
	//로그아웃
	@RequestMapping(value="/logout",method={RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> logout(HttpSession session){
		Map<String, Object> result = new HashMap<String, Object>();
		session.invalidate();
		result.put("status", true);
		return result;
	}
}
