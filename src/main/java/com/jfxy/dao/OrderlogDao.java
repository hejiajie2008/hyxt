package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Orderlog;
import com.jfxy.pojo.form.OrderlogFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface OrderlogDao  {
	/**
     * 添加数据<br />
     * @param orderlog 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Orderlog orderlog);
	
	
	
	/**
     * 修改数据<br />
     * @param orderlog 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Orderlog orderlog);
	
	
	
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
     * @param orderlog 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(OrderlogFormBean orderlogFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param orderlog 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Orderlog> pageList(OrderlogFormBean orderlogFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param orderlog 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Orderlog> list(Orderlog orderlog);
	
	public List<Orderlog> queryOrderlogbymemid(Integer memid);
    

}
