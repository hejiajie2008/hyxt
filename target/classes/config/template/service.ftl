package com.sendinfo.service;

import java.util.List;

import com.sendinfo.dto.ContainerDto;
import com.sendinfo.entity.${(table.javaName)!};
/**
 *  ${(table.javaName)!} 操作的服务类<br />
 * @author ${(author)!'yooki'}
 *
 * @date ${(now)!''}
 */
public interface ${(table.javaName)!}Service extends Service {
	/**
	 * 简单保存对方象的方法<br />
	 * @param ${(table.javaName)?uncap_first!}
	 * @return 数据影响的行数
	 * @author yooki
	 */
	public int save(${(table.javaName)!} ${(table.javaName)?uncap_first!});
    /**
     * 保存实体对象(空值去除，用数据库默认值)<br />
     * @param ${(table.javaName)?uncap_first!} 实体对象
     * @return 数据库影响的行数
     * @author yooki
     */
	public int saveSelective(${(table.javaName)!} ${(table.javaName)?uncap_first!}) ;
    /**
     * 更新实体对象<br />
     * @param ${(table.javaName)?uncap_first!} 实体对象
     * @return 数据库影响的行数  
     * @author yooki
     */
	public int update(${(table.javaName)!} ${(table.javaName)?uncap_first!}) ;
    /**
     * 更新实体对象（空值不更新）
     * @param ${(table.javaName)?uncap_first!} 实体对象
     * @return 数据库影响的行数
     * @author yooki
     */
	public int updateSelective(${(table.javaName)!} ${(table.javaName)?uncap_first!}) ;
    /**
     * 保存或更新实体对象
     * @param ${(table.javaName)?uncap_first!} 实体对象
     * @return 数据库影响的行数 
     * @author yooki
     */
	public int saveOrUpdate(${(table.javaName)!} ${(table.javaName)?uncap_first!}) ;
    /**
     * 保存或更新实体对象（空值去除）
     * @param ${(table.javaName)?uncap_first!} 实体对象
     * @return 数据库影响的行数
     * @author yooki
     */
	public int saveOrUpdateSelective(${(table.javaName)!} ${(table.javaName)?uncap_first!});
    /**
     * 按主键删除对象
     * @param id 主象
     * @return 数据库影响的行数
     * @author yooki
     */
	public int deleteById(${(table.primaryKeyField.javaDataType)!} id) ;
    /**
     * 按主键查找 ${(table.javaName)?uncap_first!} 对象
     * @param id 主键
     * @return 返回查找到的对象
     * @author yooki
     */
	public ${(table.javaName)!} findById(${(table.primaryKeyField.javaDataType)!} id) ;
	<#if table.hasCode?exists && table.hasCode=="T" >
	/**
	 * 根据代码查找 ${(table.javaName)?uncap_first!} 对象
	 * @param code 编码
	 * @return 查找到 ${(table.javaName)?uncap_first!} 的对象
	 * @author yooki
	 */
	public ${(table.javaName)!} findByCode(String code);
   </#if>
	/**
	 * 查找${(table.javaName)?uncap_first!} 的数量
	 * @param ${(table.javaName)?uncap_first!}
	 * @return 返回统计的行数
	 * @author yooki
	 */
	public int count(${(table.javaName)!} ${(table.javaName)?uncap_first!});
	/**
	 * 按条件查 出列表
	 * @param ${(table.javaName)?uncap_first!} 查询的条件
	 * @return 查找到记集集合
	 * @author yooki
	 */
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!});
	/**
	 * 按条件查找出列表<br />
	 * @param ${(table.javaName)?uncap_first!} 查找的条件
	 * @param offset 偏移量
	 * @param length 查询长度
	 * @return 查找到的数据集
	 * @author yooki
	 */
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!},int offset ,int length);
	/**
	 * 按条件查找列表 及分页记录数<br />
	 * @param ${(table.javaName)?uncap_first!} 查找的条件
	 * @param offset 偏移量
	 * @param length 查询长度
	 * @return 查找到的结果集
	 * @author yooki
	 */
	public ContainerDto<${(table.javaName)!}> find(${(table.javaName)!} ${(table.javaName)?uncap_first!},int offset,int length);
	/**
	 * 批量删除的方法<br />
	 * @param ids 要删除的主删集合 
	 * @return 数据库的影响行数
	 */
	public int deleteByIds(List<${(table.primaryKeyField.javaDataType)!}> ids);
}
