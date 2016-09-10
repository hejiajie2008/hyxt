<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
        "http://struts.apache.org/dtds/struts-2.0.dtd">
<struts>
<#list tables as table>
<package name="${(table.javaName)?uncap_first!}" namespace="/${module!}/${(table.javaName)?uncap_first!}" extends="sendinfo-default">
	<action name="*" method="{1}" class="com.sendinfo.action.${(table.javaName)!}Action">
		<result>/WEB-INF/ftl/${module!}/{1}${(table.javaName)!}.ftl</result>
	</action>
	<action name="add" method="add" class="com.sendinfo.action.${(table.javaName)!}Action">
		<result>/WEB-INF/ftl/${module!}/edit${(table.javaName)!}.ftl</result>
	</action>
	<action name="view" method="edit" class="com.sendinfo.action.${(table.javaName)!}Action">
		<result>/WEB-INF/ftl/${module!}/view${(table.javaName)!}.ftl</result>
	</action>
	<action name="save" method="save" class="com.sendinfo.action.${(table.javaName)!}Action">
		<!--<interceptor-ref name="sendinfoTokenStack"/>-->
		<result name="redirect" type="redirect" ><#noparse>${redirectPath}</#noparse></result>
		<result name="input">/WEB-INF/ftl/${module!}/edit${(table.javaName)!}.ftl</result>
	</action>
	<action name="del" method="del" class="com.sendinfo.action.${(table.javaName)!}Action">
		<result type="redirect" ><#noparse>${redirectPath}</#noparse></result>
	</action>
	<action name="delAll" method="delAll" class="com.sendinfo.action.${(table.javaName)!}Action">
		<result type="redirect" ><#noparse>${redirectPath}</#noparse></result>
	</action>
</package>
</#list>
</struts>