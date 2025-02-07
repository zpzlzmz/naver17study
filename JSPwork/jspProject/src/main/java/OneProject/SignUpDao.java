package OneProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.connect.MysqlConnect;

public class SignUpDao {

	MysqlConnect db = new MysqlConnect();
	 
	public void insertUserInfo(SignUpDto dto) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    String sql = "INSERT INTO userInfo (userid, nickname, passwd, addr, writeday) VALUES (?, ?, ?, ?, NOW())";
	    System.out.println("실행할 SQL 쿼리: " + sql);


	    conn = db.getNaverCloudConnection();
	    try {
	        pstmt = conn.prepareStatement(sql);
	        
	        // 바인딩
	        pstmt.setString(1, dto.getUserid());
	        pstmt.setString(2, dto.getNickname());
	        pstmt.setString(3, dto.getPasswd());
	        pstmt.setString(4, dto.getAddr());
	        

	        // 쿼리 실행
	        int result = pstmt.executeUpdate();
	        
	        

	        
	        if (result > 0) {
	            System.out.println("회원가입 성공!");
	        } else {
	            System.out.println("회원가입 실패!");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pstmt, conn);
	    }
	}
	
	public SignUpDto getUserById(String userID) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from userInfo where userid = ?";
		SignUpDto dto = null;
		conn = db.getNaverCloudConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
			    dto = new SignUpDto();
			    dto.setIdx(rs.getInt("idx"));
			    dto.setUserid(rs.getString("userid"));
			    dto.setNickname(rs.getString("nickname"));
			    dto.setPasswd(rs.getString("passwd"));  // 확인
			    dto.setAddr(rs.getString("addr"));
			    dto.setWriteday(rs.getTimestamp("writeday"));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
			
		}
		return dto;
	}
	
	
}
