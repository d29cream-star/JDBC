package com.kh.animal.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.animal.controller.AnimalController;
import com.kh.animal.model.dto.AnimalDto;

public class AnimalView {

	private Scanner sc = new Scanner(System.in);
	private AnimalController ac = new AnimalController();

	public void mainMenu() {
		while(true) {
			System.out.println("동물 관리 프로그램");
			System.out.println("메뉴");
			System.out.println("1.동물 조회");
			System.out.println("2.동물 저장");
			System.out.print("메뉴 번호를 입력해주세요.");
			int menu = 0;
			
			try{
				menu = sc.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("숫자만 입력해주세요.");
			
			}finally {
			 sc.nextLine();	
			}
			switch(menu) {
			case 1 : read(); break;
			case 2 : save(); break;
			case 0 : System.out.println("프로그램 종료");sc.close();return;
			default: System.out.println("잘못 입력하셨습니다.");
			}
			
		}
		
	}
	public void read() {
		System.out.println("동물 정보 조회");
		List<AnimalDto> list = ac.read();
		if(list.isEmpty()) {
			System.out.println("정보 없음");
		}else {
			for(AnimalDto a : list) {
			System.out.println("동물 번호:" + a.getAnimalNo());
			System.out.println("동물 이름:" + a.getAnimalName());
		}
	}
}
	public void save() {
		System.out.print("동물이름을 입력해주세요.");
		String animalName = sc.nextLine();
		
		int result = ac.save(animalName);
		if(result < 0 ) {
			System.out.println("문제 발생");
		}else {
			System.out.println("정상작동");
		}
	}
	
}
