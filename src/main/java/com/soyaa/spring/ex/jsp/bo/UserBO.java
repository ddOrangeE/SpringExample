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
	
	// BO 한테 User 객체를 파라미터로 전달하는 이유!
	// Controller 가 User 라는 객체를 생성해서 값을 저장했다
	// BO한테 정보(객체 user)를 전달하려면 BO에게도 저장할 데이터가 있어야 하기 때문에 파라미터로 User 를 전달하는 것 
	public int addUserByObject(User user) {
		return userDAO.inserBserByObject(user);
	}
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능
	public User userRecent() {
		return userDAO.selectUserRecent();
	}
	
	
}
