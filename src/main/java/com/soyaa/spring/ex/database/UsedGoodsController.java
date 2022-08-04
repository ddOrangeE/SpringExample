package com.soyaa.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soyaa.spring.ex.database.bo.UsedGoodsBO;
import com.soyaa.spring.ex.database.model.UsedGoods;

// request 를 전달 받고, response 를 만드는 일 (Controller 의 역할)
@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	@RequestMapping("/database/ex01")   // Request 관련 할 일 (맵핑, 파라미터 있으면 전달 받기)
	@ResponseBody
	public List<UsedGoods> ex01() {
		
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		
		return usedGoodsList;
	}
}
