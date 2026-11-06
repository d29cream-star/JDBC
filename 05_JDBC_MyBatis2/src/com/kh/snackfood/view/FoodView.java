package com.kh.snackfood.view;

import java.util.Scanner;

import com.kh.snackfood.controller.FoodController;

public class FoodView {

	private FoodController fc = new FoodController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("분식점 리뷰 시스템");
			System.out.println("메뉴");
			System.out.println("1. 모든 분식 및 리뷰 조회 ");
			System.out.println("2. ");
			
			
			System.out.println("9. 프로그램 종료 ");
			
			System.out.print("메뉴 번호 입력");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" : selectFoodList(); break;
			
			
			
			case "9" : sc.close(); return;
			
			}
		}
	}
	private void selectFoodList() {
		fc.selectFoodList();
	}
	
}
