package com.kakao.hymin;

import java.util.HashMap;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kakao.hymin.model.TradeOutDTO;
import com.kakao.hymin.trade.dao.TradeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TradeDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TradeDAOTest.class);

	private TradeDAO tradeDAO;
	
	@Test
	public void testGetTradeCustList() throws Exception {
		
		List<HashMap<String, Object>> tradeList = tradeDAO.getTradeCustList();

		logger.info("\n trade List \n ");

		if(tradeList.size() > 0) {
			for(HashMap<String, Object> map : tradeList) {
				logger.info(map.toString());
			}
		} else {
			logger.info("NO DATA");
		}
	}
	
	@Test @Ignore
	public void testGetNoTradeCustList() throws Exception {

		List<HashMap<String, Object>> tradeList = tradeDAO.getNoTradeCustList();

		logger.info("\n trade List \n ");

		if(tradeList.size() > 0) {
			for(HashMap<String, Object> map : tradeList) {
				logger.info(map.toString());
			}
		} else {
			logger.info("NO DATA");
		}
	}
	
	@Test @Ignore
	public void testGetTradeSumList() throws Exception {

		List<TradeOutDTO> tradeList = tradeDAO.getTradeSumList();

		logger.info("\n trade List \n ");

		if(tradeList.size() > 0) {
			for(TradeOutDTO out : tradeList) {
				logger.info("getBrName : " + out.getBrName() );
				logger.info("getBrCode : " + out.getBrCode() );
				logger.info("getSumAmt : " + out.getSumAmt() );
			}
		} else {
			logger.info("NO DATA");
		}
	}
	
	@Test @Ignore
	public void testGetBranchSumInfo() throws Exception {
		String brName="강남점";

		HashMap<String, Object> tradeList = tradeDAO.getBranchSumInfo(brName);

		logger.info("\n trade List \n ");

		if(tradeList.size() > 0) {			
				logger.info(tradeList.toString());
		} else {
			logger.info("NO DATA");
		}
	}
	
	@Test @Ignore
	public void testGetBranchSumInfo2() throws Exception {	

		HashMap<String, Object> tradeList = tradeDAO.getBranchSumInfo2();

		logger.info("\n trade List \n ");

		if(tradeList.size() > 0) {			
				logger.info(tradeList.toString());
		} else {
			logger.info("NO DATA");
		}
	}

}
