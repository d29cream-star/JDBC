package com.kh.plant.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.plant.model.dto.HousePlantDto;

public class PlantDao {

	public int save(SqlSession session, HousePlantDto hpd) {
		
		return session.insert("plantMapper.save",hpd);
		
	}
	public List<HousePlantDto> view(SqlSession session){
		return session.selectList("plantMapper.view");
	}
}