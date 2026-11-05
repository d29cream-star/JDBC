package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcTemplate {
	
	public static Connection getConnection() {
		
		try {
		
			Properties prop = new Properties();
			prop.load(new FileInputStream("resources/connection.properties"));
			//System.out.println(prop.getProperty("URL"));
			
			
			Connection conn = DriverManager.getConnection(prop.getProperty("URL"), 
														  prop.getProperty("USERNAME"), 
														  prop.getProperty("PASSWORD"));
												
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn) {
	 
		try {
			if(conn != null	) {
					conn.close();
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset != null){
				rset.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
