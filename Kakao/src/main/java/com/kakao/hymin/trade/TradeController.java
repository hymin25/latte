package com.kakao.hymin.trade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakao.hymin.mapper.TradeMapper;
import com.kakao.hymin.model.TradeOutDTO;
import com.kakao.hymin.model.TradeOutListDTO;

@Controller
public class TradeController {
	
	@Autowired
    private TradeMapper tradeMapper;
	
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
    public String index() {
        return "trade/index";
    }		
		
	// API1
	@RequestMapping(value = "/trade/api_1", method = RequestMethod.GET)
	public @ResponseBody List<HashMap<String, Object>> getTradeCustList() {
		return tradeMapper.getTradeCustList();
	}
	
	// API2
	@RequestMapping(value = "/trade/api_2", method = RequestMethod.GET)
	public @ResponseBody List<HashMap<String, Object>> getNoTradeCustList() {
		return tradeMapper.getNoTradeCustList();
	}
	
	// API3
	@RequestMapping(value = "/trade/api_3", method = RequestMethod.GET)
	public @ResponseBody List<TradeOutListDTO> getTradeSumList() {		
		
		List<TradeOutListDTO> returnList = new ArrayList<TradeOutListDTO>();
		TradeOutListDTO outList = new TradeOutListDTO();
		ArrayList<TradeOutDTO> addList = new ArrayList<TradeOutDTO>();
		
		List<TradeOutDTO> resultList =  tradeMapper.getTradeSumList();
		
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
	
	 //API4
	@ResponseBody
	@RequestMapping(value = "/trade/api_4", method = RequestMethod.GET)
	public HashMap<String, Object> getBranchSumInfo(@RequestParam("brName") String brName) {
		HashMap<String, Object> result = null;
		
		if(brName.equals("판교점")) {
			result= tradeMapper.getBranchSumInfo2();
		}else if(brName.equals("분당점")){
			result = new HashMap<String, Object>();
			result.put("code", "404");
			result.put("메세지", "br code not found error");
		}else {
			result= tradeMapper.getBranchSumInfo(brName);
		}
		return result;
	}

}
