package com.kh.animal.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dto.AnimalDto;
import com.kh.common.JdbcTemplate;

public class AnimalService {


	public List<AnimalDto> read(Connection conn) {
		Connection conn = JdbcTemplate.getConnection();
		List<AnimalDto> animals = new AnimalDao().read(conn);
		JdbcTemplate.close(conn);
		return animals;
	}
	public int save(String animalName) {
		Connection conn = JdbcTemplate.getConnection();
		int result = new AnimalDao().save(conn, animalName);
		JdbcTemplate.close(conn);
		return result;
	}
}
