package com.kh.books.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.books.controller.BookController;
import com.kh.books.exception.InvalidPriceException;
import com.kh.books.model.dto.BookDto;

public class BookView {

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("도서관 책관리 시스템");
			System.out.println("1. 책 전체 조회");
			System.out.println("2. 책 추가하기");
			System.out.println("3. 책 가격 수정하기");
			System.out.println("4. 책 삭제하기	");
			System.out.println("5. 책 한권 검색하기");
			System.out.println("6. 책 카테고리 검색하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴번호를 입력해주세요>");
			int menuNum = 0;
			try {
				menuNum = sc.nextInt();
			}catch(InputMismatchException e) {
				e.printStackTrace();
				continue;
			}finally {
				sc.nextLine();
			}
			switch(menuNum) {
			case 1 : selectAll(); break;
			case 2 : insertBook(); break;
			case 3 : updatePrice(); break;
			case 4 : deleteBook(); break;
			case 5 : selectOne(); break;
			case 6 : searchByCategory(); break;
			case 0 : System.out.println("프로그램 종료"); sc.close(); return;
			default: System.out.println("잘못 입력하셨습니다.");		
			}
		}
	}
	public void selectAll() {
		System.out.println("전체 검색 시스템입니다.");
		List<BookDto> list = bc.selectAll();
		if(list.isEmpty()) {
			System.out.println("조회하신 결과가 없습니다.");
		}else {
			for(BookDto b : list) {
				System.out.println("ISBN : " + b.getISBN());
				System.out.println("제목 : " + b.getBookName());
				System.out.println("저자 : " + b.getAuther());
				System.out.println("가격 : " + b.getPrice());
				System.out.println("출판사: " + b.getPublisher());
				System.out.println("카테고리 : " + b.getCategory());
				System.out.println("출판일 : " + b.getCreateDate());
				System.out.println("==============================");
				
			}
		}
	}
	public void insertBook() {
		System.out.println("책 등록 서비스입니다.");
		System.out.print("ISBN 번호를 입력해주세요");
		Long ISBN = null;
		try {
		sc.nextLong();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}catch(NullPointerException e	) {
			e.printStackTrace();
		}
		finally {
			sc.nextLine();
		}
		System.out.print("제목을 입력해주세요>");
		String bookName = sc.nextLine();
		System.out.print("저자를 입력해주세요.>");
		String auther = sc.nextLine();
		System.out.print("가격을 입력해주세요.>")	;
		int price = 0;
		try {
			price = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}catch(InvalidPriceException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
			
		}System.out.print("출판사를 입력해주세요.>");
		String publisher = sc.nextLine();
		System.out.print("카테고리를 입력해주세요.>");
		String category = sc.nextLine();
		System.out.print("출판일을 입력해주세요.>");
		String createDate = sc.nextLine();
		
		int result = bc.insertBook(ISBN, bookName, auther, price, publisher, category, createDate);
		if(result > 0) {
			System.out.println("책등록이 완료되었습니다.");
		}else {
			System.out.println("책등록에 실패했습니다.");
		}
	}
	public void updatePrice() {
		System.out.println("책 가격 수정 서비스");
		System.out.print("수정할 ISBN을 입력하세요.");
		Long ISBN = null;
		try {
			ISBN = sc.nextLong();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}System.out.print("수정하실 가격을 입력해주세요.");
		int price = 0;
		try {
			price = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		int result = bc.updatePrice(ISBN, price);
		if(result > 0) {
			System.out.println("가격 수정이 완료되었습니다.");
		}else {
			System.out.println("가격 수정에 실패했습니다.");
		}
	}
	public void deleteBook() {
		System.out.println("책 삭제 서비스");
		System.out.print("삭제하실 책의 ISBN을 입력해주세요.>");
		Long ISBN = null;
		try {
			ISBN = sc.nextLong();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		int result = bc.deleteBook(ISBN);
		if(result > 0 ) {
			System.out.println("책 삭제가 완료되었습니다.");
		}else {
			System.out.println("책 삭제에  실패했습니다.");
		}
	}
	public void selectOne() {
		System.out.println("책 한권 검색 서비스");
		System.out.print("검색하실 ISBN을 입력해주세요.");
		Long ISBN = null;
		try{
			ISBN = sc.nextLong();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		BookDto bd = bc.selectOne(ISBN);
		
	}
	public void searchByCategory() {
		System.out.println("카테고리별 검색");
		System.out.print("카테고리를 입력해주세요.");
		String category = sc.nextLine();
		List<BookDto> list = bc.searchByCategory(category);
		if(list.isEmpty()) {
			System.out.println("조회결과가 없습니다.");
		}else {
			for(BookDto b : list) {
				System.out.println("ISBN : " + b.getISBN());
				System.out.println("제목 : " + b.getBookName());
				System.out.println("저자 : " + b.getAuther());
				System.out.println("가격 : " + b.getPrice());
				System.out.println("출판사: " + b.getPublisher());
				System.out.println("카테고리 : " + b.getCategory());
				System.out.println("출판일 : " + b.getCreateDate());
				System.out.println("==============================");
			}
		}
	}
	public void searchByCondition() {
		System.out.println("키워드로 검색하기");
		System.out.println("1. 제목");
		System.out.println("2. 저자");
		System.out.println("3. 출판사");
		System.out.println("4. 카테고리");
		System.out.print("메뉴 번호를 입력해주세요.");
		int menu = 0;
		try {
			menu = sc.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
			sc.nextLine();
		}
		System.out.print("키워드를 입력해주세요.");
	}
}
