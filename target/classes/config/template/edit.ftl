<#noparse>
<#include "../htmlTop.ftl">
<link href="${(staticInfo.path)!}/css/product.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${(staticInfo.path)!}/script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${(staticInfo.path)!}/script/validate-common.js"></script>
<!--body头-->
<#include "../htmlMiddle.ftl">
</#noparse>
<div class="title_box">
	<div class="title_content"><#noparse><#if </#noparse>(${(table.javaName)?uncap_first!}.${(table.primaryKeyField.fieldName)!})?exists><#noparse><@s.text name="modify"/><#else><@s.text name="add"/></#if><@s.text </#noparse>name="${(table.javaName)?uncap_first!}"/>
	</div>
</div>
<form action="save.${r"$"}{suffix}" method="post">
<input type="hidden" name="${(table.javaName)?uncap_first!}.${(table.primaryKeyField.fieldName)!}" value="${r"$"}{(${(table.javaName)?uncap_first!}.${(table.primaryKeyField.fieldName)!})!}"/>
<#if table.versionField?exists>
<input type="hidden" name="${(table.javaName)?uncap_first!}.version" value="${r"$"}{(${(table.javaName)?uncap_first!}.version)!}"/>
</#if>
<input type="hidden" name="redirectPath" value="${r"$"}{redirectPath!}"/>
${r"<@s.token/>"}
  <div class="info_content">
    <ul class="info_list">
    <#list table.allFields as field>
     <#if field.fieldName!="version" && field.fieldName!=table.primaryKeyField.fieldName>
	    <li><span class="span w250 b r"><label for="${(table.javaName)?uncap_first!}_${(field.fieldName)!}"><#noparse><@s.text </#noparse> name="${(table.javaName)?uncap_first!}_${(field.fieldName)!}"/>：</label></span>
	    <#if field.length &lt; 128><input type="text"  class="text w130" id="${(table.javaName)?uncap_first!}_${(field.fieldName)!}" name="${(table.javaName)?uncap_first!}.${(field.fieldName)!}" value="${r"$"}{(${(table.javaName)?uncap_first!}.${(field.fieldName)!}<#if field.javaDataType=="Date">?string("yyyy-MM-dd HH:mm")</#if>)!}"/><#else><textarea  class="text-style-130" name="${(table.javaName)?uncap_first!}.${(field.fieldName)!}" id="${(table.javaName)?uncap_first!}_${(field.fieldName)!}">${r"$"}{(${(table.javaName)?uncap_first!}.${(field.fieldName)!})!}</textarea></#if>
	    </li>
	</#if>
   </#list>
    </ul>
  </div>
<div class="operate operate_center">
   <input type="submit"  value="保存" class="btn" />
</div>
</form>
<#noparse><!--html尾-->
<#include "../htmlBottom.ftl">
</#noparse>