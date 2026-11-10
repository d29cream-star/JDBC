package com.kh.subs.model.dto;

public class SubscriptionDto {

	private int subNo;
	private String subName;
	private int monthlyFee;
	private int paymentDay;
	private String category;
	
	public SubscriptionDto() {
		super();
	}
	public SubscriptionDto(String subName, int monthlyFee, int paymentDay, String category) {
		super();
		this.subName = subName;
		this.monthlyFee = monthlyFee;
		this.paymentDay = paymentDay;
		this.category = category;
	}
	public SubscriptionDto(int subNo, String subName, int monthlyFee, int paymentDay, String category) {
		super();
		this.subNo = subNo;
		this.subName = subName;
		this.monthlyFee = monthlyFee;
		this.paymentDay = paymentDay;
		this.category = category;
	}

	public int getSubNo() {
		return subNo;
	}
	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public int getMonthlyFee() {
		return monthlyFee;
	}
	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	public int getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(int paymentDay) {
		this.paymentDay = paymentDay;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "SubscriptionDto [subNo=" + subNo + ", subName=" + subName + ", monthlyFee=" + monthlyFee
				+ ", paymentDay=" + paymentDay + ", category=" + category + "]";
	}
	
	
}
