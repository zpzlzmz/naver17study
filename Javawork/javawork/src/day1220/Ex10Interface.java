package day1220;


interface InterB{
	int Speed = 100; //final (interface에서는 모든 선언 상수, 추상이다.)
	public void speedWrite();
	public void speedUp(int speed);
	public void speedDown(int speed);

}


class Car implements InterB{
	
	int curSpeed = Speed; // 초기값 100 

	@Override
	public void speedWrite() {
		// TODO Auto-generated method stub
//		System.out.println("현재 속도는 "+Speed);
		System.out.println("현재 속도는 "+curSpeed);
		
	}

	@Override
	public void speedUp(int speed) {
		// TODO Auto-generated method stub
		//Speed+=Speed; // 오류 final 상수이기 때문
		
		curSpeed += speed;
		System.out.println("증가된 속도는: "+curSpeed);
		
	}

	@Override
	public void speedDown(int speed) {
		// TODO Auto-generated method stub
		curSpeed -= speed;
		System.out.println("감소된 속도는: "+curSpeed);
	}
	
}


public class Ex10Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterB inter = new Car();
		inter.speedWrite();
		inter.speedUp(40);
		inter.speedDown(56);

	}

}
