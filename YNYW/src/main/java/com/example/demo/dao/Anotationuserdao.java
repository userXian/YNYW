package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Entity.user;

@Mapper
public interface Anotationuserdao {
	
	@Select("SELECT * FROM springbootdb where name_id =#{name_id}")
	@Results({
		@Result (column="name_id" ,property="name_id"), 
		@Result (column="name_name", property="name_name"), 
		@Result (column="password" ,property="password"),
		@Result (column="description", property="description"), 
	})
	user findByid(@Param("name_id") String name_id);

}
