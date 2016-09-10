<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.jfxy.dao.${(table.javaName)!}Dao" >
  <!--映射返回值-->
  <resultMap id="ResultMap" type="com.jfxy.pojo.${(table.javaName)!}" >
    <id column="${(table.primaryKeyField.columnName)!}" property="${(table.primaryKeyField.fieldName)!}"  />
    <#list table.allFields as field >
     <#if field.columnName!=table.primaryKeyField.columnName>
     <result column="${(field.columnName)!}" property="${(field.fieldName)!}"  />
     </#if>
    </#list>
  </resultMap>
  <!--where 条件组装-->
  
  <sql id="Where_Clause" >
    <where >
     	<#list table.allFields as field>
     	
     	
	  	  <#if  field.columnName!= table.primaryKeyField.columnName>
		      <if test="${(field.fieldName)!} != null" >
		       
		         <#if field_index!=1>and </#if>${(field.columnName)!} = <#noparse>#{</#noparse>${(field.fieldName)!}} 
		      </if>
	      </#if>
       </#list>
    </where>
  </sql>

 <!--基本列-->
  <sql id="Base_Column_List" >
    <#list table.allFields as field >
     ${(field.columnName)!}<#if field_has_next>,</#if><#t>
    </#list>
    <#nt>
  </sql>
  
  
  <!--添加数据-->
  <insert id="insert" parameterType="com.jfxy.pojo.${(table.javaName)!}" >
    insert into ${(table.tableName)!} (<#rt>
    <#list table.allFields as field>
     ${(field.columnName)!}<#if field_has_next>,</#if><#t>
 	</#list>
      )<#t>
    values (<#t> 
       <#list table.allFields as field>
       <#noparse>#{</#noparse>${(field.fieldName)!}}<#if field_has_next>,</#if><#t>
      </#list>
      )<#lt>
  </insert>
  
  
  <!--修改数据-->
  <update id="update" parameterType="com.jfxy.pojo.${(table.javaName)!}" >
    update ${(table.tableName)!}
    <set >
	    <#list table.allFields as field>
	  	  <#if  field.columnName!= table.primaryKeyField.columnName>
	      <if test="${(field.fieldName)!} != null" >
	        ${(field.columnName)!} = <#noparse>#{</#noparse>${(field.fieldName)!}}<#if table.versionField?exists ><#if field.fieldName==table.versionField.fieldName>+1</#if> </#if>,
	      </if>
	      </#if>
	  </#list>
    </set>
    where  ${(table.primaryKeyField.columnName)!}= <#noparse>#{</#noparse>${(table.primaryKeyField.fieldName)!}}
          <#if table.versionField?exists>
           and ${(table.versionField.columnName)!}= <#noparse>#{</#noparse>${(table.versionField.fieldName)!}}
          </#if>
  </update>
  
  
   <!--批量删除的方法-->
   <delete id="deleteById" parameterType="int" >
    delete from ${(table.tableName)!}
    where  ${(table.primaryKeyField.columnName)!}=<#noparse>#</#noparse>{value}
  </delete>
  
  
  	<!--批量删除的方法-->
   <delete id="deleteByIds" parameterType="map" >
    delete from ${(table.tableName)!}
    where  ${(table.primaryKeyField.columnName)!} in (
    <foreach collection="Ids" item="item" index="index" separator=",">
		<#noparse>#</#noparse>{item}
	</foreach>
	)
  </delete>
  
  
  
  	<!-- 查询总记录数 -->
	<select id="count" parameterType="com.jfxy.pojo.form.${(table.javaName)!}FormBean" resultType="int">
		SELECT COUNT(*) FROM ${(table.tableName)!}
		
		<include refid="Where_Clause" />
	</select>
  
 	 <!-- 按条件查询结果集(带分页) -->
	<select id="pageList" parameterType="com.jfxy.pojo.form.${(table.javaName)!}FormBean" resultMap="ResultMap">
		SELECT  <include refid="Base_Column_List" />
		 FROM ${(table.tableName)!}
		 
		<#noparse> <if test="_parameter != null" ></#noparse>
		<include refid="Where_Clause" />
		  
		  LIMIT <#noparse>#{firstResult},#{pageSize}</#noparse>
		  <#noparse></if></#noparse>
	</select>
  
 	 <!-- 按条件查询结果集(不带分页) -->
	<select id="list" parameterType="com.jfxy.pojo.${(table.javaName)!}" resultMap="ResultMap">
		SELECT 
		 <include refid="Base_Column_List" />
		  FROM ${(table.tableName)!}
		 <#noparse><if test="_parameter != null" ></#noparse>
			<include refid="Where_Clause" />
	<#noparse>	</if></#noparse>
		  
		
	</select>
  
 
  
  
  
  
 
  

</mapper>