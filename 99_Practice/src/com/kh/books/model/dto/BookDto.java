package com.kh.books.model.dto;

import java.sql.Date;

public class BookDto {

	private Long ISBN;
	private String bookName;
	private String auther; //철자 잘못썼다!!
	private int price;
	private String publisher;
	private String category;
	private String createDate;
	
			
	public BookDto() {
		super();
	}

	public BookDto(String bookName, String auther, int price, String publisher, String category, String createDate) {
		super();
		this.bookName = bookName;
		this.auther = auther;
		this.price = price;
		this.publisher = publisher;
		this.category = category;
		this.createDate = createDate;
	}

	public BookDto(Long iSBN, String bookName, String auther, int price, String publisher, String category,
			String createDate) {
		super();
		ISBN = iSBN;
		this.bookName = bookName;
		this.auther = auther;
		this.price = price;
		this.publisher = publisher;
		this.category = category;
		this.createDate = createDate;
	}

	public Long getISBN() {
		return ISBN;
	}

	public void setISBN(Long iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BookDto [ISBN=" + ISBN + ", bookName=" + bookName + ", auther=" + auther + ", price=" + price
				+ ", publisher=" + publisher + ", category=" + category + ", createDate=" + createDate + "]";
	}
	
	
	
}
