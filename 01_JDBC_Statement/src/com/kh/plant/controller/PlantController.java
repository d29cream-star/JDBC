package com.kh.plant.controller;

import java.util.List;

import com.kh.plant.model.dto.HousePlantDto;
import com.kh.plant.model.service.PlantService;

public class PlantController {

	private PlantService ps = new PlantService();
	
	public int save(String plantName, String plantType) {
		HousePlantDto hpd = 
				new HousePlantDto(plantType, plantName);
		return ps.save(hpd);
	
	}
	public List<HousePlantDto> view() {
		return ps.view();
	}
}
