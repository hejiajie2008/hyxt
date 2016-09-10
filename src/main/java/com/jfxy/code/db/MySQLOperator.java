package com.jfxy.code.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfxy.code.config.GenerateConfig;
import com.jfxy.code.pojo.Field;
import com.jfxy.code.pojo.Table;
import com.jfxy.util.StringUtil;


@Service("mySQLOperator")
public class MySQLOperator   {

	String sql="select table_name,table_comment from information_schema.tables where table_schema = '"+GenerateConfig.SCHEMA+"' and table_name like '"+GenerateConfig.MODULE.toUpperCase()+"%'";
	
	
	String fieldSql="select column_key,column_type,column_name,is_nullable,Data_type,column_comment,numeric_precision,numeric_scale,CHARACTER_MAXIMUM_LENGTH,column_key from information_schema.columns where table_schema='"+GenerateConfig.SCHEMA+"' and table_name=?";
	

	@Autowired
	private DruidDataSource dataSource;

	
	
	
	public List<Table> getTables() {
		try {
			
			
			
			Connection connection=dataSource.getConnection();
			
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Table> tables = new ArrayList<Table>();
			PreparedStatement ps1 = connection.prepareStatement(fieldSql);
			//PreparedStatement ps2 = connection.prepareStatement(pkSql);
			
			while (rs.next()) {
				String tableName = rs.getString("table_name");
				String tableComments = rs.getString("table_comment");
				
				System.out.println("ss="+tableName);
				Table table = new Table();
				table.setTableName(tableName);
				table.setComments(tableComments);
				processTable(table);
				tables.add(table);
				ps1.clearParameters();
				ps1.setString(1, tableName);
				ResultSet rs1 = ps1.executeQuery();
				while (rs1.next()) {
					String columnName = rs1.getString("COLUMN_NAME");
					String dataType = rs1.getString("DATA_TYPE");
					
					int dataPrecision = rs1.getInt("numeric_precision");
					String nullable = rs1.getString("is_nullable");
					String comments = rs1.getString("column_comment");
					String column_key=rs1.getString("column_key");
					int scale = rs1.getInt("numeric_scale");
					Field field = new Field();
					field.setColumnName(columnName);
					String[] commentses = comments.split("\\|");
					field.setComments(commentses[0]);
					if (commentses.length > 1) {
						field.setCommentsDetail(commentses[1]);
					}
					field.setDataType(dataType);
					field.setNullable(nullable);
					
					System.out.println("名称"+columnName+",dataType="+dataType);
					
					if(!dataType.contains("text")){
						int dataLength= rs1.getInt("CHARACTER_MAXIMUM_LENGTH");
						if (dataType.contains("int")||dataType.contains("decimal")) {
							field.setLength(dataPrecision);
							field.setScale(scale);
						} {
							
							field.setLength(dataLength);
						}
						
					}
					
					
					processField(field);
					table.addField(field);
					
					if(column_key.equals("PRI")){
						table.setPrimaryKeyField(field);
					}
					
					
					
					if (columnName.equals("VERSION")) {
						table.setVersionField(field);
						
					}
					

				}
				rs1.close();
			}
			ps1.close();
			
			rs.close();
			ps.close();
			connection.close();
			return tables;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	
	public void processTable(Table table) {
		String tableName = table.getTableName();
		String strs[] = tableName.split("_");
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(StringUtil.capFirstUpperCase(str.toLowerCase()));
		}
		table.setJavaName(sb.toString());
	}

	
	public void processField(Field field) {
		String columnName = field.getColumnName();
		String strs[] = columnName.split("_");
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(StringUtil.capFirstUpperCase(str.toLowerCase()));
		}
		field.setFieldName(StringUtil.capFirstLowerCase(sb.toString()));
		String dataType = field.getDataType();
		if ("char".equals(dataType)) {
			
			field.setType("char");
			field.setJavaDataType("String");
		} else if ("blob".equals(dataType)) {
			field.setType("blob");
			field.setJavaDataType("String");
		} else if ("varchar".equals(dataType)) {
			field.setType("varchar");
			field.setJavaDataType("String");
		} else if (dataType.contains("text")) {
			System.out.println(dataType);
			field.setType(dataType);
			field.setJavaDataType("String");
		} else if(dataType.contains("int")||"bit".equals(dataType)){
			field.setType(dataType);
			if("bigint".equals(dataType)){
				field.setJavaDataType("Long");
			}else{
				field.setJavaDataType("Integer");
			}
			
			
		}else if ("float".equals(dataType)) {
			field.setType("float");
			field.setJavaDataType("Float");
			
		}else if ("double".equals(dataType)) {
			field.setType("double");
			field.setJavaDataType("Double");
			
		}else if ("decimal".equals(dataType)) {
			field.setType("decimal");
			field.setJavaDataType("Decimal");
			
		} else if ("timestamp".equals(dataType)) {
			field.setType("timestamp");
			field.setJavaDataType("Date");
		} else if (dataType.contains("date")||dataType.contains("time")||dataType.contains("year")) {
			field.setType(dataType);
			field.setJavaDataType("Date");
		}else{
			System.out.println("为找到类型");
		}
	}
}
