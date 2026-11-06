package com.kh.animal.model.dto;

public class AnimalDto {

	private int animalNo;
	private String animalName;
	
	public AnimalDto() {
	}

	public AnimalDto(String animalName) {
		this.animalName = animalName;
	}

	public AnimalDto(int animalNo, String animalName) {
		this.animalNo = animalNo;
		this.animalName = animalName;
	}

	public int getAnimalNo() {
		return animalNo;
	}

	public void setAnimalNo(int animalNo) {
		this.animalNo = animalNo;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	@Override
	public String toString() {
		return "AnimalDto [animalNo=" + animalNo + ", animalName=" + animalName + "]";
	}
	
	
	
}
