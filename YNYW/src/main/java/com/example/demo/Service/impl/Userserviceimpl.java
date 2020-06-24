package com.example.demo.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.user;
import com.example.demo.Entity.userRecordtime;
import com.example.demo.Service.Userservice;
import com.example.demo.dao.Userdao;

@Service
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
public class Userserviceimpl implements Userservice{
 
	@Autowired
	Userdao userdao; 
	//Anotationuserdao Anotationuserdao;
	@Override
	public int userEnter(String userId,String possword,String authority) {
		
		user user1=userdao.findByid(userId);
		if(user1==null) {
			System.out.println("没有该用户");
			return 0;
		}else if(possword.equals(user1.getPassword())) {
			if(authority.equals(user1.getAuthority()) && authority.equals("用户")) {
				return 2;
			}else if(authority.equals(user1.getAuthority()) && authority.equals("管理员")) {
				return 1;
			}else {
				return 0;
			}
		}
		return 0;
	}
	
	@Override
	public boolean userRecord(userRecordtime recordtime) {
		int row=userdao.AddRecord(recordtime);
		if(row>0) {
			System.out.println("记录成功");
			return true;
		}
		return false;
	}

	@Override
	public user finduser(String userId) {
		
		return userdao.finduser(userId);
	}

	@Override
	public boolean userupdate(user user) {
		int row=userdao.userupdate(user);
		if(row>0) {
			return true;
		}else {
		return false;
		}
	}

	
	
}
