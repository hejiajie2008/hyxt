package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Staffclass;
import com.jfxy.pojo.form.StaffclassFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface StaffclassDao  {
	/**
     * 添加数据<br />
     * @param staffclass 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Staffclass staffclass);
	
	
	
	/**
     * 修改数据<br />
     * @param staffclass 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Staffclass staffclass);
	
	
	
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
     * @param staffclass 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(StaffclassFormBean staffclassFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param staffclass 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Staffclass> pageList(StaffclassFormBean staffclassFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param staffclass 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Staffclass> list(Staffclass staffclass);
    

}
