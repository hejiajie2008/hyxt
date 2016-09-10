package com.sendinfo.action;
import java.util.ArrayList;
import java.util.List;

import com.sendinfo.entity.${(table.javaName)!};
import com.sendinfo.service.${(table.javaName)!}Service;
import com.sendinfo.util.StringUtil;
/**
 * 
 * @author ${(author)!'yooki'}
 *
 * @date ${(now)!''}
 */
public class ${(table.javaName)!}Action extends Action {

	private ${(table.javaName)!} ${(table.javaName)?uncap_first !};
	
	public ${(table.javaName)!} get${(table.javaName)!}() {
		return ${(table.javaName)?uncap_first !};
	}
	
	public void set${(table.javaName)!}(${(table.javaName)!} ${(table.javaName)?uncap_first!}) {
		this.${(table.javaName)?uncap_first!} = ${(table.javaName)?uncap_first!};
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             spring 注入                                                                                                                                       //
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private ${(table.javaName)!}Service ${(table.javaName)?uncap_first !}Service;
	
	public void set${(table.javaName)!}Service(${(table.javaName)!}Service ${(table.javaName)?uncap_first!}Service) {
		this.${(table.javaName)?uncap_first!}Service = ${(table.javaName)?uncap_first!}Service;
	}
	
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                             action                                                        //                                                                           //
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 编辑动作
	 */
	public String edit() {
		${(table.javaName)?uncap_first!}= ${(table.javaName)?uncap_first!}Service.findById(<#if table.primaryKeyField.javaDataType=="Long">Long.valueOf(id)<#else>id</#if>);
		return SUCCESS;
	}
	
    /**
     * 保存动作
     */
	public String save() {
	    if(!validateInput()){
	      return INPUT;
	    }
		${(table.javaName)?uncap_first!}Service.saveOrUpdateSelective(${(table.javaName)?uncap_first!});
		if(StringUtil.isNotTrimBlank(getRedirectPath())){
			return REDIRECT;
		}
		return SUCCESS;
	}
	
	/**
	 * 验证输入
	 */
	private boolean validateInput(){
		//输入你验证
		return true;
	}
	
   /**
    * 列查询动作
    */
	public String list() {
        containerDto =	${(table.javaName)?uncap_first!}Service.find(${(table.javaName)?uncap_first!}, offset, getLength());
        //计算重定向地址
        generateRedirectPath();
		//计算分页
		calcPaging();
		return SUCCESS;
	}
	
	/**
	 * 删除动作
	 */
	public String del(){
		if(StringUtil.isNotTrimBlank(id)){
		${(table.javaName)?uncap_first!}Service.deleteById(<#if table.primaryKeyField.javaDataType=="Long">Long.valueOf(id)<#else>id</#if>);
		}
		return SUCCESS;
	}
	
	/**
	 * 批量删除，这个方法不严谨，没有权限控制
	 */
	public String delAll(){
		if(ids!=null&&!ids.isEmpty()){
			<#if table.primaryKeyField.javaDataType=="Long">
			List<Long> list = new ArrayList<Long>();
			for(String id:ids){
				list.add(Long.valueOf(id));
			}
			${(table.javaName)?uncap_first!}Service.deleteByIds(list);
			<#else>
			${(table.javaName)?uncap_first!}Service.deleteByIds(ids);
			</#if>
		}
		return SUCCESS;
	}
}
