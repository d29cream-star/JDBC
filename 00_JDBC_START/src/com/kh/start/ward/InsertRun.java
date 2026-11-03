package com.kh.start.ward;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertRun {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		//String sql = " INSERT INTO WARD VALUES('W7', 'KH병동', '특실', 4)";
		Scanner sc = new Scanner(System.in);
		System.out.print("커피명을 입력하세요.");
		String coffeeName = sc.nextLine();
		
		/*String sql = "INSERT "
				+ " INTO "
				+"  COFFEE "
				+ "VALUES "
				+ "("
				+ "SEQ_COFFEE.NEXTVAL"
				+ ", '" + coffeeName + "'"
				+ SYSDATE + ")"*/
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("INSERT ");
		sb.append("  INTO ");
		sb.append("		   COFFEE  ");
		sb.append("VALUES ");
		sb.append("		   (");
		sb.append("		   SEQ_COFFEE.NEXTVAL");
		sb.append("      , '" + coffeeName + " ' ");
		sb.append("		 , SYSDATE");
		sb.append("		   )");
		String sql = sb.toString();
		System.out.println(sql);
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");

			System.out.println("DB 연결 성공");
			
			stmt = conn.createStatement();
			System.out.println("Statment 객체 생성");
			
			result = stmt.executeUpdate(sql);
			System.out.println("SQL문 실행 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("프로젝트에 ojdbc.jar 파일을 추가하지 않을 경우");
			System.out.println("oracle.jdbc.driver.OracleDriver에 오타");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLSyntaxErrorException");
			System.out.println("username password 문제");
			System.out.println("NullPointException. JDBC 객체들 확인");
			System.out.println("URL 작성 오류");
			System.out.println("SQL IntergrityConstraintViolation : 테이블 제약조건 확인");

		} finally {
			try {
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
