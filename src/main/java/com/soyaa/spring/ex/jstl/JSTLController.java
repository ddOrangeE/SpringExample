package com.soyaa.spring.ex.jstl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soyaa.spring.ex.jstl.model.Book;

@Controller
@RequestMapping("/jstl")
public class JSTLController {

	// 예제 1번
	@GetMapping("/ex01")
	public String jstlEx01() {
		
		return "jstl/ex01";
	}
	
	// 예제 2번
	@GetMapping("/ex02")
	public String jstlEx02(Model model) {
		
		model.addAttribute("weight", 75);
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		
		model.addAttribute("fruitList", fruitList);
		
		// List<Map>
		// 사용자 정보 Map
		List<Map<String, Object>> userList = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "김인규");
		map.put("age", 28);
		map.put("hobby", "댄스");
		
		userList.add(map);
		
		map = new HashMap<>();
		map.put("name", "김바다");
		map.put("age", 3);
		map.put("hobby", "사냥하기");
		
		userList.add(map);
		
		model.addAttribute("userList", userList);
		
		// List 안에 class가 저장된 형태
		
		// 책 정보 리스트
		List<Book> bookList = new ArrayList<>();
		
		Book book = new Book();
		
		book.setTitle("아몬드");
		book.setAuthor("손원평");
		book.setPublisher("창비");
		
		bookList.add(book);
		
		book = new Book();
		
		book.setTitle("코스모스");
		book.setAuthor("칼 세이건");
		book.setPublisher("사이언스북스");
		
		bookList.add(book);
		
		model.addAttribute("books", bookList);
		
		return "jstl/ex02";
	}
	
	
	// 예제 3번 format 라이브러리
	
	@GetMapping("/ex03")
	public String jstlEx03(Model model) {
		
		Date now = new Date();  // 기본 date 객체를 생성해주면 현재 시간을 기반으로 생성해줌
		
		model.addAttribute("now", now);
		
		String dateString = "2022/08/12 18:18:20";
		
		model.addAttribute("dateString", dateString);
		return "jstl/ex03";
	}
	
}
