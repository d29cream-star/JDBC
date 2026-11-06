package com.kh.plant.model.service;

import static com.kh.common.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.plant.model.dao.PlantDao;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantService {
	
	public int save(HousePlantDto hpd) {
		validateHousePlant(hpd);		
		SqlSession session = getSqlSession();
		int result = new PlantDao().save(session, hpd);
		session.close();
		return result;
	}
	public List<HousePlantDto> view() {
		SqlSession session = getSqlSession();
		List<HousePlantDto> result = new PlantDao().view(session);
		session.close();
		return result;
		
	}
	public int edit(HousePlantDto hpd) {
		validateHousePlant(hpd);		
		validatePlantNo(hpd.getPlantNo());
		SqlSession session = getSqlSession();
		int result = new PlantDao().edit(session, hpd);
		session.close();
		return result;		
	}
	public int delete(int plantNo) {
		validatePlantNo(plantNo);
		SqlSession session = getSqlSession();
		int result = new PlantDao().delete(session, plantNo);
		session.close();
		return result;
		
	}
	public HousePlantDto oneView(int plantNo) {
		validatePlantNo(plantNo);
		SqlSession session = getSqlSession();
		HousePlantDto result = new PlantDao().oneView(session, plantNo);
		session.close();
		return result;
	}
	
	public List<HousePlantDto> findByType(String keyword) {
		//if("바보".equals(keyword)||"멍청이".equals(keyword)||"똥개".equals(keyword)) {
		//	throw new RuntimeException("해당 검색어는 검색할 수 없습니다.");
		//}
		List<String> badKeywords = List.of("바보", "멍청이", "똥개");
		if(badKeywords.contains(keyword)){
		throw new RuntimeException(keyword + "은(는) 검색할 수 없습니다.");
		}
		SqlSession session = getSqlSession();
		List<HousePlantDto> result = new PlantDao().findByType(session, keyword);
		session.close();
		return result;
	}
	private void validatePlantNo(int plantNo) {
		if(plantNo < 1) {
			throw new RuntimeException("식물번호는 1보다 작을 수 없습니다.");
		}
	}
	private void validateHousePlant(HousePlantDto hpd) {
		checkNull(hpd);
		checkPlantName(hpd);
		checkPlantType(hpd);
		
	}
	private void checkNull(HousePlantDto hpd) {
		if(hpd == null){
			throw new RuntimeException("잠시 후 다시 시도해주세요.");
		}	
	}
	private void checkPlantName(HousePlantDto hpd) {
		if(hpd.getPlantName().isBlank() || hpd.getPlantName().length() > 40){
			throw new RuntimeException("유효하지 않은 식물 이름입니다.");
		}
	}
	private void checkPlantType(HousePlantDto hpd) {
		if(hpd.getPlantType().isBlank()||hpd.getPlantType().length() > 6) {
			throw new RuntimeException("유효하지 않은 식물 종류입니다.");
		}
	}
	
}
