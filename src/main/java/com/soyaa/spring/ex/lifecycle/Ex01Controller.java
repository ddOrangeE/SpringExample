package com.soyaa.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 공통요소 묶기(이 class안에 있는 메소드는 모두 이거 붙이고 시작하는 것)
@RequestMapping("/lifecycle/ex01")
public class Ex01Controller {

	// 클래스는 항상 대문자로, 패키지는 소문자로, 프로젝트는 대문자로 시작
	
	// 문자열 response 만들기
	// 언어테이션 순서는 중요하지 않음, 메소드 위에만 있으면 됨
	@RequestMapping("/1") // @RequestMapping("/lifecycle/ex01/1")
	@ResponseBody
	public String stringResponse() {
		return "예제 1번 문자열 담는 response";
	}
	
	// 어떻게 Response 되었는가!!
	// responseBody 언어테이션 을 붙이는 순간 http 가 판단, 어떻게 표현 할 것인가 그다음에 전달해줌(?)
	
	// map json response
	// 과일이름 : 가격
	// int는 이제 안됨 이유는..? Map 은 class 기반의 객체만 쓸수 있음! (int는 class 기반의 객체가 아님!)
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> mapResponse() {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("apple", 1500);
		map.put("banana", 3000);
		map.put("orange", 1000);
		
		return map;
	}
	
	
	
	
}
