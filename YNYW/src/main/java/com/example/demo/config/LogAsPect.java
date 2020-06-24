package com.example.demo.config;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.Entity.user;
import com.example.demo.Entity.userRecordtime;
import com.example.demo.Service.LogService;
import com.example.demo.Service.impl.LogServiceimpl;

import springfox.documentation.spi.service.contexts.SecurityContext;
@Aspect
@Component
public class LogAsPect {
	private final static Logger log = org.slf4j.LoggerFactory.getLogger(LogAsPect.class);
	@Autowired
	LogServiceimpl logservice;
	
	@Pointcut("@annotation(com.example.demo.config.Log)")
	public void pointcut() {}
	
//	@Around("pointcut()")
//	public Object around(ProceedingJoinPoint point) {
//		Object result =null;
//		long beginTime = System.currentTimeMillis();
//		
//		try {
//		    
//			result = point.proceed();
//			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//	    	Date date = new Date(System.currentTimeMillis());
//	    	String time=formatter.format(date);
//			insertLog(point,time);
//		} catch (Throwable e) {
//			
//		}
//		return result;
//	}
	@After("pointcut()")
	public void after(JoinPoint point) {
		System.out.print("---------1111111111");
		String userId = (String)point.getArgs()[0];
		System.out.print("---------"+userId);
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    	Date date = new Date(System.currentTimeMillis());
    	String time=formatter.format(date);
		insertLog(userId, time);
	}
	private void insertLog(String userId ,String time) {
		userRecordtime recordtime= new userRecordtime();
		recordtime.setUserId(userId);
		recordtime.setRegisterDatetime(time);
		logservice.insertLog(recordtime);
		log.info("记录成功！");
	}
}
