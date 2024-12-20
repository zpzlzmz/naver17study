package day1220;

//추상 클래스는 객체 생성을 할 수 없다. new로 생성이 불가(어나니머스로 하라캄, 기본형으로는 불가)
//자식 클래스로 하여금 반드시 구현하게 할 목적으로 추상 메서드를 만든다.
//만약 자식 클래스가 추상메서드를 오버라이드 안했을경우 그 클래스도 추상화 시켜야한다
abstract class Parent2{
	abstract public void process();// 추상 메서드는 일반 클래스의 멤버로 올 수 없다.
	//부모가 process에서 하는일이 없을경우
	//그렇다고 안만들면 자식크래스에서 오버라ㅣ이드를 할 수 없다;
	//이럴경우 미완성으로 선언만 하는데 이러한경우 abstract메서드로 만든다(미완성메서드라는 의미)
	
	//abstract 클래스는 추상 메서드 분 아니라 일반 메서드도 구현 가능 
	public void study() {
		System.out.println("자바 공부를 한다");// 부모만 가진 일반 메서드 
	}
	
	
	
}


class Your1 extends Parent2{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("벽지공사를 합니다.");
	}
	
	
	//Your1이 가진 메서드 
		public void draw() {
			System.out.println("그림을 그린다.");
		}
	
}

class Your2 extends Parent2{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("타일 공사를 합니다.");
	}
}



public class Ex6Abstract {

	
	public static void yourProcess(Parent2 p) {
		p.process();
		p.study();
		//p.draw();// 오류 발생! !!!!! 공습경보!!!!!
		//p에 Your2가 생성되어있는경우에는 오류가 발생 !! 
		((Your1)p).draw();// 오우쉐엣; 다운캐스팅 parent 클래스를 자식 클래스로 바꿔서 자식 클래스의 함수를 출력 ;
		//다운 캐스팅은 많이 쓰지않는다.
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		yourProcess(new Your1());
		System.out.println("=".repeat(30));
		//yourProcess(new Your2());
		
		//yourProcess(new Parent2());// 추상 클래스는 new로 생성할 수 없다

	}

}
