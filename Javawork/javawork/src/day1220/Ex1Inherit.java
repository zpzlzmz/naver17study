package day1220;

class SuperObj1{
	SuperObj1(){
		System.out.println("super 생성자");
	} 
	SuperObj1(String msg){
		System.out.println("super 메세지 받는 생성자:"+msg);
	}
}

///////////////////

class SubObj1 extends SuperObj1{
	SubObj1(){
		
		//첫줄에 super()가 생략되어있기 때문에 - 직접 쓸 경우 첫줄이어야 한다(default 는 항상 앞에 super가 자동으로 붙음)
		//super();//super는 무조건 첫줄이어야함 아니면 error 나옴 
		System.out.println("sub 생성자");
	}
	SubObj1(String msg){
		super(msg);//인자가 있기 때문에 생략불가- 만약 생략하면 부모의 default 를 출력함(super 생성자)
		System.out.println("sub의 두번째 생성자");
	}
}

public class Ex1Inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub // 오버라이딩 -> 메서드 재 정의 : 부모가 흰색 소나타를 물려주면 내가 나의 사용처에 맞게 기능을 추가하는것
		//상속 받았을때는 -> 접근자를 더 높은걸 못씀 ex) 부모 protected  자식이 가능한 접근자 ->protected, private. (public 이나 default 는 못씀)
		SubObj1 sub1 = new SubObj1();
		SubObj1 sub2 = new SubObj1("Hello");
	}

}
