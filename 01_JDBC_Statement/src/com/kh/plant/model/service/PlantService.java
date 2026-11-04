package com.kh.plant.model.service;

import java.util.List;

import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		return new PlantDao().save(hpd); 
		
		
	}
	public List<HousePlantDto> view() {
		return new PlantDao().view();
	}
	public int edit(HousePlantDto hpd) {
		return new PlantDao().edit(hpd);
	}
	public int delete(int plantNo) {
		
		if(plantNo < 1) {
			throw new RuntimeException("식물번호는 1보다 작을 수 없습니다.");
		}
		
		return new PlantDao().delete(plantNo);
	}
	public HousePlantDto oneView(int plantNo) {
		
		return new PlantDao().oneView(plantNo);
	}
	
	public List<HousePlantDto> findByType(String keyword) {
		return new PlantDao().findByType(keyword);
	}
}
