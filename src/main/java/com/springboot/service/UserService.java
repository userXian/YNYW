package com.springboot.service;

import com.springboot.entity.User;

public interface UserService {
	public boolean checkPassword(String name, String password);
	public User getUser(String userId);

//	public List<User> getAll();
}
