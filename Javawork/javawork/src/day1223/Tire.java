package day1223;

public class Tire {
	public void roll() {
		System.out.println("회전합니다");
	}
}


class HankookTire extends Tire{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		super.roll();
		System.out.println("한국 타이어가 회전합니다.");
	}
}

class KumhoTire extends Tire{
	@Override
	public void roll() {
		// TODO Auto-generated method stub
		super.roll();
		System.out.println("금호 타이어가 회전합니다.");
	}
}

class Car{
	public Tire tire;
	
	public void run() {
		tire.roll();
	}
}