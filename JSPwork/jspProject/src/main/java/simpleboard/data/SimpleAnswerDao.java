package simpleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class SimpleAnswerDao {
	MysqlConnect db = new MysqlConnect();
	
	public void insertAnswer(SimpleAnswerDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into simpleanswer (num,nickname,content,writeday) values (?,?,?,now())";
		
		conn = db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인드
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	public List<SimpleAnswerDto> getAnswerByNum(int num){
		List<SimpleAnswerDto> alist=new Vector<SimpleAnswerDto>();
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from simpleanswer where num=?";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				SimpleAnswerDto dto = new SimpleAnswerDto();
				
				
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				alist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return alist;
	}
	
	public void deleteAnswer(int idx) {
		SimpleAnswerDto dto = new SimpleAnswerDto();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String sql="delete from simpleanswer where idx=?";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
}
