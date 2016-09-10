package com.jfxy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnSqlUtils {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn(String filepath){
		Connection conn=null;
		try {
			Properties properties=new Properties();
			properties.load(new FileInputStream(new File(filepath)));
			String url=properties.getProperty("mysql.db.url");
			String username=properties.getProperty("mysql.db.username");
			String password=properties.getProperty("mysql.db.password");
			conn=DriverManager.getConnection(url,username,password);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
