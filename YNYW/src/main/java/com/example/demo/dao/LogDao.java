package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.Entity.userRecordtime;

@Mapper
public interface LogDao {
	
	int AddLog(userRecordtime recordtime);
	
}
