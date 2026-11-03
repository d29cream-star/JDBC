package com.kh.animal.model.service;

import java.util.List;

import com.kh.animal.model.dao.AnimalDao;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalService {


	public List<AnimalDto> read() {
		return new AnimalDao().read();
	}
	public int save(String animalName) {
		return new AnimalDao().save(animalName);
	}
}
