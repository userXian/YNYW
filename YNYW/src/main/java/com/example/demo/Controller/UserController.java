package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.user;
import com.example.demo.Entity.userRecordtime;
import com.example.demo.Service.LogService;
import com.example.demo.Service.Userservice;
import com.example.demo.Service.impl.LogServiceimpl;
import com.example.demo.config.Log;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class UserController {
	@Autowired
	Userservice Userserviceimpl; 
	
	@Autowired
	LogService LogServiceimpl;
	
	@ApiOperation(value = "登录", notes = "这是一个登录功能，通过从用户请求获取用户名和密码进行登录")
	@ApiImplicitParams(value = {
	  @ApiImplicitParam(name = "userId", value = "用户名", paramType = "query"),
	  @ApiImplicitParam(name = "password", value = "密码", paramType = "query")
	})
	
	@PostMapping("/login")
	@ResponseBody
//Log-----------Aop记录：	
	//@Log("测试aoplog")
	public int hello(@RequestBody user user){
		String userId=user.getUserId();
		String password=user.getPassword();
		String authority=user.getAuthority();
		System.out.print(authority);
		int enter=0;
		enter=Userserviceimpl.userEnter(userId,password,authority);
		if(enter>0) {
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
	    	Date date = new Date(System.currentTimeMillis());
	    	String time=formatter.format(date);
	    	userRecordtime recordtime= new userRecordtime();
	    	recordtime.setUserId(userId);
			recordtime.setRegisterDatetime(date);
			LogServiceimpl.insertLog(recordtime);
		}
		System.out.print(enter);
		return enter;
	}
	
	@PostMapping("/user")
	@ResponseBody
	public user find(@RequestBody String userId) {
		return Userserviceimpl.finduser(userId);
	}
	
	@PostMapping("/userupdate")
	@ResponseBody
	public boolean userupdate(@RequestBody user user) {
		return Userserviceimpl.userupdate(user);
	}
	
}
