package day1220;


import day1220_2.DbServerSystem;

class DataProcess extends DbServerSystem{
	private String sql;
	
	public DataProcess() {
		sql = "select";
		this.dbServerName="MySql";//protected 인 경우 직접 접근 가능함(상속관계인경우에)
		//this.serverPort = 9000; //오류: default 멤버 변수는 상속관계라고 해도 접근 불가
	}
	
	
	public DataProcess(String dbServerName, int serverPort, String sql) {
		super(dbServerName,serverPort);
		this.sql=sql;
	}
	
	public void Process() {
		//this.serverStart();//서브 클래스의 오버라이드 메서드가 없는경우 this를 사용해 부모 클래스의 메서드를 호출 할 수 있다.
		//하지만 오버라이드 메서드가 있는경우 부모메서드 호출시 반드시 super로 호출하기(this로 호출하면 재귀함수가 되어버림)
		super.serverStart();
		System.out.println("SQL문 "+sql+" 처리함");
		this.serverClose();
	}
		
	
	
}


public class Ex3Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataProcess s1 = new DataProcess();
		s1.Process();
		System.out.println();
		DataProcess s2 = new DataProcess("MonggoDB",9080,"Oracle");
		s2.Process();
	}

}
