package com.kh.plant.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public int save(HousePlantDto hpd) {
		
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql =  " INSERT  "
					+ "   INTO  "
					+ "			HOUSEPLANT	"
					+ " VALUES	"
					+ "			("
					+ 			" SEQ_PLANT_NO.NEXTVAL "
					+ "		,  ' "
					+			hpd.getPlantType() +"' "
					+ "     ,  ' "
					+			hpd.getPlantName() +"' "
					+ "			)";
			
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		return result;
	}

	public List<HousePlantDto> view() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<HousePlantDto> list = new ArrayList<>();

		String sql = """
					SELECT
							PLANT_NO
						 ,  PLANT_NAME
						 ,	PLANT_TYPE
					  FROM	
					  		HOUSEPLANT
					 ORDER
					 	BY	
					 		PLANT_NO DESC
					 """;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
		
			while(rset.next()) {
				HousePlantDto h = new HousePlantDto();
				h.setPlantNo(rset.getInt("PLANT_NO"));
				h.setPlantName(rset.getString("PLANT_NAME"));
				h.setPlantType(rset.getString("PLANT_TYPE"));
				
				list.add(h);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
			rset.close();
			stmt.close();
			conn.close();
			}catch(SQLException e) {
				
			}
		}
		return list; //조회된 결과물을 맵핑해놓은 dto 객체들의 주소값을 요소로 갖고 있는 List의 주소값을 반환
	}
	public int edit(HousePlantDto hpd) {
	
		int result = 0;
		String sql = " UPDATE  "
					+"		  HOUSEPLANT "
					+"    SET  "
					+"        PLANT_NAME = ' " 
					+		  hpd.getPlantName() +" ' "
					+"	   ,  PLANT_TYPE = ' "
					+		  hpd.getPlantType() +" ' "
					+"  WHERE  "
					+" 		  PLANT_NO = "
					+		  hpd.getPlantNo();
		
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/XEPDB1", "HOSPITAL", "oracle");
			 Statement stmt = conn.createStatement()){
			 result = stmt.executeUpdate(sql);
			 
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return result;
	}
}
