package com.jfxy.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfxy.dao.MemDao;
import com.jfxy.dao.PointgiftDao;
import com.jfxy.dao.PointlogDao;
import com.jfxy.pojo.Mem;
import com.jfxy.pojo.Pointgift;
import com.jfxy.pojo.Pointlog;
import com.jfxy.pojo.form.PointgiftFormBean;
import com.jfxy.util.Pagination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jfxy.dao.GiftclassDao;
import com.jfxy.pojo.Giftclass;
import com.jfxy.service.PointManagerService;

/**
 * 
 * 礼品分类模块业务层
 * 
 * @author wangkun
 * @version 1.0, 2016年3月10日
 */
@Transactional
@Service
public class PointManagerServiceImpl implements PointManagerService {
	@Autowired
	private GiftclassDao giftclassDao;
    @Autowired
	private PointgiftDao pointgiftDao;
    @Autowired
    private PointlogDao pointlogDao;
    @Autowired
    private MemDao memDao;
	/**
	 * 查询礼品分类列表
	 */
	public List<Giftclass> queryGiftClassList() {
		List<Giftclass> giftList = giftclassDao.queryGiftClassList(0);
		return giftList;
	}

	/**
	 * 获取礼品类别列表
	 */
	public List<Giftclass> queryGiftCategory() {
		// Map<String,Object> map=new HashMap<String,Object>();
		// map.put("status", status);
		List<Giftclass> giftList = giftclassDao.queryGiftCategory();
		return giftList;
	}

	/**
	 * 根据分类名称获取分类数目
	 */
	
	public int queryGiftClassCountByName(Giftclass giftclass) {

		return giftclassDao.queryGiftClassCountByName(giftclass);
	}
   /**
    * 添加礼品分类
    */
	
	public int addGiftClass(Giftclass giftclass) {
		
		return giftclassDao.addGiftClass(giftclass);
	}

	/**
	 * 查询礼品列表
	 * @param pointgiftFormBean
	 * @return
	 */
	
	public PointgiftFormBean queryPointGiftListByCondition(PointgiftFormBean pointgiftFormBean) {
		int total = pointgiftDao.queryGiftCountByCondition(pointgiftFormBean);
		pointgiftFormBean.setTotal(total);
		List<Pointgift> pointGifts=pointgiftDao.queryPointGiftListByCondition(pointgiftFormBean);
		pointgiftFormBean.setDatas(pointGifts);
		return pointgiftFormBean;
	}

	/**
	 * 查询礼品详情
	 * @param giftID 礼品id
	 * @return
	 */
	
	public Pointgift queryPointGiftDetailById(int giftID) {
		return pointgiftDao.queryPointGiftDetailById(giftID);
	}

	/**
	 * 删除礼品
	 * @param giftID 礼品id
	 * @return
	 */
	
	public int deleteGiftById(int giftID) {

		return pointgiftDao.deleteGiftById(giftID);
	}

	/**
	 * 根据礼品id查询是否已兑换
	 * @param giftID 礼品id
	 * @return
	 */
	
	public int queryGiftCountById(int giftID) {
		return pointgiftDao.queryGiftCountById(giftID);
	}

	
	public List<Giftclass> queryGiftClassIdList() {
		return giftclassDao.queryGiftClassIdList();
	}

	
	public int queryGiftCountByName(Pointgift pointgift) {
		return pointgiftDao.queryGiftCountByName(pointgift);
	}

	/**
	 * 添加礼品
	 * @param pointgift 礼品对象
	 * @return
	 */
	
	public int addGift(Pointgift pointgift) {
		return pointgiftDao.addGift(pointgift);
	}

	/**
	 * 更新礼品
	 * @param pointgift 礼品对象
	 * @return
	 */
	
	public int updateGift(Pointgift pointgift) {
		return pointgiftDao.updateGift(pointgift);
	}

	/**
	 * 查询兑换礼品下分页礼品数据
	 * @param page 分页对象
	 * @param key   礼品名称或简码
	 * @return
	 */
	
	public List<Pointgift> queryPointGiftListByPage(Pagination<Pointgift> page,String key) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("key","%" + key + "%");
		if (page != null) {
			map.put("firstResult", page.getFirstResult());
			map.put("pageSize", page.getPageSize());
			int total=pointgiftDao.queryGiftCountByPage(map);
			page.setTotal(total);
		}
		return pointgiftDao.queryPointGiftListByPage(map);
	}
	
	public int updatePoint(Pointlog pointlog){
		Mem mem=new Mem();
		mem.setMemid(pointlog.getPointmemid());
		int pointnumber=pointlog.getPointnumber();
		int type=pointlog.getPointchangetype();
		StringBuffer sb=new StringBuffer();
		sb.append("手动进行");
		if(type==1){
			sb.append("扣除积分,积分变动：[");
			sb.append(-pointnumber);
			mem.setMempoint(-pointnumber);
		}else{
			sb.append("增加积分,积分变动：[");
			sb.append(pointnumber);
			mem.setMempoint(pointnumber);
		}
		
		sb.append("],备注：");
		sb.append(pointnumber);
		pointlog.setPointremark(sb.toString());
		memDao.updateMemMoney(mem);
		pointlogDao.insert(pointlog);
		
		return 1;
	}
}
