<#noparse><#include "../htmlTop.ftl">
<!--body头-->
<link href="${(staticInfo.path)!}/css/product.css" rel="stylesheet" type="text/css" />
<link href="${(staticInfo.path)!}/css/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${(staticInfo.path)!}/script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${(staticInfo.path)!}/script/list-common.js"></script>
<script type="text/javascript" src="${(staticInfo.path)!}/script/paging.js"></script>
<script type="text/javascript" src="${(staticInfo.path)!}/script/lhgdialog/lhgdialog.min.js"></script>
<#include "../htmlMiddle.ftl">
</#noparse>
<form action="list.${r"$"}{suffix}" method="get">
<input type="hidden" name="length" value="${r"$"}{(length)!}"/>
<div class="search_box">
   <ul>
  <#assign column =0>
	<#list table.allFields as field>
		<#if field.fieldName!=table.primaryKeyField.fieldName && field.fieldName!="version">
		<#if column%3==0>
		<li>
		</#if>
		    <span class="span w80 r"><label for="${(table.javaName)?uncap_first!}_${(field.fieldName)!}">${r"<@s.text"} name="${(table.javaName)?uncap_first!}_${(field.fieldName)!}"/>：</label></span>
		    <span class="span w150 l"><input type="text"   class="text text130" name="${(table.javaName)?uncap_first!}.${(field.fieldName)!}" id="${(table.javaName)?uncap_first!}_${(field.fieldName)!}" maxlength="${(field.length)!}"  value="<#noparse>$</#noparse>{(${(table.javaName)?uncap_first!}.${(field.fieldName)!})!}" /></span>
		<#if column%3==2>
		</li>
		</#if>
		 <#assign column = column+1> 
		</#if>
	</#list>
  <#if column%3!=0>
  </li>
  </#if>
<!--查询按钮-->
   <li><input type="submit"  class="search_style" value="" />
   </li>
  </ul>
</div>
</form>
<div class="list">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table" id="list">
          <tr class="title">
            <td width="4%"><input type="checkbox" name="parent"/></td>
            <td width="60">${r"<@s.text "} name="number"/></td>
            <#list table.allFields as field >
             <#if field.fieldName!=table.primaryKeyField.fieldName && field.fieldName!="version">
             <td>${r"<@s.text "} name="${(table.javaName)?uncap_first!}_${(field.fieldName)!}"/></td>
             </#if>
            </#list>
            <td width="180">${r"<@s.text "} name="operate"/></td>
          </tr>
        <#noparse>
            <#assign xPath="${action.encodeUTF8(redirectPath,\"offset=\"+offset)}"> 
            <@s.url action="edit.${suffix}" id="edit"/>
			<@s.url action="del.${suffix}" id="del"/>
			<@s.url action="view.${suffix}" id="view"/>
			<#assign editAuth=action.hasAuth(edit)>
			<#assign delAuth=action.hasAuth(del)>
			<#assign viewAuth=action.hasAuth(view)>
         <#list containerDto.list as item>
          <tr <#if item_index%2==1>class="onn" </#if>></#noparse>
            <td><input type="checkbox" value="${r"$"}{(item.${(table.primaryKeyField.fieldName)!})!}" name="child"/></td>
            <td>${r"$"}{(item_index+offset+1)!}</td>
     <#list table.allFields as field >
         <#if field.fieldName!=table.primaryKeyField.fieldName && field.fieldName!="version">
         	<td <#if field.javaDataType=="BigDecimal">align="right"<#else>align="center"</#if> valign="middle">${r"$"}{(item.${(field.fieldName)!})<#if field.javaDataType=="Date">?string("yyyy-MM-dd HH:mm")</#if><#if field.javaDataType=="BigDecimal">?string("0.##")</#if>!}</td>
         </#if>
    </#list>
     		<td><#noparse><#if viewAuth></#noparse>
     			<a class="view_tb" href="javascript:void(0)" onclick="view('view.${r"$"}{suffix}','${r"$"}{(item.id)!}');return false;">${r"<@s.text "} name="view"/></a><#noparse></#if></#noparse><#noparse><#if editAuth></#noparse>
     			<a class="edit_tb" href="javascript:void(0)" onclick="edit('edit.${r"$"}{suffix}','${r"$"}{(item.id)!}','${r"$"}{xPath}');return false;">${r"<@s.text "} name="edit"/></a><#noparse></#if></#noparse><#noparse><#if delAuth></#noparse>
     			<a class="delete_tb" href="javascript:void(0)" onclick="del('del.${r"$"}{suffix}','${r"$"}{(item.id)!}','${r"$"}{xPath}','您确定要删除序号为${r"$"}{(item_index+offset+1)!}的记录吗?');return false;">${r"<@s.text "} name="delete"/></a> <#noparse></#if></#noparse>
     		</td>
          </tr>
          <#noparse>
          </#list>
          <#if (containerDto.list?size ==0)>
           </#noparse>
          <tr class="nobackground">
            <td height="90" colspan="${(table.allFields?size+1)!}"><img src="${r"$" }{(staticInfo.path)!}/img/right/cion_1.gif" />对不起，暂无信息</td>
          </tr>
           <#noparse>
          </#if>
          </#noparse>
        </table>
         <!--分页条-->
         <#noparse>
		  <#include "../paging.ftl">
		  </#noparse>
    </div><!--list-->
<#noparse><!--html尾-->
<#include "../htmlBottom.ftl">
</#noparse>