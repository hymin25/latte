package com.kakao.hymin.model;

public class TradeOutDTO {
	
	private String year;
	private int sumAmt;
	
	private String brName;
	private String brCode;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(int sumAmt) {
		this.sumAmt = sumAmt;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
}
