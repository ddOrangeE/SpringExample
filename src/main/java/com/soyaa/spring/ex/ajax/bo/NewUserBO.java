package com.soyaa.spring.ex.ajax.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyaa.spring.ex.ajax.dao.NewUserDAO;
import com.soyaa.spring.ex.jsp.model.User;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	// import 만 잘 해주면 다른 패키지에 있는 model이더라도 쓸 수 ㅇ있다 -- jsp model user
	public List<User> getUserList() {
		return newUserDAO.selectUserList();
	}
	
	public int addUser(String name, String birthday, String email) {
		return newUserDAO.insertUser(name, birthday, email);
	}
}
