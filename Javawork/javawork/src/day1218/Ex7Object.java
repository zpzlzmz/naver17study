package day1218;

class Apple{
	//private을 제외하고 모드 직접 접근 가능
	static String message="Hello"; //static 보통 공유 데이터로 많이 씀 (변수)(클래스 멤버 변수) 
	static final String EMP="비트캠프"; // 상수(final 을 쓰면 상수)  
	String name ="캔디";//인스턴스 멤버 변수
}

public class Ex7Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메세지:"+Apple.message);//다른 클래스의 Static 변수는 (클래스명.변수명)으로 접근
		System.out.println("EMP:"+Apple.EMP);
		Apple.message = "Happy Day";
		System.out.println(Apple.message);
		//Apple.EMP = "Hello"; //final 상수는 값 변경 할 수 없다.
		
		//다른 클래스의 인스턴스 멤버 변수를 접근하기 위해서 new로 생성된 인스턴스 변수가 있어야함 .
		Apple a = new Apple();
		
		System.out.println("이름:"+a.name);
		//System.out.println("이름="+Apple.name); // Apple 의 인스턴스 변수 생성은 a로 했으니 이렇게 적으면 안됨
		a.name = "미라";
		System.out.println("이름="+a.name);
		Apple b= new Apple();
		b.name = "영자";
		System.out.println("a의 이름="+a.name+"\nb의 이름="+b.name);
	}

}


