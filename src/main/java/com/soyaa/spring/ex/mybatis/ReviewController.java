package com.soyaa.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soyaa.spring.ex.mybatis.bo.ReviewBO;
import com.soyaa.spring.ex.mybatis.model.Review;

@Controller
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	// 특정 id의 Review 데이터 가져오기
	@RequestMapping("/mybatis/ex01/1")
	@ResponseBody
	
	// Servlet 에서는 request.getParameter 을 썼지만 여기서는 @RequestParam 그리고 괄호안에 ("") 안에 파라미터 이름을 정한다
	// Controller 와 DAO는 아예 모르는 사이이기 때문에 변수이름이 같을 필요가 없다
	
	// 파라미터 "id"로 전달받은 값이 int id로 저장되고, 그 아이디가 BO 에 전달되고 그 아이디가 DAO 에 전달 되는데 그 int id가 xml 에 전달될수 있게 @Param("변수") 로 저장되고 그게 xml 에 #{변수}에 전달!!
	
	public Review review(@RequestParam("id") int id) {
		Review review = reviewBO.getReview(id);
		//Review review = reviewBO.getReview(4);
		return review;
	}
	
}
