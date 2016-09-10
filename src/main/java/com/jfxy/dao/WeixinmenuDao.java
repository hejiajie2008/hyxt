package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.Weixinmenu;
import com.jfxy.pojo.form.WeixinmenuFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2015-12-22 16:03:24
 */
public interface WeixinmenuDao  {
	/**
     * 添加数据<br />
     * @param weixinmenu 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Weixinmenu weixinmenu);
	
	
	
	/**
     * 修改数据<br />
     * @param weixinmenu 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Weixinmenu weixinmenu);
	
	
	
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
     * @param weixinmenu 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(WeixinmenuFormBean weixinmenuFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param weixinmenu 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Weixinmenu> pageList(WeixinmenuFormBean weixinmenuFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param weixinmenu 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Weixinmenu> list(Weixinmenu weixinmenu);
	
	
	public List<Weixinmenu> findWeixinmenu(int rootId);
    

}
