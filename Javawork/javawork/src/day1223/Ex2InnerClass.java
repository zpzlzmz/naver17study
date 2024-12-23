package day1223;


class OuterObj{
	int a = 100;
	static int b  = 200;
	private int c = 300;
	class InnerObj{
		int x= 400;
		static int y = 500;//jdk 17에서는 가능하지만 11에서는 Static 선언 불가 -> 중간버전은 몰?루 
		
		public void disp() {//내부에 있는 disp 를 호출하기 위해서 outer를 선언 후 inner를 선언하고 또 호출을 해야하지만
			
			System.out.println("a = "+a);
			System.out.println("b = "+b);
			System.out.println("c = "+c);
			System.out.println("x = "+a);
			System.out.println("y = "+y);
		}
	}
	public void outerDisp() {//이런식으로 Outer에 Inner 의 함수를 호출하는것을 만들면 편하다 
		InnerObj In1 = new InnerObj();
		In1.disp();
	}
}


public class Ex2InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterObj out1 = new OuterObj();
		out1.outerDisp();
		System.out.println();
		//직접 내부 클래스의 메서드를 호출하려면? 
		//Outer.Inner obj1 = new Outer().new Inner();
		OuterObj.InnerObj obj1 = out1.new InnerObj();
		obj1.disp();

	}

}
