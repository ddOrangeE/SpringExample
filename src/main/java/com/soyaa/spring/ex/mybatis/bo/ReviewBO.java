package com.soyaa.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyaa.spring.ex.mybatis.dao.ReviewDAO;
import com.soyaa.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;

	// 예제 1번
	
	// 특정 id의 review 얻어와서 리턴
	// BO는 순수한 java코드니까 int id 고대로 전달가능
	public Review getReview(int id) {
		Review review = reviewDAO.selectReview(id);
		// Review review = reviewDAO.selectReview(8);
		
		return review;
	}
	
	
	// 예제 2번
	
	// 가게 id, 메뉴, 사용자이름, 별점, 리뷰내용 전달 받아서 저장
	// DAO 에서 int로 return 해준다
	public int addReview(int storeId, String menu, String userName, double point, String review) {
		return reviewDAO.insertReview(storeId, menu, userName, point, review);
	}
	
	// 리뷰 정보를 객체로 전달 받아서 저장
	public int addReviewByObject(Review review) {
		
		return reviewDAO.insertReviewByObject(review);
	}
}
