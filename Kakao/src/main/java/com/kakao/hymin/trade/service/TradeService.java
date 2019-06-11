package com.kakao.hymin.trade.service;

import java.util.HashMap;
import java.util.List;

import com.kakao.hymin.model.TradeOutListDTO;

public interface TradeService {
	
	// API1	
	public List<HashMap<String, Object>> getTradeCustList() throws Exception;
	
	// API2
	public List<HashMap<String, Object>> getNoTradeCustList() throws Exception;
	
	// API3
	public List<TradeOutListDTO> getTradeSumList() throws Exception;
	
	// API4
	public HashMap<String, Object> getBranchSumInfo(String brName) throws Exception;	

}
