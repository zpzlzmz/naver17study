package day1220;


class Parent1{
	public void process() {
		System.out.println("기본 작업을 한다");
	}
}

class My1 extends Parent1{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		super.process();
		System.out.println("벽지작업을 한다");
	}
}

class My2 extends Parent1{
	@Override
	public void process() {
		// TODO Auto-generated method stub
	
		super.process();
		System.out.println("바닥 작업을 한다");
	}
	
}

public class Ex5Inherit {
	
	public static void homeProcess(My1 my) {
		my.process();
	}

	public static void homeProcess2(My2 my) {
		my.process();
	}
	
	public static void homeProcessAll(Parent1 p) { //다형성 처리 (서브클래스가 많을수록 좋음( 반드시 @Override가 되어야 함)
		p.process();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		My1 my1 = new My1();
//		my1.process();
//		System.out.println();
		My2 my2 = new My2();
//		my2.process();
		
		homeProcess(my1);
		homeProcess2(my2);
		System.out.println();
		//다형성 처리 
		Parent1 p1 = null;
		p1= new My1();
		p1.process(); // my1이 가진 Process 메서드가 호출됨 
		System.out.println();
		p1 = new My2();
		p1.process();
		
		System.out.println("=".repeat(50));
		
		homeProcessAll(new My1());
		System.out.println();
		homeProcessAll(new My2());
		System.out.println();
		homeProcessAll(new Parent1());
	}

}
