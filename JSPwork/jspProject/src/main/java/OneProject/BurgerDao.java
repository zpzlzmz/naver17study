package OneProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;


public class BurgerDao {
	
	MysqlConnect db = new MysqlConnect();
	
	public BurgerDto getBurgerById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		BurgerDto dto = new BurgerDto();
		
		String sql = "select * from burger where id=?";
		
		conn = db.getNaverCloudConnection();
		
		try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1,id);
	        rs  = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	dto.setId(rs.getInt("id"));
	        	dto.setName(rs.getString("name"));
	        	dto.setDescription(rs.getString("description"));
	        	dto.setPrice(rs.getInt("price"));
	        	dto.setImageUrl(rs.getString("image_url"));
	        	dto.setCategory(rs.getString("category"));
	        	
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs,pstmt, conn);
	    }
		
		return dto;
	};
	
	
	public List<BurgerDto> getBurgersByCategory(String category) {
	    List<BurgerDto> list = new ArrayList<BurgerDto>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    String sql = "SELECT * FROM burgers WHERE category = ?";
	    
	    try {
	        conn = db.getNaverCloudConnection();
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, category);
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            BurgerDto dto = new BurgerDto();
	            dto.setId(rs.getInt("id"));
	            dto.setName(rs.getString("name"));
	            dto.setDescription(rs.getString("description"));
	            dto.setPrice(rs.getInt("price")); 
	            dto.setImageUrl(rs.getString("image_url"));
	            dto.setCategory(rs.getString("category"));
	            
	            list.add(dto);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(rs, pstmt, conn);
	    }
	    
	    return list;
	}


}
