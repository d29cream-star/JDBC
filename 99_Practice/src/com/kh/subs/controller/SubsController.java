package com.kh.subs.controller;

import java.util.List;

import com.kh.subs.model.dto.SubscriptionDto;
import com.kh.subs.model.service.SubsService;

public class SubsController {

	private SubsService ss = new SubsService();
	
	public List<SubscriptionDto> selectAll(){
		return ss.selectAll();
	}
	public int insertSub(String subName, int monthlyFee, int paymentDay, String category) {
		
		SubscriptionDto sd = new SubscriptionDto(subName, monthlyFee, paymentDay, category);
		return ss.insertSub(sd);
	}
	public SubscriptionDto selectOne(int subNo) {
		return ss.selectOne(subNo);
	}
	public int updateFee(int subNo, int monthlyFee) {
		SubscriptionDto sd = new SubscriptionDto();
		sd.setSubNo(subNo);
		sd.setMonthlyFee(monthlyFee);
		return ss.updateFee(sd);
	}
	public int deleteSub(int subNo) {
		return ss.deleteSub(subNo);
	}
	public List<SubscriptionDto> searchedByCategory(String keyword){
		return ss.searchedByCategory(keyword);
	}

}
