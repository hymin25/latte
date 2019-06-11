package com.kakao.hymin.trade;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kakao.hymin.model.TradeOutListDTO;
import com.kakao.hymin.trade.service.TradeService;

@Controller
public class TradeController {
	
	@Inject
	private TradeService tService;
	
	@RequestMapping(value = "/trade", method = RequestMethod.GET)
    public String index() {
        return "trade/index";
    }		
		
	// API1
	@RequestMapping(value = "/trade/api_1", method = RequestMethod.GET)
	public @ResponseBody List<HashMap<String, Object>> getTradeCustList() throws Exception {
		return tService.getTradeCustList();
	}
	
	// API2
	@RequestMapping(value = "/trade/api_2", method = RequestMethod.GET)
	public @ResponseBody List<HashMap<String, Object>> getNoTradeCustList() throws Exception {
		return tService.getNoTradeCustList();
	}
	
	// API3
	@RequestMapping(value = "/trade/api_3", method = RequestMethod.GET)
	public @ResponseBody List<TradeOutListDTO> getTradeSumList() throws Exception {
		return tService.getTradeSumList();
	}
	
	 //API4
	@ResponseBody
	@RequestMapping(value = "/trade/api_4", method = RequestMethod.GET)
	public HashMap<String, Object> getBranchSumInfo(@RequestParam("brName") String brName) throws Exception {
		return tService.getBranchSumInfo(brName);		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public String exceptionHandler(Model model, Exception e){
		model.addAttribute("exception", e);
		model.addAttribute("code", "404");
		model.addAttribute("메세지", e.getMessage());
		return "error/exception";

	}
}
