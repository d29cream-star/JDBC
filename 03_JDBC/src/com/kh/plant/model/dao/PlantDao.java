package com.kh.plant.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.plant.model.dto.HousePlantDto;

public class PlantDao {

	private Properties prop = new Properties();
	public PlantDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/houseplant-mapper.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public int save(Connection conn, HousePlantDto hpd) {
		int result = 0;
		Properties prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("resources/houseplant-mapper.xml"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(prop.getProperty("save"));
		
		String sql = prop.getProperty("save");
				
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
		
		String sql = prop.getProperty("view");
				
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
		String sql = prop.getProperty("edit");
		
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
		String sql = prop.getProperty("delete");
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