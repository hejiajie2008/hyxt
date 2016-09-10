package com.sendinfo.dao.impl;

import java.util.List;

import com.sendinfo.dao.${(table.javaName)!}Dao;
import com.sendinfo.entity.${(table.javaName)!};
import com.sendinfo.mybatis.Criteria;
import com.sendinfo.mybatis.Example;
import com.sendinfo.util.StringUtil;
/**
 * 
 * @author ${(author)!'yooki'}
 *
 * @date ${(now)!''}
 */
public class ${(table.javaName)!}DaoImpl extends DaoImpl implements ${(table.javaName)!}Dao {

	@Override
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		Example example = new Example();
		fillExample(${(table.javaName)?uncap_first!},example);
		return selectByExample(example);
	}
	
	@Override
	public List<${(table.javaName)!}> list(${(table.javaName)!} ${(table.javaName)?uncap_first!}, int offset, int length) {
		Example example = new Example();
		example.setFirstResult(offset);
		example.setMaxResult(offset+length);
		fillExample(${(table.javaName)?uncap_first!}, example);
		return selectByExample(example);
	}

	@Override
	public int count(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		Example example = new Example();
		fillExample(${(table.javaName)?uncap_first!}, example);
		return countByExample(example);
	}
	
	@Override
	public int deleteByIds(List<${(table.primaryKeyField.javaDataType)!}> ids) {
		Example example = new Example();
		Criteria criteria = example.createCriteria();
		criteria.addCriterion("${(table.primaryKeyField.columnName)!} in ", ids);
		return deleteByExample(example);
	}
	
	private void fillExample(${(table.javaName)!} ${(table.javaName)?uncap_first!},Example example){
		if(${(table.javaName)?uncap_first!}!=null){
			Criteria criteria = example.createCriteria();
			<#list table.allFields as field>
			   <#if field.fieldName!="version">
				<#if field.javaDataType!="String">
				if(${(table.javaName)?uncap_first!}.get${(field.fieldName)?cap_first!}()!=null){
					criteria.addCriterion(" ${(field.columnName)!} = ", ${(table.javaName)?uncap_first!}.get${(field.fieldName)?cap_first!}());
				}
				<#else>
				if(StringUtil.isNotTrimBlank(${(table.javaName)?uncap_first!}.get${(field.fieldName)?cap_first!}())){
					criteria.addCriterion(" ${(field.columnName)!} = ", ${(table.javaName)?uncap_first!}.get${(field.fieldName)?cap_first!}().trim());
				}
				</#if>
				</#if>
			</#list>
		}
	}
}