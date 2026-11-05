package com.kh.animal.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.animal.model.dto.AnimalDto;

public class AnimalDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<AnimalDto> read(Connection conn, String platnName) {
	
		List<AnimalDto> animals = new ArrayList<>();

		String sql = """
				SELECT
						ANIMAL_NO
					 ,  ANIMAL_NAME
				  FROM
				  		ANIMAL
				 ORDER
				 	BY
				 		ANIMAL_NO ASC
				 	""";

		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()){
			while (rset.next()){
				ad
				
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animals;

	}
	public int save(String animalName) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "INSERT "
				   + "  INTO "
				   + "		  ANIMAL"
				   + " VALUES "
				   + "		  ( "
				   + "			SEQ_ANIMAL_NO.NEXTVAL"
				   + "		  , ' "
				   + 			animalName 
				   +"		  ' ) ";
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/ORCL", "JOANNA", "whdkssk1");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
	}
}
