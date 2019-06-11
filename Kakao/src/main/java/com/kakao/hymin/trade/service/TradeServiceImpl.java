package com.kakao.hymin.trade.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import com.kakao.hymin.model.TradeOutDTO;
import com.kakao.hymin.model.TradeOutListDTO;
import com.kakao.hymin.trade.dao.TradeDAO;

@Service
public class TradeServiceImpl implements TradeService {
	
	@Inject
	private TradeDAO tradeDAO;
	
	// API1
	@Override
	public List<HashMap<String, Object>> getTradeCustList() throws Exception{
		return tradeDAO.getTradeCustList();
	}
		
	// API2
	@Override
	public List<HashMap<String, Object>> getNoTradeCustList() throws Exception{
		return tradeDAO.getNoTradeCustList();
	}
	
	// API3
	@Override
	public List<TradeOutListDTO> getTradeSumList() throws Exception{
		List<TradeOutListDTO> returnList = new ArrayList<TradeOutListDTO>();
		TradeOutListDTO outList = new TradeOutListDTO();
		ArrayList<TradeOutDTO> addList = new ArrayList<TradeOutDTO>();
		
		List<TradeOutDTO> resultList =  tradeDAO.getTradeSumList();
		
		for(int i=0; i<resultList.size();i++){
			addList.add(resultList.get(i));
			
			if(i==resultList.size()-1) {
				outList.setYear(resultList.get(i).getYear());
				outList.setFilelist(addList);
				returnList.add(outList);
				outList = new TradeOutListDTO();
				addList = new ArrayList<TradeOutDTO>();
			}else {
				if(!resultList.get(i).getYear().equals(resultList.get(i+1).getYear())) {
					outList.setYear(resultList.get(i).getYear());
					outList.setFilelist(addList);
					returnList.add(outList);
					outList = new TradeOutListDTO();
					addList = new ArrayList<TradeOutDTO>();
				}
			}
		}
		return returnList;
	}
	
	// API4
	@Override
	public HashMap<String, Object> getBranchSumInfo(String brName) throws Exception{
		HashMap<String, Object> result = null;
		
		if(brName.equals("판교점")) {
			result= tradeDAO.getBranchSumInfo2();
		}else if(brName.equals("분당점")){
			result = new HashMap<String, Object>();
			result.put("code", "404");
			result.put("메세지", "br code not found error");
			
			//throw new NotFoundException("br code not found error");
		}else {
			result= tradeDAO.getBranchSumInfo(brName);
		}
		return result;
	}
}
