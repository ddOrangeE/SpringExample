package com.soyaa.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soyaa.spring.ex.ajax.bo.NewUserBO;
import com.soyaa.spring.ex.jsp.model.User;

// controller 는 bean에 저장된다!! 같은 이름일 수 없다

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private NewUserBO newUserBO;
	
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = newUserBO.getUserList();
		
		model.addAttribute("userList", userList);
		
		return "/ajax/userList";
	}
	
	@GetMapping("input")
	public String userInput() {
		return "ajax/userInput";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> addUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthDay
			, @RequestParam("email") String email) {
		
		int count = newUserBO.addUser(name, birthDay, email);
		
		// API 은 요청을 전달 받고 순수한 데이터 형태로 보여준다 그런데 깔끔하게 보여주기 위해서 json 형태로 보여주는 것이 일반적이다
		// ajax에 담기는 response 가 html 그대로니까 기본 데이터 형태로 바꿔줌 그 데이터가 : API
//		return "redirect:/ajax/user/list";
		
		// json 형태로 전달하기
		// 성공시 : {"result":"success"}
		// 실패시 : {"result":"fail"}
		
		// Spring 에서는 json 형태로 만들기 쉽게 도와주는 jackson 라이브러리가 있으니까 json 형태와 가장 비슷한 map 형태로 전달
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
//			return "성공";
			
			map.put("result", "success");
		} else {
//			return "실패";
			
			map.put("result", "fail");
		}
		
		return map;   // http 컴퍼터가 map을 보고 판단해서 이건 json 형태로 만들어야겠다 그담에 json 라이브러리가 json 형태의 문자열을 만들어준다!
					  // 결국 response 에 담기는 건 json 문자열
	}
	
	// API
	// email 중복 여부를 알려주는 api
	@GetMapping("/is_duplicate")
	@ResponseBody   // responsebody 가 없으면 jsp를 찾는다,, API 와 view의 차이점 생각해보면 됨!!
	public Map<String, Boolean> isDuplicate(@RequestParam("email") String email) {
		
		boolean isDuplicate = newUserBO.isDuplicateEmail(email);
		
		// {"is_duplicate":true} or {"is_duplicate":false}
		
		// 랩퍼클래스의 형태로 저장 해줘야함 (Map은!!) 그래서 boolean 못쓰고 Boolean
		Map<String, Boolean> map = new HashMap<>();
		
		// 자체가 boolean 이기 때문에 isDuplicate == true 가 아니라 isDuplicate만 하면 저 뜻이 된다
		if(isDuplicate) {
			map.put("is_duplicate", true);
		} else {
			map.put("is_duplicate", false);
		}
		
		return map;
	}
	
	
	
	
	
	
	
	
} 
