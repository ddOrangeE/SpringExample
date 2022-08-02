package com.soyaa.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// extends HttpServlet 해줄 필요 없다!! 
@Controller
public class HelloController {
	
	// 메소드도 맘대로 만들어도 됨
	
	// 언어테이션 추가
	@ResponseBody
	@RequestMapping("/hello") // 슬래쉬로 무조건 시작해야한다.
	public String helloWorld() {
		
		return "Hello World!!";
	}

}

// 콘솔에 뜨는 건 log 라고 부름 현재 상태를 기록된것
// 문제 없이 잘 수행하고 있다 - INFO 

// localhost:8080 + 내가 맵핑한 주소 ) error 404 : 주소가 잘못됐다!!