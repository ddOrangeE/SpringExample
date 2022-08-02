package com.soyaa.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soyaa.spring.ex.lifecycle.model.Person;

@RestController //@Controller + @ResponseBody 
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {

	@RequestMapping("/3") // @RequestMapping("/lifecycle/ex01/3")
	public String stringResponse() {
		
		return "RestController 테스트!!";
	}
	
	// 직접 만든 클래스의 객체 return
	@RequestMapping("/4")
	public Person objectResponse() {
		// 생성자 따로 안만들었기 때문에 기본 생성자
		// 다른 패키지에 있으니까 import
		Person person = new Person();
		person.setName("김인규");
		person.setAge(19);
		
		return person; // 멤버변수의 이름을 key로, 값을 value 로 알아서 잡아서 보여줌
	}
	
	// entity - http status code 포함 (사용법으로 알고 있기)
	@RequestMapping("/5")
	public ResponseEntity<Person> entityResponse() {
		
		Person person = new Person();
		person.setName("김인규");
		person.setAge(19);
		
		// ResponseEntity 안에 들어갈 데이터 형태 잡아주기 (List 만들 때에도 general 형식으로 형태 잡아준 것 처럼)
		
		// Status - 200, OK 
		// 우리가 따로 안잡아주면 200
		// 500 - Internal server error 을 전달 시킬 거임 
		// 사실 이런 형태로는 잘 안씀
		ResponseEntity<Person> entity = new ResponseEntity(person, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	
	}
	// localhost 로 들어가면 페이지 이상 없이 나옴 검사 눌러서 콘솔 보면 에러 뜸
	// 언제 쓰냐! 특정한 사이트에 이상한 거 와다다 누르면 뜸!! 
	
	// google 에 HttpStatus 코드 검색하면 상태 코드 라고 나옴 (404, 400, 405 500(특히: 내가 짜둔 서버에 에러) 자주봄)
}
