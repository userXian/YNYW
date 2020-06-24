package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.Entity.user;
import com.example.demo.Entity.userRecordtime;

@Mapper
public interface Userdao {
	
	user findByid(@Param("userId") String userId);
	int AddRecord(userRecordtime recordtime);
	user finduser(@Param("userId") String userId);
	int userupdate(user user);
}
