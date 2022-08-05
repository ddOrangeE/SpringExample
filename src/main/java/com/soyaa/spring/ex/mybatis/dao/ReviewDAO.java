package com.soyaa.spring.ex.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.soyaa.spring.ex.mybatis.model.Review;

@Repository
public interface ReviewDAO {

	
	// 예제 1번
	
	// 특정 id의 review 테이블 조회 결과 리턴
	
	// 하나만 전달할 거니까 List 가 아니라 객체 그 자체 전달
	
	// DAO 는 java, xml 은 xml이니까 여기서 파라미터를 받을 때 알아들을 수 있게 전달해줘야함
	public Review selectReview(@Param("id") int id);

	// 예제 2번
	
	// 가게 id, 메뉴, 사용자이름, 별점, 리뷰내용 전달 받아서 테이블에 insert
	public int insertReview(
			// xml 에서 사용할 수 있도록 각각의 별명을 붙여준다
			@Param("storeId") int storeId  
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	// 객체를 전달 받아서 리뷰 내용을 insert
	public int insertReviewByObject(Review review);

}
