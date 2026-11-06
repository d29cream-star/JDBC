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
	
	public int edit(SqlSession session, HousePlantDto hpd) {
		return session.update("plantMapper.edit", hpd);
	}
	public int delete(SqlSession session, int plantNo) {
		return session.delete("plantMapper.delete", plantNo);
		
	}
	public HousePlantDto oneView(SqlSession session, int plantNo) {
		return session.selectOne("plantMapper.oneView", plantNo);
	}
	public List<HousePlantDto> findByType(SqlSession session, String keyword){
		return session.selectList("plantMapper.findByType", keyword);
	}
}