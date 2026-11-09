package com.kh.snackfood.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.snackfood.model.dao.FoodDao;
import com.kh.snackfood.model.dto.SnackFoodDto;

public class FoodService {
	private FoodDao fd = new FoodDao();
	
	public List<SnackFoodDto> selectFoodList() {
		
		SqlSession session = Template.getSqlSession();
		List<SnackFoodDto> foods = fd.selectFoodList(session);
		session.close();
		return foods;
	}
	
	public List<SnackFoodDto> selectByCondition(Map<String, String> arguments){
		SqlSession session = Template.getSqlSession();
		
		/*
		switch(argumnets.get("menuNo")) {
		case "1" : fd.selectFoodByFoodName(session, map); break; 
		}
		*/
		
		List<SnackFoodDto> foods =  fd.selectByCondition(session, arguments);
		session.close();
		return foods;
	}
	
	public int insertFood(SnackFoodDto sf) {
		SqlSession session = Template.getSqlSession();
		int result = fd.insertFood(session, sf);
		session.close();
		return result;
	}
}
