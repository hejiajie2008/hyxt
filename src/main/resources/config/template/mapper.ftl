package com.jfxy.dao;

import java.util.List;
import java.util.Map;

import com.jfxy.pojo.${(table.javaName)!};
import com.jfxy.pojo.form.${(table.javaName)!}FormBean;
/**
 * 
 * @author ${(author)!'hejiajie'}
 *
 * @date ${(now)!''}
 */
public interface ${(table.javaName)!}Dao  {
	/**
     * 添加数据<br />
     * @param ${(table.javaName)?uncap_first!} 条件对象
     * @void 数据库修改影响的行数
     * @author ${(author)!'hejiajie'}
     */
	public int insert(${(table.javaName)!} ${(table.javaName)?uncap_first!});
	
	
	
	/**
     * 修改数据<br />
     * @param ${(table.javaName)?uncap_first!} 条件对象
     * @void 数据库修改影响的行数
     * @author ${(author)!'hejiajie'}
     */
	public int update(${(table.javaName)!} ${(table.javaName)?uncap_first!});
	
	
	
	/**
	 * 删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 * @author ${(author)!'hejiajie'}
	 */
	public int deleteById(int value);
	
	/**
	 * 批量删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 * @author ${(author)!'hejiajie'}
	 */
	public int deleteByIds(Map<String,Object> map);
	
	
	
	
	
	
	/**
     * 按条件统计记录数 <br />
     * @param ${(table.javaName)?uncap_first!} 查询的条件
     * @return 统计数
     * @author ${(author)!'hejiajie'}
     */
	public int count(${(table.javaName)!}FormBean ${(table.javaName)?uncap_first!}FormBean);
	

	
	
	

    /**
     * 按条件查询结果集<br />
     * @param ${(table.javaName)?uncap_first!} 条件对象
     * @return 查找到的记录集数
     * @author hejiajie
     */
	public List<${(table.javaName)!}> pageList(${(table.javaName)!}FormBean ${(table.javaName)?uncap_first!}FormBean);
   /**
    * 按条件查询结果集数 <br />
    * @param ${(table.javaName)?uncap_first!} 条件对象
    * @return 查找到的结果集数
    * @author ${(author)!'hejiajie'}
    */
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!});
    

}
