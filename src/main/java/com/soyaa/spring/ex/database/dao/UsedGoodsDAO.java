package com.soyaa.spring.ex.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soyaa.spring.ex.database.model.UsedGoods;

// 인터페이스 - 정의만 하는 것 : 실제 해당 쿼리를 수행할 xml 필요

// 펄시스턴스 레이어 
// 인터페이스로 만들어야 함
// 이걸 통해서 쿼리 수행

@Repository // 이게 있어야 데이터 베이스 관련된 작업들이 처리가 됨
public interface UsedGoodsDAO {
	
	// BO에서 사용할 수 있는 기능을 만들어 주는 것
	
	// used Goods 의 모든 행을 조회하는 기능
	// interface 는 고리가 없음 그냥 바로 콜론
	public List<UsedGoods> selectUsedGoodsList();

	// used Goods 를 가지고 오려면 어떤 걸로 가지고 와야할까?
	// 맵도 되지만 타입 다 지정해서 써야하고, 오타내기도 쉬워
	// 클래스 만들어서 멤버 변수 저장하고 객체 생성 해서 쓰자!! - model 패키지에 class 만들기
	
	// DAO 가 select 를 usedGoods 에 저장할 수 있는 이유!! 
	// mybatis 사용법에 따라 메소드 연결해주고, 객체에 저장할 수 있도록 해줬기 때문에 
}
