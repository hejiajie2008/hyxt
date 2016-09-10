<#noparse>
<#include "../htmlTop.ftl">
<link href="${(staticInfo.path)!}/css/product.css" rel="stylesheet" type="text/css" />
<!--body头-->
<#include "../htmlMiddle.ftl">
</#noparse>
<div class="title_box">
	<div class="title_content"><#noparse><@s.text name="view"/><@s.text </#noparse>name="${(table.javaName)?uncap_first!}"/></div>
</div>
  <div class="info_content">
    <ul  class="info_list info_center">
    <#list table.allFields as field>
     <#if field.fieldName!="version" >
	    <li><span class="span w150 r"><#noparse><@s.text </#noparse> name="${(table.javaName)?uncap_first!}_${(field.fieldName)!}"/>：</span>
	    <span class="span w250 l"> ${r"$"}{(${(table.javaName)?uncap_first!}.${(field.fieldName)!}<#if field.javaDataType=="Date">?string("yyyy-MM-dd HH:mm")</#if>)!}</span>
	    </li>
	</#if>
   </#list>
    </ul>
  </div>
<div class="operate operate_center">
<input type="button" class="btn" value="返回" onclick="history.back()"/>
</div>
<#noparse><!--html尾-->
<#include "../htmlBottom.ftl">
</#noparse>