package com.soyaa.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	// 리턴 타입은 경로이기 때문에 무조건 String
	@RequestMapping("/lifecycle/ex02/1")
	public String ex02View() {
		
		return "lifecycle/ex02";
	}
	// return  하는 주소는 java 안에서 접근하기 위한 주소
	
	// RequestMapping 과 return 주소는 전혀 상관 없다!!
	
	
	//RequestMapping("/") 은 슬래쉬가 필수!!! -> 사용자가 접근하기 위한 주소
	
	
}
