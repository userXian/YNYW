package com.springboot.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.AnotationUserDao;
import com.springboot.dao.LogDao;
import com.springboot.entity.User;
import com.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AnotationUserDao userDao;

	@Autowired
	private LogDao logDao;

	@Override
	public boolean checkPassword(String id, String password) {

		User user = userDao.findById(id);
		if (user != null && password.equals(user.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public User getUser(String userId) {
		User user = userDao.findById(userId);
		return user;
	}

	@Override
	public void registerLog(String userId) {
		logDao.registerLog(userId, LocalDateTime.now());
	}

}
