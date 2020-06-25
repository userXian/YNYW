package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.Entity.logs;
import com.example.demo.Entity.userRecordtime;

@Mapper
public interface LogDao {
	
	int AddLog(userRecordtime recordtime);
	List<logs> logs();
	
}
