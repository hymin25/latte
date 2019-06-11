package com.kakao.hymin.trade.dao;

import java.util.HashMap;
import java.util.List;

import com.kakao.hymin.model.TradeOutDTO;

public interface TradeDAO {
	
	// API1	
	public List<HashMap<String, Object>> getTradeCustList() throws Exception;
	
	// API2
	public List<HashMap<String, Object>> getNoTradeCustList() throws Exception;
	
	// API3
	public List<TradeOutDTO> getTradeSumList() throws Exception;
	
	// API4
	public HashMap<String, Object> getBranchSumInfo(String brName) throws Exception;
	
	// API4-2
	public HashMap<String, Object> getBranchSumInfo2() throws Exception;

}
