package com.sendinfo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sendinfo.dao.${(table.javaName)!}Dao;
import com.sendinfo.dto.ContainerDto;
import com.sendinfo.entity.${(table.javaName)!};
import com.sendinfo.service.${(table.javaName)!}Service;
/**
 * ${(table.javaName)!} 操作的服务类<br />
 * @author ${(author)!'yooki'}
 *
 * @date ${(now)!''}
 */
public class ${(table.javaName)!}ServiceImpl extends ServiceImpl implements ${(table.javaName)!}Service {
	/**
	 * 日志对象
	 */
	private static final Logger logger = LoggerFactory.getLogger(${(table.javaName)!}ServiceImpl.class);
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             spring 注入                                                                                                                                       //
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 数据库注入对象
	private ${(table.javaName)!}Dao ${(table.javaName)?uncap_first!}Dao;

	// spring注入

	public void set${(table.javaName)!}Dao(${(table.javaName)!}Dao ${(table.javaName)?uncap_first!}Dao) {
		this.${(table.javaName)?uncap_first!}Dao = ${(table.javaName)?uncap_first!}Dao;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             spring 注入                                                                                                                                       //
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int save(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if (logger.isDebugEnabled()) {
			logger.debug("开始保存${(table.javaName)?uncap_first!}{} 对象", ${(table.javaName)?uncap_first!});
		}
		int i = ${(table.javaName)?uncap_first!}Dao.insert(${(table.javaName)?uncap_first!});
		if (logger.isDebugEnabled()) {
			logger.debug("结束保存${(table.javaName)?uncap_first!}{} 对象", ${(table.javaName)?uncap_first!});
		}
		return i;
	}

	@Override
	public int saveSelective(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if (logger.isDebugEnabled()) {
			logger.debug("开始保存${(table.javaName)?uncap_first!}{} 对象,忽略空值", ${(table.javaName)?uncap_first!});
		}
		int i = ${(table.javaName)?uncap_first!}Dao.insertSelective(${(table.javaName)?uncap_first!});
		if (logger.isDebugEnabled()) {
			logger.debug("结束保存${(table.javaName)?uncap_first!}{} 对象,忽略空值", ${(table.javaName)?uncap_first!});
		}
		return i;
	}

	@Override
	public int update(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if (logger.isDebugEnabled()) {
			logger.debug("开始更新${(table.javaName)?uncap_first!}{} 对象", ${(table.javaName)?uncap_first!});
		}
		int i = ${(table.javaName)?uncap_first!}Dao.updateByPrimaryKey(${(table.javaName)?uncap_first!});
		if (logger.isDebugEnabled()) {
			logger.debug("结束更新${(table.javaName)?uncap_first!}{} 对象", ${(table.javaName)?uncap_first!});
		}
		return i;
	}

	@Override
	public int updateSelective(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if (logger.isDebugEnabled()) {
			logger.debug("开始更新${(table.javaName)?uncap_first!}{} 对象,忽略空值", ${(table.javaName)?uncap_first!});
		}
		int i = ${(table.javaName)?uncap_first!}Dao.updateByPrimaryKeySelective(${(table.javaName)?uncap_first!});
		if (logger.isDebugEnabled()) {
			logger.debug("结束更新${(table.javaName)?uncap_first!}{} 对象,忽略空值", ${(table.javaName)?uncap_first!});
		}
		return i;
	}

	@Override
	public int saveOrUpdate(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if(logger.isDebugEnabled()){
			logger.debug("保存或更新${(table.javaName)?uncap_first!}{}对象",${(table.javaName)?uncap_first!});
		}
		if (<#if table.primaryKeyField.javaDataType=="String">StringUtil.isTrimBlank(${(table.javaName)?uncap_first!}.get${(table.primaryKeyField.fieldName)?cap_first!}())<#else>${(table.javaName)?uncap_first!}.get${(table.primaryKeyField.fieldName)?cap_first!}() == null</#if>) {
			return save(${(table.javaName)?uncap_first!});
		} else {
			return update(${(table.javaName)?uncap_first!});
		}
	}

	@Override
	public int saveOrUpdateSelective(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if(logger.isDebugEnabled()){
			logger.debug("保存或更新${(table.javaName)?uncap_first!}{}对象,忽略空值",${(table.javaName)?uncap_first!});
		}
		if (<#if table.primaryKeyField.javaDataType=="String">StringUtil.isTrimBlank(${(table.javaName)?uncap_first!}.get${(table.primaryKeyField.fieldName)?cap_first!}())<#else>${(table.javaName)?uncap_first!}.get${(table.primaryKeyField.fieldName)?cap_first!}() == null</#if>){
			return saveSelective(${(table.javaName)?uncap_first!});
		} else {
			return updateSelective(${(table.javaName)?uncap_first!});
		}
	}

	@Override
	public int deleteById(${(table.primaryKeyField.javaDataType)!} id) {
		if (logger.isDebugEnabled()) {
			logger.debug("调用deleteById的方法id={}", id);
		}
		int i = ${(table.javaName)?uncap_first!}Dao.deleteByPrimaryKey(id);
		if (logger.isDebugEnabled()) {
			logger.debug("调用deleteById的方法id={} 影响行数{}", new Object[] { id, i });
		}
		return i;
	}

	@Override
	public ${(table.javaName)!} findById(${(table.primaryKeyField.javaDataType)!} id) {
		if (logger.isDebugEnabled()) {
			logger.debug("调用findById的方法id={}", id);
		}
		${(table.javaName)!} ${(table.javaName)?uncap_first!}= ${(table.javaName)?uncap_first!}Dao.selectByPrimaryKey(id);
		if (logger.isDebugEnabled()) {
			logger.debug("调用findById的方法id={},对象{}", new  Object[]{id,${(table.javaName)?uncap_first!}});
		}
		return ${(table.javaName)?uncap_first!};
	}
	
	<#if table.hasCode?exists && table.hasCode=="T" >
	@Override
	public ${(table.javaName)!} findByCode(String code) {
		if(logger.isDebugEnabled()){
			logger.debug("根据 code {} 查找对象",code);
		}
		${(table.javaName)!} ${(table.javaName)?uncap_first!}= ${(table.javaName)?uncap_first!}Dao.selectByCode(code);
		if(logger.isDebugEnabled()){
			logger.debug("根据code {} 查找对象 ,查到结果",new Object[]{code,${(table.javaName)?uncap_first!}});
		}
		return ${(table.javaName)?uncap_first!};
	}
	</#if>
	
	@Override
	public int count(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if(logger.isDebugEnabled()){
			logger.debug("开始统计${(table.javaName)?uncap_first!}数量,条件{}",${(table.javaName)?uncap_first!});
		}
		int i= ${(table.javaName)?uncap_first!}Dao.count(${(table.javaName)?uncap_first!});
		if(logger.isDebugEnabled()){
			logger.debug("统计${(table.javaName)?uncap_first!}数量,条件{} 数量 {}",new Object[]{${(table.javaName)?uncap_first!},i});
		}
		return i;
	}

	@Override
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		if(logger.isDebugEnabled()){
			logger.debug("按条件${(table.javaName)?uncap_first!},查找记录数,条件{}",${(table.javaName)?uncap_first!});
		}
		List<${(table.javaName)!}>  list =  ${(table.javaName)?uncap_first!}Dao.list(${(table.javaName)?uncap_first!});
		if(logger.isDebugEnabled()){
			logger.debug("按条件${(table.javaName)?uncap_first!},查找记录数,条件{} 结果{}",new Object[]{${(table.javaName)?uncap_first!},list});
		}
		return list;
	}

	@Override
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!}, int offset, int length) {
		if(logger.isDebugEnabled()){
			logger.debug("按条件${(table.javaName)?uncap_first!},查找记录数,条件{},偏移量{},查询数据长度{}",new Object[]{${(table.javaName)?uncap_first!},offset,length});
		}
		List<${(table.javaName)!}>  list =  ${(table.javaName)?uncap_first!}Dao.list(${(table.javaName)?uncap_first!},offset,length);
		if(logger.isDebugEnabled()){
			logger.debug("按条件${(table.javaName)?uncap_first!},查找记录数,条件{}偏移量{},查询数据长度{} 结果{}",new Object[]{${(table.javaName)?uncap_first!},offset,length,list});
		}
		return list;
	}

	@Override
	public ContainerDto<${(table.javaName)!}> find(${(table.javaName)!} ${(table.javaName)?uncap_first!}, int offset, int length) {
	   ContainerDto<${(table.javaName)!}> containerDto = new ContainerDto<${(table.javaName)!}>();
	   containerDto.setTotalRowNum(count(${(table.javaName)?uncap_first!}));
	   List<${(table.javaName)!}> list = list(${(table.javaName)?uncap_first!}, offset, length);
	   containerDto.setOffset(offset);
	   if(list.isEmpty()&&containerDto.getTotalRowNum()>0){
		   list = list(${(table.javaName)?uncap_first!}, 0, length);
		   containerDto.setOffset(0);
	   }
	   containerDto.setList(list);
	   return containerDto;
	}
	
	@Override
	public int deleteByIds(List<${(table.primaryKeyField.javaDataType)!}> ids) {
		if(logger.isDebugEnabled()){
			logger.debug("批量删除的方法 id{}",ids);
		}
		int rowNum = ${(table.javaName)?uncap_first!}Dao.deleteByIds(ids);
		if(logger.isDebugEnabled()){
			logger.debug("批量删除的方法 id{},删除掉{}行数据",ids,rowNum);
		}
		return rowNum;
	}
}