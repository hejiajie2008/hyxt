<#list tables as table>
${(table.javaName)?uncap_first!}=${(table.javaName)?uncap_first!}
<#list table.allFields as field>
<#if field.fieldName!= table.primaryKeyField.fieldName && field.fieldName!="version">
${(table.javaName)?uncap_first!}_${(field.fieldName)!}=${(field.fieldName)!}
</#if>
</#list>
</#list>