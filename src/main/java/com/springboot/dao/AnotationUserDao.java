package com.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.entity.User;

@Mapper
public interface AnotationUserDao {

//	     /**
//	      *
//	      * @param userid
//	      */
//	     @Select("SELECT user_id,user_name,password,description FROM t_user where user_id = #{userid}")
//	     @Results({
//	             @Result(property = "userid", column = "user_id"),
//	             @Result(property = "username", column = "user_name"),
//	             @Result(property = "password", column = "password"),
//	             @Result(property = "description", column = "description"),
//	     })
	     User findById(@Param("userid") String userid);

//	     /**
//	      *
//	      * @param userid
//	      */
//	     @Select("SELECT user_id,user_name,password,description FROM t_user")
//	     @Results({
//	             @Result(property = "userid", column = "user_id"),
//	             @Result(property = "username", column = "user_name"),
//	             @Result(property = "password", column = "password"),
//	             @Result(property = "description", column = "description"),
//	     })
//	     List<User> findAll();
}