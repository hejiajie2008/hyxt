package com.jfxy.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.MemChangeCard;
import com.jfxy.pojo.MemExcel;
import com.jfxy.pojo.Memcount;
import com.jfxy.pojo.Memdrawmoney;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.Memrecharge;
import com.jfxy.pojo.SendCards;
import com.jfxy.pojo.form.MemFormBean;
import com.jfxy.pojo.form.MemlevelFormBean;
import com.jfxy.pojo.form.MemrechargeFormBean;
/**
 * 
 * 会员模块业务层
 * 
 * @author  hejiajie
 * @version  2.0, 2016年3月8日
 */
public interface MemService {

	@Transactional 
	public Integer createMem(Mem mem);
	
	
	@Transactional
	public boolean createMem(List<Mem>  mems);
	
	@Transactional
	public boolean createMemExcel(List<MemExcel>  mems);

	public MemFormBean getPage(MemFormBean memFormBean);
	
	public MemlevelFormBean getPage(MemlevelFormBean memLevelFormBean);
	public MemrechargeFormBean getPage(MemrechargeFormBean memrechargeFormBean);
	@Transactional
	public boolean deleteMem(long memId);
	
	public List<Memlevel> getList();
	@Transactional
	public void saveMemLevel(Memlevel memlevel);
	@Transactional
	public void deleteMemLevel(int memLevelId,int shopid);
	@Transactional
	public void updateMemLevel(Memlevel memlevel);
	
	public Memlevel findMemLevel(int memlevelid);
	
	public Mem findMem(Long  memid);
	@Transactional
	public void updateMem(Mem mem);
	
	public List<GoodsClassRebat> queryGoodsClass(Map<String, Integer> map);
	
	public List<GoodsClassRebat> queryGoodsClassforA(Map<String, Integer> map);
	
	public List<Mem> findMem(MemFormBean memFormBean);
	@Transactional
	public void saveMemRecharge(Memrecharge memrecharge);
	
	
	public Integer saveDrawMoney(Memdrawmoney memdrawmoney);
	
	public Integer changeCard(MemChangeCard memChangeCard);
	public Integer changePwd(MemChangeCard memChangeCard);
	
	public Integer sendCards(SendCards sendCards);
	
	
	public Integer saveMemLock(Integer memid,Integer state,String remark);
	
	
	public Integer saveDelayTime(Integer memid,String newPastTime,String remark);
	public Integer  saveMemCount(Memcount memcount);
	

	
}
