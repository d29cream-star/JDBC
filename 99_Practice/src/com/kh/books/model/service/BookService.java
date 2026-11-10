package com.kh.books.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.books.model.dao.BookDao;
import com.kh.books.model.dto.BookDto;
import com.kh.common.Template;

public class BookService {

	public List<BookDto> selectAll(){
		SqlSession session = Template.getSqlSession();
		try {
			List<BookDto> list = new BookDao().selectAll(session);
			return list;
		}finally {
			session.close();
		}
	}
	public int insertBook(BookDto bd) {
		SqlSession session = Template.getSqlSession();
		try {
			int result = new BookDao().insertBook(session, bd);
			return result;
		}finally {
			session.close();
		}
		
	}
	public int updatePrice(BookDto bd) {
		SqlSession session = Template.getSqlSession();
		try {
			int result = new BookDao().updatePrice(session, bd);
			return result;
		}finally {
			session.close();
		}
	}
	public int deleteBook(Long ISBN) {
		SqlSession session = Template.getSqlSession();
		try {
			int result = new BookDao().deleteBook(session, ISBN);
			return result;
		}finally {
			session.close();
		}
	}
	public BookDto selectOne(Long ISBN)	{
		SqlSession session = Template.getSqlSession();
		try {
			BookDto bd = new BookDao().selectOne(session, ISBN);
			return bd;
		}finally {
			session.close();
		}
	}
	public List<BookDto> searchByCategory(String category){
		SqlSession session = Template.getSqlSession();
		try {
			List<BookDto> list = new BookDao().searchByCategory(session, category);
			return list;
		}finally {
			session.close();
		}
	
	
	}
}
