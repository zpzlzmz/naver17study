package day1218;

public class Ex6Object {
	
	//멤버 변수나 상수를 선언하는 영역임 .
	static int x = 10;//static 변수는 인스턴스 없이도 접근이 가능 하다 
	static int y = 20;
	//메서드도 static 으로 만들기 
	
	public static void showTitle() {
		System.out.println("클래스 공부중");
		System.out.println("static 변수는 접근 가능 :"+x+","+y);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("x="+Ex6Object.x);//static 변수는 클래스 명으로 접근
		System.out.println("x="+x);//같은 클래스 멤버일 경우 앞에 클래스 명을 생략 가능하다. 
		
		
		//static 변수 x와y를 더해보자
		System.out.println("Static 변수 x와y를 더해보자");
		int sum = x+y;
		System.out.println("sum = "+sum);
		
		//static 메서드 호출
		Ex6Object.showTitle();
		showTitle();
		
	}

}
