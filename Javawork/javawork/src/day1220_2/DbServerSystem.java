package day1220_2;

public class DbServerSystem {
	//접근 지정자 default 해보고 protected 로 수정해보자 
	protected String dbServerName;//다른 패키지에서 this. 나 super.으로 해서 보이면 
	int serverPort;
	
	public DbServerSystem() {
		// TODO Auto-generated constructor stub
		dbServerName ="Oracle";
		serverPort = 8080;
	}
	
	
	public DbServerSystem(String dbServerName) {
		this.dbServerName = dbServerName;
		this.serverPort = 8080; 
	}
	
	public DbServerSystem(String dbServerName, int serverPort) {
		this.dbServerName = dbServerName;
		this.serverPort = serverPort;
	}
	
	public void serverStart() {
		System.out.println(serverPort+" port로 "+dbServerName+ " DB세팅 완료");
	}
	
	public void serverClose() {
		System.out.println(dbServerName+" DB Close");
	}
	
	
	
	
	
}
