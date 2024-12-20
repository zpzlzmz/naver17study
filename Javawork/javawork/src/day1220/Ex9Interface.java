package day1220;
interface InterA{
	/*
	 * interface는 음식점의 메뉴판과 같음(실체가 없이 메뉴목록만 있기 때문이다)
	 * 실제로 주문을 해야 음식이 만들어지는것처럼 구현을 해야만 기능을 구현할 수 있다.
	 * 
	 * 인터페이스에는 추상 메서드와 상수만이 올 수 있다.
	 * 이떄 abstract나 final 은 생략.
	 */
	public void process();
	
}


class SubInter implements InterA{
	
	public void process() {
		System.out.println("Sub클래스의 Process");
	};
}

public class Ex9Interface {
	
	public static void processAll(InterA I1) {
		I1.process();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		InterA inter = new SubInter();
//		inter.process();
		
//		processAll(new SubInter());
		SubInter t1 = new SubInter();
		processAll(t1);
		
	}

}
