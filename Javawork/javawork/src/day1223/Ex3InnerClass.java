package day1223;

abstract class AbstEx{
	abstract public void show();
	
} 

interface MyDB{
	public void list();
	public void insert();
}

class SubMyDB implements MyDB{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("목록 출력2");
	}
	@Override 
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("목록 입력2");
	}
}


public class Ex3InnerClass {
	
	MyDB mydb1 = new MyDB() {
		
		@Override
		public void list() {
			// TODO Auto-generated method stub
			System.out.println("DB목록을 출력합니다");
			
		}
		
		@Override
		public void insert() {
			// TODO Auto-generated method stub
			System.out.println("DB 데이터를 추가 합니다.");
		}
	}; 
	
	
	//익명 내부 클래스 형태로 구현 - 어나니머스 오버라이드
	AbstEx Abst1 = new AbstEx() {
		
		@Override
		public void show() {
			// TODO Auto-generated method stub
			System.out.println("Show 호출");
		}
	};
	MyDB myDB2 = new SubMyDB(); // MyDB로 하든 SubMyDB로 하든 상속 받은거라 둘중 아무거나 사용가능 생성만 SubMyDB로 하기.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3InnerClass ex3 = new Ex3InnerClass();
		ex3.Abst1.show(); //same system.out.print 느낌
		System.out.println();
		ex3.mydb1.list();
		ex3.mydb1.insert(); 
		System.out.println();
		ex3.myDB2.insert();
		ex3.myDB2.list();
		
		
		
		
		
		
		
	}

}
