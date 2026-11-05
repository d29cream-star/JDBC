package com.kh.plant.model.dto;

public class HousePlantDto {

	private int plantNo;
	private String plantType;
	private String plantName;
	
	public HousePlantDto() {}
	
	public HousePlantDto(String plantType, String plantName) {
		this.plantType = plantType;
		this.plantName = plantName;
	}
	public HousePlantDto(int plantNo, String plantType, String plantName) {
		this.plantNo = plantNo;
		this.plantType = plantType;
		this.plantName = plantName;
	}
	public int getPlantNo() {
		return plantNo;
	}
	public void setPlantNo(int plantNo) {
		this.plantNo = plantNo;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	@Override
	public String toString() {
		return "HousePlantDto [plantName=" + plantName + ", plantNo=" + plantNo + ", plantType=" + plantType + "]";
	}
}
