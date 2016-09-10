package com.jfxy.service;

import java.util.List;

import com.jfxy.pojo.Giftclass;
import com.jfxy.pojo.Pointgift;
import com.jfxy.pojo.Pointlog;
import com.jfxy.pojo.form.PointgiftFormBean;
import com.jfxy.util.Pagination;

public interface PointManagerService {
/**
 * 查询礼品分类列表
 * @return
 */
public	List<Giftclass> queryGiftClassList();
/**
 * 获取礼品类别列表
 * @return
 */
public List<Giftclass> queryGiftCategory();
/**
 * 根据类别名称查询礼品数目
 * @param giftclass 礼品对象
 * @return
 */
public int queryGiftClassCountByName(Giftclass giftclass);
/**
 * 添加礼品分类
 * @return
 */
 public int addGiftClass(Giftclass giftclass);

 /**
  * 查询礼品列表
  * @return
  */
 PointgiftFormBean queryPointGiftListByCondition(PointgiftFormBean pointgiftFormBean);

 /**
  * 根据礼品id查询礼品详情
  * @param giftID 礼品id
  * @return
  */
 public  Pointgift queryPointGiftDetailById(int giftID);

 /**
  * 删除礼品
  * @param giftID 礼品id
  * @return
  */
 public int deleteGiftById(int giftID);

 /**
  * 根据礼品id查询礼品是否已兑换
  * @param giftID 礼品id
  * @return
  */
 public  int queryGiftCountById(int giftID);

 /**
  * 查询分类列表id
  * @return
  */
 public List<Giftclass> queryGiftClassIdList();

 /**
  * 根据礼品名称是否已存在
  * @param pointgift 礼品对象
  * @return
  */
 int queryGiftCountByName(Pointgift pointgift);

 /**
  * 添加礼品
  * @param pointgift 礼品对象
  * @return
  */
 public int addGift(Pointgift pointgift);

 /**
  * 更新礼品
  * @param pointgift 礼品对象
  * @return
  */
 public  int updateGift(Pointgift pointgift);

 /**
  * 查询兑换礼品分页数据
  * @param page 分页对象
  * @param key   礼品名称或简码
  * @return
  */
 public List<Pointgift> queryPointGiftListByPage(Pagination<Pointgift> page,String key);
 /**
  * 修改积分
  * <功能详细描述>
  * @param pointlog
  * @return [参数说明]
  * 
  * @return int [返回类型说明]
  * @exception throws [违例类型] [违例说明]
  * @see [类、类#方法、类#成员]
  */
 public int updatePoint(Pointlog pointlog);
 
 
}
