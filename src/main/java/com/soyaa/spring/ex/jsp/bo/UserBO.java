package com.soyaa.spring.ex.jsp.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyaa.spring.ex.jsp.dao.UserDAO;
import com.soyaa.spring.ex.jsp.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	// new user 데이터 저장
	// 이름, 생년월일, 자기소개, 이메일
	public int addUser(String name, String birthDay, String introduce, String email) {
		
		int count = userDAO.insertUser(name, birthDay, introduce, email);
		
		return count;
	}
	
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능
	public User userRecent() {
		return userDAO.selectUserRecent();
	}
	
	
}
