package com.example.demo.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.userRecordtime;
import com.example.demo.Service.LogService;
import com.example.demo.dao.LogDao;

@Service
public class LogServiceimpl implements LogService{

	@Autowired
	LogDao logdao;
	
	@Override
	public int insertLog(userRecordtime recordtime) {
		
		return logdao.AddLog(recordtime);
	}
	
}
