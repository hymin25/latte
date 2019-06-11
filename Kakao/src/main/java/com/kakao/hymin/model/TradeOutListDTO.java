package com.kakao.hymin.model;

import java.util.ArrayList;

public class TradeOutListDTO {
	private String year;
	private ArrayList<TradeOutDTO> filelist;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public ArrayList<TradeOutDTO> getFilelist() {
		return filelist;
	}
	public void setFilelist(ArrayList<TradeOutDTO> filelist) {
		this.filelist = filelist;
	}

}
