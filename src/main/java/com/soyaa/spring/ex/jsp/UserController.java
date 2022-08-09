package com.soyaa.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	// @ResponseBody 
	
	// jsp 로 연결하는 건 String으로 return - jsp 주소
	public String userRecent(Model model) {  // List 왜씀?
		// 필요한 파라미터는 그때 그때 꺼내 쓴다. 
		// Model 이라는 객체를 Spring 에서 전달해줌 (있는 걸 전달해주는 것)
		
		User lastUser = userBO.userRecent();
		
		model.addAttribute("title", "최근 등록 사용자 정보");
		// key value 형태
		// 필요할 때마다 addAttribute
		
		model.addAttribute("user", lastUser);
		// 객체 자체를 저장 가능
		// 값이 중요한 거지 변수는 관계 없음
		
		// 모델에 추가된 값은 return 된 경로에서 사용 가능
		
		return "jsp/userInfo";
	}
	
	
	
	
}
