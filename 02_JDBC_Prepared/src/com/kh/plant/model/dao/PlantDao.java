package com.kh.plant.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.plant.model.dto.HousePlantDto;

public class PlantDao {

	static {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public int save(Connection conn, HousePlantDto hpd) {
		int result = 0;
		String sql = """
					INSERT
					  INTO
					  	    HOUSEPLANT
					VALUES
							(
							SEQ_PLANT_NO.NEXTVAL
						 ,	?
						 ,	?
						 	)
				
				   	 """;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, hpd.getPlantType());
			pstmt.setString(2, hpd.getPlantName());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	public List<HousePlantDto> view(Connection conn){
		List<HousePlantDto> plants = new ArrayList<>();
		
		String sql = """
					SELECT
						   PLANT_NO
						 , PLANT_TYPE
						 , PLANT_NAME
				      FROM
				      	   HOUSEPLANT
				     ORDER
				     	BY
				     	   PLANT_NO
				
				     """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()){
			while(rset.next()) {
				plants.add(new HousePlantDto(rset.getInt("PLANT_NO")
										   , rset.getString("PLANT_TYPE")
										   , rset.getString("PLANT_NAME")));
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return plants;
	}
	
	public int edit(Connection conn, HousePlantDto hpd) {
		int result = 0;
		String sql = """
					UPDATE
					  	   HOUSEPLANT
					   SET
					   	   PLANT_NAME = ?
					   	 , PLANT_TYPE = ?
					 WHERE
					 	   PLANT_NO = ?
				     """;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, hpd.getPlantName());
			pstmt.setString(2, hpd.getPlantType());
			pstmt.setInt(3, hpd.getPlantNo());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}return result;
	}
	public int delete(Connection conn, int plantNo) {
		int result = 0;
		String sql = """
					DELETE
					  FROM
					  		HOUSEPLANT
					 WHERE
					 		PLANT_NO = ?				
					 """;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, plantNo);
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public HousePlantDto oneView(Connection conn, int plantNo) {
		
		
		return result;
	}
	public List<HousePlantDto> findByType(Connection conn, String keyword){
		
	}
}