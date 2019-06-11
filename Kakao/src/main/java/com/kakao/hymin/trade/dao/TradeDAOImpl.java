package com.kakao.hymin.trade.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kakao.hymin.model.TradeOutDTO;

@Repository
public class TradeDAOImpl implements TradeDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;	
	
	@Override
	public List<HashMap<String, Object>> getTradeCustList() throws Exception{
		return sqlSession.selectList("com.kakao.hymin.trade.tradeMapper.getTradeCustList");
	}
	
	@Override
	public List<HashMap<String, Object>> getNoTradeCustList() throws Exception {
		return sqlSession.selectList("com.kakao.hymin.trade.tradeMapper.getNoTradeCustList");
	}

	@Override
	public List<TradeOutDTO> getTradeSumList() throws Exception {
		return sqlSession.selectList("com.kakao.hymin.trade.tradeMapper.getTradeSumList");
	}

	@Override
	public HashMap<String, Object> getBranchSumInfo(String brName) throws Exception {
		return sqlSession.selectOne("com.kakao.hymin.trade.tradeMapper.getBranchSumInfo", brName);
	}
	
	@Override
	public HashMap<String, Object> getBranchSumInfo2() throws Exception {
		return sqlSession.selectOne("com.kakao.hymin.trade.tradeMapper.getBranchSumInfo2");
	}

}
