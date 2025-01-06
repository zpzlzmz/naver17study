package day0106DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class PersonModel {
	MysqlConnect connect = new MysqlConnect();
	
	//한번에 출력
	public List<Vector<String>> getAllDatas(){
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select * from person order by num desc";
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("age"));
				data.add(rs.getString("hp"));
				data.add(rs.getString("blood"));
				list.add(data);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	
	
	public void insertPerson(PersonDto dto) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into person (name,age,blood,hp) values (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setString(3, dto.getBlood());
			pstmt.setString(4, dto.getHp());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
		
	}
	
	
	public void deletePerson(int num) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from person where num =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connect.dbClose(pstmt, conn);
		}
		
	}
	
}
