package com.kh.plant.view;

import java.util.List;
import java.util.Scanner;

import com.kh.plant.controller.PlantController;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantView {

	private PlantController pc = new PlantController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("화초 관리 프로그램");
			System.out.println("1. 화초 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 화초 수정");
			System.out.println("4. 화초 삭제");
			System.out.println("5. 화초 한개만 조회");
			System.out.println("6. 화초 종류 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : save();break;
			case "2" : view(); break;
			case "3" : edit(); break;
			case "4" : delete(); break;
			case "5" : oneView(); break;
			case "6" : findByType(); break;
			case "0" : sc.close(); return;
			default: System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}
	private void save() {
		System.out.println("\n 화초 추가 서비스");
		System.out.print("화초 이름을 입력해주세요.");
		String plantName = sc.nextLine();
		System.out.print("화초 종류를 입력해주세요.");
		String plantType = sc.nextLine();
	
		//if(!plantName.isBlank()) {
			int result = pc.save(plantName, plantType);			
		//}else {
		//	System.out.println("화초 이름을 입력해주세요.");
		//}
			if(result > 0) {
				System.out.println("화초가 추가되었습니다.");
			}else{
				System.out.println("화초가 추가되지 못했습니다.");
			}
	
	
	}
	private void view() {
		System.out.println("화초 목록입니다.");	
		List<HousePlantDto> plants = pc.view();
		if(plants.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		}else {
			System.out.println("\n조회된 화초는 총" + plants.size() + "개");
			for(HousePlantDto h : plants) {
				System.out.println(" =====================================");
				System.out.print(" 식물번호 : " + h.getPlantNo());
				System.out.print(" 식물이름 : " + h.getPlantName());
				System.out.print(" 식물종류 : " + h.getPlantType());
				System.out.println();
			}
		}
		
	}
	private void edit() {
		System.out.print("화초 수정 기능입니다.");
		System.out.print("식물 번호를 입력해주세요.");
		int plantNo = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 화초의 이름을 입력하세요.");
		String plantName = sc.nextLine();
		System.out.print("수정할 화초의 종류를 입력하세요.");
		String plantType = sc.nextLine();
		
		int result = pc.edit(plantNo, plantName, plantType);
		
		if(result > 0) {
			System.out.println("화초 정보를 변경하였습니다.");
		}else {
			System.out.println("화초 정보를 실패하였습니다.");
		}
	}
	private void delete() {
		System.out.println("화초 삭제 기능입니다.");
		System.out.print("식물 번호를 입력해주세요.");
		int plantNo = sc.nextInt();
		sc.nextLine();
		try {
			int result = pc.delete(plantNo);
			if(result > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	private void oneView() {
		System.out.println("화초 한개 조회 기능입니다.");
		System.out.print("식물 번호를 입력해주세요.");
		int plantNo = sc.nextInt();
		sc.nextLine();
		
		HousePlantDto result = pc.oneView(plantNo);
		if(result!=null) {
			System.out.println("====================================");
			System.out.println(" 식물번호 : " + result.getPlantNo());
			System.out.println(" 식물이름 : " + result.getPlantName());
			System.out.println(" 식물종류 : " + result.getPlantType());		
			}else {
			System.out.println("조회 실패");
		}
	}
	
	private void findByType() {
		System.out.println("화초 검색 기능입니다.");
		System.out.println("검색하고 싶은 키워드를 입력하세요.");
		String keyword = sc.nextLine();
		
		List<HousePlantDto> hpd = pc.findByType(keyword);
		
		if(hpd.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
			}else {
				for(HousePlantDto h : hpd) {
					System.out.println("====================================");
					System.out.println(" 식물번호 : " + h.getPlantNo());
					System.out.println(" 식물이름 : " + h.getPlantName());
					System.out.println(" 식물종류 : " + h.getPlantType());		
			}
			
		}
		
	}
}
