package com.soyaa.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soyaa.spring.ex.mybatis.bo.ReviewBO;
import com.soyaa.spring.ex.mybatis.model.Review;

@Controller
@RequestMapping("/mybatis")
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	
	// 예제 1번
	
	// 특정 id의 Review 데이터 가져오기
	@RequestMapping("/ex01")
	@ResponseBody
	
	// Servlet 에서는 request.getParameter 을 썼지만 여기서는 @RequestParam 그리고 괄호안에 ("") 안에 파라미터 이름을 정한다
	// Controller 와 DAO는 아예 모르는 사이이기 때문에 변수이름이 같을 필요가 없다
	
	// 파라미터 "id"로 전달받은 값이 int id로 저장되고, 그 아이디가 BO 에 전달되고 그 아이디가 DAO 에 전달 되는데 그 int id가 xml 에 전달될수 있게 @Param("변수") 로 저장되고 그게 xml 에 #{변수}에 전달!!
	
	// RequestParam 이라는 걸 사용했을 때 파라미터를 전달받지 않으면 400에러가 난다.
	// RequestParam의 원래 식
//	public Review review(@RequestParam(value="id", required=true) int id) {
	
	
	public Review review(
//			@RequestParam("id") int id  // 축약된 형태
//			@RequstParam(value="id", required=true) int id 기본값
//			@RequestParam(value="id", required=false) int id // 필수 항목이 아닌 파라미터 설정 (이렇게 하면 500에러가 난다 우리 메소드 자체가 파라미터가 없으면 쿼리수행이 안되기 때문)
			// int는 null일 수 없기 때문에 에러가 난다 
			// null일 땐 타입을 랩퍼클래스로 써주어야 한다 -> Integer id
//			@RequestParam(value="id", required=false) Integer id
			
			// 없으면 아무거나 보여줘라!! 내가 null일 때 기본값을 지정해주는 방식 : 이건 내가 설정한 값이 채워지기 때문에 null을 고민할 필요 없다
			@RequestParam(value="id", defaultValue="3") int id
//			, @RequestParam("test") String test   // 파라미터 추가해주고 싶으면 이렇게 쉼표하고 받고 싶은 값 이어주면 된다
			
			// Servlet 은 requestParameter 을 무조건 Spring으로 받았지만, Spring은 문자열로 받은 걸 내가 지정한 타입으로 변환시켜준다!!
			
			) {
		Review review = reviewBO.getReview(id);
		//Review review = reviewBO.getReview(4);
		return review;
	}
	
	// 예제 2번
	@RequestMapping("/ex02")
	@ResponseBody  // 문자열 그대로 전달할 수 있도록 붙여주기
	public String addReview() {
		// 가게 id, 메뉴, 사용자이름, 별점, 리뷰내용
		// int count =  reviewBO.addReview(4, "콤비네이션피자", "김바다", 4.5, "할인도 많이 받고 잘먹었습니다!!");
		
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다!!");
		
		int count = reviewBO.addReviewByObject(review);
		
		return "삽입 결과 : " + count; 
	}
	
	// 하나씩 파라미터 나열하기 힘들어 한번에 전달할 수 있는 방법 없을까?
	// 내가 만들어놓은 Review class 객체로 전달 할 수는 없을까?
	
}
