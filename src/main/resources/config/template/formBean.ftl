package com.jfxy.pojo.form;

import com.jfxy.util.Pagination;
import com.jfxy.pojo.${(table.javaName)!};
<#assign isDate=0><#assign isDecimal=0>
<#list table.allFields as field >
<#if field.javaDataType="Date"><#assign isDate=1></#if>
<#if field.javaDataType="BigDecimal"><#assign isDecimal=1></#if>
</#list>
<#if isDate!=0>
import java.util.Date;
</#if><#if isDecimal!=0>
import java.math.BigDecimal;
</#if>

/**
 * ${(table.comments)!} <br />
 * ${(table.tableName)!}<br />
 * @author ${(author)!'yooki'}
 * @date ${(now)!''}
 */
public class ${(table.javaName)!}FormBean extends Pagination<${(table.javaName)!}>  <#if table.implemeFields?size &gt;0 >implements <#list table.implemeFields as s >${s}<#if s_has_next>,</#if></#list></#if> {
  private static final long serialVersionUID = 1L;
 <#list table.allFields as field >
  <#if field.fieldName =="id" >
  <#elseif field.fieldName=="createTime" >
  <#elseif field.fieldName=="createBy" >
  <#elseif field.fieldName=="modifyTime" >
  <#elseif field.fieldName=="modifyBy" >
  <#else>
   /**
    * ${(field.comments)!}   ${(field.commentsDetail)!}<br />
    * 允许为空  ${(field.nullable)!} <br />
    * 数据长度 ${(field.length)}<#if field.scale &gt; 0 > , ${(field.scale)!}</#if><br />
    */
   private ${(field.javaDataType)!} ${(field.fieldName)!};
  </#if>
  </#list>
 <#list table.allFields as field >
  <#if field.fieldName =="id" >
  <#elseif field.fieldName=="createTime" >
  <#elseif field.fieldName=="createBy" >
  <#elseif field.fieldName=="modifyTime" >
  <#elseif field.fieldName=="modifyBy" >
  <#else>
   /**
    * 获得 ${(field.comments)!}<br />
    * @return ${(field.fieldName)!}<br />
    */
   public ${(field.javaDataType)!} get${(field.fieldName)?cap_first!}(){
     return ${(field.fieldName)!};
   }
   
   /**
    * 设置 ${(field.comments)!} <br />
    * @param ${(field.fieldName)!}
    */
   public void set${(field.fieldName)?cap_first!}(${(field.javaDataType)!} ${(field.fieldName)!} ){
     this.${(field.fieldName)!}=${(field.fieldName)!};
   }
  </#if>
 </#list>
}
