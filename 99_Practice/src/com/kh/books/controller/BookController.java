package com.kh.books.controller;

import java.util.List;

import com.kh.books.model.dto.BookDto;
import com.kh.books.model.service.BookService;

public class BookController {

	private BookService bs = new BookService();
	
	public List<BookDto> selectAll(){
		return bs.selectAll();
	}
	public int insertBook(Long ISBN, String bookName, String auther, int price, String publisher, String category, String createDate) {
		BookDto bd = new BookDto(ISBN, bookName, auther, price, publisher, category,createDate);
		return bs.insertBook(bd);
	}
	public int updatePrice(Long ISBN, int price) {
		BookDto bd = new BookDto();
		bd.setISBN(ISBN);
		bd.setPrice(price);
		return bs.updatePrice(bd);
	}
	public int deleteBook(Long ISBN) {
		return bs.deleteBook(ISBN);
	}
	public BookDto selectOne(Long ISBN) {
		return bs.selectOne(ISBN);
	}
	public List<BookDto> searchByCategory(String category){
		return bs.searchByCategory(category);
	}
}
