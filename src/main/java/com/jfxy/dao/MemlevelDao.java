package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.GoodsClassRebat;
import com.jfxy.pojo.Memlevel;
import com.jfxy.pojo.form.MemlevelFormBean;
/**
 * 
 * @author hejiajie
 *
 * @date 2015-12-03 14:13:11
 */
public interface MemlevelDao  {
	/**
     * 添加数据<br />
     * @param memlevel 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int insert(Memlevel memlevel);
	
	
	
	/**
     * 修改数据<br />
     * @param memlevel 条件对象
     * @void 数据库修改影响的行数
     * @author hejiajie
     */
	public int update(Memlevel memlevel);
	
	
	
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
     * @param memlevel 查询的条件
     * @return 统计数
     * @author hejiajie
     */
	public int count(MemlevelFormBean memlevelFormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param memlevel 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<Memlevel> pageList(MemlevelFormBean memlevelFormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param memlevel 条件对象
    * @return 查找到的结果集数
    * @author hejiajie
    */
	public List<Memlevel> list(Memlevel memlevel);
	
	
	/**
	    * 根据ID查会员级别<br />
	    * @param memlevel 条件对象
	    * @return 查找到的结果集数
	    * @author hejiajie
	    */
	public Memlevel findbyId(int memlevel);
	
	public List<GoodsClassRebat> queryGoodsClass(Map<String, Integer> map);
	
	
	public List<GoodsClassRebat> queryGoodsClassforA(Map<String, Integer> map);
	
	
	public void insertRebat(GoodsClassRebat goodsClassRebat);
	
	public void updateRabat(GoodsClassRebat goodsClassRebat);
	
	public void deleteRabat(GoodsClassRebat goodsClassRebat);
    

}
