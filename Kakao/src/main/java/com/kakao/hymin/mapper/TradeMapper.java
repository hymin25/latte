package com.kakao.hymin.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kakao.hymin.model.TradeOutDTO;

public interface TradeMapper {
	
	@Select("select aa.trade_year as year , a.accnt_nm as name, aa.accnt_no as acctNo, aa.sum_amt as sumAmt\r\n" + 
			"from (\r\n" + 
			"	select row_number() over (partition by tt.trade_year order by tt.sum_amt desc) as rnum,\r\n" + 
			"    tt.*\r\n" + 
			"	from (\r\n" + 
			"		select substr(trade_dt,1,4) trade_year, t.accnt_no, sum(t.trade_amt - t.trade_fee) sum_amt\r\n" + 
			"		from db1.tbl_trade t\r\n" + 
			"		where t.cncl_yn = 'N'\r\n" + 
			"		group by trade_year, t.accnt_no\r\n" + 
			"    )TT\r\n" + 
			")AA, db1.tbl_accnt a\r\n" + 
			"where aa.accnt_no = a.accnt_no\r\n" + 
			"and rnum = 1\r\n" + 
			"order by year")
    public List<HashMap<String, Object>> getTradeCustList();	// API1
	
	@Select("SELECT '2018' as year, a.accnt_nm as name, a.accnt_no as acctNo\r\n" + 
			"FROM db1.tbl_accnt a LEFT outer JOIN db1.tbl_trade t \r\n" + 
			"ON a.accnt_no = t.accnt_no and t.trade_dt like'2018%' and t.cncl_yn = 'N'\r\n" + 
			"where t.accnt_no is null\r\n" + 
			"union all\r\n" + 
			"SELECT '2019' as year, a.accnt_nm as name, a.accnt_no as acctNo\r\n" + 
			"FROM db1.tbl_accnt a LEFT outer JOIN db1.tbl_trade t \r\n" + 
			"ON a.accnt_no = t.accnt_no and t.trade_dt like'2019%' and t.cncl_yn = 'N'\r\n" + 
			"where t.accnt_no is null")
    public List<HashMap<String, Object>> getNoTradeCustList();	// API2
	
	@Select("select substr(t.trade_dt,1,4) as year, b.branch_cd as brCode, b.branch_nm as brName, sum(t.trade_amt - t.trade_fee) as sumAmt\r\n" + 
			"from db1.tbl_trade t, db1.tbl_accnt a, db1.tbl_branch b\r\n" + 
			"where t.accnt_no = a.accnt_no\r\n" + 
			"and a.branch_cd = b.branch_cd\r\n" + 
			"and t.cncl_yn = 'N'\r\n" + 
			"group by substr(t.trade_dt,1,4), b.branch_cd, b.branch_nm\r\n" + 
			"order by substr(t.trade_dt,1,4), sumAmt desc")
    public List<TradeOutDTO> getTradeSumList();	// API3
	
	@Select("select b.branch_nm as brName, b.branch_cd as brCode, sum(t.trade_amt - t.trade_fee) as sumAmt\r\n" +
			"		from db1.tbl_trade t, db1.tbl_accnt a, db1.tbl_branch b\r\n" + 
			"		where t.accnt_no = a.accnt_no\r\n" + 
			"		and a.branch_cd = b.branch_cd\r\n" + 
			"		and t.cncl_yn = 'N'\r\n" + 
			"		and b.branch_nm = #{branch_nm} \r\n" + 
			"		group by b.branch_cd, b.branch_nm")
	public HashMap<String, Object> getBranchSumInfo(String branch_nm);	// API4
	
	@Select("select '판교점' as brName, 'A' as brCode, sum(t.trade_amt - t.trade_fee) as sumAmt\r\n" + 
			"from db1.tbl_trade t, db1.tbl_accnt a, db1.tbl_branch b\r\n" + 
			"where t.accnt_no = a.accnt_no\r\n" + 
			"and a.branch_cd = b.branch_cd\r\n" + 
			"and t.cncl_yn = 'N'\r\n" + 
			"and b.branch_nm in('분당점','판교점')")
	public HashMap<String, Object> getBranchSumInfo2();	// API4-2


}
