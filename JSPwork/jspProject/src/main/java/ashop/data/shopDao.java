package ashop.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class shopDao {
	MysqlConnect db = new MysqlConnect();
	public List<shopDto> getAllDatas(){
		
		List<shopDto> list = new Vector<shopDto>();
		Connection conn = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql = "select * from shop order by idx";
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				shopDto dto = new shopDto();
				
				dto.setIdx(rs.getInt("idx"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setSu(rs.getInt("su"));
				dto.setDanga(rs.getInt("danga"));
				dto.setIpgoday(rs.getTimestamp("ipgoday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
		
	}
}
