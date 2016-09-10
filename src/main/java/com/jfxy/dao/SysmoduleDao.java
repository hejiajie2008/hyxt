package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Sysmodule;
import com.jfxy.pojo.form.SysmoduleFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2015-12-03 14:31:34
 */
public interface SysmoduleDao  {
	/**
     * 添加数据<br />
     * @param sysmodule 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Sysmodule sysmodule);
	
	
	
	/**
     * 修改数据<br />
     * @param sysmodule 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Sysmodule sysmodule);
	
	
	
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
     * @param sysmodule 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(SysmoduleFormBean sysmoduleFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param sysmodule 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Sysmodule> pageList(SysmoduleFormBean sysmoduleFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param sysmodule 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Sysmodule> list(Sysmodule sysmodule);
	
	/**
	 * 查询所有菜单
	 * @param value
	 * @return
	 */
	public List<Sysmodule> findMenus(int value);

	
	/**
	 * 查询所有模块
	 * @param value
	 * @return
	 */
	public List<Sysmodule> findModuleList(int groupid);
	
	public List<Sysmodule> findalllist();
	
    

}
