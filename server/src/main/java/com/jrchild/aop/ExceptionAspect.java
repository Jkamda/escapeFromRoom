package com.jrchild.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Order(10)
@Component
public class ExceptionAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAspect.class);
	
	@Around("@annotation(org.springframework.web.bind.annotation.RequestMapping) || @annotation(org.springframework.web.bind.annotation.GetMapping)")
	public Object handleException(ProceedingJoinPoint pjp) throws Throwable{
		try {
			return pjp.proceed();
		} catch (Throwable e) {
			// AOP에서 클레스 읽어오기
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			Class returnType = signature.getReturnType();
						
			ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			// 응답읽어오기
			HttpServletResponse res = requestAttributes.getResponse();
			HttpServletRequest req = requestAttributes.getRequest();
			
			if(returnType == String.class){
				if(e instanceof SecurityException){
					
				}else {
					return pjp.proceed();
				}
			}else {
				return pjp.proceed();
			}
		}
		return null;
	}
}
