package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Pointgift;
import com.jfxy.pojo.form.PointgiftFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface PointgiftDao  {
	/**
     * 添加数据<br />
     * @param pointgift 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Pointgift pointgift);
	
	
	
	/**
     * 修改数据<br />
     * @param pointgift 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Pointgift pointgift);
	
	
	
	/**
	 * 删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 * @author hejiajie
	 */
	public int deleteById(int value);
	
	/**
	 * 批量删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 * @author hejiajie
	 */
	public int deleteByIds(Map<String, Object> map);
	
	
	
	
	
	
	/**
     * 按条件统计记录数 <br />
     * @param pointgift 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(PointgiftFormBean pointgiftFormBean);
	

    /**
     * 按条件查询结果集<br />
     * @param pointgift 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Pointgift> pageList(PointgiftFormBean pointgiftFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param pointgift 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Pointgift> list(Pointgift pointgift);
	/**
	 * 查询礼品列表
	 * @param pointgiftFormBean
	 * @return
	 */
	List<Pointgift> queryPointGiftListByCondition(PointgiftFormBean pointgiftFormBean);

	/**
	 * 查询礼品数目
	 * @param pointgiftFormBean
	 * @return
	 */
	int queryGiftCountByCondition(PointgiftFormBean pointgiftFormBean);

	/**
	 * 根据礼品id查询礼品详情
	 * @param giftID 礼品id
	 * @return
	 */
	Pointgift queryPointGiftDetailById(int giftID);

	/**
	 * 删除礼品
	 * @param giftID 礼品id
	 * @return
	 */
	int deleteGiftById(int giftID);

	/**
	 * 根据礼品id查询是否已兑换
	 * @param giftID 礼品id
	 * @return
	 */
	int queryGiftCountById(int giftID);

	/**
	 * 根据礼品名称查询礼品是否已存在
	 * @param pointgift 礼品对象
	 * @return
	 */
	int queryGiftCountByName(Pointgift pointgift);

	/**
	 * 添加礼品
	 * @param pointgift 礼品对象
	 * @return
	 */
	int addGift(Pointgift pointgift);

	/**
	 * 更新礼品
	 * @param pointgift 礼品对象
	 * @return
	 */
	int updateGift(Pointgift pointgift);

	/**
	 * 查询兑换礼品下礼品数据
	 * @param map
	 * @return
	 */
	int queryGiftCountByPage(Map<String, Object> map);

	/**
	 * 查询兑换礼品下礼品信息
	 * @param map
	 * @return
	 */
	List<Pointgift> queryPointGiftListByPage(Map<String, Object> map);
}
