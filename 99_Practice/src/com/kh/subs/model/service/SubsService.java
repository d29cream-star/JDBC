package com.kh.subs.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.subs.model.dao.SubsDao;
import com.kh.subs.model.dto.SubscriptionDto;

public class SubsService {

	public List<SubscriptionDto> selectAll() {
		SqlSession session = Template.getSqlSession();
		try {
			List<SubscriptionDto> list = new SubsDao().selectAll(session);
			return list;
		} finally {
			session.close();
		}
	}

	public int insertSub(SubscriptionDto sd) {
		validateSubscription(sd);
		SqlSession session = Template.getSqlSession();
		if (new SubsDao().countByName(session, sd.getSubName()) > 0) {
			session.close();
			throw new RuntimeException("이미 구독중인 서비스입니다.");
		}
		try {
			int result = new SubsDao().insertSub(session, sd);
			return result;
		} finally {
			session.close();
		}

	}

	public SubscriptionDto selectOne(int subNo) {
		validateSubNo(subNo);
		SqlSession session = Template.getSqlSession();
		try {
			SubscriptionDto sd = new SubsDao().selectOne(session, subNo);
			return sd;
		} finally {
			session.close();
		}
	}

	public int updateFee(SubscriptionDto sd) {
		validateSubNo(sd.getSubNo());
		SqlSession session = Template.getSqlSession();
		try {
			int result = new SubsDao().updateFee(session, sd);
			return result;
		} finally {
			session.close();
		}
	}

	public int deleteSub(int subNo) {
		validateSubNo(subNo);
		SqlSession session = Template.getSqlSession();
		try{
			int result = new SubsDao().deleteSub(session, subNo);
			return result;
		}finally {
			session.close();
		}
	}

	public List<SubscriptionDto> searchedByCategory(String keyword) {
		SqlSession session = Template.getSqlSession();
		try{
			List<SubscriptionDto> list = new SubsDao().searchedByCategory(session, keyword);
			return list;
		}finally {
			session.close();
		}
	}

	public List<SubscriptionDto> searchByCondition(int subNo, String keyword) {
		Map<String, Object> param = new HashMap<>();
		param.put("subNo", subNo);
		param.put("keyword", keyword);
		SqlSession session = Template.getSqlSession();
		try{
			List<SubscriptionDto> list = session.selectList("subsMapper.searchByCondition", param);
			return list;
		}finally {
			session.close();
		}
	}

	private void validateSubscription(SubscriptionDto sd) {
		checkNull(sd);
		checkSubName(sd);
		checkMonthlyFee(sd);
		checkPaymentDay(sd);
	}

	private void checkNull(SubscriptionDto sd) {
		if (sd == null) {
			throw new RuntimeException("잠시 후 다시 시도해주세요.");
		}
	}

	private void checkSubName(SubscriptionDto sd) {
		if (sd.getSubName().isBlank() || sd.getSubName().length() > 50) {
			throw new RuntimeException("유효하지 않은 서비스명입니다.");
		}
	}

	private void checkMonthlyFee(SubscriptionDto sd) {
		if (sd.getMonthlyFee() <= 0) {
			throw new RuntimeException("월 요금은 0보다 커야 합니다.");
		}
	}

	private void checkPaymentDay(SubscriptionDto sd) {
		if (sd.getPaymentDay() < 1 || sd.getPaymentDay() > 31) {
			throw new RuntimeException("결제일은 1일부터 31일 사이여야 합니다.");
		}
	}

	private void validateSubNo(int subNo) {
		if (subNo < 1) {
			throw new RuntimeException("구독번호는 1보다 작을 수 없습니다.");
		}
	}
}
