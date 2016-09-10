




package com.jfxy.dao;



import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Batch;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.RptMem;
import com.jfxy.pojo.SendCards;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.RptMemFormBean;






public interface MemDao {


	public boolean createMem(Mem mem);

	public void updateMem(Mem mem);

	public void deleteMem(long memIds);
	
	public int getMemCount(MemFormBean formBean);


	public List<Mem> getMemList(MemFormBean formBean);
	
	
	public Mem queryMembyId(long id);
	
	
	public void updateMemMoney(Mem mem);

	
	public Integer validateMemCard(String value);
	
	public Integer validateMobile(String value);
	
	public boolean createMemsjzx(Mem mem);
	
	
	public List<Mem> pageOrderList(MemFormBean memFormBean);
	
	public void  updateMemCard(Mem mem);
	public boolean createMemsplfk(SendCards sendCards);
	
	public Integer updateMemlock(Mem mem);
	public Integer updateMemDelayTime(Mem mem);
	
	public Integer countRptMem(RptMemFormBean rptMemFormBean);
	
	public List<RptMem> pageListRptMem(RptMemFormBean rptMemFormBean);
	
	public Integer batchCreateMem(Batch batchMem);
	
	
	public Integer validateMemCardpassword(Map<String, Object> map);
}
