package com.jfxy.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jfxy.pojo.Sysuser;
import com.jfxy.pojo.form.SysuserFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2016-01-11 13:48:04
 */
public interface SysuserDao  {
	/**
     * 添加数据<br />
     * @param sysuser 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Sysuser sysuser);
	
	
	
	/**
     * 修改数据<br />
     * @param sysuser 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Sysuser sysuser);
	
	/**
     * 修改密码<br />
     * @param sysuser 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int updatePassword(Sysuser sysuser);
	
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
     * @param sysuser 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(SysuserFormBean sysuserFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param sysuser 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Sysuser> pageList(SysuserFormBean sysuserFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param sysuser 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Sysuser> list(Sysuser sysuser);
	
	
	public Sysuser findByUsername(String username);
	
	public Sysuser findByUserid(Integer userid);
	
	
	/**
	 * 查询所有权限
	 * @param value
	 * @return
	 */
	public Set<String> findPermissions(int value);
    

}
