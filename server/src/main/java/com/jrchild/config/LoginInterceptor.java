package com.jrchild.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response,
							 Object handler) {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("isLogin") != null && (boolean) session.getAttribute("isLogin") == true) {
			return true;
		}else {
			try {
				response.sendRedirect(request.getContextPath() + "/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		
	}
}
