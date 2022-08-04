package com.soyaa.spring.ex.mybatis.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyaa.spring.ex.mybatis.dao.ReviewDAO;
import com.soyaa.spring.ex.mybatis.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;

	// 특정 id의 review 얻어와서 리턴
	// BO는 순수한 java코드니까 int id 고대로 전달가능
	public Review getReview(int id) {
		Review review = reviewDAO.selectReview(id);
		// Review review = reviewDAO.selectReview(8);
		
		return review;
	}
}
