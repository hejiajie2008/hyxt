package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Sysshopauthority;
import com.jfxy.pojo.form.SysshopauthorityFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface SysshopauthorityDao  {
	/**
     * 添加数据<br />
     * @param sysshopauthority 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Sysshopauthority sysshopauthority);
	
	
	
	/**
     * 修改数据<br />
     * @param sysshopauthority 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Sysshopauthority sysshopauthority);
	
	
	
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
     * @param sysshopauthority 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(SysshopauthorityFormBean sysshopauthorityFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param sysshopauthority 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Sysshopauthority> pageList(SysshopauthorityFormBean sysshopauthorityFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param sysshopauthority 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Sysshopauthority> list(Sysshopauthority sysshopauthority);
    

	
	public void updateshopauthorydate(int shopid);
	
	public String querysysshopdata(int shopid);
}
