package com.kh.plant.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JdbcTemplate;
import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		
		Connection conn = JdbcTemplate.getConnection();
		int result = new PlantDao().save(conn,hpd);
		JdbcTemplate.close(conn);
		return result;
		
	}
	public List<HousePlantDto> view() {
		
		Connection conn = JdbcTemplate.getConnection();
		List<HousePlantDto> plants = new PlantDao().view(conn);
		JdbcTemplate.close(conn);
		return plants;
		
	}
	public int edit(HousePlantDto hpd) {
		Connection conn = JdbcTemplate.getConnection();
		int result = new PlantDao().edit(conn, hpd);
		JdbcTemplate.close(conn);
		return result;
		
	}
	public int delete(int plantNo) {
		if(plantNo < 1) {
			throw new RuntimeException("식물번호는 1보다 작을 수 없습니다.");
		}
		Connection conn = JdbcTemplate.getConnection();
		int result =  new PlantDao().delete(conn, plantNo);
		JdbcTemplate.close(conn);
		return result;
		
	}
	public HousePlantDto oneView(int plantNo) {
		Connection conn = JdbcTemplate.getConnection();
		HousePlantDto result = new PlantDao().oneView(conn, plantNo);
		JdbcTemplate.close(conn);
		return result;
	}
	
	public List<HousePlantDto> findByType(String keyword) {
		Connection conn = JdbcTemplate.getConnection();
		List<HousePlantDto> result = new PlantDao().findByType(conn, keyword);
		JdbcTemplate.close(conn);
		return result;
	}
}
