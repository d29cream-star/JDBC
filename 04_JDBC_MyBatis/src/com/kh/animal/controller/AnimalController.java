package com.kh.animal.controller;

import java.util.List;

import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.service.AnimalService;

public class AnimalController {

	private AnimalService as = new AnimalService();
	
	public List<AnimalDto> read() {
		return as.read();
	}
	public int save(String animalName) {
		return as.save(animalName);
	}
}
