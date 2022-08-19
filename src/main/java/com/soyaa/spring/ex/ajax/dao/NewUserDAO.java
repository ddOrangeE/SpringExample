package com.soyaa.spring.ex.ajax.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.soyaa.spring.ex.jsp.model.User;

@Repository
public interface NewUserDAO {

	public List<User> selectUserList();
	
	public int insertUser(
			@Param("name") String name
			, @Param("birthDay") String birthDay
			, @Param("email") String email);
	
	// 얘는 BO 한테 count 개수만 전달해주면 됨
	public int selectCountEmail(@Param("email") String email);
}
