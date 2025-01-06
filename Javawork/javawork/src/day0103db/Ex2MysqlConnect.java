package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlConnect {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="1234";
	
	public Ex2MysqlConnect(){
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("MYSQL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MYSQL 드라이버 실패:"+e.getMessage());			
		}
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("SQL접속 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 접속 실패:"+e.getMessage());
		}
		
		return conn;
	}
	
	public void personWriteData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//방법 1
		String sql="Select name,age,blood,hp,date_format(today,\"%Y-%m-%d %H:%i\") today from person";
		//방법 2
		//String sql = """
			//	select name,age,blood,hp,date_format(today,\"%Y-%m-%d %H:%i\") today from person""";
		conn = this.getConnection();
		
		
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("이름\t나이\t혈액형\t휴대폰\t시간");
			System.out.println("=".repeat(50));
			
			while(rs.next()) {
				String name = rs.getString("name");
				String blood = rs.getString("blood");
				int age = rs.getInt("age");
				String hp = rs.getString("hp");
				String today = rs.getString("today");
//				String sname = rs.getString(1);
//				int age = rs.getInt(2);
//				String blood = rs.getString(3);
//				String hp = rs.getString(4);
//				String today = rs.getString(5);
				
				System.out.println(name+"\t"+blood+"\t"+age+"\t"+hp+"\t"+today);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch bloc
			System.out.println("sql문 오류 :"+e.getMessage());
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2MysqlConnect ex2 = new Ex2MysqlConnect();
		ex2.personWriteData();
	}
	

}
