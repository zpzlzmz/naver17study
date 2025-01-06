package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

public class Ex5MysqlInsertSelect {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username="root";
	String password="1234";
	
	public Ex5MysqlInsertSelect() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 오류:"+e.getMessage());
		}
		
	}
	
	
	
	public Connection GetConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 접속 실패:"+e.getMessage());
		}
		return conn;
	}
	
	public void insertPerson(String name, String blood, int age, String hp) {
		Connection conn= null;
		Statement stmt = null;
		String sql = "insert into person (name,blood,age,hp,today) values ("+"'"+name+"','"+blood.toUpperCase()+"',"+age+",'"+hp+"',now())";
		//System.out.println(sql);
		
		
		conn = this.GetConnection();
		try {
			stmt = conn.createStatement();
			//insert문 실행
			stmt.execute(sql);
			System.out.println("DB에 데이터를 추가했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void writePerson() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs=null;
		
		String sql = "select * from person order by num";
		conn = this.GetConnection();
		
		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("\t\t** Person Table **");
			System.out.println();
			System.out.println("이름\t나이\t혈액형\t핸드폰\t\t날짜");
			System.out.println("=".repeat(50));
			
			while(rs.next()) {
				String today = rs.getString("today").substring(0,10);
				System.out.println(rs.getString("name")+"\t"+rs.getInt("age")+"\t"+rs.getString("blood")+"\t"+rs.getString("hp")+"\t"+today);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void searchName(String name) {
		int count = 0;
		/*
		 * 문제: name 이 '영자' 인경우 영자를 포함하는 모든 데이터를 출력
		 * 예
		 * 1번째 
		 * 이름: 김영자
		 * 혈액형 : B형
		 * 나이: 23세 
		 * 핸드폰:  010-2222-3333
		 * ---------------------
		 * 2번째 
		 * 이름:영자순
		 * ...
		 * 
		 * if (만야ㅐㄱ 없을 경우 ) 
		 * 	"영자"를 포함한 회원은 없습니다. 출력하기 
		 * 
		 */
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from person where name like '%"+name+"%'";
		//String sql = "select * from person where name like concat('%','"+name+"','%')";
		conn = GetConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				System.out.println((count+1)+"번째");
				System.out.println("이름:"+rs.getString("name"));
				System.out.println("혈액형:"+rs.getString("blood"));
				System.out.println("나이:"+rs.getInt("age"));
				System.out.println("핸드폰:"+rs.getString("hp"));
				System.out.println("-".repeat(30));
				count++;
			}
			if(count == 0) {
				System.out.println("\""+name+"\" 를 포함한 회원은 없습니다.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
	
	
	//이름을 찾아 삭제하는 메서드
	public void deletePerson(String name) {
		int count = 0;
		/*
		 * name이 이영자일경우
		 * 있을경우 1명의 데이터가 삭제되었습니다
		 * 
		 * 이영자가 2명일 경우
		 * 2명의 데이터가 삭제되었습니다.
		 * 
		 * 없을 경우 "이영자" 님은 존재하지 않습니다.
		 * int executeUpdate (String sql) 
		 * 실행한 sql 문의 갯수를 반환 --> 2명이 삭제된 경우 2반환 1명이 삭제되면 1반환 
		 * 해당이름이 없어서 삭제를 못했다면 0반환.
		 * 
		 */
		Connection conn = null;
		Statement stmt  = null;
		
		
		String sql ="delete from person where name like '"+name+"'";
		
		conn = GetConnection();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql) ;
			if(a>0)
			System.out.println(a+"명의 데이터가 삭제되었습니다");
			else
				System.out.println("\""+name+"\" 님은 존재하지 않습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
	
	
	

	private int executeUpdate(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5MysqlInsertSelect ex5 = new Ex5MysqlInsertSelect();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.데이터 추가 2.전체출력 3.이름 검색 4.멤버삭제 5. 종료");
			System.out.println("select menu?");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:{
				System.out.println("데이터를 추가합니다");
				System.out.println("이름을 입력하세요 : ");
				String name = sc.nextLine();
				System.out.println("혈액형을 입력하세요 : ");
				String blood = sc.nextLine();
				System.out.println("나이을 입력하세요 : ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰을 입력하세요 : ");
				String hp = sc.nextLine();
				ex5.insertPerson(name,blood, age, hp);
				break;
			}
			case 2:{
				ex5.writePerson();
				break;
			}
			case 3:{
				System.out.println("검색할 이름을 입력하세요");
				String name = sc.nextLine();
				ex5.searchName(name);
				break;
			}
			case 4:{
				System.out.println("삭제할 이름을 입력하세요");
				String name = sc.nextLine();
				ex5.deletePerson(name);
				break;
			}
				
			default:
				System.out.println("***     프로그램을 종료합니다     ***");
				System.exit(0);
				
			}
			System.out.println("------------------------------");
		}
	}

}
