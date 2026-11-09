package com.kh.snackfood.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.snackfood.controller.FoodController;
import com.kh.snackfood.model.dto.FoodReviewDto;
import com.kh.snackfood.model.dto.SnackFoodDto;

public class FoodView {

	private FoodController fc = new FoodController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("분식점 리뷰 시스템");
			System.out.println("메뉴");
			System.out.println("1. 모든 분식 및 리뷰 조회 ");
			System.out.println("2. 분식 검색하기");
			System.out.println("3. 분식 저장");
			
			
			System.out.println("9. 프로그램 종료 ");
			
			System.out.print("메뉴 번호 입력");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" : selectFoodList(); break;
			case "2" : selectByCondition(); break;
			case "3" : insertFood(); break;
			
			
			case "9" : sc.close(); return;
			
			}
		}
	}
	private void selectFoodList() {
		List<SnackFoodDto> foods = fc.selectFoodList();
		
		if(foods.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		}else {
			for(SnackFoodDto s : foods) {
				System.out.println("============================");
				System.out.println(s.getFoodName() + "의 리뷰 목록");
				System.out.println("============================");
				List<FoodReviewDto> reviews = s.getReviews();
				
				if(reviews.isEmpty()) {
					System.out.println(s.getFoodName()+ "은(는) 리뷰가 존재하지 않습니다.");
				}else {
					for(FoodReviewDto r: reviews) {
						System.out.println("리뷰내용 :" + r.getReviewContent());
					}
				}
			}
		}
	}
	
	private void selectByCondition() {
		System.out.println("검색 조건을 설정해주세요.");
		System.out.print("1. 분식 메뉴/ 2. 리뷰작성자	 / 3. 리뷰내용	 >");
		String menuNo = sc.nextLine();
		System.out.print("검색하실 키워드를 입력해주세요.>");
		String keyword = sc.nextLine();
		/*
		Map<String, String> arguments = new HashMap();
		arguments.put("menuNo", menuNo);
		arguments.put("keyword", keyword);
		*/
		Map<String, String> arguments = Map.of("menuNo", menuNo,
											   "keyword", keyword);
		
		List<SnackFoodDto> foods = fc.selectByCondition(arguments);
		if(foods.isEmpty()) {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}else {
			for(SnackFoodDto s : foods) {
				System.out.println(s);
			}
		}
	}
	
	
	
	private void insertFood() {
		System.out.println("분식저장");
		System.out.print("번호");
		Long num = sc.nextLong();
		System.out.print("분식이름");
		String name = sc.nextLine();
		System.out.print("가격");
		Integer price = sc.nextInt(); 
		System.out.print("분식카테고리");
		String category = sc.nextLine();
	
		fc.insertFood(num, name, price, category);
	}
	
}
