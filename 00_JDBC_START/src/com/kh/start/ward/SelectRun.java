package com.kh.start.ward;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = """
				
						SELECT
								COFFEE_NO
							 ,  COFFEE_NAME
							 ,	CREATE_DATE
						  FROM	
						  		COFFEE
						 ORDER
						 	BY
						 		CREATE_DATE DESC
   					 """;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록");
			
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle" );
		System.out.println("연결성공");
	
		stmt = conn.createStatement();
		
		rset = stmt.executeQuery(sql);		
		//System.out.println(rset);
		
		while(rset.next()) {
			int coffeeNo = rset.getInt("COFFEE_NO");
			String coffeeName = rset.getString("COFFEE_NAME");
			Date createDate = rset.getDate("CREATE_DATE");
			System.out.println(" 커피 번호 : " + coffeeNo
							+  " 커피 이름 : " + coffeeName	
							+  " 제조 일시 : " + createDate	);
		}
	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
