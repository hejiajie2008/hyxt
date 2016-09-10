package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Goodsclass;
import com.jfxy.pojo.form.GoodsclassFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface GoodsclassDao  {
	/**
     * 添加数据<br />
     * @param goodsclass 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Goodsclass goodsclass);
	
	
	
	/**
     * 修改数据<br />
     * @param goodsclass 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Goodsclass goodsclass);
	
	
	
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
	public int deleteByIds(Map<String,Object> map);
	
	
	
	
	
	
	/**
     * 按条件统计记录数 <br />
     * @param goodsclass 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(GoodsclassFormBean goodsclassFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param goodsclass 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Goodsclass> pageList(GoodsclassFormBean goodsclassFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param goodsclass 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Goodsclass> list(Goodsclass goodsclass);
	
	
	
	
	public void deleteByShopId(Map<String, Integer> map);
	
	
	public void deleteByGoodsShopId(Map<String, Integer> map);
	
	
	public void insertClassAutho(Map<String, Integer> map);
	
	
	public Goodsclass findbyId(Integer classid);
	
	
	public List<GoodsClassRebat> findclassrebate(Map<String, Integer> map);
	
	public void insertclassRebat(GoodsClassRebat goodsClassRebat);
	
	public void deleteclassRabat(Map<String, Integer> map);



	
	
    

}
