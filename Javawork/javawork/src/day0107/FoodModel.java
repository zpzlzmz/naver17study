package day0107;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class FoodModel {
	MysqlConnect mysqlConnect = new MysqlConnect();


	//메뉴 등록 Insert 하는 메서드 
	public void foodMenuInsert(String foodName, int foodPrice, String foodSize) {
		Connection conn = mysqlConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into foodrest (foodname,foodprice,foodsize) values (?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, foodName);
			pstmt.setInt(2, foodPrice);
			pstmt.setString(3,foodSize);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}

	}

	
	

	//전체 메뉴 반환하는 메서드
	public List<Vector<String>> getAllMenus(){
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from foodrest order by num";

		conn = mysqlConnect.getConnection();

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector<String> data =new Vector<String>();

				data.add(rs.getString("num"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));

				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}


		return list;
	}

	//예약 데이터 Insert

	public void foodOrderInsert(FoodOrderDto dto) {
		Connection conn = mysqlConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into foodorder (num,ordername,ordercnt,bookingday) values (?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getOrderName());
			pstmt.setInt(3,dto.getOrderaCnt());
			pstmt.setString(4, dto.getBookingDay());
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}

	}



	public List<Vector<String>> getAllOrders(){
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select idx,ordername,foodname,foodprice,foodsize,ordercnt,bookingday from foodrest fr,foodorder fo where fr.num = fo.num";

		conn = mysqlConnect.getConnection();

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Vector<String> data =new Vector<String>();

				data.add(rs.getString("idx"));
				data.add(rs.getString("ordername"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				data.add(rs.getString("ordercnt"));
				data.add(rs.getString("bookingday"));

				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}


		return list;
	}

	//등록메뉴 삭제
	public void deleteFoodMenu(int num) {

		Connection conn = mysqlConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from foodrest where num = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}




	}


	//예약자 삭제
	public void deleteOrder(int idx) {

		Connection conn = mysqlConnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from foodorder where idx = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}



	//등록메뉴를 예약한 건수 반환
	public int getOrderMenuCount(int num) {
		int cnt = 0;
		Connection conn = mysqlConnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select count(*) count from foodorder where num = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
				cnt = rs.getInt("count");
			else
				System.out.println("예약된 메뉴가 아닙니다.");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
		
		
		return cnt;
	}
	


}




