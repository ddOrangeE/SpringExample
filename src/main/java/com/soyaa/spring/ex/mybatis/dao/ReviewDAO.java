package com.soyaa.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.soyaa.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {

	// 특정 id의 review 테이블 조회 결과 리턴
	
	// 하나만 전달할 거니까 List 가 아니라 객체 그 자체 전달
	
	// DAO 는 java, xml 은 xml이니까 여기서 파라미터를 받을 때 알아들을 수 있게 전달해줘야함
	public Review selectReview(@Param("id") int id);
}
