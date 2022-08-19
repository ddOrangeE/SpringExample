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
	
	// BO 는 Controller 가 사용하기 편리하게 return 해주는 것이 좋음
	// email 중복여부 알려주는 기능
	// email 중복 여부를 알려줘야 하니까 기다 아니다 boolean 리턴해주기
	public boolean isDuplicateEmail(String email) {
		// 최대한 DAO 는 멍텅구리로 만드는 것이 좋음 
		// 너는 이쿼리 수행해! 이거에 대한 정답은 내가 알아서 할거야
		
//		SELECT count(1) FROM `new_user` WHERE `email` = 'lecture@hagulu.com'; 이런 식으로 가면 되니까
		// count 가 1이 나오면 중복된 게있는 것!!
		
		// resultType 이 int니까 int로 저장
		int count = newUserDAO.selectCountEmail(email);
		if(count == 0) {
			return false; // 중복되었는지에 대한 메소드니까 중복 안됐으니까 false
		} else {
			return true;
		}
		
	}
}
