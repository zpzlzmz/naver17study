package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성 처리 예)
		List<String> list = null; // 부모클래스
		list = new Vector<String>(); //리스트를 상속받은 클래스
		list.add("red"); // add라는 메서드는 오버라이드 메서드
		list.add("green");
		
		for(String a:list)
			System.out.println(a);
		
		
		
		//현재 할당된 크기를 알아본,ㄴ  capacity()이 메서드는 Vector만이 가지고 있음 
		int n=((Vector<String>) list).capacity(); // 다운캐스팅임 이게 List 부모 vector 자식 클래스라 자식 클래스의 오버라이드된 함수를 쓰기 위해서 다운캐스팅.
		
		System.out.println(n);
	}

}
