package com.kh.subs.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.subs.controller.SubsController;
import com.kh.subs.model.dto.SubscriptionDto;

public class SubsView {

	private SubsController ctrl = new SubsController();
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		while(true) {
			System.out.println("\n===구독 서비스 관리 프로그램===");
			System.out.println("1. 구독 전체 조회하기");
			System.out.println("2. 구독 추가하기");
			System.out.println("3. 구독 하나만 조회하기");
			System.out.println("4. 월 요금 변경하기");
			System.out.println("5. 구독 해지하기");
			System.out.println("6. 카테고리로 검색하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택하세요>");
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1" : selectAll(); break;
			case "2" : insertSub(); break;
			case "3" : selectOne(); break;
			case "4" : updateFee(); break;
			case "5" : deleteSub();break;
			case "6" : searchedByCategory(); break;
			case "0" : System.out.println("프로그램을 종료합니다."); sc.close(); return;
			default: System.out.println("존재하지 않는 메뉴입니다."); 
			}
		}
	}
	public void selectAll() {
		List<SubscriptionDto> list = ctrl.selectAll();
		if(list.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다.");
		}else {
			for(SubscriptionDto s : list) {
				System.out.println("==============================");
				System.out.println("구독번호 : " + s.getSubNo() + ", ");
				System.out.println("서비스명 : " + s.getSubName() + ", ");
				System.out.println("월 요금 : " + s.getMonthlyFee() + ", ");
				System.out.println("결제일 : " + s.getPaymentDay() + ", ");
				System.out.println("카테고리 : " + s.getCategory());
			}
		}
	}
	public void insertSub() {
		System.out.println("\n 구독 추가 서비스입니다.");
		System.out.print("서비스명을 입력하세요>");
		String subName = sc.nextLine();
		System.out.print("월 요금을 입력하세요(원)");
		int monthlyFee = 0;
		try {
			monthlyFee = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		System.out.print("결제일을 입력하세요.(1~31)");
		int paymentDay = 0;
		try {
			paymentDay = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		System.out.print("카테고리를 입력하세요(OTT/음악/쇼핑/기타)>");
		String category = sc.nextLine();
		
		try{
			int result = ctrl.insertSub(subName, monthlyFee, paymentDay, category);
		if(result > 0 ) {
			System.out.println("구독 추가에 성공했습니다.");
		}else {
			System.out.println("구독 추가에 실패했습니다.");
		}
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
	public void selectOne() {
		System.out.println("\n구독 조회 서비스입니다.");
		System.out.print("조회할 구독번호를 입력하세요>");
		int subNo = 0;
		try {
			subNo = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		SubscriptionDto sd = ctrl.selectOne(subNo);
		if(sd != null) {
			System.out.println("검색결과입니다.");
			System.out.println("서비스명 : " + sd.getSubName());
			System.out.println("월 요금 : " + sd.getMonthlyFee() + "원");
			System.out.println("결제일 : 매월 " + sd.getPaymentDay() + "일");
			System.out.println("카테고리 : " + sd.getCategory());
		}else {
			System.out.println("존재하지 않는 구독번호입니다.");
		}
	}
	public void updateFee() {
		System.out.println("\n월 요금 변경 서비스입니다.");
		System.out.print("변경할 구독 번호를 입력하세요.>");
		int subNo = 0;
		try {
			subNo = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		System.out.print("새 월 요금을 입력하세요(원)>");
		int monthlyFee = 0;
		try {
			monthlyFee = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		int result = ctrl.updateFee(subNo, monthlyFee);
		if(result > 0) {
			System.out.println("요금 변경에 성공하셨습니다.");
		}else {
			System.out.println("요금 변경에 실패하셨습니다.");
		}
	}
	public void deleteSub() {
		System.out.println("\n구독 해지 서비스입니다.");
		System.out.print("해지할 구독번호를 입력하세요>");
		int subNo = 0;
		try {
			subNo = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		int result = ctrl.deleteSub(subNo);
		if(result > 0 ) {
			System.out.println("구독 해지에 성공하셨습니다.");
		}else {
			System.out.println("구독 해지에 실패하셨습니다.");
		}
	}
	public void searchedByCategory() {
		System.out.print("\n검색할 카테고리를 입력하세요 >");
		String keyword = sc.nextLine();
		
		List<SubscriptionDto> list = ctrl.searchedByCategory(keyword);
		
		if(list.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다.");
		}else {
			for(SubscriptionDto s : list) {
				System.out.println(s);
			}
		}
	}
	
}
