package com.soyaa.spring.ex.jsp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.soyaa.spring.ex.jsp.model.User;

@Repository
public interface UserDAO {
	
	public int insertUser(
			@Param("name") String name
			, @Param("birthDay") String birthDay
			, @Param("introduce") String introduce
			, @Param("email") String email);
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능
	
	public List<User> selectUserRecent();
}
