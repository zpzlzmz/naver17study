package day0103db.copy;

public class Ex1OracleConnect {
	
	static final String ORACLE_DRIVER ="oracle.jdbc.OracleDriver";
	
	public Ex1OracleConnect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 실패:"+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1OracleConnect ex1 = new Ex1OracleConnect();
	}

}
