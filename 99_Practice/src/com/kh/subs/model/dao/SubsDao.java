package com.kh.subs.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.subs.model.dto.SubscriptionDto;

public class SubsDao {

	public List<SubscriptionDto> selectAll(SqlSession session){
		return session.selectList("subsMapper.selectAll");
	}
	public int insertSub(SqlSession session, SubscriptionDto sd) {
		return session.insert("subsMapper.insertSub", sd);
	}
	public SubscriptionDto selectOne(SqlSession session, int subNo) {
		return session.selectOne("subsMapper.selectOne", subNo);
	}
	public int updateFee(SqlSession session, SubscriptionDto sd) {
		return session.update("subsMapper.updateFee", sd);
	}
	public int deleteSub(SqlSession session, int subNo) {
		return session.delete("subsMapper.deleteSub", subNo);
	}
	public List<SubscriptionDto> searchedByCategory(SqlSession session, String keyword){
		return session.selectList("subsMapper.searchedByCategory", keyword);
		
	}
	public int countByName(SqlSession session, String subName) {
		return session.selectOne("subsMapper.countByName", subName);
	}
}
