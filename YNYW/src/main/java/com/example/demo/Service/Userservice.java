package com.example.demo.Service;

import com.example.demo.Entity.user;
import com.example.demo.Entity.userRecordtime;

public interface Userservice {

	public int userEnter(String nameId,String possword,String authority);
	public boolean userRecord(userRecordtime recordtime);
	public user finduser(String userId);
	public boolean userupdate(user user);
	
}
