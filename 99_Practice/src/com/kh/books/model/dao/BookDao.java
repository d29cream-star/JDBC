package com.kh.books.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.books.model.dto.BookDto;

public class BookDao {

	public List<BookDto> selectAll(SqlSession session) {
		return session.selectList("bookMapper.selectAll");
	}

	public int insertBook(SqlSession session, BookDto bd) {
		return session.insert("bookMapper.insertBook", bd);
	}

	public int updatePrice(SqlSession session, BookDto bd) {
		return session.update("bookMapper.updatePrice", bd);
	}

	public int deleteBook(SqlSession session, Long ISBN) {
		return session.delete("bookMapper.deleteBook", ISBN);
	}

	public BookDto selectOne(SqlSession session, Long ISBN) {
		return session.selectOne("bookMapper.selectOne", ISBN);
	}
	public List<BookDto> searchByCategory(SqlSession session, String category){
		return session.selectList("bookMapper.searchByCategory", category);
	}
}
