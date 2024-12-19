package day1219;

/*
 * 생성자
 * 1. 객체 생성시 자동호출
 * 2. 리턴 타입이 없음(형식[접근지정자] 클래스명)
 * 3. 오버로딩(Overloading : 중복함수)이(가) 가능하다 -> 생성자 이름은 같지만 인자가 다른것
 * 4. 생성자에서는 주로 멤버 변수 초기화를 담당함
 */


class Apple{
	Apple(){
		System.out.println("디폴트 생성자");
	}
	/////
	Apple(String name){
		System.out.println(name+" 을 인자로 받음");
	}
	Apple(int age){
		System.out.println(age+" 을 인자로 받음");
	}
	Apple(String name, int age){
		System.out.println(name+" 과 "+age+" 를 인자로 받음");
	}
}




public class Ex3Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1 = new Apple();//생성자 자동 호출(
		Apple a2 = new Apple("김준호");
		Apple a3 = new Apple(12);
		Apple a4 = new Apple("김준호",27);
	}

}
