package com.jfxy.dao;

import java.util.List;
import com.jfxy.pojo.Giftclass;

public interface GiftclassDao {

	int deleteByPrimaryKey(Integer giftclassid);


	int addGiftClass(Giftclass giftclass);

	Giftclass selectByPrimaryKey(Integer giftclassid);

	int updateByPrimaryKeySelective(Giftclass record);

	int updateByPrimaryKey(Giftclass record);
	/**
	 * 查询礼品分类列表
	 * @return
	 */
	public List<Giftclass> queryGiftClassList(int rootId);
    /**
     * 获取礼品类别类别
     * @return
     */
	List<Giftclass> queryGiftCategory();
    /**
     * 根据类别名称查询数目
     * @param giftclass
     * @return
     */
	int queryGiftClassCountByName(Giftclass giftclass);

	/**
	 * 查询礼品分类集合id
	 * @return
	 */
	List<Giftclass> queryGiftClassIdList();
}