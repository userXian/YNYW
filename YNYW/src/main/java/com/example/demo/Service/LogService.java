package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.userRecordtime;

public interface LogService {
	
	int insertLog(userRecordtime recordtime);
	List logs();
	
}
