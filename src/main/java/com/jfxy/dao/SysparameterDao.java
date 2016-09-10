package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Sysparameter;
import com.jfxy.pojo.form.SysparameterFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface SysparameterDao  {
	/**
     * 添加数据<br />
     * @param sysparameter 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Sysparameter sysparameter);
	
	
	
	/**
     * 修改数据<br />
     * @param sysparameter 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Sysparameter sysparameter);
	
	
	
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
     * @param sysparameter 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(SysparameterFormBean sysparameterFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param sysparameter 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Sysparameter> pageList(SysparameterFormBean sysparameterFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param sysparameter 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Sysparameter> list(Sysparameter sysparameter);
    

}
