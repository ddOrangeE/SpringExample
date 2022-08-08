package com.soyaa.spring.ex.jsp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soyaa.spring.ex.jsp.bo.UserBO;
import com.soyaa.spring.ex.jsp.model.User;

@Controller

@RequestMapping("/jsp/user")
public class UserController {

	@Autowired
	private UserBO userBO;
	
	// new user 데이터 저장
	// 이름, 생년 월일, 자기소개, 이메일
//	@RequestMapping("/add") // RequestMapping이라는 애가 get, post 둘다 관리해준다 // 이러면 편리하긴 한데 좋진 않다 정확히 method 를 명시해주는 것이 좋다!!
//	@RequestMapping(path="/add", method=RequestMethod.POST) // RequestMethod. 뒤에 내가 사용할 메소드 써주면 된다!!
	
	// 서버가 갑임 ㅋ

	// 더 쉽게 하는 법
	@PostMapping("/add")
	@ResponseBody
	public String addUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthDay
			, @RequestParam("introduce") String introduce
			, @RequestParam("email") String email
			) {
		
		int count = userBO.addUser(name, birthDay, introduce, email);
		
		return "삽입 결과 : " + count;
		
	}
	
//	@RequestMapping("/input")
	@GetMapping("/input")
	public String userInput() {
		return "jsp/userInput";
	}
	
	
	// 가장 최근에 등록된 사용자 정보를 하나 얻어 오는 기능(user table 기반)
	
	@GetMapping("/search")  // GET POST 
	@ResponseBody
	public User userRecent() {  // List 왜씀?
		return userBO.userRecent();
	}
	
	
	
	
}
