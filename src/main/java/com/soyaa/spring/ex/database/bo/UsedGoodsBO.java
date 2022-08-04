package com.soyaa.spring.ex.database.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyaa.spring.ex.database.dao.UsedGoodsDAO;
import com.soyaa.spring.ex.database.model.UsedGoods;

// UsedGoods 를 처리하는 비지니스 레이어
// 데이터베이스를 조회하는 게 필요해서 만드는 것

// 전달 받은 데이터를 조작하거나 처리하고, 리턴 받은 데이터를 조작 처리하는 과정 (로직)
@Service
public class UsedGoodsBO {

	@Autowired // 이거 밑에 객체 멤버변수 만들면 springframework 알아서 전달해줌
	private UsedGoodsDAO usedGoodsDAO; 
	
	// 이렇게 했으면 우리가 객체 생성한 것 처럼 사용하면 됨
	
	// Controller 가 요청할 수 있게 만든 것
	
	// usedGoods 테이블의 모든 행 정보 가져오는 메소드
	public List<UsedGoods> getUsedGoodsList() {
		// DAO 객체를 생성해야한다 - DAO 는 interface 객체 생성 불가
		// 여기서 직접 객체 생성해서 사용하지 않음 - 웹서비스는 수만명의 사용자가 씀 즉, 여기서 객체 생성을 하게 되면 무분별하게 잘못 객체를 생성해서 사용할 가능성이 높아짐 - 메모리 낭비
		// springframework 내부에서 객체를 직접 생성해서 관리해줌 그걸 우리가 요청해서 사용 할 수 있음
	
		List<UsedGoods> usedGoodsList = usedGoodsDAO.selectUsedGoodsList();
		return usedGoodsList;
	}
	
}
