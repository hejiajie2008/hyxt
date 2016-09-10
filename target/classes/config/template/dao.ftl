package com.jfxy.dao;

import java.util.List;

import com.jfxy.pojo.${(table.javaName)!};
/**
 * 
 * @author ${(author)!'yooki'}
 *
 * @date ${(now)!''}
 */
public interface ${(table.javaName)!}Dao  {
    /**
     * 按条件查询结果集<br />
     * @param ${(table.javaName)?uncap_first!} 条件对象
     * @return 查找到的记录集数
     * @author yooki
     */
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!});
   /**
    * 按条件查询结果集数 <br />
    * @param ${(table.javaName)?uncap_first!} 条件对象
    * @param offset 偏移量
    * @param length 查询长度
    * @return 查找到的结果集数
    * @author yooki
    */
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!}, int offset, int length);
    /**
     * 按条件统计记录数 <br />
     * @param ${(table.javaName)?uncap_first!} 查询的条件
     * @return 统计数
     * @author yooki
     */
	public int count(${(table.javaName)!} ${(table.javaName)?uncap_first!});
		/**
	 * 批量删除的方法 <br />
	 * @param ids 主键集合
	 * @return 数据库删除影响的行数
	 */
	public int deleteByIds(List<${(table.primaryKeyField.javaDataType)!}> ids);

}
