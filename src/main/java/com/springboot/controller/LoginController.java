package com.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.service.UserService;

@CrossOrigin(origins = { "http://localhost:4200", "null" })
@RestController
public class LoginController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/login")
	@ResponseBody
	public boolean login(HttpServletRequest request) {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		boolean result = service.checkPassword(userId, password);
		if (result) {
			service.registerLog(userId);
			return result;
		}
		return false;
	}

}
